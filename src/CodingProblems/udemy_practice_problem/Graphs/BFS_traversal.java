package CodingProblems.udemy_practice_problem.Graphs;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS_traversal {
	
	public static void main(String[] args) {
		List<List<Integer>> input = new ArrayList<>();
		
		int[][] array = new int[][] {{1,3}, {0}, {3,8}, {0,2,4,5}, {3,6}, {3}, {4,7}, {6}, {2}};
		
		bfs(array);
	}
	
	
	public static  void bfs(int[][] arr) {
		List<Integer> result = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		Set<Integer> set = new LinkedHashSet<>();
		q.add(arr[0][0]);
		result.add(arr[0][0]);
		set.add(arr[0][0]);
		while(!q.isEmpty()) {
			
			int val = q.poll();
			
			int[] valArr = arr[val];
			
			for(int i: valArr) {
				if(!set.contains(i)) {
					q.add(i);
					set.add(i);
					result.add(i);
				}
			}
		}
		
		for(int i: result) {
			System.out.print(i +" ");
		}
	}

}
