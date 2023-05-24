package ml.cloverkit.reflection.pets;

import java.util.ArrayList;
import java.util.List;

public class ForNamePetCreator extends Creator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static final String[] typeNames = {
            "ml.cloverkit.reflection.pets.Mutt",
            "ml.cloverkit.reflection.pets.Pug",
            "ml.cloverkit.reflection.pets.EgyptianMau",
            "ml.cloverkit.reflection.pets.Manx",
            "ml.cloverkit.reflection.pets.Cymric",
            "ml.cloverkit.reflection.pets.Rat",
            "ml.cloverkit.reflection.pets.Mouse",
            "ml.cloverkit.reflection.pets.Hamster"
    };

    // @SuppressWarnings 不能直接应用于 {} 静态初始化块
    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }
}
