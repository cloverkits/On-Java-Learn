package ml.cloverkit.exceptions;

// 重写的方法只能抛出其基类版本中说明异常
// 或者是以这些异常为基类派生出来的异常

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    Inning() throws BaseballException {}

    public void event() throws BaseballException {
        // 实际上不是必须抛出异常
    }

    public abstract void atBat() throws Strike, Foul;

    // 没有抛出检测型异常
    public void walk() {}
}

class StromException extends Exception {}
class RainedOut extends StromException {}
class PopFoul extends Foul {}

interface Strom {
    void event() throws RainedOut;
    void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Strom {
    // 可以为构造器添加异常，但是
    // 必须处理基类构造器的异常
    public StormyInning() throws RainedOut, BaseballException {}

    public StormyInning(String s) throws BaseballException {}

    // 普通方法必须遵守积累方法的约定 (编译错误)
    // public void walk() throws PopFoul {}
    // 对于基类中不存在的方法，接口可以自行声明:
    @Override
    public void rainHard() throws RainedOut {}
    // 技术基类版本会抛出异常，
    // 我们也可以选择不抛出异常
    @Override
    public void event() {}
    // 重写的方法，可以抛出其积累版本所说明的异常的子类:
    @Override
    public void atBat() throws PopFoul {}

    public static void main(String[] args) {
        try {
            StormyInning si = new StormyInning();
        } catch (PopFoul e) {
            System.out.println("Pop foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
        // 派生版本没有抛出 Strike
        try {
            // 如果向上转型，会发生什么情况？
            Inning i = new StormyInning();
            i.atBat();
            // 必须捕获来自该方法的基类版本的异常
        } catch (Strike e) {
            System.out.println("Strike");
        } catch (Foul e) {
            System.out.println("Foul");
        } catch (RainedOut e) {
            System.out.println("Rained out");
        } catch (BaseballException e) {
            System.out.println("Generic baseball exception");
        }
    }
}
