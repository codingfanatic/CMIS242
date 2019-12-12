/*
Account.java
Richard Clarke
11-17-19
A class used to instantiate an account. It contains methods for withdrawing, depositing, transferring funds, and
displaying the balance of the accounts.
*/
import javax.swing.*;

public class Account{
    private double balance;
    private GoodFrame frame = new GoodFrame();
    private static int numberOfWithdrawals = 0;

    Account(){
        this.balance = 0;
    }

    public void withdraw(Double d) throws InsufficientFundsException{
            if(numberOfWithdrawals >= 4){
                if(d + 1.5 > this.balance){
                    throw new InsufficientFundsException("Your account balance is less than the amount entered and potential withdrawal fees.");
                }
                this.balance -= 1.5;
            }

            if(d > this.balance){
                throw new InsufficientFundsException("Your account balance is less than the amount entered and potential withdrawal fees.");
            }

        this.balance -= d;
        numberOfWithdrawals++;
        JOptionPane.showMessageDialog(frame, "$" + d + "0 withdrawal complete.",
        "WITHDRAW SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deposit(Double d){
        this.balance += d;
        JOptionPane.showMessageDialog(frame, "$" + d + "0 deposit complete.",
        "DEPOSIT SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }

    public void transfer(Double d, Account receiveAccount) throws InsufficientFundsException{
        if(d > this.balance) {
            throw new InsufficientFundsException("Your account balance is less than the amount entered.");
        }
        
        this.balance -= d;
        receiveAccount.balance += d;

        JOptionPane.showMessageDialog(frame, "$" + d + "0 transfer complete.",
        "TRANSFER SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }

    public String getBalance(){
        return String.valueOf(this.balance);
    }

    public void display(){
        System.out.println(this.balance);
    }
}