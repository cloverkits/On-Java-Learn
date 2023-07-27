package ml.cloverkit.enums;

import java.util.Random;

public enum Input {
    NICKEL(5), DIME(10), QUARTER(25), DOLLAR(100),
    TOOTHPASTE(200), CHIPS(75), SODA(100), SOAP(50),
    ABORT_TRANSACTION {
        @Override
        int amount() {  // 不允许
            throw new RuntimeException("ABORT.amount()");
        }
    },
    STOP {  // 这必须是最后一个实例
        @Override
        int amount() {  // 不允许
            throw new RuntimeException("SHUT_DOWN.amount()");
        }
    }
    ;
    int value;  // 单位为美分 (cent)

    Input(int value) {
        this.value = value;
    }

    // 无参构造器，提供给没有 value 值的枚举实例
    Input() {}

    int amount() {
        return value;   // 单位为美分 (cent)
    }

    static final Random rand = new Random(47);

    public static Input randomSelection() {
        // 也不包括 STOP:
        return values()[rand.nextInt(values().length - 1)];
    }
}
