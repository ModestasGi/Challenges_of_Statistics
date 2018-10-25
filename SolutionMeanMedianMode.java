package hackerrankchallenges.Days10OfStatistics;

import java.util.Scanner;

public class SolutionMeanMedianMode {

    public static void main(String[] args) {

        Scanner ui = new Scanner(System.in);

        boolean engage = true;
        String errorMessage ="";

            int n = ui.nextInt();

            if (n < 10 || n > 2500) {
                engage = false;
                errorMessage = "Input error in first line";
            }

            long[] x = new long[n];

            for (int i = 0; i < n; i++) {
                x[i] = ui.nextLong();
                if ((x[i] < 0) || (x[i] > 100000)) {
                    engage = false;
                    errorMessage = "Input error in second line";
                }
            }
// calculation part

        while (engage){
            float mean = 0;
            float median;
            long mode = x[0];

            for (int i = 0; i < n; i++){
                mean = mean + x[i];
                if(mode > x[i])
                mode = x[i];
            }
// searching median
            long temp;
// ascending order
            for (int i = 0; i < x.length; i++) {
                for (int j = i; j > 0; j--) {
                    if (x[j] < x [j - 1]) {
                        temp = x[j];
                        x[j] = x[j - 1];
                        x[j - 1] = temp;
                    }
                }
            }
             for(int i = 0; i < x.length; i++){
                 System.out.println(x[i]);

             }

            float[] foundMiddle;
            if (x.length %2 == 0) {
                // even-length array (two middle elements)
                foundMiddle = new float[2];
                foundMiddle[0] = x[(x.length/2) - 1];
                foundMiddle[1] = x[x.length/2];
                median = (foundMiddle[0] + foundMiddle[1])/2;
            } else {
                // odd-length array (only one middle element)
                foundMiddle = new float[1];
                foundMiddle[0] = x[x.length/2];
                median = foundMiddle[0];
            }
            System.out.println(mean/n); // done
            System.out.println(median); // done
            System.out.println(mode); // done
            engage = false;
        }

        if (!(errorMessage.equals(""))){
            System.out.println(errorMessage);
        }
        ui.close();
    }
}
