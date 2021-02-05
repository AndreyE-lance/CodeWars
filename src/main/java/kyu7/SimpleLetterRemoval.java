package kyu7;

import java.util.Random;

public class SimpleLetterRemoval {
    public static void main(String[] args) {
        System.out.println(solve("abracadabra", 0));
    }

    public static String solve(String s, int k) {


        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int alphabetIndex = 0;
        String result = "";
        if(k==0) result = s;
        if (s.length() >= k) {
            for (int i = 0; i < k; i++) {
                result = s.replaceFirst(String.valueOf(alphabet.charAt(alphabetIndex)), "");
                if (s.equals(result)) {
                    i--;
                    alphabetIndex++;
                }
                s = result;
            }
        }
        return result; // Do your magic!
    }
}
