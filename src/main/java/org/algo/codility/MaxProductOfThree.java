package org.algo.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxProductOfThree {

    public int solution(int[] A) {
        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }

        int [] negLowest3 = new int[] {0, 0, 0};
        int [] highest3 = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        int nNeg = 0, nPos = 0;

        for (int j = 0; j < A.length; j ++) {
            int curMin = A[j],
                curMax = A[j];
            if (curMin < 0) {
                nNeg ++;
            }
            for (int k = 0; k < 3 ; k ++) {
                if (curMin < negLowest3[k]) {
                    int temp = negLowest3[k];
                    negLowest3[k] = curMin;
                    curMin = temp;
                }

                if (curMax > highest3[k]) {
                    int temp = highest3[k];
                    highest3[k] = curMax;
                    curMax = temp;
                }
            }
        }
        nPos = A.length - nNeg;

        int max3Sum = highest3[0] * highest3[1] * highest3[2];
        int negSum = Integer.MIN_VALUE;
        if (nNeg >=2 && nPos >= 1) {
            negSum = negLowest3[0] * negLowest3[1] * highest3[0];
        }

        if (negSum > max3Sum) {
            return negSum;
        } else {
            return max3Sum;
        }
    }

    @Test
    public void test1() {
        int result = solution(new int[] {-3, 1, 2, -2, 5, 6});
        assertEquals(60, result);
    }

    @Test
    public void test2() {
        int result = solution(new int[] {-3, 1, 2, -2, 5, -6});
        assertEquals(90, result);
    }

    @Test
    public void test3() {
        int result = solution(new int[] {-3, 5, -6});
        assertEquals(90, result);
    }

    @Test
    public void test4() {
        int result = solution(new int[] {-3, 5, 6});
        assertEquals(-90, result);
    }

    @Test
    public void test5() {
        int result = solution(new int[] {3, 5, 6});
        assertEquals(90, result);
    }

    @Test
    public void test6() {
        int result = solution(new int[] {-3, -5, -6});
        assertEquals(-90, result);
    }

    @Test
    public void test7() {
        int result = solution(new int[] {-1, 2, -3, -3, 3});
        assertEquals(27, result);
    }

    @Test
    public void test8() {
        int result = solution(new int[] {1, 2, -3});
        assertEquals(-6, result);
    }

    @Test
    public void test9() {
        int result = solution(new int[] {-1, -2, -3, -3, -3});
        assertEquals(-6, result);
    }

    @Test
    public void test10() {
        int result = solution(new int[] {-1, -2, -3, -3, -3});
        assertEquals(-6, result);
    }
}
