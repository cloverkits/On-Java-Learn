package ml.cloverkit.collections;

import reflection.pets.*;

import java.util.*;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = new PetCreator().list(7);
        System.out.println("1: " + pets);
        Hamster h = new Hamster();
        // 自动调整大小
        pets.add(h);
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h));
        // 按对象移除
        pets.remove(h);
        Pet p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));
        Pet cymric = new Cymric();
        System.out.println("5 " + pets.indexOf(cymric));
        System.out.println("6 " + pets.remove(cymric));
        // 必须是类型精准匹配的对象
        System.out.println("7: " + pets.remove(p));
        System.out.println("8: " + pets);
        // 在某个索引处插入
        pets.add(3, new Mouse());
        System.out.println("9: " + pets);
        List<Pet> sub = pets.subList(1, 4);
        System.out.println("subList: " + sub);
        System.out.println("10: " + pets.containsAll(sub));
        // 就地排序
        Collections.sort(sub);
        System.out.println("sorted subList: " + sub);
        // 在 containsAll() 中，顺序并不重要
        System.out.println("11: " + pets.containsAll(sub));
        // 混合一下 (洗牌)
        Collections.shuffle(sub, rand);
        System.out.println("shuffled subList " + sub);
        System.out.println("12: " + pets.containsAll(sub));
        ArrayList<Pet> copy = new ArrayList<>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        System.out.println("sub: " + sub);
        copy.retainAll(sub);
        System.out.println("13: " + copy);
        // 获得一个新副本
        copy = new ArrayList<>(pets);
        // 按索引移除
        copy.remove(2);
        System.out.println("14: " + copy);
        // 仅一处类型精准匹配的对象
        copy.removeAll(sub);
        System.out.println("15: " + copy);
        // 替换一个元素
        copy.set(1, new Mouse());
        System.out.println("16: " + copy);
        // 中间插入一个列表
        copy.addAll(2, sub);
        System.out.println("17: " + copy);
        System.out.println("18: " + pets.isEmpty());
        pets.clear();
        System.out.println("19: " + pets);
        System.out.println("20: " + pets.isEmpty());
        pets.addAll(new PetCreator().list(4));
        System.out.println("21: " + pets);
        Object[] o = pets.toArray();
        System.out.println("22: " + o[3]);
        Pet[] pa = pets.toArray(new Pet[0]);
        System.out.println("23: " + pa[3].id());
    }
}
