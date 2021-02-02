package kyu7;

/*Definition
Extra perfect number is the number that first and last bits are set bits.

Task
Given a positive integer N , Return the extra perfect numbers in range from 1 to N .

*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExtraPerfectNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(extraPerfect(39)));
    }
    public static int[] extraPerfect(int number) {
        System.out.println(isExtra(Integer.toBinaryString(number)));
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=number;i++){
            if(isExtra(Integer.toBinaryString(i))){
                list.add(i);
            }
        }
        return list.stream().mapToInt(x -> x).toArray(); // Do your magic!
    }

    public static boolean isExtra(String string) {
        if (string.charAt(0) == string.charAt(string.length()-1)) {
            return true;
        } else {
            return false;
        }
    }
}
