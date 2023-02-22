package ml.cloverkit.functional;

interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {

    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

class Unrated {
    static String twich(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    Strategy strategy;
    String msg;

    Strategize(String msg) {
        this.msg = msg;
        strategy = new Soft();
    }

    void comunicate() {
        System.out.println(strategy.approach(msg));
    }

    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        Strategy[] strategies = {
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase() + "!";
                    }
                },
                msg -> msg.substring(0, 5),
                Unrated::twich
        };
        Strategize s = new Strategize("Hello there");
        s.comunicate();
        for (Strategy strategy : strategies) {
            s.changeStrategy(strategy);
            s.comunicate();
        }
    }
}
