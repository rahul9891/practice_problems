package CodingProblems.LeetCode_Porblems;

public class Trapping_Rainwater {
	
	public static void main(String[] args) {
		int result = maxWater(new int[] {0,1,0,2,1,0,3,1,0,1,2});
		
		System.out.println(result);
	}
	
	
	static int maxWater1(int[] arr) {
		int totalWater = 0;
		for(int i=0;i<arr.length;i++) {
			
			int left = i;
			int right = i;
			int leftMax = 0;
			int rightMax =0;		
			while(left >= 0) {
				
				leftMax = Math.max(leftMax, arr[left]);
				left--;
			}
			while(right < arr.length) {
				
				rightMax = Math.max(rightMax, arr[right]);
				right++;
			}
			
			int water = Math.min(rightMax, leftMax) - arr[i];
			if(water > 0)
			totalWater += water;
			left--;
			right++;
				
		}
		
		return totalWater;
	}
	
	static int maxWater(int[] arr) {
		int totalWater = 0;
		int left = 0;
		int right = arr.length-1;
		int leftMax = 0;
		int rightMax = 0;
		
		while(left < right) {
			
			if(arr[left] <= arr[right]) {
			//	if(left>0) {
					if(arr[left] > leftMax) {
						leftMax = arr[left];
					} else {
						totalWater += leftMax - arr[left];
					}
			//	}
				left++;
			} else {
			//	if(right < arr.length -1) {
					if(arr[right] > rightMax) {
						rightMax = arr[right];
					} else {
						totalWater += rightMax - arr[right];
					}
			//	}
				right--;
				
			}
		}
		
		return totalWater;
	}

}
