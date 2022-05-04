package CodingProblems.Hacker_Rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class String_Problems {
	
	
	/**
	 * Given a square grid of characters in the range ascii[a-z], rearrange elements of each row alphabetically, ascending. 
	 * Determine if the columns are also in ascending alphabetical order, 
	 * top to bottom. Return YES if they are or NO if they are not
	 * 
	 * grid = ['ebacd', 'fghij', 'olmkn', 'trpqs', 'xywuv']
	 * 
	 * first arrange all the strings in alphatical order
	 * then check if all the columns are in alphabatical order
	 * */
	public static String gridChallenge(List<String> grid) {
		
		int[] asciiArr = new int[grid.get(0).length()];
		List<String> newWord = new ArrayList<>();
		for(int i =0;i<grid.size();i++) {
			
			String word = grid.get(i);
			for(int j=0;j<word.length();j++) {
				asciiArr[j] = word.charAt(j);
			}
			Arrays.sort(asciiArr);
			String result = "";
			for(int j=0;j<word.length();j++) {
				result += (char)asciiArr[j];
			}
			newWord.add(result);
		}
		
		for(int i=0;i<newWord.size()-1;i++) {
			for(int j=0;j<newWord.get(i).length();j++) {
				if((int)newWord.get(i).charAt(j) > (int)newWord.get(i+1).charAt(j)) return "NO";
			}
		}
		
		return "YES";
	}
	
	public static void main(String[] args) {
		
		List<String> input = new ArrayList<>();
		
		input.add("ebacd");
		input.add("fghij");
		input.add("olmkn");
		input.add("trpqs");
		input.add("xywuv");
		
		System.out.println(gridChallenge(input));
		
	}

}
