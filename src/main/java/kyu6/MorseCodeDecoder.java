package kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorseCodeDecoder {
    public static void main(String[] args) {
        System.out.println(decode(".... . -.--   .--- ..- -.. ."));
    }

    public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the
        // preloaded Morse code table through MorseCode.get(code)
        List<String> lList = new ArrayList<String>(Arrays.asList(morseCode.split("\\s{1,2}")));
        lList.forEach(l-> System.out.println(l));
        StringBuilder ret = new StringBuilder();
        for (String s : lList) {
            if (!s.equals(""))
                ret.append(MorseCode.get(s));
            else {
                ret.append(" ");
            }
        }
        return ret.toString().trim();
    }
}

class MorseCode {
    public static String get(String s) {
        return "A";
    }
}
