package udemy_practice_problem;

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
}