import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Written by Dan Cancelmo
 * For a campus Kickstart/Codejam held by Google at the University of Rochester
 */
public class Dance {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        danceBattle(in);
    }

    /**
     * For each case that exists:
     * While you can beat the weakest team, dance against them.
     * When you don't have enough energy:
     *      If you have no honor or is only one team left: quit
     *      Otherwise always recruit
     * Output the total honor you have at the end of each case
     *
     * @param in the scanner connected to the Standard input
     */

    public static void danceBattle(Scanner in) {
        int numCases = in.nextInt();
        for (int i = 1; i <= numCases; i++) {
            System.out.print("Case #" + i + ":");
            int honor = 0;
            int energy = in.nextInt();
            int numRivals = in.nextInt();
            LinkedList<Integer> rivalSkills = new LinkedList<>();
            for (int j = 0; j < numRivals; j++) {
                rivalSkills.add(in.nextInt());
            }
            Collections.sort(rivalSkills);
            while (!rivalSkills.isEmpty()) {
                int first = rivalSkills.getFirst();
                if (first < energy) {
                    rivalSkills.removeFirst();
                    honor++;
                    energy -= first;
                } else {
                    if (honor == 0 || rivalSkills.size() == 1) {
                        break;
                    } else {
                        energy += rivalSkills.removeLast();
                        honor--;
                    }
                }
            }
            System.out.print(" " + honor + "\n");
        }
    }
}
