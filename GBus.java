import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Written by Dan Cancelmo
 * For a campus Kickstart/Codejam held by Google at the University of Rochester
 */
public class GBus {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        busRouter(in);
    }

    /**
     * For each case that exists:
     * Collect al the ranges of each bus.
     * Iterate through each city given and see if it is within that range.
     * If so, iterate the trainCounter.
     * Output the trainCounter at the end of each case
     *
     * @param in the scanner connected to the Standard input
     */
    public static void busRouter(Scanner in) {
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            System.out.print("Case #" + i + ":");
            int trainCount = in.nextInt();
            Range[] trains = new Range[trainCount];
            for (int j = 0; j < trainCount; j++) {
                trains[j] = new Range(in.nextInt(), in.nextInt());
            }
            int numCities = in.nextInt();
            for (int k = 0; k < numCities; k++) {
                int city = in.nextInt();
                int trainCounter = 0;
                for (Range train : trains) {
                    if (train.getLow() <= city && city <= train.getHigh()) {
                        trainCounter++;
                    }
                }
                System.out.print(" " + trainCounter);
            }
            System.out.print("\n");
        }
    }
}
