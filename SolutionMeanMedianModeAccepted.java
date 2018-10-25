package hackerrankchallenges.Days10OfStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionMeanMedianModeAccepted {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        boolean engage = true;
        String errorMessage ="";
        if (size < 10 || size > 2500) {
            errorMessage = "Input error in first line\nConstraints 10<N<2500";
            engage = false;
        }
        int [] a = new int[size];
        for(int i = 0;i < size;i++) {
            a[i] = s.nextInt();
            if ((a[i] < 0) || (a[i] > 100000)) {
                System.out.println("Input error " + a[i]);
                errorMessage = "Input error in second line\nConstraints 0<x<10e5";
                engage = false;
            }
        }

        while (engage) {

            System.out.println(getMean(a));
            System.out.println(getMedian(a));
            System.out.println(getMode(a));

            engage = false;
        }

        if (!(errorMessage.equals(""))){
            System.out.println(errorMessage);
        }

        s.close();
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

    private static double getMedian(int[] a) {
        double median;
        int size = a.length;
        int [] copy = a.clone();
        Arrays.sort(copy);
        if(size % 2 == 0)
            median = (double) (copy[size/2 - 1] + copy[size/2]) / 2;
        else {
            median = (double) copy[(size-1)/2];
        }
        return median;
    }

    private static int getMode(int[] a) {
        int mode = 0;
        int size = a.length;
        int [] copy = a.clone();
        Arrays.sort(copy);
        int count = 0, max = 0;
        int current = copy[0];
        for(int i = 0;i < size;i++) {
            if (copy[i] == current) {
                count++;
            } else {
                count = 1;
                current = copy[i];
            }
            if (count > max) {
                max = count;
                mode = copy[i];
            }
        }
        return mode;
    }

}
