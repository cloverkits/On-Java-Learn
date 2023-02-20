package ml.cloverkit.collections;

import java.util.Map;

record Employee(String name, int id) {}
public class BasicRecord {
    public static void main(String[] args) {
        Employee bob = new Employee("Bob Dobbs", 11);
        Employee dot = new Employee("Dorothy Gale", 9);
        // 错误
        // bob.id = 11;
        System.out.println(bob.name());
        System.out.println(bob.id());
        System.out.println(bob);
        Map<Employee, String> map = Map.of(bob, "A", dot, "B");
        System.out.println(map);
    }
}
