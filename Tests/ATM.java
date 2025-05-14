import java.util.Scanner;
public class ATM {
    private static double balance = 1000.00;
    private static final String USER_ID = "praveen";
    private static final String PIN = "1234";
    private static boolean authenticate(String userId, String pin){
        return USER_ID.equals(userId) && PIN.equals(pin);
    }
    private static double getBalance() {
        return balance;
    }
    private static void depositMoney(double money) {
        if (money <= 0) {
            System.err.println("Invalid Amount Entered.");
            System.exit(0);
        }
        balance += money;
    }
    private static void withdrawAmount(double withdrawalAmount) {
        if (withdrawalAmount > balance) {
            System.err.println("Your Current Balance is: " + balance + ", you've entered the larger amount to withdraw try again with lesser amount.");
            System.exit(0);
        }
        balance -= withdrawalAmount;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our Bank.");
        System.out.print("Enter your user id: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your pin: ");
        String pin = scanner.nextLine();
        if (! authenticate(userId, pin)) {
            System.err.print("Invalid Creds ...");
            System.exit(0);
        }
        int choice = 0;
        System.out.println("logged in successfully !!");
        while(choice != 4) {
            System.out.println();
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Exit/Logout");
            System.out.println();
            System.out.print("Enter Your Choice > ");
            choice = scanner.nextInt();

            switch(choice){
                case 1:
                    double currentBalance = getBalance();
                    System.out.println("Your Current Balance is: " + currentBalance);
                    break;
                case 2:
                    System.out.print("Enter the money you want to withdraw: ");
                    double withdrawalAmount = scanner.nextDouble();
                    withdrawAmount(withdrawalAmount);
                    System.out.println("Money Withdrawed Successfully.");
                    System.out.println("Your new balance is: " + getBalance());
                    break;
                case 3:
                    System.out.print("Enter the money you want to deposit: ");
                    double money = scanner.nextDouble();
                    depositMoney(money);
                    System.out.println("Money Deposited Successfully.");
                    System.out.println("Your new balance is: " + getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for choosing our bank.");
                    System.out.println("logged out.");
                    break;
                default:
                    System.out.println("Invalid Operation Detected.");
            }
        }
    }
}