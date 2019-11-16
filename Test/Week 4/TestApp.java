public class TestApp extends GoodFrame{

    TestApp(){
        super();
        add(new TestPanel());
    }

    public static void main (String[] args){
        TestApp tApp = new TestApp();
        tApp.display();
       
        //TestAccount acc = new TestAccount(50);
        //System.out.println(acc.getBalance());
    }
}