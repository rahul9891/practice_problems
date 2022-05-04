package CodingProblems.Hacker_Rank.Misc_Problems;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Stack;

public class Simple_Text_Editor {

	Stack<String> stack = new Stack<>();
	String result = "";

	public static void main(String[] args) throws FileNotFoundException {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
		 * class should be named Solution.
		 */

		// BufferedReader scanner = new BufferedReader(new
		// FileReader("simple_text_editor.txt"));
		Scanner scanner = new Scanner(new FileReader("simple_text_editor.txt"));
		Simple_Text_Editor s = new Simple_Text_Editor();
		int k=0;String str="";
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int command = scanner.nextInt();
			switch(command) {
            case 1:
                str = scanner.next().trim();
                s.append(str);
                break;
            case 2:
                k = scanner.nextInt();
                s.delete(k);
                break;
            case 3:
                k = scanner.nextInt();
                s.print(k);
                break;
            case 4:
                s.undo();
                break;
        }
		}

		scanner.close();
	}

	static void runCommand(Scanner scanner, int command, Simple_Text_Editor s) {

	}

	void append(String str) {
		stack.push(result);
		result += str;

	}

	void delete(int k) {
		stack.push(result);
		result = result.substring(0, result.length() - k);
	}

	void print(int k) {
		System.out.println(result.charAt(k - 1));
	}

	void undo() {
		result = stack.pop();
	}

}
