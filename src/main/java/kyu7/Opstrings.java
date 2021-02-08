package kyu7;
///https://www.codewars.com/kata/56dbe0e313c2f63be4000b25/train/java

interface Opsable {
    String Mirror(String s);
}

public class Opstrings {
    public static void main(String[] args) {
        String sVert = "TestVert";
        System.out.println(Opstrings.oper(Opstrings::vertMirror, sVert));
        String sHoriz = "TestHorizont";
        System.out.println(Opstrings.oper(Opstrings::horMirror, sHoriz));
    }

    public static String vertMirror (String strng) {
        return strng;
    }

    public static String horMirror (String strng) {
        return strng;
    }

    public static String oper(Opsable operator, String s) {
        return operator.Mirror(s);
    }
}
