package CodingProblems.udemy_practice_problem.Graphs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DFS_Traversal {

    public static void main(String[] args) {

        int[][] array = new int[][] {{1,3}, {0}, {3,8}, {0,2,4,5}, {3,6}, {3}, {4,7}, {6}, {2}};
        Set<Integer> set = new LinkedHashSet<>();
        List<Integer> result = new ArrayList<>();

        dfs(array, set, array[0][0], result);

        for(int i:result) {
            System.out.print(i + " ");
        }
    }

    public static void dfs(int[][] arr, Set<Integer> set, int startVal, List<Integer> result) {

        if(set.contains(startVal)) {
            return;
        }

        result.add(startVal);
        set.add(startVal);
        int[] loopVal = arr[startVal];

        for(int i: loopVal) {
            dfs(arr, set, i, result);
        }
    }
}
