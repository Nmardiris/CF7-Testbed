package gr.aueb.cf.ch13;

public class Account2 {
    private int id;
    private String iban;
    private String firstName;
    private String lastName;
    private String ssn;
    private double balance;

    public Account2() {

    }

    public Account2(int id, String iban, String firstName, String lastName, String ssn, double balance) {
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

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Depopits a certain amount of money
     *
     * @param amount the amount of money to be deposited
     * @throws Exception if the amount is negative
     */


    public void deposit(double amount) throws Exception {
        try {
            if (amount < 0){
                throw new Exception("The amount must not be negative.");
            }
            balance += amount;
            System.out.println("Amount " + amount + " was succesfully deposited"); // logging
        } catch (Exception e) {
            System.err.println("Error. amount " + amount + "can not be negative");
            //e.printStackTrace();
            throw e;
        }
    }

    public void withdraw(double amount, String ssn) {
        try{
            if (!isSsnValid(ssn)) {
                throw new Exception("Ssn " + ssn + "is not valid");
            }
            if (amount > balance) {
                throw new Exception("insuficient balance" + balance + " for amount " +amount );
            }
        }
        catch (Exception e) {
            System.err.println("Error. amount " + amount + "can not be negative");
            //e.printStackTrace();
            throw e;
        }
    }

    /**
     *
     * @param ssn
     * @return
     */

    private boolean isSsnValid(String ssn){
        return this.ssn.equals(ssn);
    }

}
