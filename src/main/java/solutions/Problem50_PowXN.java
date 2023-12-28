package solutions;

public class Problem50_PowXN {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }

        if (n == -1) {
            return 1/x;
        }

        if (n == 1) {
            return x;
        }

        double firstProduct = myPow(x, n / 2);
        double powed = firstProduct * firstProduct;

        int nAbsolute = n >= 0 ? n : -n;

        if (n >= 0 && n % 2 == 1) {
            powed *= x;
        } else if (n < 0 && -n % 2 == 1) {
            powed *= 1/x;
        }

        return powed;
    }
}
