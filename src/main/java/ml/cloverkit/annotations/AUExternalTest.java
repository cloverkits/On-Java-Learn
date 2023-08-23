package ml.cloverkit.annotations;

import onjava.atunit.Test;

public class AUExternalTest extends AtUnitExample1 {

    @Test
    boolean tMethodOne() {
        return methodOne().equals("This is methodOne");
    }

    @Test
    boolean tMethodTwo() {
        return methodTwo() == 2;
    }
}
