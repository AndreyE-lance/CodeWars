package kyu6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Complete the solution so that the function
 will break up camel casing, using a space between words.

Example
solution("camelCasing")  ==  "camel Casing"*/
public class BreakCamelCase {
    public static void main(String[] args) {
            System.out.println(camelCase("small[BeSeemVerbsWorldEye]Big"));
        /*System.out.println(camelCase("different Verbs [Woman Way] Want Take"));
        System.out.println(camelCase("...t New Make Own Look [Great] Great Public"));*/
    }

    public static String camelCase(String input) {
        Pattern pattern = Pattern.compile("[A-Z]");
        Matcher matcher = pattern.matcher(input);
        String output = input;
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            if(input.substring(start-1,end-1).matches("[a-z&\\]]")){
            output = output.replace(input.substring(start,end), " "+input.substring(start,end));}
        }
        return output;
    }
}
