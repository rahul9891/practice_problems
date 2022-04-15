package udemy_practice_problem;

import java.util.ArrayDeque;

public class Expand_Mine_Sweeper {

    public static void main(String[] args) {
        
    }

    /**
     * 
     * 
     * @param field 2-D array
     * @param rows rows in the output
     * @param cols columns in the output
     * @param givenI row number for mine
     * @param givenJ colun number for mine
     * @return resultant 2-D array
     */
    static int[][] click(int[][] field, int rows, int cols, int givenI, int givenJ) {

      //  int[][] result = new int[rows][cols];
        
        ArrayDeque<int[]> queue = new ArrayDeque<>();

        if(field[givenI][givenJ] == 0) {

            field[givenI][givenJ] = -2;
            int[] cordinates = {givenI, givenJ};
            queue.add(cordinates);

        } else return field;

        while(!queue.isEmpty()) {

            int[] newCordinates = queue.remove();
            int currentI = newCordinates[0];
            int currentJ = newCordinates[1];

            for(int i = currentI -1;i<=currentI+1;i++) {
                for(int j=currentJ-1;j<=currentJ+1;j++) {
                    if(i >= 0 && i < rows && j >=0 && j < cols && field[i][j] == 0) {
                        field[i][j] = -2;
                        int[] cordinates = {i,j};
                        queue.add(cordinates);
                    }
                }
            }
        }

        return field;
    }
    
}
