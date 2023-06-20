package ml.cloverkit.generics;

import java.util.ArrayList;
import java.util.List;

public class nonCovariantGenerics {
    // Compile Error: incompatible types
    // List<Fruit> first = new ArrayList<Apple>();
}
