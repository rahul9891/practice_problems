package CodingProblems.LeetCode_Porblems;


/**
 * LeetCode 1025
 * */
public class Divisor_Game {
    public static boolean divisorGame(int n) {
        int count=0;
        while(n > 1) {
            
            n = n - maxFactor(n);
            count++;
        }
        
        return count%2 != 0;
        
    }
    
    static int maxFactor(int n) {
        
        int max = 0;
        
        for(int i=1;i<n;i++) {
            if(n%i== 0) {
                max = Math.max(max, i);
            }
        }
        return max;
    }
    
    public static void main(String[] args) {
		System.out.println(divisorGame(3));
	}
}
