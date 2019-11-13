import java.awt.*;

public class SimpleNameApp extends MyFrame{

    public SimpleNameApp(){
        super("HAPPY FEET! WOMBO COMBO", 500, 300);
        add(new SimpleNamePanel());
    }
    public static void main(String[] args){
        SimpleNameApp snApp = new SimpleNameApp();
        snApp.display();
    }
}