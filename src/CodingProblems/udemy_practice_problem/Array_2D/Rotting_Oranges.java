package CodingProblems.udemy_practice_problem.Array_2D;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    static int[][] nav = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
    public static void main(String[] args) {
        int[][] input = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        Rotting_Oranges r = new Rotting_Oranges();

       int count =  r.orangesRotting(input);
        System.out.println(count);
    }



    public int orangesRotting(int[][] grid) {
        int freshCount = 0;
        int count =0;
        Queue<Integer[]> q = new LinkedList<>();
        for(int x=0;x<grid.length;x++) {
            for(int y=0;y<grid[x].length;y++) {
                if(grid[x][y] ==1) {
                    freshCount++;
                }
                if(grid[x][y] == 2) {
                    q.add(new Integer[]{x, y});
                }
            }
        }
        int qSize = q.size();
        while(!q.isEmpty()) {
            if(qSize == 0) {
                count++;
                qSize = q.size();
            }

            Integer[] curVal = q.poll();
            qSize--;

            for(int i=0;i<nav.length;i++) {
                int[] curNav = nav[i];
                int newRow = curVal[0]+curNav[0];
                int newCol = curVal[1]+curNav[1];
                if(newRow < 0 || newRow >= grid.length || newCol <0 || newCol >= grid[0].length) {
                    continue;
                }
                int newVal = grid[newRow][newCol];
                if(newVal == 1) {
                    freshCount--;
                    q.add(new Integer[]{newRow, newCol});
                    grid[newRow][newCol] = 2;
                }

            }


        }
        if(freshCount > 0) return -1;

        return count;

    }

//    public static int bfs(int[][] grid, Queue<Integer[]> q, int freshCount) {
//        int count = 0;
//        while(!q.isEmpty()) {
//            int qSize = q.size();
//            Integer[] curVal = q.poll();
//            grid[curVal[0]][curVal[1]] = 2;
//            if(qSize == 0) count++;
//            for(int i=0;i<nav.length;i++) {
//
//                int[] curNav = nav[i];
//
//                int newRow = curVal[0]+curNav[0];
//                int newCol = curVal[1]+curNav[1];
//                if(newRow >=0 && newRow < grid.length && newCol >=0 && newCol < grid[0].length) {
//                    int newVal = grid[newRow][newCol];
//                    if(newVal == 1) {
//                        freshCount--;
//                        q.add(new Integer[]{newRow, newCol});
//                    }
//                }
//            }
//
//
//        }
//        return count;
//    }
}
