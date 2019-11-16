public class TestAccount{
    private double balance;

    TestAccount(double balance){
        this.balance = balance;
    }

    public void display(){
        System.out.println(this.balance);
    }
}