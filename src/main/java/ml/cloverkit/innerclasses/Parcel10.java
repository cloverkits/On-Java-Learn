package ml.cloverkit.innerclasses;

public class Parcel10 {

    public Destination destination(final String dest, final float price) {
        return new Destination() {
            private int cost;
            // 为每个对象执行实例初始化
            {
                cost = Math.round(price);
                if (cost > 100) {
                    System.out.println("Over budget!");
                }
            }
            private String label = dest;
            @Override
            public String readLabel() {
                return label;
            }
        };
    }

    public static void main(String[] args) {
        Parcel10 p = new Parcel10();
        Destination d = p.destination("Tasmania", 101.395F);
    }
}
