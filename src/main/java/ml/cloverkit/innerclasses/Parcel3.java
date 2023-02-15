package ml.cloverkit.innerclasses;

public class Parcel3 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        public String readLabel() {
            return this.label;
        }
    }

    public static void main(String[] args) {
        Parcel3 p = new Parcel3();
        // 必须使用外部类的实例来创建内部类的实例
        Parcel3.Contents contents = p.new Contents();
        Parcel3.Destination tasmania = p.new Destination("Tasmania");
    }
}
