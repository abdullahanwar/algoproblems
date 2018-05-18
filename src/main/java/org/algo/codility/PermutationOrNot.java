package org.algo.codility;

import static java.lang.Math.abs;

public class PermutationOrNot {

    // Find whether array A is permutation of [1, A.length]

    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            int absAi = abs(A[i]);
            if (absAi <= A.length && A[absAi - 1] > 0) {
                A[absAi - 1] *= -1;
            }
        }

        int permutation = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                permutation =  0;
                break;
            }
        }

        return permutation;
    }

    public static void main(String [] args) {
        PermutationOrNot pOrNot = new PermutationOrNot();
        System.out.println(pOrNot.solution(new int[]{2}));
    }
}
