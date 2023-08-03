// 在继承层次结构中的任意一层插入可克隆性
package ml.cloverkit.references;

class Person {}

class Hero extends Person {}

class Scientist extends Person implements Cloneable {
    @Override
    public Scientist clone() {
        try {
            return ((Scientist) super.clone());
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MedScientist extends Scientist {}

public class HorrorFlick {
    public static void main(String[] args) {
        Person p = new Person();
        Hero h = new Hero();
        Scientist s = new Scientist();
        MedScientist m = new MedScientist();
        Scientist sClone = s.clone();
        MedScientist mClone = (MedScientist) m.clone();
    }
}
