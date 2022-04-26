package udemy_practice_problem.Array_2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS_2DArray {

    static int[][] directions = new int[][]{{-1,0}, {0,1}, {1,0}, {0,-1}};
    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}};
        List<Integer> result = dfs_traversal(input);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> dfs_traversal(int[][] input) {

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        dfs(input, 0, 0, map, result);
        return result;
    }


    public static void dfs(int[][] arr, int row, int col, Map<Integer, Integer> map, List<Integer> result) {

        if(row < 0 || row >= arr.length || col < 0 || col >= arr[0].length || map.containsKey(arr[row][col])) {
            return;
        }
        result.add(arr[row][col]);
        map.put(arr[row][col], 1);
        for(int i=0;i<directions.length;i++) {
            int[] currDir = directions[i];
            dfs(arr, row + currDir[0], col + currDir[1], map, result);
        }

    }
}
