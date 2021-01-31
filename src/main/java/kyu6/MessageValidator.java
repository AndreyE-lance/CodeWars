package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MessageValidator {
    public static void main(String[] args) {
        System.out.println(isAValidMessage("WyqrfnCmNefpuFLWyEkqiWcTTTleepeGBIwFrHAuzLvoOVkcCoGVBVlsXYlLNucyJKQECOKduePUaejTpribYvezOORtsInJeziuJyeInYPbfiNUEKKqWkhUZcznXQmvcrAPdDlUhIyWGxZTQuSMhOItFTAQdTgODuvmHnLM"));
    }
    public static boolean isAValidMessage(String message) {
        if(message.isEmpty()) return true;
        if(message.equals("0")) return true;
        List<String> wordsList = new LinkedList<>(Arrays.asList(message.split("\\d+")));
        wordsList.remove(0);
        System.out.println(wordsList);
        List<String> digitsList = new LinkedList<>(Arrays.asList(message.split("\\D+")));
        System.out.println(digitsList);
        if(digitsList.isEmpty()||wordsList.isEmpty()) return false;
        if(digitsList.size()!=wordsList.size()) return false;
        int i=0;
        for (String w:wordsList) {
            if(w.length()!=Integer.parseInt(digitsList.get(i))) return false;
            i++;
        }
        return true;
    }
}
