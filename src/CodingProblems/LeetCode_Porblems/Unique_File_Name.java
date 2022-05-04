package CodingProblems.LeetCode_Porblems;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1487
 * */
public class Unique_File_Name {
	
    public static String[] getFolderNames(String[] names) {
        
        Map<String, Integer> map = new HashMap<>();
        String[] result = new String[names.length];
        for(int i=0;i<names.length;i++){
            if(!map.containsKey(names[i])) {
                map.put(names[i], 1);
                result[i] = names[i];
            } else {
                int val = map.get(names[i]);
                result[i] = names[i]+"("+val+")";
                map.put(names[i], val+1);
                
            }
        }
        return result;
        
    }
    
    public static void main(String[] args) {
		
    	String[] input = new String[] {};
	}

}
