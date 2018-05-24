package org.algo.codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IsTrianglePresentInArray {
    // 10, 2, 5, 1, 8, 20
    // 1, 2, 5, 8, 10, 20

    public int solution(int[] A) {
        int nCount = 0;

        if (A.length >= 3) {
            Arrays.sort(A);

            for (int j = 2; j < A.length; j ++) {
                if (A[j] < 0l + A[j - 1] + A[j - 2]) {
                    nCount = 1;
                    break;
                }
            }
        }

        return nCount;
    }

    @Test
    public void test1() {
        assertEquals(1, solution(new int[] {10, 2, 5, 1, 8, 20}));
    }

    @Test
    public void test2() {
        assertEquals(1, solution(new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}));
    }
}
