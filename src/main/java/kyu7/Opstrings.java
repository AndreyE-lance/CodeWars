package kyu7;
///https://www.codewars.com/kata/56dbe0e313c2f63be4000b25/train/java

interface Opsable {
    String Mirror(String s);
}

public class Opstrings {
    public static void main(String[] args) {


        String sVert = "IzOTWE\nkkbeCM\nWuzZxM\nvDddJw\njiJyHF\nPVHfSx";
        //"EWTOzI\nMCebkk\nMxZzuW\nwJddDv\nFHyJij\nxSfHVP"
        System.out.println(Opstrings.oper(Opstrings::vertMirror, sVert));

        String sHoriz = "njMK\ndbrZ\nLPKo\ncEYz";
        //"cEYz\nLPKo\ndbrZ\nnjMK"
        System.out.println(Opstrings.oper(Opstrings::horMirror, sHoriz));
    }

    public static String vertMirror (String strng) {
        String[] array = strng.split("\\n");
        String result = "";
        for (String s: array) {
            StringBuilder sb = new StringBuilder(s);
            result+=sb.reverse().append("\n").toString();
        }
        return result.trim();
        // your code
    }
    public static String horMirror (String strng) {
        String[] array = strng.split("\\n");
        StringBuilder result = new StringBuilder();
        for(int i = array.length-1;i>=0;i--){
            result.append(array[i]).append("\n");
        }
        return result.toString().trim();
        // your code
    }
    public static String oper(Opsable operator, String s) {
        // your code and complete ... before operator
        return operator.Mirror(s);
    }
}
