package CodingProblems.udemy_practice_problem;

import java.util.HashMap;

/**
 * a = 'aabbcdd' output = 'c'
 * a = 'aabb' output = null
 * a = 'aabbde' output = d first non-repeating character returned
 *
 * */
public class Non_repeating_character {

    public static void main(String[] args) {
        String[] input = new String[]{"aabbcdd", "aabb", "aabbde", "abcab", "aabbdbc"};

        for(String s: input) {
            Character result = non_repeating_character(s);
            System.out.println("Input - "+ s+ " Output - " +result);
        }
//        Character result = non_repeating_character("aabbdbc");
//        System.out.println(result);
    }

    static Character non_repeating_character(String s) {
        Character result = null;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char a: s.toCharArray()) {
            if(!map.containsKey(a)) {
                map.put(a, 1);
            } else {
                int freq = map.get(a);
                map.put(a, freq + 1);
            }
        }
        for(Character c: s.toCharArray()) {
            if(map.get(c) ==1 ) {
                return c;
            }
        }
        return result;
    }
}
