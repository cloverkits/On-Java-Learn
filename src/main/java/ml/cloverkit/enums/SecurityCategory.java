package ml.cloverkit.enums;

import ml.cloverkit.Enums;

// 更简洁的枚举子归类
enum SecurityCategory {
    STOCK(Security.Stock.class),
    BOUND(Security.Bond.class);

    Security[] values;

    SecurityCategory(Class<? extends Security> kind) {
        this.values = kind.getEnumConstants();
    }

    interface Security {
        enum Stock implements Security {
            SHORT, LONG, MARGIN
        }

        enum Bond implements Security {
            MUNICIPAL, JUNK
        }
    }

    public Security randomSelection() {
        return Enums.random(values);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            SecurityCategory category = Enums.random(SecurityCategory.class);
            System.out.println(category + ": " + category.randomSelection());
        }
    }
}
