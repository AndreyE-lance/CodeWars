package kyu7;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TwoToOne {
    public static void main(String[] args) {
        System.out.println(longest("abcd","dctr"));
    }
    public static String longest (String s1, String s2) {
        // your code
        String sb = s1+s2;
        Set<String> set = new TreeSet<String>();
        for (char c:sb.toCharArray()) {
            set.add(String.valueOf(c));
        }
        sb="";
        for (String s: set) {
            sb+=s;
        }
        return sb;
    }
}
