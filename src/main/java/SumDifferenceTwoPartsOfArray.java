import static java.lang.Math.abs;

public class SumDifferenceTwoPartsOfArray {

    public int solution(int A[]) {
        int globalfirstHalf = 0, globalLastHalf = 0;
        for (int i=0; i < A.length/2; i++) {
            globalfirstHalf += A[i];
            globalLastHalf += A[A.length/2 + i];
        }
        if (A.length % 2 == 1) {
            globalLastHalf += A[A.length -1];
        }
        int minDiff = (int) abs(globalLastHalf - globalfirstHalf);
        int firstHalf = globalfirstHalf, lastHalf = globalLastHalf;
        for (int p = A.length/2 - 1; p > 0; p --) {
            firstHalf -= A[p];
            lastHalf  += A[p];
            int diff = (int) abs(lastHalf - firstHalf);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        firstHalf = globalfirstHalf;
        lastHalf = globalLastHalf;
        for (int p = A.length/2+1; p < A.length; p ++) {
            firstHalf += A[p - 1];
            lastHalf  -= A[p - 1];
            int diff = (int) abs(lastHalf - firstHalf);
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        return minDiff;
    }

    public static void main(String args[]) {
        System.out.println((new SumDifferenceTwoPartsOfArray()).solution(new int[]{3, 1, 2, 4, 3}));
    }
}
