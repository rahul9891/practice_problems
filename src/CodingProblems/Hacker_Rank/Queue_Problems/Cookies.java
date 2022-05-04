package CodingProblems.Hacker_Rank.Queue_Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A = [2,7,3,6,4,6] k =9
 * 
 * smallest numbers = [2,3] -> 2 + 3*2 = 8
 * 
 * A' = [8,7,6,4,6]
 * 
 * smallest numbers = [6,4] -> 4 + 6*2 = 16
 * 
 * A'' = [8,7,16,6]
 * 
 * ... so on
 * 
 * it would take 4 iterations to reach where all the values are greater than k
 * 
 * [23,20,16]
 * 
 * */
public class Cookies {
	
	public static void main(String[] args) {
		
		int[] input = new int[] {1,62,14};
		List<Integer> A = new ArrayList<Integer>();
		for(int i=0;i<input.length;i++) {
			A.add(input[i]);
		}
		
		int result = cookies(9, A);
		
		System.out.println(result);
		
		
	}
	
	static int cookies(int k, List<Integer> A) {
		
        Queue<Integer> pq = new PriorityQueue<>(A);
        
//        A.forEach(item -> {
//            if(item.intValue() < k) {
//                pq.offer(item);
//            }
//        });
        
        int count =0;
        
        while(pq.size() > 1 && pq.peek() < k) {
            Integer a = pq.poll();
            Integer b = pq.poll();        
            int sum = a + (2*b);
            pq.offer(sum);
            count++;
        }
        
        if(pq.size() == 1 && pq.peek() < k) return -1;
        
        return count;
		
	}

}
