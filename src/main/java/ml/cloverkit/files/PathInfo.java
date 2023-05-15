package ml.cloverkit.files;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathInfo {
    static void show(String id, Object p) {
        System.out.println(id + p);
    }

    static void info(Path p) {
        show("toString:\n", p);
        show("Exists: ", Files.exists(p));
        show("Regular File: ", Files.isRegularFile(p));
        show("Directory: ", Files.isDirectory(p));
        show("Absolute: ", p.isAbsolute());
        show("Parent: ", p.getParent());
        show("Root: ", p.getRoot());
        System.out.println("*".repeat(20));
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("os.name"));
        info(Paths.get("C:", "path", "to", "nowhere", "NoFile.txt"));
        Path p = Paths.get("src/main/java/ml/cloverkit/files/PathInfo.java");
        info(p);
        Path ap = p.toAbsolutePath();
        info(ap);
        info(ap.getParent());

        try {
            info(p.toRealPath());
        } catch (IOException e) {
            System.out.println(e);
        }

        URI u = p.toUri();
        System.out.println("URI:\n" + u);
        Path puri = Paths.get(u);
        System.out.println(Files.exists(puri));

        // 不要被骗了
        File f = ap.toFile();
    }
}
