import javax.swing.*;

public class GoodFrame extends JFrame {
    //Dimensions for the window
    static final int WIDTH = 500, HEIGHT = 500;

    //Constructors which builds the frame
    public GoodFrame(){
        super("ATM Machine");
        setFrame(WIDTH, HEIGHT);
    }

    //Displays the window
    public void display(){
        setVisible(true);
    }

    //Configure the dimensions and settings for the content of the Frame
    private void setFrame(int width, int height){
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}