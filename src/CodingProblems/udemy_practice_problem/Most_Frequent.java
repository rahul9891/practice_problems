package CodingProblems.udemy_practice_problem;

import java.util.HashMap;
import java.util.Map;

/**
 * input [1,3,1,3,2,1]
 *
 * output 1
 * */
public class Most_Frequent {

    public static void main(String[] args) {

        int result = most_frequent(new int[]{1,3,1,3,2,1,2,6,2,7,9,3,5,90,5,1,2,6,3,2});
        System.out.println(result);

    }

    static int most_frequent(int[] arr) {

        Map<Integer, Integer> freq = new HashMap<>();
        int index=0;int max_value = -1;
        for(int i=0;i<arr.length;i++) {
            if(freq.containsKey(arr[i])) {
                int curr_value = freq.get(arr[i]);
                freq.put(arr[i], curr_value +1);
            } else freq.put(arr[i], 1);
            if(freq.get(arr[i]) > max_value) {
                max_value = freq.get(arr[i]);
                index = arr[i];
            }
        }
        //int index=0;int max_value = 0;
//        for(int result: freq.keySet()) {
//            if(freq.get(result) > max_value) {
//                max_value = freq.get(result);
//                index = result;
//            }
//        }

        return index;
    }
}
