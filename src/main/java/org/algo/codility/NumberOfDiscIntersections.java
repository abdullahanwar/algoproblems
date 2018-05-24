package org.algo.codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NumberOfDiscIntersections {

    public int solution(int[] A) {
        int count = 0;

        long lower[] = new long[A.length];
        long upper[] = new long[A.length];

        for (int k = 0; k < A.length; k ++) {
            lower[k] = 0l + k - A[k];
            upper[k] = 0l + k + A[k];
        }

        Arrays.sort(lower);
        Arrays.sort(upper);

        int totalCount = 0;
        int i = 0;

        for (int j = 0; j < A.length; j ++) {

            while (i < A.length && lower[i] <= upper[j]) {
                totalCount = totalCount + (i - j);
                i ++;
            }

            if (totalCount >  10_000_000) {
                totalCount = -1;
                break;
            }

        }

        return totalCount;
    }

    @Test
    public void test1() {
        int array[] = new int[] {1, 5, 2, 1, 4, 0};
        assertEquals(11, solution(array));
    }

    @Test
    public void test2() {
        int array[] = new int[] {1, 5, 2};
        assertEquals(3, solution(array));
    }

    @Test
    public void test3() {
        int array[] = new int[] {1, 2147483647, 0};
        assertEquals(2, solution(array));
    }
}
