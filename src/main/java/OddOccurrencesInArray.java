public class OddOccurrencesInArray {
    // Find a single element that comes odd number of times where other comes even number of times.
    public int solution(int ar[], int ar_size)
    {
        int res = 0;
        for (int i = 0; i < ar_size; i++)
            res = res ^ ar[i];

        return res;
    }

}
