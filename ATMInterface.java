import java.util.Scanner;
public class ATMInterface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000.00);
        ATM atm = new ATM(account);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter the amount to withdraw");
                    double withdrawAmount = scanner.nextDouble();
                    System.out.println("Entered amount to withdraw: "+withdrawAmount);
                    
                    atm.withdraw(withdrawAmount);
                    break;
                case 2:
                    System.out.println("Enter the amount to deposit");
                    double depositAmount = scanner.nextDouble();
                    System.out.println("Entered amount to deposit: "+depositAmount);
                 
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
