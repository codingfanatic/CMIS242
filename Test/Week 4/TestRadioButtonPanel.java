//Panel for the RadioButtons
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class TestRadioButtonPanel extends JPanel {
    //private Formattable fullName;
    private TestPanel tPanel;
    private JRadioButton checkingButton = new JRadioButton("Checking");
    private JRadioButton savingsButton = new JRadioButton("Savings");
    private ButtonGroup group = new ButtonGroup();
        
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));

    private GoodFrame frame = new GoodFrame();
    private TestAccount tAcc = new TestAccount();

    public TestRadioButtonPanel(TestPanel tPanel) {
        this.tPanel = tPanel;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        checkingButton.setSelected(true);
        group.add(checkingButton); 
        group.add(savingsButton);

        radioPanel.add(checkingButton);
        radioPanel.add(savingsButton);
        
        add(radioPanel);

    }
//Return whehter or not checking is selected hehe
    public boolean checkingSelected(){
        return checkingButton.isSelected();
    }
}