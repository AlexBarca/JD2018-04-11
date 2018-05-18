package by.it.obmetko.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    private static <T extends Number> Set<T> getUnion(Set<T>... a) {
        Set<T> result = new HashSet<>();
        for (Set<T> set : a) {
            result.addAll(set);
        }
        return result;
    }

    private static <T extends Number> Set<T> getCross(Set<T>... a) {
        Set<T> result = null;
        for (Set<T> set : a) {
            if (result == null)
                result = new HashSet<>(set);
            else
                result.retainAll(set);
        }
        return result;
    }


    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1, 2,-33, 4, 5, 5, 12, 6, 75, 7, 68,-89));
        Set<Integer> b = new TreeSet<>(Arrays.asList(8, 9, 10, 14,-55, 5, 6, 6,-77, 7, 86,-33));
        Set<Integer> c = new HashSet<>(Arrays.asList(1, 2, 43, 5, 11, 6,-33, 6, 75, 77, 1, 8));
        Set<Integer> d = new TreeSet<>(Arrays.asList(8,-89, 10, 43, 5, 13, 6, 6, 7, 97, 8,-33));
        Set<Integer> unionRes = getUnion(a, b, c, d);
        System.out.println("getUnion(a, b, c, d) result: " + unionRes);
        Set<Integer> crossRes = getCross(a, b, c);
        System.out.println("getCross(a, b, c) result: " + crossRes);
    }


}

