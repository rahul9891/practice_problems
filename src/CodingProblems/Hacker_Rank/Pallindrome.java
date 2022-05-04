package CodingProblems.Hacker_Rank;

public class Pallindrome {
	
	
	
	/**
	 * 
	 * Given a string find the index of character if removed makes the string as Pallindrome
	 * 
	 * a = "aaab"  if index = 3 char 'b' is removed, it becomes a pallindrome
	 * 
	 * a = "aaa" it is already a pallidrome, return -1
	 * 
	 * a = "baa" if index = 0 char 'b' is removed, it becomes a pallindrome
	 * 
	 * */
	public static int pallindromeIndex(String s) {
		
		int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (isPalidrom(s,i,j-1)) {
                    return j;
                } else {
                    return i;
                }
            } 
            i ++;
            j --;
        }
        return -1;
	}
	
	static boolean isPalidrom(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) !=  s.charAt(j)) {
                return false;
            }
            i +=1;
            j -=1;
        }
        return true;
    }
	
	public static void main(String[] args) {
		
		System.out.println(pallindromeIndex("baba"));
	}

}
