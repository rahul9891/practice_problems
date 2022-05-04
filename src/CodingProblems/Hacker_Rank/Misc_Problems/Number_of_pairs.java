package CodingProblems.Hacker_Rank.Misc_Problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Calculate the number of pairs from the given array 
 * when substracted from each other gives the given integer k
 * 
 * @parameter int k, List<Integer> arr
 * @return int number of pairs
 * 
 * input pairs(2, [1,5,3,4,2]
 * output [5,3] [4,2] [3,1] output = 3
 * */
public class Number_of_pairs {

	public static void main(String[] args) {
		
		List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		arr.add(6);
		arr.add(8);
		arr.add(9);
		arr.add(4);
		
		int result = pairs(2, arr);
		int result1 = pair_with_pointers(2, arr);
		
		System.out.println(result);
		System.out.println(result1);
		
	}
	
	static int pairs(int k, List<Integer> arr) {
		int count =0;
		Set<Integer> set = new HashSet<>();
		
		for(int i=0;i<arr.size();i++) {
			set.add(arr.get(i));
		}
		
		for(int i=0;i<arr.size();i++) {
			if(set.contains(arr.get(i) + k)) {
				count++;
			}
		}
		return count;
		
	}
	
	// [1,2,3,4,5] [1,4,6,8,9]
	static int pair_with_pointers(int k, List<Integer> arr) {
		int count =0;
		
		int left = 0;
		int right = 1;
		Collections.sort(arr);
		while(right < arr.size()) {
			int diff = Math.abs(arr.get(left) - arr.get(right));
			if(diff == k) {
				count++;
				right++;
			} else if(diff > k) {
				left++;
			} else {
				right++;
			}
			
		}
		
		return count;
	}

}
