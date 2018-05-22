package org.algo.codility;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

 The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

 */
public class GenomicRange {

    public int[] solution(String S, int[] P, int[] Q) {
        int [][] gPrefixSum = new int[3][S.length() + 1];
        for (int i = 0; i < S.length(); i ++){
            char v = S.charAt(i);
            int impact = getImpact(v);
            gPrefixSum[0][i + 1] = gPrefixSum[0][i];
            gPrefixSum[1][i + 1] = gPrefixSum[1][i];
            gPrefixSum[2][i + 1] = gPrefixSum[2][i];
            if (impact != 4) {
                gPrefixSum[impact - 1][i + 1] += 1;
            }
        }

        int result[] = new int[Q.length];
        for (int j = 0; j < Q.length; j++) {
            int minGen = 0;
            if (P[j] == Q[j]) {
                minGen = getImpact(S.charAt(Q[j]));
            } else {
                for (int k = 0; k < 3; k++) {
                    int sum = gPrefixSum[k][Q[j] + 1] - gPrefixSum[k][P[j]];
                    if (sum > 0) {
                        minGen = k + 1;
                        break;
                    }
                }
            }
            result[j] = minGen != 0? minGen : 4;
        }


        return result;
    }

    private int getImpact(char v) {
        int impact = 0;
        if (v == 'A') {
            impact = 1;
        } else if (v == 'C') {
            impact = 2;
        } else if (v == 'G') {
            impact = 3;
        } else {
            return 4;
        }
        return impact;
    }

    @Test
    public void test1() {
        int result[] = solution("CAGCCTA", new int[]{2, 5, 0}, new int[] {4, 5, 6 });
        System.out.println(Arrays.toString(result));
        assertArrayEquals(new int[]{2, 4, 1}, result);

    }

    @Test
    public void test2() {
        int result[] = solution("C", new int[]{0}, new int[] {0});
        assertArrayEquals(new int[]{2}, result);
        int result1[] = solution("A", new int[]{0}, new int[] {0});
        assertArrayEquals(new int[]{1}, result1);
        int result2[] = solution("T", new int[]{0}, new int[] {0});
        assertArrayEquals(new int[]{4}, result2);
        int result3[] = solution("G", new int[]{0}, new int[] {0});
        assertArrayEquals(new int[]{3}, result3);

    }

    @Test
    public void testSingle() {
        int result2[] = solution("CAGCCTA", new int[]{2, 4, 5}, new int[] {2, 4, 5});
        System.out.println(Arrays.toString(result2));
        assertArrayEquals(new int[]{3, 2, 4}, result2);
    }

    @Test
    public void testDouble() {
        int result2[] = solution("AC", new int[]{0, 1}, new int[] {1, 1});
        System.out.println(Arrays.toString(result2));
        assertArrayEquals(new int[]{1, 2}, result2);
    }
}
