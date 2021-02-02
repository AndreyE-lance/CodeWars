package kyu6;
/*
* Let us consider this example (array written in general format):

ls = [0, 1, 3, 6, 10]

Its following parts:

ls = [0, 1, 3, 6, 10]
ls = [1, 3, 6, 10]
ls = [3, 6, 10]
ls = [6, 10]
ls = [10]
ls = []
The corresponding sums are (put together in a list): [20, 20, 19, 16, 10, 0]

The function parts_sums (or its variants in other languages) will take as parameter
* a list ls and return a list of the sums of its parts as defined above.*/


import java.util.Arrays;

public class SumParts {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumParts(new int[]{0, 1, 3, 6, 10})));
    }

    public static int[] sumParts(int[] ls) {
        int sum = 0;
        int[] parts;
        if (ls.length == 0) {
            parts = new int[1];
            parts[0] = 0;
        } else {
            parts = new int[ls.length+1];
            sum = Arrays.stream(ls).sum();
            parts[0] = sum;
            for (int i = 1; i < ls.length; i++) {
                sum -= ls[i - 1];
                parts[i] = sum;
            }
            parts[ls.length] = 0;
        }
        return parts;

    }
}
