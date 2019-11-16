import java.awt.*;
import javax.swing.*;

//The Panel for combining the Buttons Panel and Input Panel
class TestPanel extends JPanel {
    //Instantiate the IOPanel and Buttons Panel
    public ButtonPanel btnPanel = new ButtonPanel(this);
    public TestInputPanel tPanel = new TestInputPanel(this);

    public TestPanel(){
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        add(btnPanel, BorderLayout.PAGE_START);
        add(tPanel, BorderLayout.CENTER);
    }
}