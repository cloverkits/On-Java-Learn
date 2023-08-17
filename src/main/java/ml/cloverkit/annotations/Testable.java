package ml.cloverkit.annotations;

import ml.cloverkit.atunit.Test;

public class Testable {
    public void execute() {
        System.out.println("executing...");
    }

    @Test
    void testExecute() {
        execute();
    }
}
