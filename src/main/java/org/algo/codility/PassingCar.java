package org.algo.codility;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.

 Array A contains only 0s and/or 1s:

 0 represents a car traveling east,
 1 represents a car traveling west.
 The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.

 */
public class PassingCar {
    public int solution(int[] A) {
        if (A.length <= 1) return 0;
        int totalPassingCar = 0;
        int total = A[A.length - 1];
        for (int i=A.length - 2; i >= 0; i--) {
            if (A[i] == 1) {
                total = total + A[i];
            } else {
                totalPassingCar  += total;
                if (totalPassingCar > 1000000000) {
                    return -1;
                }
            }
        }
        return totalPassingCar;
    }
    @Test
    public void test1() {
        assertEquals (5, solution(new int[]{0, 1, 0, 1, 1}));
        assertEquals (1, solution(new int[]{0, 1}));
        assertEquals (0, solution(new int[]{1, 0}));
        assertEquals (0, solution(new int[]{1, 1, 1, 1, 1}));


    }
}
