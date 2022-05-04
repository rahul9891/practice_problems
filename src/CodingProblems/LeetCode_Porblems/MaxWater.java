package CodingProblems.LeetCode_Porblems;


/**
 * Leetcode problem number 11
 * */
public class MaxWater {
	public static void main(String[] args) {
		
	}
	
	static int maxArea_brute(int[] arr) {
	    int maxWater = 0;
	    for(int i=0;i<arr.length-1;i++) {
	      for(int j=i+1;j<arr.length;j++) {
	        int water = Math.min(arr[j], arr[i]) * (j-i);
	        maxWater = Math.max(water, maxWater);
	      }
	    }
	    return maxWater;
	}
	
	
	static int maxArea_optimal(int[] arr) {
		int left=0;
		int right = arr.length-1;
		int max = 0;
		while(left < right) {
			int area = Math.min(arr[left], arr[right]) * (right -left);
			max = Math.max(max, area);
			if(arr[left] <= arr[right]) left++;
			else right--;
		}
		
		return max;
	}
}
