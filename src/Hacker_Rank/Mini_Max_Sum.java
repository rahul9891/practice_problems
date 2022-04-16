package Hacker_Rank;

import java.util.ArrayList;


/**
 * 
 * Given an array of 5 positive numbers
 * print out the minimum and maximum sum of the 4 numbers
 * 
 *  a = [1,2,3,4,5]
 *  
 *  min sum = 1+2+3+4 = 10
 *  max sum = 2+3+4+5 = 13
 *  
 *  out put = 10 13
 * 
 * */
import java.util.List;

public class Mini_Max_Sum {

    public static void main(String[] args) {


        List<Integer> input = new ArrayList<>();
        int[] inputArr = new int[]{256741038, 623958417, 467905213, 714532089, 938071625};

        for(int i=0;i<inputArr.length;i++) {
            input.add(inputArr[i]);
        }

        miniMaxSum(input);

    }

    public static void miniMaxSum(List<Integer> arr) {
        // Write your code here
        int lowestValue = lowestValue(arr);
        System.out.println("lowest value - "+lowestValue);
        int highestValue = maxValue(arr);
        System.out.println("highest value - "+highestValue);

        System.out.print( sum(arr, highestValue) + " " +sum(arr, lowestValue));

    }

    public static Integer lowestValue(List<Integer> arr) {
        int minIndex = -1;
        int minValue = Integer.MAX_VALUE;
        for(int i=0;i<arr.size();i++) {
            int currentVal = arr.get(i);
            if(currentVal < minValue) {
                minValue = currentVal;
                minIndex = i;
            }
        }

        return minIndex;
    }

    public static Integer maxValue(List<Integer> arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;
        for(int i=0;i<arr.size();i++) {
            int current = arr.get(i);
            if(current > maxValue) {
                maxValue = current;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static Long sum(List<Integer> arr, int avoidIndex) {
        long sum =0;
        for(int i=0;i<arr.size();i++) {
            if(i != avoidIndex) sum += arr.get(i);
        }

        return sum;
    }
}
