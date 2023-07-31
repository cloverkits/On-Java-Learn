package ml.cloverkit.enums;

public interface Competitor<T extends Competitor<T>> {
    Outcome compete(T competitor);
}
