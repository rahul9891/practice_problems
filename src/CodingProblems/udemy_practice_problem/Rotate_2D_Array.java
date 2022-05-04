package CodingProblems.udemy_practice_problem;

public class Rotate_2D_Array {
    

    public static void main(String[] args) {
        
        int[][] results = rotate_array(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 3);


        for(int[] result: results) {
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
        }
    }

    static int[][] rotate_array(int[][] input, int n) {

        int[][] result = new int[n][n];

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<n;j++) {
                result[j][n-1-i] = input[i][j];
            }
        }

        return result;
    }

/**
 * Rotate array without using a new array
 * @param input
 * @param n
 * @return
 */
    static int[][] rotate_in_place_array(int[][] input, int n) {

        int[] temp_arr = new int[4];


        for(int i=0;i<(Math.ceil(n/2) - 1);i++) {
            for(int j=0;j<(Math.floor(n/2) - 1);j++) {
               int[] result = rotate_sub(i, j, n);
                for(int k=0;k<4;k++) {
                    temp_arr[k] = input[i][j];
                    result = rotate_sub(i, j, n);
                }
                for(int k=0;k<4;k++) {
                    input[i][j] = temp_arr[(k+3) % 4];
                    result = rotate_sub(i, j, n);
                }

            }
        }
        return input;
    }


    static int[] rotate_sub(int i, int j, int n) {
        int[] result = new int[2];

        result[0] = j;
        result[1] = n-1-i;

        return result;
    }
}