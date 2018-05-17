public class GCD {
    public int gcd(int m, int n) {
        m = m > 0 ? m : -m;
        n = n > 0 ? n : -n;
        int temp = m;
        if (m > n) {
            temp = n;
            n = m;
            m = temp;
        }

        if (m == 0 || m ==1) {
            return m;
        }

        while (n % m != 0) {
            temp = m;
            m = n % m;
            n = temp;
        }
        return m;
    }
}
