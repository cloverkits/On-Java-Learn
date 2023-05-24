package ml.cloverkit.reflection;

class Building {}
class House extends Building {}

public class ClassCasts {
    public static void main(String[] args) {
        Building b = new House();
        Class<House> houseType = House.class;
        House h = houseType.cast(b);
        // 或者直接这样进行转型
        h = (House) b;
        // 或者这样? 可以但是没必要
        h = House.class.cast(b);
    }
}
