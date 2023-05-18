package ml.cloverkit.strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Hex {
    public static String format(byte[] data) {
        StringBuilder result = new StringBuilder();
        int n = 0;

        for (byte b : data) {
            if (n % 16 == 0)
                result.append(String.format("%05X: ", n));
            result.append(String.format("%02X ", b));
            n++;
            if (n % 16 == 0) result.append("\n");
        }
        result.append("\n");
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length == 0)
            // 通过输出这个类文件来测试
            System.out.println(format(Files.readAllBytes(Paths.get("target/classes/ml/cloverkit/strings/Hex.class"))));
        else
            System.out.println(format(Files.readAllBytes(Paths.get(args[0]))));
    }
}
