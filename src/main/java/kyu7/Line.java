package kyu7;
/*Sheldon, Leonard, Penny, Rajesh and Howard are in the queue for a
"Double Cola" drink vending machine; there are no other people in the queue.
 The first one in the queue (Sheldon) buys a can, drinks it and doubles! The
 resulting two Sheldons go to the end of the queue. Then the next in the queue
 (Leonard) buys a can, drinks it and gets to the end of the queue as two Leonards, and so on.

For example, Penny drinks the third can of cola and the queue will look like this:

Rajesh, Howard, Sheldon, Sheldon, Leonard, Leonard, Penny, Penny
Write a program that will return the name of the person who will drink the n-th cola.

Input:
The input data consist of an array which contains at least 1 name, and single integer
 n which may go as high as the biggest number your language of choice supports
 (if there's such limit, of course).

Output / Examples:
Return the single line — the name of the person who drinks the n-th can of cola.
 The cans are numbered starting from 1.*/

import java.sql.Time;
import java.util.*;

import static java.lang.Math.pow;

public class Line {
    public static void main(String[] args) {
        String[] names = new String[]{"Sheldon", "Leonard", "Penny", "Rajesh", "Howard"};
        long startTime = System.currentTimeMillis();
        System.out.println(WhoIsNext(names, Integer.MAX_VALUE)); //3178
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime - startTime) + "ms");
    }

    public static String WhoIsNext(String[] names, int n) {
        // Your code is here...
        String name = "";
        /*//List<String> list = new ArrayList<>(Arrays.asList(names.clone()));
        Deque<String> deque = new ArrayDeque<>(Arrays.asList(names.clone()));
        for(int i=0; i<n;i++){
            name = deque.pollFirst();
            deque.add(name);
            deque.add(name);
        }*/
        int p = 0;
        if (n < 6) {
            name = names[n - 1];
        } else {
            while(5* pow(2,p)<=n){
                n-=5* pow(2,p);
                p++;
            }
            int res = (int) (n/Math.pow(2, p));
            if(res==0) name = "Sheldon";
            if(res==1) name = "Leonard";
            if(res==2) name = "Penny";
            if(res==3) name = "Rajesh";
            if(res==4) name = "Howard";
        }
        return name;
    }
}
