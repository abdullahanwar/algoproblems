/**
 * Find the max no of continuous zeros in a number enclosed by 1.
 */
class MaxGap {
    public int solution(int N) {
        int maxGap = 0;
        int gap = 0;
        boolean start = false;
        while (N != 0) {
            if (N % 2 == 1) start = true;
            if (start == true) {
                if (N % 2 == 0) gap++;
                else {
                    if (gap > maxGap) maxGap = gap;
                    gap = 0;
                }
            }
            N /= 2;
        }
        return maxGap;
    }

    public static void main(String[] ars) {
        System.out.println((new MaxGap()).solution(561892));
    }
}