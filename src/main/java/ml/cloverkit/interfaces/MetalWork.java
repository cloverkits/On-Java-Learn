package ml.cloverkit.interfaces;

class Heat implements Operation {
    @Override
    public void execute() {
        Operation.show("Heat");
    }
}

public class MetalWork {
    public static void main(String[] args) {
        Operation twist = new Operation() {
            @Override
            public void execute() {
                Operation.show("Twist");
            }
        };

        Operation.runOpt(
                new Heat(),
                new Operation() {
                    @Override
                    public void execute() {
                        Operation.show("Hammer");
                    }
                },
                twist,
                () -> Operation.show("Anneal")
        );
    }
}
