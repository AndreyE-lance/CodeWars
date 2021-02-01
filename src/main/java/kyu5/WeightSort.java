package kyu5;

/*My friend John and I are members of the "Fat to Fit Club (FFC)".
 John is worried because each month a list with the weights of
 members is published and each month he is the last on the list which means he is the heaviest.

I am the one who establishes the list so I told him: "Don't worry any
more, I will modify the order of the list". It was decided to attribute
a "weight" to numbers. The weight of a number will be from now on the sum of its digits.

For example 99 will have "weight" 18, 100 will have "weight" 1 so in
the list 100 will come before 99.

Given a string with the weights of FFC members in normal order can you
give this string ordered by "weights" of these numbers?

When two numbers have the same "weight", let us class them as
if they were strings (alphabetical ordering) and not numbers:

180 is before 90 since, having the same "weight" (9), it comes before as a string.

All numbers in the list are positive numbers and the list can be empty.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Paar implements Comparable<Paar> {
    private final int weight;
    private final String value;

    public Paar(int weight, String value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(Paar o) {
        if(weight-o.weight!=0){
        return weight - o.weight;}else{
            return value.compareTo(o.getValue());
        }
    }

    @Override
    public String toString() {
        return "Paar{" +
                "weight=" + weight +
                ", value='" + value + '\'' +
                '}';
    }
}

public class WeightSort {
    public static void main(String[] args) {
        System.out.println(orderWeight("2000 103 123 4444 99"));
        System.out.println(orderWeight("11 11 2000 10003 22 123 1234000 44444444 9999"));
    }

    public static String orderWeight(String string) {
        StringBuilder sb = new StringBuilder();
        List<Paar> paars = new ArrayList<>();
        if (!string.isEmpty()) {
            String[] input = string.split(" ");
            for (String s : input) {
                paars.add(new Paar(getWeight(s), s));
            }
            Collections.sort(paars);
            paars.forEach(p -> {
                sb.append(p.getValue());
                sb.append(" ");
            });
        }
        return sb.toString().trim();
    }

    public static int getWeight(String number) {
        int result = 0;
        String[] array = number.split("");
        for (String s : array) {
            result += Integer.parseInt(s);
        }
        return result;
    }
}
