public class TestAccount{
    private double balance;

    TestAccount(){
        this.balance = 5000;
    }

    public String getBalance(){
        return String.valueOf(this.balance);
    }

    public void display(){
        System.out.println(this.balance);
    }
}