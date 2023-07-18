package ml.cloverkit.arrays;

import ml.cloverkit.Rand;

import java.util.Arrays;

import static ml.cloverkit.ArrayShow.show;

public class ModifyExisting {
    public static void main(String[] args) {
        double[] da = new double[7];
        Arrays.setAll(da, new Rand.Double()::get);
        show(da);
        Arrays.setAll(da, n -> da[n] / 100);
        show(da);
    }
}
