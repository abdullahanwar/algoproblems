package org.algo.codility;

import java.util.HashSet;

public class DistinctNumberInArray {
    public int solution(int[] A) {
        HashSet<Integer> numberMap = new HashSet<>((A.length * 2)/3 + 1);
        for (int j = 0; j < A.length; j ++) {
            numberMap.add(A[j]);
        }
        return numberMap.size();
    }

}
