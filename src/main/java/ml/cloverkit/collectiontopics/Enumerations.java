// Java 1.0/1.1 中的 Vector 和 Enumeration
package ml.cloverkit.collectiontopics;

import onjava.Countries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Vector;

public class Enumerations {
    public static void main(String[] args) {
        Vector<String> v = new Vector<>(Countries.names(10));
        Enumeration<String> e = v.elements();
        while (e.hasMoreElements())
            System.out.println(e.nextElement() + ", ");
        // 为任何 Collection 生成一个 Enumeration:
        e = Collections.enumeration(new ArrayList<>());
    }
}
