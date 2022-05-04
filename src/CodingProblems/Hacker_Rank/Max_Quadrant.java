package CodingProblems.Hacker_Rank;


import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2d-array which is 2n X 2n size. find the sum of the maximum quadrant
 *
 * Example:
 *      [[1 2 3 4],
 *      [5 6 7 8],
 *      [9 10 11 12],
 *      [13 14 15 16]]
 *
 *   Here each quadrant is [1 2 5 6], [3 4 7 8], [9 10 13 14] etc..
 *
 *   here the sum of each quadrant would be [1+2+5+6] and so on..
 *
 *   so highest sum would be [11+12+15+16] = 54 (output)
 *
 * */
public class Max_Quadrant {

    public static void main(String[] args) {

    }


    public static int flipMatrix(List<List<Integer>> matrix) {

        int size = matrix.size();
        int sum = 0;
        for(int i=0;i<(size/2+1);i++) {
            for(int j=0;j<(size/2+1);j++) {
                List<Integer> list = new ArrayList<>();
                list.add(matrix.get(i).get(j));
                list.add(matrix.get(i).get(size - j - 1));
                list.add(matrix.get(size-i-1).get(j));
                list.add(matrix.get(size-i-1).get(size - j - 1));
                sum += max(list);

            }
        }

        return sum;
    }

    public static int max(List<Integer> list) {
        int maxValue = Integer.MIN_VALUE;

        for(int n: list) {
            if(n > maxValue) maxValue = n;
        }
        return maxValue;
    }


}
