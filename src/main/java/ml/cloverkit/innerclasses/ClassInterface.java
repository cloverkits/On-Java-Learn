package ml.cloverkit.innerclasses;

public interface ClassInterface {

    void howdy();

    class Test implements ClassInterface {

        @Override
        public void howdy() {
            System.out.println("Howdy!");
        }
    }

    static void main(String[] args) {
        new Test().howdy();
    }
}
