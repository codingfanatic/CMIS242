import java.awt.*;
import javax.swing.*;

//The Panel for combining the Buttons Panel and Input Panel
class TestPanel extends JPanel {
    //Instantiate the IOPanel and Buttons Panel
    public ButtonPanel btnPanel = new ButtonPanel(this);
    public TestInputPanel tInputPanel = new TestInputPanel(this);
    public TestRadioButtonPanel tRadioPanel = new TestRadioButtonPanel(this);

    public TestPanel(){
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        add(btnPanel, BorderLayout.PAGE_START);
        add(tInputPanel, BorderLayout.CENTER);
        add(tRadioPanel, BorderLayout.EAST);
    }
}