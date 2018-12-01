import java.util.Scanner;
/**
 * @author Anthony Hartman
 * @date 10/24/2018
 */
public class Main {
    /**
     * method: main
     * @param args String array : contains any command line parameters
     * @returns Does not return anything.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String keepGoing = "Y";
        System.out.println("TEXT CALCULATOR"
                + "\nTYPE HELP OR OFF AT ANY TIME");
        do {
            Problem theProblem = new Problem();
            theProblem.askForNumber(1);
            theProblem.getOperator();
            theProblem.askForNumber(2);
            theProblem.solveProblem();
            System.out.print(theProblem.result);
            System.out.print("\nDo you want to continue? Y / N: ");
            keepGoing = sc.next().trim().toUpperCase();
        } while (keepGoing.equalsIgnoreCase( "Y"));
        sc.close();
    }
}
