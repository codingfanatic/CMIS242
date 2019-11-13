//Panel for displaying the Text fields
import java.awt.*;
import javax.swing.*;
class IOPanel extends JPanel {
    //SimpleNamePanel and Labels
    private SimpleNamePanel snPanel;
    private JLabel firstNameLbl = new JLabel("First", JLabel.CENTER);
    private JLabel middleNameLbl = new JLabel("Middle", JLabel.CENTER);
    private JLabel lastNameLbl = new JLabel("Last", JLabel.CENTER);
    private JLabel fullNameLbl = new JLabel("Full Name", JLabel.CENTER);
    //TextFields
    private JTextField firstNameText = new JTextField("");
    private JTextField middleNameText = new JTextField("");
    private JTextField lastNameText = new JTextField("");
    private JTextField fullNameText = new JTextField("");

    //Constructor
    public IOPanel(SimpleNamePanel snPanel) {
        this.snPanel = snPanel;
        setLayout(new GridLayout(2, 4));
        fullNameText.setBackground(Color.lightGray);
        fullNameText.setEditable(false);
        add(firstNameLbl); add(middleNameLbl); add(lastNameLbl); add(fullNameLbl);
        add(firstNameText); add(middleNameText); add(lastNameText); add(fullNameText);
    }

    //Getter/setter methods
    String getFirstName(){
        return firstNameText.getText();
    }

    String getMiddleName(){
        return middleNameText.getText();
    }

    String getLastName(){
        return lastNameText.getText();
    }

    void setFullName(String fullName){
        fullNameText.setText(fullName);
    }




}