package hackerrankchallenges.Days10OfStatistics;

import java.util.Scanner;

public class SolutionWeightedMean {

    public static void main(String[] args) {
        Scanner ui = new Scanner(System.in);
        int size = ui.nextInt();
        int[] numbersFirst = new int[size];
        for(int i = 0; i < size; i++) {
            numbersFirst[i] = ui.nextInt();
        }
        int[] numbersSecond = new int[size];
        for(int i = 0; i < size; i++) {
            numbersSecond[i] = ui.nextInt();
        }
        ui.close();
        int top, bottom;
        top = bottom = 0;

        for(int i = 0; i < size; i++){

            top = top + (numbersFirst[i] * numbersSecond[i]);
            bottom = bottom + numbersSecond[i];
        }

        System.out.printf("%.1f\n", (double) top/bottom);

        ui.close();
    }
}
