package LeetCode_Porblems;


import java.util.Random;

/**
 * LeetCode 384
 * */
public class Shuffle_an_Array {

    int[] result;
    Random rand;

    public Shuffle_an_Array(int[] nums) {
        result = nums;
        rand = new Random();
    }

    public int[] reset() {
        return result;
    }

    public int[] shuffle() {

        int[] copy = result.clone();
        int size = copy.length;

        while(size >0) {

            int index = rand.nextInt(size);
            int temp = copy[index];
            copy[index] = copy[size-1];
            copy[size-1] = temp;
            size--;
        }
        return copy;

    }

    static void print(int[] nums) {
        for(int i: nums) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {

        Shuffle_an_Array s = new Shuffle_an_Array(new int[]{1,2,3,4});

        int[] result = s.shuffle();
        print(result);

        print(s.reset());

    }

}
