import java.util.Scanner;

public class Main {
    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);

            try {
                switch (tokens[0]) {
                    case "add" -> {
                        if (tokens.length == 1) {
                            throw new ArrayIndexOutOfBoundsException("Wrong command. Correct command: " + ADD_COMMAND);
                        }
                        executor.addCustomer(tokens[1]);
                    }
                    case "list" -> executor.listCustomers();
                    case "remove" -> {
                        if (tokens.length == 1) {
                            throw new ArrayIndexOutOfBoundsException("Wrong command. Correct command: remove Василий Петров");
                        }
                        executor.removeCustomer(tokens[1]);
                    }
                    case "count" -> System.out.println("There are " + executor.getCount() + " customers");
                    case "help" -> System.out.println(helpText);
                    default -> System.out.println(COMMAND_ERROR);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
