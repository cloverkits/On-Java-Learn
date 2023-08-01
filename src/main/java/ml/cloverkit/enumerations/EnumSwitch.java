package ml.cloverkit.enumerations;

public class EnumSwitch {
    enum Signal { GREEN, YELLOW, RED }
    Signal color = Signal.RED;

    public void change() {
        color = switch (color) {
            case RED    -> Signal.GREEN;
            case GREEN  -> Signal.YELLOW;
            case YELLOW -> Signal.RED;
        };
    }
}
