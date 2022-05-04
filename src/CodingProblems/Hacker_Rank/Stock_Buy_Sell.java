package CodingProblems.Hacker_Rank;

import java.util.ArrayList;

public class Stock_Buy_Sell {

    public static void main(String[] args) {
        int[] input = new int[]{11, 42 ,49, 96, 23 ,20 ,49 ,26, 26, 18, 73, 2, 53, 59, 34, 99, 25, 2};

        ArrayList<ArrayList<Integer>> result = stockBuySell(input, input.length);
        for(ArrayList<Integer> i: result) {
            System.out.print(i.get(0) + " "+ i.get(1));
            System.out.println();
        }
    }

    static ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
        int left = 0;
        int right = 1;
        int profit = 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        while(left < n && right < n) {

            while(right<n && profit < A[right] - A[left]) {
                profit = A[right] - A[left];
                right++;
            }

            if(profit > 0) {
                ArrayList<Integer> subList = new ArrayList<>();
                subList.add(left);
                subList.add(right-1);
                result.add(subList);
                left = right;
                right = left+1;
                profit=0;
            }
            else if(profit == 0) {
                left++;
                right = left+1;
            }
        }
        return result;
       // return null;
    }
}
