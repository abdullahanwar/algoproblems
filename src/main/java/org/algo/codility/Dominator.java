package org.algo.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

 For example, consider array A such that
 [3, 4, 3, 2, 3, -1, 3, 3]

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
 The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.
 */

public class Dominator {

    public int solution(int[] A) {
        if (A.length == 0) return -1;

        int index = -1;
        int sc = 0;
        for (int i = 0; i < A.length; i ++) {
            if (sc == 0) {
                index = i;
                sc ++;
            } else if (A[index] != A[i]) {
                sc --;
            } else {
                sc ++;
            }
        }
        if (index != -1) {
            int count = 0;
            for (int j = 0; j < A.length; j ++) {
                if (A[j] == A[index]) {
                    count ++;
                }
            }
            if (count <= A.length / 2) {
                index = -1;
            }
        }
        return index;
    }

    @Test
    public void test1() {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        assertEquals(3, A[solution(A)]);
    }

    @Test
    public void test2() {
        int[] A = {3};
        assertEquals(3, A[solution(A)]);
    }

    @Test
    public void test3() {
        int[] A = {4, 4, 3};
        assertEquals(4, A[solution(A)]);
    }
}
