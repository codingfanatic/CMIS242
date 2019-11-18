import javax.swing.*;

public class TestAccount{
    private double balance;
    private GoodFrame frame = new GoodFrame();
    static int numberOfWithdrawals = 0;

    TestAccount(){
        this.balance = 5000;
    }

    public void withdraw(Double d) throws brukAssException{
            if(numberOfWithdrawals >= 4){
                if(d + 1.5 > this.balance){
                    throw new brukAssException("Your account balance is less than the amount entered. Who wrote this? lol");
                }
                this.balance -= 1.5;
            }

            if(d > this.balance){
                throw new brukAssException("Your account balance is less than the amount entered. Who wrote this? lol");
            }

        this.balance -= d;
        numberOfWithdrawals++;
        JOptionPane.showMessageDialog(frame, "$" + d + "0 withdrawal complete.",
        "WITHDRAW SUCCESS", JOptionPane.INFORMATION_MESSAGE);
    }

    public void deposit(Double d){
        this.balance += d;
    }

    public void transfer(Double d, TestAccount receiveAccount) throws brukAssException{
        if(d > this.balance) {
            throw new brukAssException("Your account balance is less than the amount entered. Who wrote this? lol");
        }
        
        this.balance -= d;
        receiveAccount.deposit(d);
    }

    public String getBalance(){
        return String.valueOf(this.balance);
    }

    public void display(){
        System.out.println(this.balance);
    }
}