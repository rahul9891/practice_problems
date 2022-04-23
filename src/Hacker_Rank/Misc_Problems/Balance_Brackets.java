package Hacker_Rank.Misc_Problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

public class Balance_Brackets {
	
	public static void main(String[] args) throws IOException  {
		
		BufferedReader reader = new BufferedReader(new FileReader("balanced_brackets.txt"));
		String cases = reader.readLine();
		
		String[] ans = new String[Integer.parseInt(cases)];
		for(int i=0;i<ans.length;i++) {
			String input = reader.readLine();
			ans[i] = isBalanced(input);
		}
		
		for(int i=0;i<ans.length;i++) {
			System.out.println(i+1 + " " + ans[i]);
		}
		reader.close();
		
	}
	
	
	static String isBalanced(String s) {
        Stack<Character> bStack = new Stack<>();
        
        for(Character c: s.toCharArray()) {
            if(c == '{' || c== '(' || c=='[') {
                bStack.push(c);
            } else {
                if(!bStack.isEmpty()) {
                    Character currChar = bStack.pop();
                    if(currChar == '{' && c != '}') {
                        return "NO";
                    }
                    if(currChar == '[' && c != ']') {
                        return "NO";
                    }
                    if(currChar == '(' && c != ')') {
                        return "NO";
                    }
                } else return "NO";
            }
        }
        return "YES";
	}

}
