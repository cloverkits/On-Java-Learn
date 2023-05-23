package ml.cloverkit.strings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JGrep {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println(
                    "Usage: java JGrep file regex"
            );
            System.exit(0);
        }

        Pattern p = Pattern.compile(args[1]);
        Matcher m = p.matcher("");
        // 遍历输入文件的每一行
        Files.readAllLines(Paths.get(args[0])).forEach(
                line -> {
                    m.reset(line);
                    while (m.find())
                        System.out.println(m.group() + ": " + m.start());
                }
        );
    }
}
