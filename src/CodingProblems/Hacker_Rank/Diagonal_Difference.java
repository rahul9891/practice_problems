package CodingProblems.Hacker_Rank;

import java.util.List;


/**
 * Given a 2-D array, return the absolute difference between the sum of diagonal
 * */
public class Diagonal_Difference {

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int leftDiag = 0;
        int rightDiag = 0;
        for(int i=0;i<arr.size();i++) {
            for(int j=0;j<arr.get(i).size();j++) {
                if(i==j) leftDiag += arr.get(i).get(j);
                if(j == (arr.size() -1 - i)) rightDiag += arr.get(i).get(j);
            }
        }

        return Math.abs(leftDiag - rightDiag);

    }

    public static void main(String[] args) {

    }
}
