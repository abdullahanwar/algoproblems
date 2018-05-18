package org.algo.codility;

/**
 * given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K,
 */
public class CountingDiv {
    public int solution(int A, int B, int M) {
        if (A % M == 0)
            return (B / M) - (A / M) + 1;

        // A is not divisible by M
        return (B / M) - (A / M);
    }
}
