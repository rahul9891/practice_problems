package udemy_practice_problem;

import java.util.HashMap;

public class Is_One_Away {
	
	public static void main(String[] args) {
		
       System.out.println("1 - " + isOneAway("abcde", "abcd"));  // should return true
      System.out.println("2 - " +isOneAway("abde", "abcde"));  // should return true
      System.out.println("3 - " +isOneAway("a", "a"));  // should return true
      System.out.println("4 - " +isOneAway("abcdef", "abqdef"));  // should return true
      System.out.println("5 - " +isOneAway("abcdef", "abccef"));  // should return true
      System.out.println("6 - " +isOneAway("abcdef", "abcde"));  // should return true
      System.out.println("7 - " +isOneAway("aaa", "abc"));  // should return false
      System.out.println("8 - " +isOneAway("abcde", "abc"));  // should return false
      System.out.println("9 - " +isOneAway("abc", "abcde"));  // should return false
      System.out.println("10 - " +isOneAway("abc", "bcc"));  // should return false
		
	}
	
	static Boolean isOneAway(String s1,String s2) {
        if(s1.length() - s2.length() > Math.abs(1)) {
            return false;
        }
        
        if(s1.length() - s2.length() == 0) {
            int count =0;
            for(int i=0;i<s1.length();i++) {
                if(s1.charAt(i) != s2.charAt(i)) count++;
            }
            if(count > 1) return false;

            return true;
        }
        
        if(s1.length() > s2.length()) {
            return isDiffOne(s1, s2);
        } else {
            return isDiffOne(s2, s1);
        }
	}

    static Boolean isDiffOne(String s1, String s2) {

        int i=0;
        int count=0;

        while(i < s2.length()) {
            if(s1.charAt(i+count) == s2.charAt(i)) {
                i += 1;
            } else {
                count +=1;
            }
            if(count > 1) return false;
        }
        return true;
    }

}
