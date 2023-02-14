package ml.cloverkit.interfaces;

sealed interface Ifc permits Imp1, Imp2 {}

final class Imp1 implements Ifc {}
final class Imp2 implements Ifc {}

sealed abstract class AC permits X {}
final class X extends AC{}