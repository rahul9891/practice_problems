package CodingProblems.Test_Examples;

import java.util.LinkedHashSet;
import java.util.Set;

public class Set_Example {
	
	public static void main(String[] args) {
		Set<String> set = new LinkedHashSet<>();
		
		set.add("Rahul");
		set.add("Suresh");
		set.add("Mahesh");
		set.add("Swati");
		
		for(String s: set) {
			System.out.println(s);
		}
		
	}

}
