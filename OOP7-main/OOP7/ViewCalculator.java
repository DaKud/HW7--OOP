public class ViewCalculator {

    private ICalculableFactory calculableFactory;

    public ViewCalculator(ICalculableFactory calculableFactory) {
        this.calculableFactory = calculableFactory;
    }

    public void run() {
        while (true) {
            int primaryArg = promptInt("Enter the 1st argument : ");
            Calculable calculator = calculableFactory.create(primaryArg, true);
            while (true) {
                String cmd = prompt("enter the action (*, +, =) : ");
                if (cmd.equals("*")) {
                    int arg = promptInt("Enter the 2nd argument: ");
                    calculator.multi(arg);
                    continue;
                }
                if (cmd.equals("+")) {
                    int arg = promptInt("Enter the 2nd argument: ");
                    calculator.sum(arg);
                    continue;
                }
                if (cmd.equals("=")) {
                    int result = calculator.getResult();
                    System.out.printf("Result %d\n", result);
                    break;
                }
            }
            String cmd = prompt("Calculate (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }

    private int promptInt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return Integer.parseInt(in.nextLine());
    }
}