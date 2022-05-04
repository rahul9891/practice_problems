package CodingProblems.LeetCode_Porblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode 524
 * */
public class Longest_Word_Dictionary {
	
	public static void main(String[] args) {
		
		String string = "abpcplea";
		List<String> input = new ArrayList<>();
		input.add("ale");
		input.add("apple");
		input.add("monkey");
		input.add("plea");
		String result = findLongestWord(string, input);
		
		System.out.println(result);
		
	}
	
    public static String findLongestWord(String s, List<String> dictionary) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()) {
            if(!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                int val = map.get(c);
                map.put(c, val+1);
            }
        }
        boolean contains = true;
        int strLength=0;
        String result = "";
        for(String st: dictionary) {
            for(char c: st.toCharArray()) {
                if(!map.containsKey(c)) {
                    contains = false;
                } 
            }
            if(contains) {
                if(s.length() > strLength) {
                    strLength = s.length();
                    result = st;
                }
            }
        }
        
        return result;
        
    }

}
