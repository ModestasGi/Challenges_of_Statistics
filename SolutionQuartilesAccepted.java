package hackerrankchallenges.Days10OfStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionQuartilesAccepted {

    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);

        int arraySize = ui.nextInt();

        boolean engage1, engage2;
        engage1 = engage2 = true;

        if (arraySize < 5 || arraySize > 50) {
            engage1 = false;
            engage2 = false;
        }
        int[] arrList = new int[arraySize];

        while (engage1) {

            for (int i = 0; i < arrList.length; i++) {
                arrList[i] = ui.nextInt();
            }
            engage1 = false;
        }

        Arrays.sort(arrList);
        int q1 = 0;
        int q2 = computeMedian(arrList, 0, arraySize - 1);
        int q3 = 0;

        int lowerMargin;
        int upperMargin;
        if (arraySize % 2 == 0) {
            lowerMargin = arraySize / 2 - 1;
            upperMargin = arraySize / 2;
        } else {
            lowerMargin = arraySize / 2 - 1;
            upperMargin = arraySize / 2 + 1;
        }

        while (engage2) {

            q1 = computeMedian(arrList, 0, lowerMargin);
            q3 = computeMedian(arrList, upperMargin, arraySize - 1);

            engage2 = false;
        }



        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);

        ui.close();
    }

    static int computeMedian(int[] x, int beginIndex, int endIndex) {
        int size = endIndex - beginIndex + 1;
        if (size % 2 == 0) {
            return (x[beginIndex + size / 2 - 1] + x[beginIndex + size / 2]) / 2;
        } else {
            return x[beginIndex + size / 2];
        }
    }

}
