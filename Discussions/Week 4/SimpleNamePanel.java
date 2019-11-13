import java.awt.*;
import javax.swing.*;

//The Panel for combining the IOPanel and Buttons Panel
class SimpleNamePanel extends JPanel {
    //Instantiate the IOPanel and Buttons Panel
    public IOPanel ioPanel = new IOPanel(this);
    public ButtonPanel btnPanel = new ButtonPanel(this);

    public SimpleNamePanel(){
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        add(ioPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
}