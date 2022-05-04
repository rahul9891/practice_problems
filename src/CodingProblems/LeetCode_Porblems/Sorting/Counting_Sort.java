package CodingProblems.LeetCode_Porblems.Sorting;

public class Counting_Sort {
	
	public static void main(String[] args) {
		String result = countSort("geeksforgeeks");
		
		System.out.println(result);
	}
	
    public static String countSort(String arr)
    {
        // code here
        int[] countArr = new int[26];
        
        for(char c: arr.toCharArray()) {
            countArr[(int) (c - 'a')]++;
        }
        String result = "";
        for(int i=0;i<countArr.length;i++) {
            int val = countArr[i];
            if(val>0) {
                while(val > 0) {
                    result += (char) (i + 97);
                    val--;
                }
            }
        }
        
        return result;
    }

}
