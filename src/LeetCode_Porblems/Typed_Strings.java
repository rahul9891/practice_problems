package LeetCode_Porblems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Typed_Strings {
	
	public static void main(String[] args) {

		boolean result = matchStrings("ab##", "c#d#");

		System.out.println(result);
		
	}
	

	static boolean matchStrings1(String a, String b) {

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
	
	static boolean matchStrings(String a, String b) {
		
		int pointA = a.length()-1;
		int pointB = b.length()-1;
		int hashA = 0;
		int hashB = 0;
		
		while(pointA >=0 || pointB >= 0) {
			
			if(a.charAt(pointA) == '#' || b.charAt(pointB) == '#') {
				if(a.charAt(pointA) == '#') {
					int backCount =2;
					while(backCount > 0) {
						pointA--;
						backCount--;
						if(pointA >= 0 && a.charAt(pointA) == '#') {
							backCount +=2;
						}
					}
				}
				if(a.charAt(pointB) == '#') {
					int backCount =2;
					while(backCount > 1) {
						pointB--;
						backCount--;
						if(pointB >= 0 && b.charAt(pointB) == '#') {
							backCount +=2;
						}
					}
				}
				
			} else {
				if(a.charAt(pointA) != b.charAt(pointB)) return false;
				else {
					pointA--;
					pointB--;
				}
			}

		}
		return true;
	}

}
