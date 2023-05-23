package ml.cloverkit.strings;

/*! Here's a block of text to use as input to
     the regular expression matcher. Not that we
     first extract the block of text by looking for
     the special delimiters, then process the
     extracted block. !*/

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TheReplacements {
    public static void main(String[] args) throws Exception {
        String s = Files.lines(Paths.get("src/main/java/ml/cloverkit/strings/TheReplacements.java"))
                .collect(Collectors.joining("\n"));
        // 匹配上面被特地注释掉的文本快:
        Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL).matcher(s);

        if (mInput.find())
            // 被括号捕获的
            s = mInput.group(1);
        // 用一个空格替代两个或多个空格:
        s = s.replaceAll(" {2,}", " ");
        // 删除每行开头的一个或多个空格。必须启用多行模式
        s = s.replaceAll("(?m)^ +", "");
        System.out.println(s);
        s = s.replaceFirst("[aeiou]", "(VOWEL1)");
        StringBuffer sbuf = new StringBuffer();
        Pattern p = Pattern.compile("[aeiou]");
        Matcher m = p.matcher(s);
        // 一边查找一边替换:
        while (m.find())
            m.appendReplacement(sbuf, m.group().toUpperCase());
        // 插入文本的剩余部分:
        m.appendTail(sbuf);
        System.out.println(sbuf);
    }
}
