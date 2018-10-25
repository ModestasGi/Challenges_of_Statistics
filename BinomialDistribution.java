package hackerrankchallenges.Days10OfStatistics;

import java.util.Scanner;

public class BinomialDistribution {

    public static void main(String[] args) {

        Scanner ui = new Scanner(System.in);
        double ratio = ui.nextDouble();
        double ratio2 = ui.nextDouble();

        ui.close();

        // just for test System.out.println(ratio + " to " + ratio2 + " or:\n" + ratio + " : " + ratio2);

        double p = ratio/(ratio2 + ratio);
        int n = 6; // children in family
        int x = 3; // at least 3 boys

        double re = 0;
        for (x = 3; x <= n; x++) {
            re += bi(n, x, p);
        }
        System.out.format("%.3f", re);
    }

    private static Double bi(int n, int x, double p) {
        if (p < 0 || p > 1 || n < 0 || x < 0 || x > n) {
            return null;
        }
        return c(n, x) * Math.pow(p, x) * Math.pow(1 - p, n - x);
    }

    private static Long c(int n, int x) {
        if (n < 0 || x < 0 || x > n) {
            return null;
        }
        return f(n) / (f(x) * f(n - x));
    }

    private static Long f(int n) {
        if (n < 0) {
            return null;
        }
        long r = 1;
        while (n > 0) {
            r *= n--;
        }
        return r;
    }
}
