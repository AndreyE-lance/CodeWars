package kyu7;

/*Complete the solution so that it splits the string into pairs of
two characters. If the string contains an odd number of characters then it should replace
the missing second character of the final pair with an underscore ('_').*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitString {
    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution("abcde")));
    }

    public static String[] solution(String s) {
        //Write your code here
        List<String> array = new ArrayList<>();
        if (s.length() == 1) {
            array.add(s + '_');
        }
        int i = 0;
        while (s.length() > i) {
            if (i + 1 >= s.length()) {
                array.add(s.substring(i) + '_');
            } else {
                array.add(s.substring(i, i + 2));
            }
            i += 2;
        }
        return array.toArray(new String[0]);
    }
}
