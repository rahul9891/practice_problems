package CodingProblems.LeetCode_Porblems;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * LeetCode 1387
 * */
public class Power_Value {

    public static void main(String[] args) {

        int result = getKth(10,20,5);

        System.out.println(result);
    }

    public static int getKth(int lo, int hi, int k) {

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] != b[1]) {
                    return a[1]-b[1];
                } else {
                    return a[0]-b[0];
                }
            }
        });



        for(int j=lo;j<=hi;j++) {
            q.add(new int[]{j, getPower(j)});
        }
        int index=1;
        while(q.isEmpty() == false) {
            if(index == k) {
                return q.poll()[0];
            }
            q.poll();
            index++;
        }
        return 0;
    }

    public static int getPower(int n) {

        int count =0;

        while(n != 1) {
            if( n % 2 == 0) {
                n /= 2;
            } else if (n % 2 ==1) {
                n = 3*n +1;
            }
            count++;
        }

        return count;
    }
}
