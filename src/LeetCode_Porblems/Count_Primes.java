package LeetCode_Porblems;


import java.util.Arrays;

/**
 * LeetCode 204
 * */
public class Count_Primes {

    public static void main(String[] args) {
        int result = countPrimes(10);

        System.out.println(result);
    }

    public static int countPrimes(int n) {

        if(n<=2) return 0;

        boolean[] primes= new boolean[n];
        Arrays.fill(primes, true);
        int y=2;
        int count = 0;

        while(y<n) {

            if(primes[y]) {
                getPrime(primes, y);
                count++;
            }

            y++;
        }

        return count;

    }

    static void getPrime(boolean[] nums, int y) {

        for(int i=y*2;i<nums.length;i+=y) {
            nums[i] = false;
        }
    }
}
