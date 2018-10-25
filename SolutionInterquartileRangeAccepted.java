package hackerrankchallenges.Days10OfStatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SolutionInterquartileRangeAccepted {


    private static double getMedian(ArrayList<Integer> list, int start, int end) {
        double median;
        int size = end - start + 1;
        if(size % 2 == 0)
            median = (list.get(start + size/2 - 1) + list.get(start + size/2)) / 2;
        else {
            median = list.get(start + (size -1)/2);
        }

        System.out.println("median " + median);

        return median;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<n; i++) {
            list.add(scan.nextInt());
        }
        for(int i=0; i<n; i++) {
            int element = list.get(i);
            int frequency = scan.nextInt();
            while(frequency-- > 1) {
                list.add(element);
            }
        }
        scan.close();

        Collections.sort(list);

        double Q1, Q2;
        n = list.size();
        Q1 = getMedian(list, 0, n / 2 - 1);
        if (n % 2 == 0) {
            Q2 = getMedian(list, n / 2, n - 1);
        } else {
            Q2 = getMedian(list, n / 2 + 1, n - 1);
        }

        System.out.println(Q2-Q1);
    }

}
