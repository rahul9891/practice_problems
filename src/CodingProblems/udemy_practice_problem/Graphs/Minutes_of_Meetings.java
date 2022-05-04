package CodingProblems.udemy_practice_problem.Graphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 *A company has n employees with a unique ID for each employee from 0 to n - 1. The head of the company is the one with headID.
 *
 * Each employee has one direct manager given in the manager array where manager[i] is the direct manager of the i-th employee, manager[headID] = -1. Also, it is guaranteed that the subordination relationships have a tree structure.
 *
 * The head of the company wants to inform all the company employees of an urgent piece of news. He will inform his direct subordinates, and they will inform their subordinates, and so on until all employees know about the urgent news.
 *
 * The i-th employee needs informTime[i] minutes to inform all of his direct subordinates (i.e., After informTime[i] minutes, all his direct subordinates can start spreading the news).
 *
 * Return the number of minutes needed to inform all the employees about the urgent news.
 *
 * Example 1:
 *
 * Input: n = 1, headID = 0, manager = [-1], informTime = [0]
 * Output: 0
 * Explanation: The head of the company is the only employee in the company.
 *
 *
 * Example 2:
 *
 *
 * Input: n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * Output: 1
 * Explanation: The head of the company with id = 2 is the direct manager of all the employees in the company and needs 1 minute to inform them all.
 * The tree structure of the employees in the company is shown.
 *
 * */
public class Minutes_of_Meetings {

    public static void main(String[] args) {
    	
    	int result = numOfMinutes(8, 4, new int[] {2,2,4,6,-1,4,4,5}, new int[] {0,0,4,0,7,3,6,0});
    	
    	System.out.println(result);

    }

    public static int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {

        Queue<Integer> q = new LinkedList<>();
        int totalMin = 0;
        q.add(headID);
        totalMin = informTime[headID];
        while(!q.isEmpty()) {
        	 int minutes = 0;
            int id = q.poll();
            for(int i=0;i<manager.length;i++) {
                if(manager[i] == id) {
                    q.add(i);
                    minutes += informTime[i];
                }
            }
            totalMin = Math.max(totalMin, minutes);
        }

        return totalMin;

    }
}
