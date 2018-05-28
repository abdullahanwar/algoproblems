package org.algo.codility;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A non-empty array A consisting of N integers is given.

 The leader of this array is the value that occurs in more than half of the elements of A.

 An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

 For example, given array A such that:

 A[0] = 4
 A[1] = 3
 A[2] = 4
 A[3] = 4
 A[4] = 4
 A[5] = 2
 we can find two equi leaders:

 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
 */

// 4, 3, 4, 4, 4, 2

public class EquiLeader {

    public int solution(int[] A) {
        int index = -1;
        int stackCount = 0;
        for (int i = 0; i < A.length; i ++) {
            if (stackCount == 0) {
                index = i;
                stackCount ++;
            } else if (A[index] != A[i]) {
                stackCount --;
            } else {
                stackCount ++;
            }

        }
        if (index == -1) {
            return 0;
        }

        int count = 0;
        for (int j = 0; j < A.length; j ++) {
            if (A[j] == A[index]) {
                count ++;
            }
        }

        if (count <= A.length / 2) {
            return 0;
        }

        int countEqui = 0;
        int countUptoI = 0;
        for (int k=0; k < A.length; k ++) {
            if (A[k] == A[index]) {
                countUptoI ++;
            }
            if (2 * countUptoI > k+1 && 2 * (count - countUptoI) > (A.length - k -1)) {
                countEqui ++;
            }
        }

        return countEqui;
    }

    @Test
    public void test1() {
        int arr[] = new int[] {4, 3, 4, 4, 4, 2};
        assertEquals(2, solution(arr));
    }

    @Test
    public void test2() {
        int arr[] = new int[] {4, 3};
        assertEquals(0, solution(arr));
    }

    @Test
    public void test3() {
        int arr[] = new int[] {4, 3, 4};
        assertEquals(0, solution(arr));
    }

    @Test
    public void test4() {
        int arr[] = new int[] {4, 4, 4, 3, 3, 3};
        assertEquals(0, solution(arr));
    }
}
