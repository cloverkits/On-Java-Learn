package ml.cloverkit.interfaces.interfaceprocessor;

import ml.cloverkit.interfaces.filters.BandPass;
import ml.cloverkit.interfaces.filters.HighPass;
import ml.cloverkit.interfaces.filters.LowPass;
import ml.cloverkit.interfaces.filters.Waveform;

public class FilterProcessor {
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Applicator.apply(new FilterAdapter(new LowPass(1.0)), w);
        Applicator.apply(new FilterAdapter(new HighPass(2.0)), w);
        Applicator.apply(new FilterAdapter(new BandPass(3.0,4.0)), w);
    }
}
