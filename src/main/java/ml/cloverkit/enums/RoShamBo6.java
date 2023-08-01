// 给予 "tables" (表) 而非多路分发的 enum
package ml.cloverkit.enums;

public enum RoShamBo6 implements Competitor<RoShamBo6> {
    PAPER, SCISSORS, ROCK;

    private static final Outcome[][] table = {
            { Outcome.DRAW, Outcome.LOSE, Outcome.WIN }, // 布
            { Outcome.WIN, Outcome.DRAW, Outcome.LOSE }, // 剪刀 ✂️
            { Outcome.LOSE, Outcome.WIN, Outcome.DRAW }, // 石头 🪨
    };

    @Override
    public Outcome compete(RoShamBo6 other) {
        return table[this.ordinal()][other.ordinal()];
    }

    public static void main(String[] args) {
        RoShamBo.play(RoShamBo6.class, 20);
    }
}
