package udemy_practice_problem.Array_2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS_Traversal {
	
	int[][] directions = new int[][] {{-1,0}, {0,1}, {1,0}, {0,-1}};
	
	public static void main(String[] args) {
		int[][] input = new int[][]{{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}};
		BFS_Traversal b = new BFS_Traversal();
		
		List<Integer> result = b.bfs(input, 2, 2);
		
		for(int i: result) {
			System.out.print(i + " ");
		}
		
	}
	
	public List<Integer> bfs_traversal(int[][] arr) {
		
		return bfs(arr, 0,0);
			
	}
	
	public List<Integer> bfs(int[][] arr, int row, int col) {
		List<Integer> result = new ArrayList<>();
		Queue<Integer[]> q = new LinkedList<>();
		Map<Integer, Boolean> seen = new HashMap<>();
		
		
		q.add(new Integer[] {row, col});
		result.add(arr[row][col]);
		seen.put(arr[row][col], true);
		
		while(!q.isEmpty()) {
			
			Integer[] currVal = q.poll();
			
			for(int i=0;i<directions.length;i++) {
				int[] currDir = directions[i];
				int newRow = currVal[0] + currDir[0];
				int newCol = currVal[1] + currDir[1];
				if(newRow < 0 || newRow >= arr.length || newCol < 0 || newCol >= arr[0].length) {

				} else {
					int value = arr[newRow][newCol];
					if(!seen.containsKey(value)) {
						q.add(new Integer[] {newRow, newCol});
						result.add(value);
						seen.put(value, true);
					}
				}

			}
		}
		return result;
	}
}
