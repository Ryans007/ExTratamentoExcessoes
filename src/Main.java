import Model.entities.Account;
import Model.exceptions.AccountExceptions;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data");

            System.out.print("Number: ");
            int accountNumber = sc.nextInt();

            System.out.print("Holder: ");
            sc.nextLine();
            String holder = sc.nextLine();

            System.out.print("Initial balance: ");
            double initialBalance = sc.nextDouble();

            System.out.print("Withdraw limit: ");
            double withdrawLimit = sc.nextDouble();

            Account account = new Account(accountNumber, holder, initialBalance, withdrawLimit);
            System.out.println();

            System.out.print("Enter amount for withdraw: ");
            account.withdraw(sc.nextDouble());

            System.out.printf("New balance: %.2f%n", account.getBalance());
        }catch (AccountExceptions e){
            System.out.println("withdraw error: " + e.getMessage());
        }catch (RuntimeException e) {
            System.out.println("unexpected error");
        }
        sc.close();
    }
}