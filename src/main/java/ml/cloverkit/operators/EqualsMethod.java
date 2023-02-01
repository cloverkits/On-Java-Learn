package ml.cloverkit.operators;

public class EqualsMethod {

    public static void main(String[] args) {
        ValA va1 = new ValA();
        ValA va2 = new ValA();
        va1.i = va2.i = 100;
        System.out.println(va1.equals(va2));
        ValB vb1 = new ValB();
        ValB vb2 = new ValB();
        vb1.i = vb2.i = 100;
        System.out.println(vb1.equals(vb2));
    }
}

class ValA {
    int i;
}

class ValB {
    int i;

    @Override
    public boolean equals(Object o) {
        if (o instanceof ValB valB) {
            return i == valB.i;
        }
        return false;
    }
}
