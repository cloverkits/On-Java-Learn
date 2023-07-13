package ml.cloverkit.generics;

import ml.cloverkit.Suppliers;

import java.util.ArrayList;
import java.util.List;

class Customer {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Customer " + id;
    }
}

class Teller {
    private static long counter = 1;
    private final long id = counter++;

    @Override
    public String toString() {
        return "Teller " + id;
    }
}

class Bank {
    private List<BankTeller> tellers = new ArrayList<>();
    public void put(BankTeller bt) {
        tellers.add(bt);
    }
}

public class BankTeller {
    public static void serve(Teller t, Customer c) {
        System.out.println(t + "serves " + c);
    }

    public static void main(String[] args) {
        // 演示 create():
        RandomList<Teller> tellers = Suppliers.create(RandomList::new, Teller::new, 4);
        // 演示 fill():
        ArrayList<Customer> customers = Suppliers.fill(new ArrayList<>(), Customer::new, 12);
        customers.forEach(c -> serve(tellers.select(), c));
        // 演示辅助类型机制:
        Bank bank = Suppliers.fill(new Bank(), Bank::put, BankTeller::new, 3);
        // 也可以实用第二个版本的 fill():
        List<Customer> customers2 = Suppliers.fill(
                new ArrayList<>(), List::add, Customer::new, 12
        );
    }
}
