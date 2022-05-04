package CodingProblems.Hacker_Rank;

public class Caesar_Cipher {

    public static void main(String[] args) {
        String result = caesarCipher("www.abc.xy", 87);
        System.out.println(result);
    }

    static String caesarCipher(String s, int k) {
        String result = "";

        for(Character c: s.toCharArray()) {
            if(Character.isLetter(c)) {
                if(Character.isUpperCase(c)) {
                    int val = ((int) c + k - 65)%26;
                    result += String.valueOf((char) (val+65));
                } else {
                    int val = ((int) c + k - 97)%26;
                    result += String.valueOf((char) (val+97));
                }
            } else {
                result += c;
            }
        }
        return result;
    }
}
