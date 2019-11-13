import javax.swing.*;

public class MyFrame extends JFrame {
    //Dimensions for the window
    static final int WIDTH = 500, HEIGHT = 500;

    //Constructor which builds the frame
    public MyFrame(){
        super("This is a Frame");
        setFrame(WIDTH, HEIGHT);
    }

    public MyFrame(String title){
        super(title);
        setFrame(WIDTH, HEIGHT);
    }

    public MyFrame(String title, int width, int height){
        super(title);
        setFrame(width, height);
    }

    private void setFrame(int width, int height){
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}