package ml.cloverkit.files;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class Writing {
    static Random rand = new Random(47);
    static final int SIZE = 1000;

    public static void main(String[] args) throws Exception {
        // 将字节写入一个文件：
        byte[] bytes = new byte[SIZE];
        rand.nextBytes(bytes);
        Files.write(Paths.get("bytes.dat"), bytes);
        System.out.println("bytes.data: " + Files.size(Paths.get("bytes.dat")));

        // 将一个实现了 Iterable 接口的类的对象写入一个文件
        List<String> lines = Files.readAllLines(Paths.get(Writing.class.getClassLoader().getResource("Cheese.dat").toURI()));
        Files.write(Paths.get(Writing.class.getClassLoader().getResource("Cheese.txt").toURI()), lines);
        System.out.println("Cheese.txt: " + Files.size(Paths.get(Writing.class.getClassLoader().getResource("Cheese.txt").toURI())));
    }
}
