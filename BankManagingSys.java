import java.util.Scanner;

public class BankManagingSys{
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        final String CLEAR = "\033[H\033[2J";
        final String COLOR_BLUE_BOLD = "\033[34;1m";
        final String COLOR_RED_BOLD = "\033[31;1m";
        final String COLOR_GREEN_BOLD = "\033[33;1m";
        final String RESET = "\033[0m";
        final String ERROR_MSG = String.format("\t%s%s%s\n", COLOR_RED_BOLD, "%s", RESET);
        final String SUCCESS_MSG = String.format("\t%s%s%s\n", COLOR_GREEN_BOLD, "%s", RESET);

        final String DASHBOARD = "Welcome to Smart Banking";
        final String CREATE_NEW_ACCOUNT = "Create New Account";
        final String DEPOSITE = "Deposit";
        final String WITHDRAW = "Withdraw";
        final String TRANSFER = "Transfer";
        final String CHECK_ACCOUNT_BALANCE = "Check Account Balance";
        final String DELETE_ACCOUNT = "Delete Account";
        final String EXIT = "Exit";

        String screen = DASHBOARD;
        String[][] accountDetails = new String[0][];

        do {
            final String APP_TITLE = String.format("%s%s%s",
            COLOR_BLUE_BOLD, screen, RESET);

            System.out.println(CLEAR);
            System.out.println("\t" + APP_TITLE + "\n");

            switch (screen) {
                case DASHBOARD:
                    System.out.println("\t[1]. Create New Account");
                    System.out.println("\t[2]. Deposit");
                    System.out.println("\t[3]. Withdraw");
                    System.out.println("\t[4]. Transfer");
                    System.out.println("\t[5]. Check Account Balance");
                    System.out.println("\t[6]. Delete Account");
                    System.out.println("\t[7]. Exit");

                    System.out.print("\tEnter an option to continue: ");
                    int option = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (option){
                        case 1: screen = CREATE_NEW_ACCOUNT; break;
                        case 2: screen = DEPOSITE; break;
                        case 3: screen = WITHDRAW; break;
                        case 4: screen = TRANSFER; break;
                        case 5: screen = CHECK_ACCOUNT_BALANCE; break;
                        case 6: screen = DELETE_ACCOUNT; break;
                        case 7: System.out.println(CLEAR); System.exit(0);
                        default: continue;
                    }

                    break;
                case CREATE_NEW_ACCOUNT:
                    int id;
                    String name;
                    double deposit;
                    boolean valid;

                    
                    id = accountDetails.length + 1;
                    System.out.printf("ID: SDB-%05d\n",id);

                    

                    //Name Validation
                    do {
                        valid = true;
                        System.out.print("Name: ");
                        name = scanner.nextLine();

                        if (name.isBlank()){
                            System.out.printf(ERROR_MSG, "Name can't be empty");
                            valid = false;
                        }else{
                            for (int i = 0; i < name.length(); i++) {
                                if (!(Character.isLetter(name.charAt(i)) ||
                                    Character.isSpaceChar(name.charAt(i)))) {
                                    System.out.printf("%sInvalid Name%s\n", COLOR_RED_BOLD, RESET);
                                    valid = false;
                                    break;
                                }
                            }
                        }
                        if(!valid){
                            System.out.print("Do you want to try again?(Y/n)");
                            if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                            break;
                        }
                        
                    } while (!valid);

                    //Intial Deposit validation
                    do {
                        valid = true;
                        System.out.print("Initial Deposit: ");
                        deposit = scanner.nextDouble();
                        scanner.nextLine();

                        if(deposit < 5000){
                            System.out.printf(ERROR_MSG,"Insuffient amount.");
                            valid = false;
                            continue;
                        }
                        if(!valid){
                            System.out.print("Do you want to try again?(Y/n)");
                            if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                            break;
                        }

                    } while (!valid);

                
                    String[][] newAccountDetails = new String[accountDetails.length+1][3];

                    for (int i = 0; i < accountDetails.length; i++) {
                        newAccountDetails[i] = accountDetails[i];
                    }
                    
                    newAccountDetails[newAccountDetails.length-1][0] = Integer.toString(id);
                    newAccountDetails[newAccountDetails.length-1][1] = name;
                    newAccountDetails[newAccountDetails.length-1][2] = Double.toString(deposit);

                    newAccountDetails = accountDetails;

                    System.out.println();
                    System.out.printf(SUCCESS_MSG, String.format("%s:%s has been created successfully", id, name));
                    System.out.print("\tDo you want to add another (Y/n)? ");
                    if (scanner.nextLine().strip().toUpperCase().equals("Y")) continue;
                    screen = DASHBOARD;
                    
                    break;
                case DEPOSITE:
                    break;
                case WITHDRAW:
                    break;
                case TRANSFER:
                    break;
                case CHECK_ACCOUNT_BALANCE:
                    break;
                case DELETE_ACCOUNT:
                    break;
                case EXIT:
                    System.exit(0);
            }
        } while (true);
    }   
}