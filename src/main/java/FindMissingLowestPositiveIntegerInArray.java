import static java.lang.Math.abs;

public class FindMissingLowestPositiveIntegerInArray {
    /**
     * Given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        int N = A.length;
        int smallest = 0;
        int lastPos = 0;
        int tmp;
        // Keep negative numbers to the left
        for (int i = 0; i < N && lastPos < N; i++) {
            if (A[i] <= 0) {
                tmp = A[i];
                A[i] = abs(A[lastPos]);
                A[lastPos] = abs(tmp);
                lastPos ++;
            }
        }

        for (int j = lastPos; j < N; j++) {
            int absVal_j = abs(A[j]);
            if (absVal_j <= N && A[absVal_j - 1] >= 0) {
                A[absVal_j - 1] *= -1;
                if (A[absVal_j - 1] == 0) {
                    A[absVal_j - 1] = -1;
                }
            }
        }

        for (int k = 0; k < N; k++) {
            if (A[k] > -1) {
                smallest = k + 1;
                break;
            }
        }

        return smallest == 0? N + 1 : smallest ;
    }

    public static void main(String args[]) {
        FindMissingLowestPositiveIntegerInArray msp = new FindMissingLowestPositiveIntegerInArray();
        System.out.println(msp.solution(new int[] {-1}));
    }

}