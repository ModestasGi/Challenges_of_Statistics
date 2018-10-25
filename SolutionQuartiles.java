package hackerrankchallenges.Days10OfStatistics;

import java.util.Arrays;
import java.util.Scanner;

public class SolutionQuartiles {

    public static void main(String[] arg){

        Scanner ui = new Scanner(System.in);

        int arraySize = ui.nextInt();

        boolean engage1, engage2;
        engage1 = engage2 = true;
        String error = "";
        int arrListError = 1;

        if (arraySize < 5 || arraySize > 50) {
            engage1 = false;
            engage2 = false;
            error = "Error in first line input. Constraint 5 < n < 50";
        }

        int[] arrList = new int[arraySize];

        while (engage1) {

            for (int i = 0; i < arraySize; i++) {
                arrList[i] = ui.nextInt();

                if (arrList[i] < 0 || arrList[i] > 100){
                    engage2 = false;
                    error = "Error in second line input. Constraint 0 < x < 100";
                    arrListError = arrList[i];
                }

                engage1 = false;
            }
        }

        int q1, q2, q3;
        q1 = q2 = q3 = 0;

        while (engage2){

            int size = arrList.length;
            int [] copy = arrList.clone();
            Arrays.sort(copy);


            // code
            if (size%2==0){
                q1 = copy[((size/2)/2)];
                q2 = copy[(((size/2 - 1)+(size/2))/2)];
                q3 = copy[(((size/2)/2)+(size/2))];
            } else {
                q1 = (copy[(((size-1)/2)/2)] + copy[((((size-1)/2)/2)-1)])/2; // tvarkyti
                q2= copy[((size-1)/2)];
                q3 = (copy[((((size-1)/2)/2)+(size/2))] + copy[(((((size-1)/2)/2)+1)+(size/2))])/2;
            }
            engage2 = false;
        }

        if (!(error.equals(""))){
            System.out.println(error);
            if(!(arrListError == 1)){
                System.out.println("input x was -> " + arrListError);
            }
        }
        System.out.println(q1 + "\n" + q2 + "\n" + q3);
        ui.close();
    }
}
