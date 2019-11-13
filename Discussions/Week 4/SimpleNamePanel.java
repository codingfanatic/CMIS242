import java.awt.BorderLayout;
import java.awt.Color;

//The Panel for combining the IOPanel and Buttons Panel
public class SimpleNamePanel extends JPanel {
    //Instantiate the IOPanel and Buttons Panel
    public IOPanel ioPanel = new IOPanel(this);
    public ButtonsPanel btnPanel = new ButtonsPanel(this);

    public SimpleNamePanel(){
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        add(ioPanel, BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }
}