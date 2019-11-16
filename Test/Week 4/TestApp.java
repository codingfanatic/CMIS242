public class TestApp extends GoodFrame{

    TestApp(){
        super();
        add(new TestPanel());
    }

    public static void main (String[] args){
        TestApp tApp = new TestApp();
        tApp.display();
    }
}