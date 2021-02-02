package kyu4;

import java.math.BigInteger;

public class BitCount {
    public static void main(String[] args) {
        System.out.println(countOnes(1,9));
        //Пока слишком долго для больших значений - доработать
    }
    public static BigInteger countOnes(long left, long right) {
        // Your code here
        long l = 0;
        for (long i = left; i <= right; i++) {
            System.out.println(i + " : "+ Long.toBinaryString(i));
            l += i;
        }
        BigInteger ret = new BigInteger(String.valueOf(l));
        return ret;
    }
}
