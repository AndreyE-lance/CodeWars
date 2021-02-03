package kyu4;
/*Write a function that, given a string of text
(possibly with punctuation and line-breaks),
returns an array of the top-3 most occurring words,
in descending order of the number of occurrences.

Assumptions:
A word is a string of letters (A to Z) optionally containing
one or more apostrophes (') in ASCII. (No need to handle fancy punctuation.)
Matches should be case-insensitive, and the words in the result should be lowercased.
Ties may be broken arbitrarily.
If a text contains fewer than three unique words, then either
the top-2 or top-1 words should be returned, or an empty array if a text contains no words.*/


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopWords {
    public static void main(String[] args) {
        //System.out.println(top3("xQBjiIpW DcpWdbKG PzTgkPrr,dqCvOHn,xQBjiIpW?dqCvOHn CRLjwDB DcpWdbKG,LNV xQBjiIpW,PzTgkPrr LNV DcpWdbKG x'k-LNV LNV dqCvOHn qSobB DcpWdbKG,RwIVXqpw dqCvOHn-CRLjwDB dqCvOHn?LNV_dqCvOHn/PzTgkPrr xQBjiIpW?PzTgkPrr/CRLjwDB xQBjiIpW LNV?dqCvOHn:PzTgkPrr dqCvOHn xQBjiIpW?qSobB dqCvOHn.LNV,x'k dqCvOHn x'k qSobB dqCvOHn_gxWDjHDa CRLjwDB LNV RwIVXqpw PzTgkPrr qSobB/LNV CRLjwDB PzTgkPrr,gxWDjHDa-CRLjwDB CRLjwDB,RwIVXqpw;xQBjiIpW LNV!qSobB,dqCvOHn LNV-bfDGKc bfDGKc xQBjiIpW CRLjwDB;CRLjwDB LNV dqCvOHn.CRLjwDB x'k?x'k-dqCvOHn!CRLjwDB dqCvOHn qSobB;x'k dqCvOHn_qSobB dqCvOHn!xQBjiIpW PzTgkPrr bfDGKc PzTgkPrr:xQBjiIpW_RwIVXqpw_LNV PzTgkPrr:PzTgkPrr.dqCvOHn-dqCvOHn xQBjiIpW;DcpWdbKG DcpWdbKG!LNV;xQBjiIpW LNV PzTgkPrr-xQBjiIpW/dqCvOHn x'k?xQBjiIpW!LNV RwIVXqpw?x'k:qSobB PzTgkPrr,xQBjiIpW DcpWdbKG:PzTgkPrr.CRLjwDB PzTgkPrr PzTgkPrr xQBjiIpW;dqCvOHn.xQBjiIpW!LNV gxWDjHDa qSobB PzTgkPrr x'k:xQBjiIpW DcpWdbKG PzTgkPrr DcpWdbKG;LNV LNV LNV:LNV CRLjwDB_dqCvOHn!x'k!LNV,x'k dqCvOHn LNV?gxWDjHDa CRLjwDB;PzTgkPrr LNV LNV,dqCvOHn_xQBjiIpW,LNV x'k LNV CRLjwDB bfDGKc LNV;CRLjwDB;DcpWdbKG/CRLjwDB xQBjiIpW:qSobB dqCvOHn dqCvOHn x'k DcpWdbKG_CRLjwDB DcpWdbKG!dqCvOHn_bfDGKc LNV:dqCvOHn LNV_x'k!x'k ").toString());
        System.out.println(top3("  '''  "));
    }

    public static List<String> top3(String s) {
        // Your code here
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[A-Z'a-z]+");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {
            String key = matcher.group().toLowerCase();
            if (!map.containsKey(key)) {
                map.put(key, 1);
            } else {
                map.replace(key, map.get(key) + 1);
            }
        }
        map.forEach((k, v) -> System.out.println(v + " : " + k));

        List list = new LinkedList(map.entrySet());
        Collections.sort(list, (Comparator<Map.Entry<String, Integer>>) (a, b) -> b.getValue() - a.getValue());
        List<String> result = new LinkedList<>();
        int iter = 0;
        if (list.size() < 3) iter = list.size(); else iter=3;
        for(int i = 0; i<iter;i++){
            if(!list.get(i).toString().split("=")[0].equals("\\'"))result.add(list.get(i).toString().split("=")[0]);
            if(result.get(0).equals("'''")||result.get(0).equals("'")) result.clear();
        }
        return result;
    }
}
