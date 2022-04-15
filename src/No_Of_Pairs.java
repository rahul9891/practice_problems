public class No_Of_Pairs {

    public static void main(String[] args) {
        long result = countPairs(new int[]{3,2}, new int[]{2,1,6}, 2, 3);
    }

    static long countPairs(int x[], int y[], int M, int N)
    {
        // your code here
        long result = 0;

        for(int i=0;i<M;i++) {
            for(int j=0;j<N;j++) {
//                long k = x[i]^y[j];
//                long g = y[j]^x[i];
//                Math.pow(x[i], y[j]);
                if(Math.pow(x[i], y[j]) > Math.pow(y[j], x[i])) result++;
            }
        }
        System.out.println(result);
        return result;
    }
}
