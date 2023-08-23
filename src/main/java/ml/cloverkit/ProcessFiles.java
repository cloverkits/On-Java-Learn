package ml.cloverkit;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.PathMatcher;

public class ProcessFiles {
    public interface Strategy {
        void process(File file);
    }

    private Strategy strategy;
    private String ext;

    public ProcessFiles(Strategy strategy, String ext) {
        this.strategy = strategy;
        this.ext = ext;
    }

    public void start(String[] args) {
        try {
            if (args.length == 0)
                processDirectoryTree(new File("."));
            else
                for (String arg : args) {
                    File fileArg = new File(arg);
                    if (fileArg.isDirectory())
                        processDirectoryTree(fileArg);
                    else {
                        // 用户可以去掉后缀名:
                        if (!arg.endsWith("." + ext))
                            arg += "." + ext;
                        strategy.process(new File(arg).getCanonicalFile());
                    }
                }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void processDirectoryTree(File root) throws IOException {
        PathMatcher matcher = FileSystems.getDefault()
                .getPathMatcher("glob:**/*.{" + ext + "}");
        Files.walk(root.toPath())
                .filter(matcher::matches)
                .forEach(p -> strategy.process(p.toFile()));
    }
}
