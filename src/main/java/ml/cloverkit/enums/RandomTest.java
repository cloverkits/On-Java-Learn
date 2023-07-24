package ml.cloverkit.enums;

import ml.cloverkit.Enums;

enum Activity {
    SITING, LYING, STANDING, HOPPING, RUNNING, DOGGING, JUMPING, FALLING, FLYING
}

public class RandomTest {
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++)
            System.out.print(Enums.random(Activity.class) + " ");
    }
}
