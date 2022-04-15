import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Non_Repeating_Numbers {

    public static void main(String[] args) {
        int[] result = singleNumber(new int[]{1, 2, 3, 2, 1, 4});

        for(int n: result) System.out.println(n);
    }

    static int[] singleNumber(int[] nums)
    {
        // Code here
        int[] result = new int[2];

        Map<Integer, Boolean> map = new TreeMap<>();

        for(int i=0;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {
                map.put(nums[i], true);
            } else {
                map.put(nums[i], false);
            }
        }
        int index =0;
        for(int n: map.keySet()) {

            if(!map.get(n)) {
                result[index] = n;
                index++;
            }
            //index++;
        }

        return result;

    }
}
