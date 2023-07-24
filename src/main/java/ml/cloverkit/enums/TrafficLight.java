package ml.cloverkit.enums;

// 定义一个枚举类型:
enum Signal {
    GREEN, YELLOW, RED,
}

public class TrafficLight {
    Signal color = Signal.RED;

    public void change() {
        switch (color) {
            // 注意在 case 语句中，无须使用 Signal.RED
            case RED:
                color = Signal.GREEN;
                break;
            case GREEN:
                color = Signal.YELLOW;
                break;
            case YELLOW:
                color = Signal.RED;
                break;
        }
    }

    @Override
    public String toString() {
        return "The traffic light is " + color;
    }

    public static void main(String[] args) {
        TrafficLight t = new TrafficLight();
        for (int i = 0; i < 7; i++) {
            System.out.println(t);
            t.change();
        }
    }
}
