package by.it.kasiyanov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 5, 5, 5, 6, 7, 7, 7));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 6, 6, 7, 8, 9, 9, 9, 9, 10));
        System.out.println(getUnion(a, b));
        System.out.println(getCross(a, b));
    }
}
