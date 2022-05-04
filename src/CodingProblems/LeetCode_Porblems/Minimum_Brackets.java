package CodingProblems.LeetCode_Porblems;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Minimum_Brackets {

    public static void main(String[] args) {
        String result = minRemoveToMakeValid("lee(t(c)o)de)");

        System.out.println(result);

    }

    static String minRemoveToMakeValid(String s) {
        Stack<Integer> brackets = new Stack<>();
        for(int i=0;i<s.length();i++) {
            Character c = s.charAt(i);
            if(c == '(') {
                brackets.push(i);
            } else if(c == ')') {
                if(!brackets.isEmpty()) {
                    if(s.charAt(brackets.peek()) != '(') {
                        brackets.push(i);
                    } else brackets.pop();
                } else brackets.push(i);
            }
        }
        StringBuilder result = new StringBuilder();
        Set<Integer> set = new HashSet<>(brackets);
        for(int i=0;i<s.length();i++) {
            if(!set.contains(i)) result.append(s.charAt(i));
        }

        return result.toString();
    }
}
