package kyu6;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/*https://www.codewars.com/kata/5616868c81a0f281e500005c/train/java*/
public class PrizeDraw {
    public static void main(String[] args) {

        String st = "Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden";
        Integer[] we = new Integer[] {1, 3, 5, 5, 3, 6};
        System.out.println(nthRank(st, we, 2));

    }

    public static String nthRank(String st, Integer[] we, int n) {
        // your code
        if(st.isEmpty()){
            return "No participants";
        }
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<String,Integer> weight = new HashMap<>();
        List<String> namesList = new LinkedList<>(Arrays.asList(st.split(",")));
        if(namesList.size()<n){
            return "Not enough participants";
        }
        AtomicInteger num= new AtomicInteger();
        namesList.forEach(s->{
            char[] charsName=s.toLowerCase(Locale.ROOT).toCharArray();
            int w = 0;
            for(int i = 0; i<charsName.length;i++){
                w+=alphabet.indexOf(charsName[i])+1;
            }
            w+=charsName.length;
            w*=we[num.get()];
            weight.put(s,w);
            num.getAndIncrement();
        });
        weight.forEach((k,v)-> System.out.println(k+" : "+v));
        List listRes = new LinkedList(weight.entrySet());
        Collections.sort(listRes, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                if(b.getValue() - a.getValue()!=0) return b.getValue() - a.getValue(); else{}
                return a.getKey().compareTo(b.getKey());
            }
        });
        listRes.forEach(l-> System.out.println(l));
        return String.valueOf(listRes.get(n-1)).split("=")[0];
    }

}
