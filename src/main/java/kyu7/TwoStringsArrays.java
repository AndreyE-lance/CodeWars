package kyu7;

/*Given two arrays of strings a1 and a2 return a sorted
array r in lexicographical order of the strings of a1
which are substrings of strings of a2.

#Example 1: a1 = ["arp", "live", "strong"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns ["arp", "live", "strong"]

#Example 2: a1 = ["tarp", "mice", "bull"]

a2 = ["lively", "alive", "harp", "sharp", "armstrong"]

returns []*/
import java.util.*;

public class TwoStringsArrays {
    public static void main(String[] args) {
        String a[] = new String[]{ "arp", "live", "strong" };
        String b[] = new String[] { "lively", "alive", "harp", "sharp", "armstrong" };
        System.out.println(Arrays.toString(inArray(a,b)));
    }

    public static String[] inArray(String[] array1, String[] array2) {
        Set<String> result = new TreeSet<>();
        for (String subStr: array1) {
            for(int i =0;i< array2.length;i++){
                if(array2[i].contains(subStr)){
                    result.add(subStr);
                    break;
                }
            }
        }
        if(!result.isEmpty()) result.stream().sorted();
        return result.toArray(new String[0]);
    }
}
