package LeetCode_Porblems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	int[] result = new int[2];
	public static void main(String[] args) {
		
		TwoSum t = new TwoSum();
		int[] result = t.twoSums(new int[] {2,7,11,15}, 9);
		System.out.println(result[0]+" "+result[1]);
		
	}
	
	
	 public int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
       // int targetNum = 0;
        for(int i=0;i<nums.length;i++) {
                      
            if(!map.containsKey(nums[i])) {
                map.put(target-nums[i], i);
            } else {
                result[0] = map.get(nums[i]).intValue();
                result[1] = i;
                return result;
            }
        }    
        
        return result;
	}

}
