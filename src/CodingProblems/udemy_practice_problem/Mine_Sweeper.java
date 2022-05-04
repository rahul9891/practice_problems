package CodingProblems.udemy_practice_problem;

public class Mine_Sweeper {
    
    public static void main(String[] args) {
        int[][] result = mine_sweeper(new int[][]{{0,0}, {0,1}}, 3, 4);
        
        printResult(result);
    }

    static int[][] mine_sweeper(int[][] bombs, int rows, int cols) {
        int[][] result = new int[rows][cols];

        result = assignValues(result, 0, 3, 4);

        for(int[] bomb : bombs) {
            int row_i = bomb[0];
            int col_i = bomb[1];
            result[row_i][col_i] = -1;

            for(int i = row_i -1;i<=row_i+1;i++) {
                for(int j = col_i -1; j<= col_i+1;j++) {
                    if((i >= 0 && i < rows) && (j >= 0 && j < cols) && result[i][j] != -1) {
                        result[i][j] += 1;
                    }
                }
            }
        }
        return result;

    }

    static void printResult(int[][] results) {

        for(int[] result : results) {
            System.out.println(result[0] + " " + result[1]);
        }
    }

    static int[][] assignValues(int[][] arr, int val, int rows, int cols) {

        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                arr[i][j] = val;
            }
        }

        return arr;
    }
}
