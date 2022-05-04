package CodingProblems.LeetCode_Porblems;


/**
 * LeetCode q no 686
 * */
public class Reapeated_String_Match {

    public static void main(String[] args) {

        int result = repeatedStringMatch("abcd", "cdabcdab");

        System.out.println(result);

    }

    public static int repeatedStringMatch(String a, String b) {

        if(b.length() % a.length() != 0) return -1;
        char match = b.charAt(0);
        int i;
        for(i=0;i<a.length();i++) {
            if(a.charAt(i) == match) {
                break;
            }
        }
        int aMatch = i;

        for(int j=0;j<b.length();j++) {
            if(b.charAt(j) != a.charAt((j+aMatch) % a.length())) {
                return -1;
            }
        }
        int length= b.length()/a.length();

        if(a.charAt(0) == b.charAt(0)) {
            return length;
        } else {
            return length+1;
        }
    }
}
