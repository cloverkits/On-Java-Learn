// 里氏替代原则
package ml.cloverkit.enumerations;

import java.util.stream.Stream;

interface LifeForm {
    String move();
    String react();
}

class Worm implements LifeForm {

    @Override
    public String move() {
        return "Worm()::move()";
    }

    @Override
    public String react() {
        return "Worm()::react()";
    }
}

class Giraffe implements LifeForm {

    @Override
    public String move() {
        return "Giraffe()::move()";
    }

    @Override
    public String react() {
        return "Giraffe()::react()";
    }
}

public class NormalLiskov {
    public static void main(String[] args) {
        Stream.of(new Worm(), new Giraffe())
                .forEach(lf -> System.out.println(lf.move() + " " + lf.react()));
    }
}
