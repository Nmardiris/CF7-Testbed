package gr.aueb.cf.ch13;

/**
 * Defines a {@link Account} class.
 *
 * @author napom
 * @version 0.1
 * @since 0.1
 *
 */

public class Account {
    private int id;
    private String iban;
    private String firstName;
    private String lastName;
    private String ssn;
    private double balance;

    public Account() {

    }

    public Account(int id, String iban, String firstName, String lastName, String ssn, double balance) {
        this.id = id;
        this.iban = iban;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getIban() {
        return iban;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*
    * Public API
    *
    *
    * Deposits a certain amount of money
    *
    * @param amount              the amount of money to be deposited.
    * @throws Exception          if the a,ount is negative
    */

    public void deposit(double amount)  throws Exception {
        try {
            if (amount < 0 ) {
                throw new Exception("The amount must not be negative.");
            }
            balance += amount;
            System.out.println("Amount " + amount + " successfully deposited.");  // logging
        } catch (Exception e) {
            System.err.print("Error. amount " + amount + " can not be negative");
            // e.printStackTrace();
            throw e;
        }
    }

    /*
     * Public API
     *
     *
     * Withdraws an amount of money from the {@link Account}
     * based on a valid ssn checked by {@link #isSsnValid(String)}
     *
     *
     * @param amount
     *          the amount of money to be withdrawn.
     *
     * @throws ssn
     *              the given ssn.
     *
     * @throws Exception
     *     if the ssn is not valid or the balance is not sufficient or
     *      th amount is negative.
     */
    public void withdraw (double amount, String ssn) throws Exception {
        try {
                if (!isSsnValid(ssn)){
                    throw new Exception("Ssn " + ssn + " is not valid");
                }
                if (amount > balance) {
                    throw new Exception("Insuficient balance " + balance + " for amount " + amount);
                }
                if (amount < 0 ) {
                throw new Exception("The amount " + amount + " must not be negative.");
                }

                balance  -= amount;
                System.out.println("Amount " + amount + " successfully withdrawn.");  // logging
        }catch (Exception e) {
            System.err.println("Error. " + e.getMessage());
            //e.printStackTrace();
            throw e;
        }
    }

    /**
     * Teturns the balance of the {@link Account}.
     *
     *
     * @return the Account's balance.
     */
    public double getAccountBalance() {
        System.out.println("The account balance was returnerd"); // logging
        return getBalance();
    }

    /**
     * Teturns a string-based  of the {@link Account} state.
     *
     *
     * @return the string-based format of the state of the {@link Account}.
     */
    public String accountToString() {
        return "(" + id + ", " + iban + ", " + firstName + ", " + lastName + ", " + ssn + ", " + balance + ")";
    }

    // Internals

    private boolean isSsnValid(String ssn)  {
        return this.ssn.equals(ssn);
    }


}
