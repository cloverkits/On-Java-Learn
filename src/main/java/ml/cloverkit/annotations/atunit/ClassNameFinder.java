package ml.cloverkit.annotations.atunit;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class ClassNameFinder {
    public static String thisClass(byte[] classBytes) {
        Map<Integer, Integer> offsetTable = new HashMap<>();
        Map<Integer, String> classNameTable = new HashMap<>();

        try {
            DataInputStream data = new DataInputStream(new ByteArrayInputStream(classBytes));
            // 0xcafebabe
            int magic = data.readInt();
            int minorVersion = data.readShort();
            int majorVersion = data.readShort();
            int constantPoolCount = data.readShort();
            int[] constantPool = new int[constantPoolCount];
            for (int i = 1; i < constantPoolCount; i++) {
                int tag = data.read();
                // int tableSize;
                switch (tag) {
                    case 1:     // UTF
                        int length = data.readShort();
                        char[] bytes = new char[length];
                        for (int k = 0; k < bytes.length; k++)
                            bytes[k] = (char) data.read();
                        String className = new String(bytes);
                        classNameTable.put(i, className);
                        break;
                    case 5:     // LONG
                    case 6:     // DOUBLE
                        data.readLong(); // 丢弃 8 字节
                        // 必要的特殊处理，跳过此处
                        i++;
                        break;
                    case 7:     // CLASS
                        int offset =  data.readShort();
                        offsetTable.put(i, offset);
                        break;
                    case 8:     // STRING
                        data.readShort(); // 抛弃 2 字节
                        break;
                    case 3:     // INTEGER
                    case 4:     // FLOAT
                    case 9:     // FIELD_REF
                    case 10:    // METHOD_REF
                    case 11:    // INTERFACE_METHOD_REF
                    case 12:    // NAME_AND_TYPE
                    case 18:    // Invoke Dynamic (动态指令调节)
                        data.readInt(); // 抛弃 4 字节
                        break;
                    case 15:    // Method Handle (方法句柄)
                        data.readByte();
                        data.readShort();
                        break;
                    case 16:    // Method Type (方法类型)
                        data.readShort();
                        break;
                    default:
                        throw new RuntimeException("Bad tag " + tag);
                }
            }
            short accessFlags = data.readShort();
            String access = (accessFlags & 0x001) == 0 ? "nonpublic" : "public";
            int thisClass = data.readShort();
            int superClass = data.readShort();
            return access + classNameTable.get(offsetTable.get(thisClass)).replace("/", ".");
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**/*.class");
        // 遍历整个树:
        Files.walk(Paths.get("."))
                .filter(matcher::matches)
                .map(p -> {
                    try {
                        return thisClass(Files.readAllBytes(p));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(s -> s.startsWith("public:"))
                // .filter(s -> s.indexOf('$') >= 0)
                .map(s -> s.split(":")[1])
                .filter(s -> !s.startsWith("enums."))
                .filter(s -> s.contains("."))
                .forEach(System.out::println);
    }
}
