package CodingProblems.udemy_practice_problem;

import java.util.*;

/**
 * A = [1,3,4,6,7,9]
 * B = [1,2,4,5,9,10]
 *
 * output = [1,4,9]
 * */

public class Common_Elements_in_Array {

    public static void main(String[] args) {
        List<Integer> result = common_elements(new int[]{1,3,4,6,7,9}, new int[]{1,2,4,5,9,10});
        for(int n: result) {
            System.out.println(n);
        }

//        Integer[] resultFrom2nd = common_elements_with_list(new int[]{1,3,4,6,7,9}, new int[]{1,2,4,5,9,10});
//        for(int n: resultFrom2nd) {
//            System.out.println(n);
//        }

        Integer[] resultFrom2nd = common_elements_correct(new int[]{1,3,4,6,7,9}, new int[]{1,2,4,5,9,10});
        for(int n: resultFrom2nd) {
            System.out.println(n);
        }

    }

    static List<Integer> common_elements(int[] a, int[] b) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++) {
            map.putIfAbsent(a[i], 0);
        }
        for(int i=0;i<b.length;i++) {
            if(map.containsKey(b[i])) {
                result.add(b[i]);
            }
        }
        return result;
    }

//    static Integer[] common_elements_with_list(int[] a, int[] b) {
////        int max_length = 0;
////        if(a.length > b.length) max_length = b.length;
////        else max_length = a.length;
////        Integer[] result = new Integer[max_length];
//        ArrayList<Integer> result= new ArrayList<>();
//        ArrayList<Integer> listA = new ArrayList<>();
//        for(int i=0;i<a.length;i++) {
//            if(!listA.contains(a[i])) {
//                listA.add(a[i]);
//            }
//        }
//        int index=0;
//        for(int i=0;i<b.length;i++) {
//            if(listA.contains(b[i])) {
//                result.add(b[i]);
//                index += 1;
//            }
//        }
//        return (Integer[]) result.toArray();
//    }

    static Integer[] common_elements_correct(int[] a, int[] b) {

        ArrayList<Integer> result = new ArrayList<>();

        int pointA =0, pointB=0;
        while(pointA < a.length && pointB < b.length) {
            if(a[pointA] == b[pointB]) {
                result.add(a[pointA]);
                pointA++;
                pointB++;
            } else if(a[pointA] > b[pointB]) {
                pointB++;
            } else if(a[pointA] < b[pointB]){
                pointA++;
            }
        }

        Integer[] resultInArray = new Integer[result.size()];
        return result.toArray(resultInArray);
    }
}
