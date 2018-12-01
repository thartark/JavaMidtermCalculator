import java.util.Scanner;
/**
 * @author Anthony Hartman
 * @date 10/24/2018
 * This defines the Problem class, which we'll use to build the problems used by the calculator in the main method.
 */
public class Problem {
    public boolean firstNumberNeeded;
    public double firstNum;
    public String operator;
    public double secondNum;
    public double result;
    public Scanner sc = new Scanner(System.in);

    public Problem() {
    }

    /** Prompts the user for a number and assigns that number to "this.firstNum" or "this.secondNum".
     * Checks if input contains "help", "off", or "exit" and deals with those accordingly.
     * Keeps running until the user enters something. (Empty input is not accepted.)
     * @param counter This will allow reuse of the getNumber module
     * by passing in a 1 the first time the module is used, which will be changed to a 2 once a number is entered.
     * @return Does not return anything.
     */
    public void askForNumber(int counter) {
        boolean numberNeeded = true;
        String input;
        do {
            System.out.print("Enter a number or PI: ");
            input = sc.next().trim().toUpperCase();
            if (input.contains("HELP")) {
                displayHelp();
            } else if (input.contains("OFF")) {
                System.out.println("Thanks. Bye!");
                System.exit(0);
            } else if (input.contains("PI")) {
                if (counter == 1) {
                    this.firstNum = Math.PI;
                    numberNeeded = false;
                } else {
                    this.secondNum = Math.PI;
                    numberNeeded = false;
                }
            } else if (input.trim().matches(".*\\d+.*")) {
                try {
                    if (counter == 1) {
                        this.firstNum = Double.parseDouble(input);
                        numberNeeded = false;
                    } else {
                        this.secondNum = Double.parseDouble(input);
                        numberNeeded = false;
                    }
                }
                catch (Exception e) {
                    System.out.println("Sorry, that won't work. Try again: ");
                }
            } else {
                System.out.println("Try again!");
            }
        } while (numberNeeded);
    }

    /**Displays help whenever the user types "help" in input for any method in the program.
     * @return Does not return anything.
     */
    private void displayHelp() {
        System.out.print("First, enter a number or PI." +
                "\nThen, enter an operator + - * / % (find the remainder) or ^ (raise to a power)." +
                "\n\nThird, enter a number or PI." +
                "\n\nType HELP or OFF anytime!");
    }

    /** Prompts the user for an operator ( + - / * % and assigns that number to "this.operator".
     * Checks if input contains "help", "off", or "exit" and deals with those accordingly.
     * Keeps running until the user enters something. (Empty input is not accepted.)
     * @return Does not return anything.
     */
    public void getOperator() {
        do {
            System.out.print("Now enter an operator ( + - * / % ^ (raise to a power): ");
            this.operator = sc.next().trim().toUpperCase();
            if (this.operator.contains("HELP")) {
                displayHelp();
                this.operator = null;
            }
        } while (this.operator == null);
    }

    /** This method solves the problem that was built:
     * (this.firstNum, operator, this.secondNum)
     * @return This method returns this.result
     */
    public double solveProblem() {
        switch (this.operator) {
            case "+":
                this.result = this.firstNum + this.secondNum;
                break;
            case "-":
                this.result = this.firstNum - this.secondNum;
                break;
            case "*":
                this.result = this.firstNum * this.secondNum;
                break;
            case "/":
                this.result = this.firstNum / this.secondNum;
                break;
            case "%":
                this.result = this.firstNum % this.secondNum;
                break;
            case "^":
                this.result = Math.pow(this.firstNum, this.secondNum);
                break;
            default: System.out.println("Sorry, you entered an impossible operator. Try again below.");
        }
        return this.result;
    }

}


