package CodingProblems.LeetCode_Porblems;


/**
 *  LeetCode 1295
 * */
public class Even_Number_Digits {

    public static void main(String[] args) {

        int result = findNumbers(new int[]{2,5,3,7,9});
        System.out.println(result);
    }

    public static int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++) {

            if(getLength(nums[i]) % 2 == 0) count++;
        }

        return count;
    }


    static int getLength(int n) {

        int count = 0;
        while(n > 9) {
            n /= 10;
            count++;
        }
        count++;
        return count;
    }
}
