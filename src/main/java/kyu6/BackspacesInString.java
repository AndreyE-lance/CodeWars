package kyu6;

/*Assume "#" is like a backspace in string.
This means that string "a#bc#d" actually is "bd"

Your task is to process a string with "#" symbols.*/

public class BackspacesInString {
    public static void main(String[] args) {
        System.out.println(cleanString("abc####d##c#"));
    }

    public static String cleanString(String s) {
        StringBuilder sb = new StringBuilder();
        char[] array = s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(array[i]!='#'){
                sb.append(array[i]);
            }else{
                if(sb.length()>0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sb.toString();
    }
}
