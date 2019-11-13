//Panel for the submission button
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonPanel extends JPanel {
    private Formattable fullName;
    private SimpleNamePanel snPanel;
    private JButton submitBtn = new JButton("Submit");

    public ButtonPanel(SimpleNamePanel snPanel) {
        this.snPanel = snPanel;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        submitBtn.setToolTipText("Click to submit your names.");
        add(submitBtn);

        submitBtn.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                fullName = new nameLastFirstMiddle();
                btnFullNameAction();
            }
        });
    }

    public void btnFullNameAction(){
        String firstName = snPanel.ioPanel.getFirstName();
        String middleName = snPanel.ioPanel.getMiddleName();
        String lastName = snPanel.ioPanel.getLastName();
        //Set the full name in the Full Name field using the combineNames method
        //In the Formattable class
        snPanel.ioPanel.setFullName(
            fullName.combineNames(firstName, middleName, lastName));
    }
}