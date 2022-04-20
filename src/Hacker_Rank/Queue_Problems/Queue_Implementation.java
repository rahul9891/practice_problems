package Hacker_Rank.Queue_Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Queue_Implementation {
	
	Stack<Integer> stack1 = new Stack<>();
	Stack<Integer> stack2 = new Stack<>();
	public static void main(String[] args) {
		
		List<Integer[]> list = new ArrayList<>();
		list.add(0, new Integer[] {1,39});
		list.add(1, new Integer[] {1,46});
		list.add(2, new Integer[] {1,49});
		list.add(3, new Integer[] {3,0});
		list.add(4, new Integer[] {2,0});
		list.add(5, new Integer[] {3,0});

		
		Queue_Implementation q = new Queue_Implementation();
		queueCommands(q, list);
		
	}
	
	public static void queueCommands(Queue_Implementation q,List<Integer[]> list) {
		
		for(Integer[] i: list) {
			if(i[0] == 1) {
				q.enqueue(i[1]);
			} else if(i[0] == 2) {
				q.dequeue();
			} else {
				q.printQueue();
			}
		}
		
	}
	
	void enqueue(int value) {
		if(stack1.isEmpty() && stack2.isEmpty()) {
			stack1.push(value);
		} else stack2.push(value);
		
	}
	
	void dequeue() {
		if(stack1.isEmpty()) {
			moveStack();
		}
		
		stack1.pop();
	}
	
	void printQueue() {
		if(stack1.isEmpty()) {
			moveStack();
		}
		
		System.out.println(stack1.peek());
	}
	
	
	
	void moveStack() {
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
 	
}

