package org.algo.codility;

import org.junit.Test;

import static java.lang.Math.*;
import static org.junit.Assert.assertEquals;

/**
 *given an array A consisting of N integers containing daily prices of a stock share for a period of N consecutive days,
 *  returns the maximum possible profit from one transaction during this period.
 *  The function should return 0 if it was impossible to gain any profit.
 * 5 -7 3 5 -2 4 -1
 * 5 0  3 8 6 10
 */
public class MaxProfit {
    public int solution(int[] A) {
        if (A.length == 0) return 0;
        int maxProfit = 0, maxSlice = 0;
        int last = A[0];
        for (int a: A) {
            maxSlice = max(0, maxSlice + (a - last));
            maxProfit = max(maxSlice, maxProfit);
            last = a;
        }
        return maxProfit;
    }

    @Test
    public void test1() {
        assertEquals(356, solution(new int[] {23171, 21011, 21123, 21366, 21013, 21367}));
    }
}
