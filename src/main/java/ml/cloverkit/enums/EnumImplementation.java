package ml.cloverkit.enums;

import java.util.SplittableRandom;
import java.util.function.Supplier;

enum CartoonCharacter implements Supplier<CartoonCharacter> {
    SLAPPY, SPANKY, PUNCHY,
    SILLY, BOUNCY, NUTTY, BOB;

    private SplittableRandom rand = new SplittableRandom(47);

    @Override
    public CartoonCharacter get() {
        return values()[rand.nextInt(values().length)];
    }
}

public class EnumImplementation {
    public static <T> void printNext(Supplier<T> rg) {
        System.out.print(rg.get() + ", ");
    }

    public static void main(String[] args) {
        // 选择任一示例:
        CartoonCharacter cc = CartoonCharacter.BOB;
        for (int i = 0; i < 10; i++)
            printNext(cc);
    }
}
