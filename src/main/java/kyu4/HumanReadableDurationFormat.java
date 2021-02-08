package kyu4;

import java.util.*;

public class HumanReadableDurationFormat {
    private static Map<String, Integer> map = new LinkedHashMap<String, Integer>();

    public static void main(String[] args) {
        System.out.println("62 is " + formatDuration(62));
        System.out.println("3662 is "+ formatDuration(3662));
        System.out.println("3662 is " + formatDuration(8262485));
    }

    public static String formatDuration(int seconds) {
        // your code goes here
        if (seconds == 0) return "now";
        StringBuilder sb = new StringBuilder();
        mapFill(seconds);
        int ands = 0;
        for (String k : map.keySet()) {
            if (map.get(k) != 0) ands++;
            if (ands > 1) break;
        }
        int f=0;
        for(String k : map.keySet()){
            int value = map.get(k);
            if(value!=0){
                if(ands<2){
                    sb.append(endReturn(k,value));
                    break;
                }else{

                   String s = sb.toString();
                   if(f==0) {
                       sb = new StringBuilder(" and "+endReturn(k,value));
                       f++;
                   } else {
                       if(f==1){
                           sb = new StringBuilder();
                           sb.append(endReturn(k,value));
                           sb.append(s);
                           f++;
                       } else {
                           sb = new StringBuilder();
                           sb.append(endReturn(k, value));
                           sb.append(", ").append(s);
                       }
                   }
                }
            }
        }
        map.forEach((k,v)-> System.out.println(k+" "+v));
        if(seconds<31536000){
            String s = sb.toString().replace("1 year, ","");
            sb = new StringBuilder(s);}
        return sb.toString();
    }

    public static String endReturn(String word, int value) {
        if (value == 1) return value+" "+ word;
        else return value+" "+ word + "s";
    }

    public static void mapFill(int seconds){
        if(seconds<60) {
            map.put("second", seconds);
        } else{
            int f=0;
            f = seconds/60;
            map.put("second",seconds%60);
            if(f>59){
                map.put("minute",f%60);
                f=f/60;
                if(f>59){
                    map.put("hour",f%24);
                    f=f/24;
                    if(f>364){
                        map.put("day",f%365);
                        f=f/365;
                        map.put("year",f);
                    }else{
                        map.put("day",f);
                    }
                }else{
                    map.put("hour",f);
                }
            } else map.put("minute",f);
        }
    }
}
