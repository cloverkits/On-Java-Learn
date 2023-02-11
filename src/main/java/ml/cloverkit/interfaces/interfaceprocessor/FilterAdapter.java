package ml.cloverkit.interfaces.interfaceprocessor;

import ml.cloverkit.interfaces.filters.Filter;
import ml.cloverkit.interfaces.filters.Waveform;

/**
 * 适配器模式
 */
public class FilterAdapter implements Processor {
    Filter filter;

    FilterAdapter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String name() {
        return filter.name();
    }

    @Override
    public Object process(Object input) {
        return filter.process((Waveform) input);
    }
}
