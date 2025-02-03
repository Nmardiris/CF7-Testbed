package gr.aueb.cf.ch13;

public class Main {

    public static void main(String[] args) {
        Account account = new Account(1,  "GR242", "Alice", "Wonderland", "S123", 1000.0);

        try {
            account.deposit(900);
            System.out.println("The deposit was succesful");

            account.withdraw(500, "R123");

            account.withdraw(200, "S123");
            System.out.println("the withdraw was successful.");

            System.out.println("Balance: " + account.getAccountBalance());

            account.accountToString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
