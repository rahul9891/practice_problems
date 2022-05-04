package CodingProblems.GenericProblems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Subarray_Sum {

    public static void main(String[] args) {
        ArrayList<Integer> result = subarraySum(new int[]{1,2,3,7,5}, 5, 12);
        for(int r: result) {
            System.out.println(r);
        }
    }

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int sum=0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<n; i++)
        {
            q.add(i);
            sum+=arr[i];
            if(sum==s)
            {
                list.add(q.peek()+1);
                list.add(q.peek()+q.size());
                return list;
            }
            if(sum>s)
            {
                while(sum>s && !q.isEmpty())
                {
                    sum-=arr[q.poll()];
                }
                if(sum==s)
                {
                    list.add(q.peek()+1);
                    list.add(q.peek()+q.size());
                    return list;
                }
            }
        }
        list.add(-1);
        return list;
    }


}
