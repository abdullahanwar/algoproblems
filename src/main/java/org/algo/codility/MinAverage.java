package org.algo.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).
 */
public class MinAverage {
    public int solution(int [] A) {
        double minAvg = 10000;
        int minStart = 0;
        for (int start = 0; start < A.length - 1; start ++) {
            int sum2 = A[start] + A[start + 1];
            if (sum2 < minAvg * 2) {
                minStart = start;
                minAvg = sum2 / 2.0;
            }
            if (start < A.length - 2) {
                int sum3 = sum2 + A[start + 2];
                if (sum3 < minAvg * 3) {
                    minAvg = sum3 / 3.0;
                    minStart = start;
                }
            }
        }

        return minStart;
    }

    @Test
    public void test1() {
        int start = solution(new int[] {4, 2, 2, 5, 1, 5, 8});
        assertEquals(1, start);
    }

    @Test
    public void test2() {
        int start = solution(new int[] {4, 2, -2, 5, -10, 5, 8});
        assertEquals(3, start);
    }

    @Test
    public void test3() {
        int start = solution(new int[] {2, -2});
        assertEquals(0, start);
    }

    public void test4() {
        int start = solution(new int[] {10000, 10000, 10000});
        assertEquals(0, start);
    }
}
