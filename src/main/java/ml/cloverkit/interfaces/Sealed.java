package ml.cloverkit.interfaces;

sealed class Base permits D1, D2 {

}

final class D1 extends Base {}
final class D2 extends Base {}

// final class D3 extends Base {}

public class Sealed {
    public static void main(String[] args) {
        // D3 d3 = new D3();
    }
}
