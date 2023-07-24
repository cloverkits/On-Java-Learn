package ml.cloverkit.enums;

import java.util.stream.Stream;

public enum SpaceShip {
    SCOUT, CARGO, TRANSPORT, CRUISER, BATTLESHIP, MOTHERSHIP;

    @Override
    public String toString() {
        String id = name();
        String lowser = id.substring(1).toLowerCase();
        return id.charAt(0) + lowser;
    }

    public static void main(String[] args) {
        Stream.of(values()).forEach(System.out::println);
    }
}
