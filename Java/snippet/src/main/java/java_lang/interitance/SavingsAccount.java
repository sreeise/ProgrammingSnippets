package java_lang.interitance;

/*
Basic Savings subclass that calculates yearly interest and overrides deposit()
from its super class Account.
 */

public class SavingsAccount extends Account {
  private double interestRate;

  public SavingsAccount(int accountId, double startingBalance, String firstName, String lastName, String email, double interestRate) {
    super(accountId, startingBalance, firstName, lastName, email);
    this.interestRate = interestRate;
  }

  public double getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(double interestRate) {
    this.interestRate = interestRate;
  }

  // Annual Interest Rate.
  private double calculateInterest() {
    return (interestRate / 100) / 12;
  }

  public void applyInterest() {
    super.deposit(super.getBalance() + this.calculateInterest());
  }

  @Override
  public void deposit(double amount) {
    super.deposit(amount);
  }

  @Override
  public String toString() {
    return super.toString() +
          "\nSavingsAccount{" +
          "interestRate=" + interestRate +
          '}';
  }
}
