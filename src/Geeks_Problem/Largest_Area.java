package Geeks_Problem;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a grid of dimension nxm containing 0s and 1s. Find the unit area of the largest region of 1s.
 * Region of 1's is a group of 1's connected 8-directionally (horizontally, vertically, diagonally).
 *
 *
 * Example 1:
 *
 * Input: grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}}
 * Output: 5
 * Explanation: The grid is-
 * 1 1 1 0
 * 0 0 1 0
 * 0 0 0 1
 * The largest region of 1's is colored
 * in orange.
 * Example 2:
 *
 * Input: grid = {{0,1}}
 * Output: 1
 * Explanation: The grid is-
 * 0 1
 * The largest region of 1's is colored in
 * orange.
 *
 * */
public class Largest_Area {
    int[][] directions = new int[][]{{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
    public static void main(String[] args) {

        int[][] grid = {{1,1,1,0},{0,0,1,0},{0,0,0,1}};

        Largest_Area l = new Largest_Area();
        int result  = l.findMaxArea(grid);
        System.out.println(result);

    }

    public int findMaxArea(int[][] grid)
    {
        int maxL=0;
        for(int j=0;j<grid.length;j++) {
            for(int k=0;k<grid[j].length;k++) {
                if(grid[j][k] == 1)
                maxL = Math.max(maxL, bfs(grid, j, k));

            }
        }
        return maxL;

    }

    public int bfs(int[][] grid, int start, int end) {

        Queue<int[]> q = new LinkedList<>();

        int size = 0;
        grid[start][end] = 2;
        q.add(new int[]{start, end});

        while(q.isEmpty() == false) {

            size += q.size();

            int[] val = q.poll();

            for(int i=0;i<directions.length;i++) {

                int[] currVal = directions[i];

                int newRow = val[0]+currVal[0];
                int newCol = val[1]+currVal[1];

                if(newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) {
                    continue;
                } else {
                    grid[newRow][newCol] = 2;
                    q.add(new int[]{newRow, newCol});
                }

            }
        }

        return size;
    }
}
