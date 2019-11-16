import java.awt.*;

public class SimpleNameApp extends MyFrame{

    public SimpleNameApp(){
        super("HI! My name is...", 500, 300);
        add(new SimpleNamePanel());
    }
    public static void main(String[] args){
        SimpleNameApp snApp = new SimpleNameApp();
        snApp.display();
    }
}