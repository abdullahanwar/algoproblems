package org.algo.codility;

import static java.lang.Math.abs;

/**
 * Exactly one element is missing in an array of size N. element should be in range [1, N+1]
 */
public class MissingElement {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 1;
        }

        boolean n_1Present = false;
        for (int i = 0; i < A.length; i++) {
            int absAi = abs(A[i]);
            if (absAi <= A.length) {
                A[absAi - 1] *= -1;
            } else if (absAi == A.length + 1){
                n_1Present = true;
            }
        }

        int missing = -1;
        if (!n_1Present) {
            missing =  A.length + 1;
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                missing =  i + 1;
                break;
            }
        }

        return missing;
    }

    public static void main(String[] args) {
        System.out.println((new MissingElement()).solution(new int[]{1, 2, 6, 4, 5, 7}));
    }
}
