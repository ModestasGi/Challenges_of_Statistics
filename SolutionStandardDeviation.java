package hackerrankchallenges.Days10OfStatistics;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SolutionStandardDeviation {

    public static void main(String[] args){

        Scanner ui = new Scanner(System.in);

        int n = ui.nextInt();

        // todo constraints 5<n<100


        int [] arrayList = new int[n];

        for (int i = 0; i < n; i++){
            arrayList[i] = ui.nextInt();

            // todo constraints 0<x<10P5
        }
        double foundMean = getMean(arrayList);
        double sqrdDistances = 0;

        for(int i = 0; i < n ; i++){
            sqrdDistances = sqrdDistances + Math.pow((arrayList[i] - foundMean), 2);
        }

        DecimalFormat df = new DecimalFormat("#.#");
        double q = Math.sqrt(sqrdDistances/n);

        ui.close();

        System.out.println(df.format(q));

    }
    private static double getMean(int[] a) {
        double mean;
        int sum = 0;
        int size = a.length;
        for(int i : a) {
            sum += i;
        }
        mean = (double) sum/size;
        return mean;
    }
}
