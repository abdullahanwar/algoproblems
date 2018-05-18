package org.algo.codility;

public class Counting {
    public int[] counting(int []A, int m) {
        int countArray[] = new int[m+1];
        for (int i = 0; i < A.length; i ++) {
            countArray[A[i]] ++;
        }
        return countArray;
    }
}
