import java.util.Arrays;

public class CyclicRotation {
    public int gcd(int m, int n) {
        m = m > 0 ? m : -m;
        n = n > 0 ? n : -n;
        int temp = m;
        if (m > n) {
            temp = n;
            n = m;
            m = temp;
        }

        if (m == 0 || m ==1) {
            return m;
        }

        while (n % m != 0) {
            temp = m;
            m = n % m;
            n = temp;
        }
        return m;
    }

    public int[] solution(int[] A, int K) {
        if (A.length == 0) return A;
        int k = K % A.length;
        int minCycle = gcd(A.length, k);
        // write your code in Java SE 8
        for (int j=0; j<minCycle; j++) {
            int targetIndex = j, key = A[j], temp;
            for (int i = 0; i < A.length/minCycle; i ++) {
                targetIndex = (targetIndex + k) % A.length;
                temp = A[targetIndex];
                A[targetIndex] = key;
                key = temp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        CyclicRotation cr = new CyclicRotation();
        System.out.println(Arrays.toString(cr.solution(new int[]{3, 8, 9, 7, 6}, 3)));
    }
}
