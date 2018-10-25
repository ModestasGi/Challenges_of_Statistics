package hackerrankchallenges.Days10OfStatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SolutionInterquartileRange {

    public static void main(String[]args){

        Scanner ui = new Scanner(System.in);
        int sizeR = ui.nextInt();
        int [] elementRow = new int[sizeR];
        int [] frequencyRow = new int[sizeR];
        int fSum = 0;

        for(int i = 0; i < sizeR; i++){
            elementRow[i] = ui.nextInt();
        }
        for (int i = 0; i < sizeR; i++){
            frequencyRow[i] = ui.nextInt();
            fSum = fSum + frequencyRow[i];
        }

        ArrayList<Integer> dataSet = new ArrayList<>();

        for (int i = 0; i < frequencyRow.length; i++){
            for (int j = 0; j < frequencyRow[i]; j++){
                dataSet.add(elementRow[i]);
            }
        }
        Collections.sort(dataSet);

        System.out.println(dataSet.toString());

    }

}
