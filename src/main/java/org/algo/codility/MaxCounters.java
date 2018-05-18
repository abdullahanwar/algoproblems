package org.algo.codility;
//        org.algo.MaxCounters
//        START
//        Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum

import java.util.Arrays;
import java.util.HashMap;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
     HashMap<Integer, Integer> counterMap = new HashMap(N < A.length ? N : A.length);
     int maxC = 0;
     int lastMax = 0;
     boolean setMax = false;
     for (int ai = 0; ai < A.length; ai ++) {
         if (A[ai] <= N) {
             int x = A[ai] - 1;
             Integer counterX = counterMap.getOrDefault(x, lastMax);
             if (counterX < lastMax && setMax) {
                 counterX = lastMax;
             }
             counterX ++;
             if (counterX > maxC) {
                 maxC = counterX;
             }
             counterMap.put(x, counterX);
         } else if (A[ai] == N + 1) {
                 lastMax = maxC;
                 setMax = true;
         }
     }
     int [] counterArray = new int[N];
     for (int i =0; i < N; i ++) {
         Integer orDefault = counterMap.getOrDefault(i, lastMax);
         counterArray[i] = orDefault < lastMax? lastMax: orDefault;
     }
     return counterArray;
    }

    public static void main(String[] args) {
        int[] solution = (new MaxCounters()).solution(5, new int[]{3, 6, 4});
        System.out.println(Arrays.toString(solution));
    }
}
