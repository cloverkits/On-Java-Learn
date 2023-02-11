package ml.cloverkit.interfaces;

import java.util.Arrays;

class Processor {
    public String name() {
        return getClass().getName();
    }

    public Object process(Object input) {
        return input;
    }
}

class Upcase extends Processor {
    // 协变返回
    @Override
    public String process(Object input) {
        return ((String) input).toUpperCase();
    }
}

class Downcase extends Processor {
    @Override
    public String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override
    public String process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

public class Applicator {
    public static void apply(Processor p, Object s) {
        System.out.println("Using Process " + p.name());
        System.out.println(p.process(s));
    }

    public static void main(String[] args) {
        String s = "We are such as dreams are made on";
        apply(new Upcase(), s);;
        apply(new Downcase(), s);
        apply(new Splitter(), s);
    }
}
