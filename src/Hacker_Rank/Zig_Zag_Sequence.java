package Hacker_Rank;

import java.util.Arrays;

public class Zig_Zag_Sequence {


    public static void main(String[] args) {
        zigZagSequence(new int[]{1,4,7,2,3,5,6});
    }

    public static void zigZagSequence(int[] arr) {

        Arrays.sort(arr);
        printArr(arr);
        System.out.println("\n");
        int size = arr.length;
        int mid = (size)/2;
        int temp = arr[mid];
        arr[mid] = arr[size-1];
        arr[size-1]=temp;

        int start = mid+1;
        int end = size-2;
        while(start < end) {
            int temp1 = arr[start];
            arr[start] = arr[end];
            arr[end] = temp1;
            start += 1;
            end -= 1;
        }

       printArr(arr);

    }

    static void printArr(int[] arr) {
        for(int i = 0;i<arr.length;i++) {
            System.out.print(arr[i]+ " ");
        }
    }
}
