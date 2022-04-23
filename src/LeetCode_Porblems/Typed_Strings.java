package LeetCode_Porblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Typed_Strings {
	
	public static void main(String[] args) {

		boolean result = matchStrings("##z", "z");

		System.out.println(result);
		
	}
	
	static boolean matchStrings(String a, String b) {

		return buildString(a).equals(buildString(b));
	}

	static String buildString(String s) {
		StringBuilder str = new StringBuilder();

		for(int i=0;i<s.length();i++) {
			Character c = s.charAt(i);
			if(c != '#') {
				str.append(c);
			} else {
				if(str.length() > 0) {
					str.deleteCharAt(str.length()-1);
				}
			}
		}

		return str.toString();
	}

}