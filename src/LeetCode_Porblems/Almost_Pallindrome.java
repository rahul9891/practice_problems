package LeetCode_Porblems;

public class Almost_Pallindrome {
	
	public static void main(String[] args) {
		
		System.out.println(validPalindrome("abca"));
		
	}
	
    public static boolean validPalindrome(String s) {
        
    	int left = 0;
    	int right = s.length()-1;
    	
    	while(left<right) {
    		if(s.charAt(left) != s.charAt(right)) {
    			return isPall(s, left+1, right) || isPall(s, left, right-1);
    		}
    		left++;
    		right--;
    	}
    	
    	return true;
    }
    
    static boolean isPall(String s, int i, int j) {
        int left = i;
        int right = j;
        
        while(left<right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }

}
