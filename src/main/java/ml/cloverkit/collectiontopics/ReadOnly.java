package ml.cloverkit.collectiontopics;

import onjava.Countries;

import java.util.*;

public class ReadOnly {
    static Collection<String> data = new ArrayList<>(Countries.names(6));

    public static void main(String[] args) {
        Collection<String> c = Collections.unmodifiableCollection(new ArrayList<>(data));
        System.out.println(c);  // 读是可以的
        // c.add("one");        // 不能修改它

        List<String> a = Collections.unmodifiableList(new ArrayList<>(data));
        ListIterator<String> lit = a.listIterator();
        System.out.println(lit.next()); // 读是可以的
        // 不能修改它
        lit.add("one");

        Set<String> s = Collections.unmodifiableSet(new HashSet<>(data));
        // 读是可以的
        System.out.println(s);
        // 不能修改它
        // s.add("one");

        // 对于 SortedSet
        Set<String> ss = Collections.unmodifiableSet(new TreeSet<>(data));

        Map<String, String> m = Collections.unmodifiableMap(new HashMap<>(Countries.capitals(6)));
        System.out.println(m);  // 读是可以的
        // m.put("Ralph", "Howdy!");

        // 对于 SortedMap:
        Map<String, String> sm = Collections.unmodifiableSortedMap(new TreeMap<>(Countries.capitals(6)));
    }
}
