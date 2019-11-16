//Panel for the submission button
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonPanel extends JPanel {
    //private Formattable fullName;
    private TestPanel tPanel;
    private JButton balanceButton = new JButton("Balance");

    public ButtonPanel(TestPanel tPanel) {
        this.tPanel = tPanel;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        balanceButton.setToolTipText("Click to display your balance.");
        add(balanceButton);
/*
        submitBtn.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                fullName = new nameLastFirstMiddle();
                btnFullNameAction();
            }
        });
*/
    }
/*
    public void btnFullNameAction(){
        String firstName = snPanel.ioPanel.getFirstName();
        String middleName = snPanel.ioPanel.getMiddleName();
        String lastName = snPanel.ioPanel.getLastName();
        //Set the full name in the Full Name field using the combineNames method
        //In the Formattable class
        snPanel.ioPanel.setFullName(
            fullName.combineNames(firstName, middleName, lastName));
    }
*/
}