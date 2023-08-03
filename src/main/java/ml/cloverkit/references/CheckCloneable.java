// 检查一个引用是否可以克隆
package ml.cloverkit.references;

// 无法克隆————未重写 clone():
class Ordinary {}

// 重写 clone(), 未实现 Cloneable 接口:
class WrongClone extends Ordinary {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();   // 抛出异常
    }
}

// 完美克隆:
class IsCloneable extends Ordinary implements Cloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// 通过抛出异常来关闭克隆
class NoMore extends IsCloneable {
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

class TryMore extends NoMore {
    @Override
    public Object clone() throws CloneNotSupportedException {
        // 调用 NoMore.clone(), 抛出异常
        return super.clone();
    }
}

class BackOn extends NoMore {
    private BackOn duplicate(BackOn b) {
        // 以某种方式生成 b 副本，并返回该副本。这个副本毫无作用，只是为了举例:
        return new BackOn();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        // 未调用 NoMore.clone():
        return duplicate(this);
    }
}

// 你无法继承该类, 因为无法想 BackOn 中一样重写 clone():
final class ReallyNoMore extends NoMore {}

public class CheckCloneable {
    public static Ordinary tryToClone(Ordinary ord) {
        String id = ord.getClass().getName();
        System.out.println("Attempting " + id);
        Ordinary x = null;
        if (ord instanceof Cloneable) {
            try {
                x = ((Ordinary) ((IsCloneable) ord).clone());
                System.out.println("Cloned " + id);
            } catch (CloneNotSupportedException e) {
                System.out.println("Cloud not clone " + id);
            }
        } else {
            System.out.println("Doesn't implement Cloneable");
        }
        return x;
    }

    public static void main(String[] args) {
        // 向上转型:
        Ordinary[] ord = {
                new IsCloneable(),
                new WrongClone(),
                new NoMore(),
                new TryMore(),
                new BackOn(),
                new ReallyNoMore(),
        };
        Ordinary x = new Ordinary();
        for (Ordinary ord1: ord) {
            tryToClone(ord1);
        }
    }
}
