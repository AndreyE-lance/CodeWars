package kyu6;

/*Encrypt this!

You want to create secret messages which can be deciphered by the Decipher this! kata. Here are the conditions:

Your message is a string containing space separated words.
You need to encrypt each word in the message using the following rules:
The first letter needs to be converted to its ASCII code.
The second letter needs to be switched with the last letter
Keepin' it simple: There are no special characters in input.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encrypt1 {
    public static void main(String[] args) {
        System.out.println(encryptThis("Hello world"));
        System.out.println(encryptThis("A wise old owl lived in an oak"));
    }

    public static String encryptThis(String text) {
        // Implement me! :)
        if (text.equals("")) return "";
        String[] stringArray = text.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            String[] str = stringArray[i].split("");
            int ascii = str[0].charAt(0);
            str[0] = String.valueOf(ascii);
            if (str.length > 1) {
                String a = str[1];
                str[1] = str[str.length - 1];
                str[str.length - 1] = a;
            }
            StringBuilder sb = new StringBuilder();
            for (String string : str) {
                sb.append(string);
            }

            result.append(sb);
            if (i + 1 != stringArray.length) result.append(" ");
        }
        return result.toString();
    }

}
