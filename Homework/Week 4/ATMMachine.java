/*
ATMMachine.java
Richard Clarke
11-17-19
A class used to instantiate an ATM object. It allows users to visually manage a Checkings
and Savings account and logs Exceptions thrown when the accounts contain insufficient funds
for a withdrawal or transfer.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//////////////////////////////////////////
//ATM Machine class
//Defines the GUI
//////////////////////////////////////////
public class ATMMachine extends GoodFrame{

    ATMMachine(){
        super();
        add(new ATMPanel());
    }

    public static void main (String[] args){
        ATMMachine atmMachine = new ATMMachine();
        atmMachine.display();
       
        //TestAccount acc = new TestAccount(50);
        //System.out.println(acc.getBalance());
    }

}

//////////////////////////////////////////
//GoodFrame class for creating the JFrame
//////////////////////////////////////////
class GoodFrame extends JFrame {
    //Dimensions for the window
    private static final int WIDTH = 500, HEIGHT = 500;

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

//////////////////////////////////////////
//ATM Panel class for displaying the Panel
//////////////////////////////////////////
class ATMPanel extends JPanel {
    //Instantiate the Button, Input, and RadioButton Panels
    public ButtonPanel btnPanel = new ButtonPanel(this);
    public InputPanel iPanel = new InputPanel(this);
    public RadioButtonPanel rbPanel = new RadioButtonPanel(this);

    public ATMPanel(){
        setLayout(new BorderLayout());
        setBackground(Color.lightGray);
        add(btnPanel, BorderLayout.PAGE_START);
        add(iPanel, BorderLayout.CENTER);
        add(rbPanel, BorderLayout.EAST);
    }
}


//////////////////////////////////////////
//ButtonPanel class
//////////////////////////////////////////
class ButtonPanel extends JPanel {
    //private Formattable fullName;
    private ATMPanel atmPanel;
    private JButton withdrawButton = new JButton("Withdraw");
    private JButton depositButton = new JButton("Deposit");
    private JButton transferButton = new JButton("Transfer");
    private JButton balanceButton = new JButton("Balance");
    private GoodFrame frame = new GoodFrame();
    private Account checkingAccount = new Account();
    private Account savingsAccount = new Account();

    public ButtonPanel(ATMPanel atmPanel) {
        this.atmPanel = atmPanel;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        withdrawButton.setToolTipText("Click to withdraw the amount entered");
        add(withdrawButton);
        depositButton.setToolTipText("Click to deposit the amount entered");
        add(depositButton);
        transferButton.setToolTipText("Click to transfer the amount entered");
        add(transferButton);
        balanceButton.setToolTipText("Click to display your balance.");
        add(balanceButton);

        //Event handlers for each of the four buttons shown
        withdrawButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                    //Check the input is not a multiple of 20
                    if(atmPanel.iPanel.getInput() % 20 != 0){
                        JOptionPane.showMessageDialog(frame, "Please enter a multiple of $20 and try again.",
                            "Warning", JOptionPane.ERROR_MESSAGE);
                        atmPanel.iPanel.resetText();
                    }
                    //Withdraw if the Checking account is selected
                    else if (atmPanel.rbPanel.checkingSelected()){
                        try {
                            checkingAccount.withdraw(atmPanel.iPanel.getInput());
                        }
                        catch (InsufficientFundsException ex) {
                            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                            "Warning", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //Withdraw if the Savings account is selected
                    else {
                        try {
                            savingsAccount.withdraw(atmPanel.iPanel.getInput());
                        }
                        catch (InsufficientFundsException ex) {
                            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                            "Warning", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                //Reset the input text field    
                atmPanel.iPanel.resetText();
            }
        });

        depositButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                    //Check the input is a multiple of 20
                    if(atmPanel.iPanel.getInput() % 20 != 0){
                        JOptionPane.showMessageDialog(frame, "Please enter a multiple of $20 and try again.",
                            "Warning", JOptionPane.ERROR_MESSAGE);
                        atmPanel.iPanel.resetText();
                    }
                    //Deposit if the Checking account is selected
                    else if (atmPanel.rbPanel.checkingSelected()){
                        checkingAccount.deposit(atmPanel.iPanel.getInput());
                    }
                    //Deposit if the Savings account is selected
                    else {
                        savingsAccount.deposit(atmPanel.iPanel.getInput());
                    }
                //Reset the input text field    
                atmPanel.iPanel.resetText();
            }
        });

        transferButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                    //Check the input is a multiple of 20
                    if(atmPanel.iPanel.getInput() % 20 != 0){
                        JOptionPane.showMessageDialog(frame, "Please enter a multiple of $20 and try again.",
                            "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                    //Transfer if the Checking account is selected
                    else if(atmPanel.rbPanel.checkingSelected()){
                        try{
                            checkingAccount.transfer(atmPanel.iPanel.getInput(), savingsAccount);
                        }
                        catch (InsufficientFundsException ex){
                            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                            "Warning", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    //Transfer if the Savings account is selected
                    else{
                        try {
                            savingsAccount.transfer(atmPanel.iPanel.getInput(), checkingAccount);
                        }
                        catch (InsufficientFundsException ex){
                            JOptionPane.showMessageDialog(frame, ex.getMessage(),
                            "Warning", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                //Reset the input text field   
                atmPanel.iPanel.resetText();
            }
        });

        balanceButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                    //Display the Checking Account balance
                    if(atmPanel.rbPanel.checkingSelected()){
                        JOptionPane.showMessageDialog(frame, "Current Balance:\n$" + checkingAccount.getBalance() + "0",
                            "Balance", JOptionPane.INFORMATION_MESSAGE);
                    }
                    //Display the Savings Account balance
                    else{
                        JOptionPane.showMessageDialog(frame, "Current Balance:\n$" + savingsAccount.getBalance() + "0",
                            "Balance", JOptionPane.INFORMATION_MESSAGE);
                    }
            }
        });

    }
}

//////////////////////////////////////////
//Input Panel class
//////////////////////////////////////////
class InputPanel extends JPanel { 
    private ATMPanel atmPanel;
    private GoodFrame frame = new GoodFrame();
    private JTextField inputTxt = new JTextField(20);
    
    public InputPanel (ATMPanel atmPanel) {
       this.atmPanel = atmPanel;
       inputTxt.addKeyListener(new KeyAdapter() {
          @Override
          //Prevent users from entering non-numeric or non-backspace characters
          public void keyPressed(KeyEvent e) {
              char keyAsciiValue = e.getKeyChar();
              if(keyAsciiValue >= (int)'0' && keyAsciiValue <= (int)'9' || keyAsciiValue == 8){
                  inputTxt.setEditable(true);
              }
              else{
                JOptionPane.showMessageDialog(frame, "Please enter numbers only!",
                "Warning", JOptionPane.ERROR_MESSAGE);
                inputTxt.setText("");
              }
          }
       });
       add(inputTxt);
    }			
    
    //Return the amount entered by the user
    double getInput() {
        return Double.parseDouble(inputTxt.getText());
     } 
     
    //Reset the text field after each transaction
    void resetText(){
       inputTxt.setText("");
       inputTxt.setEditable(true);
    }
}
//////////////////////////////////////////
//RadioButtonPanel class
//////////////////////////////////////////
class RadioButtonPanel extends JPanel {
    //private Formattable fullName;
    private ATMPanel atmPanel;
    private JRadioButton checkingButton = new JRadioButton("Checking");
    private JRadioButton savingsButton = new JRadioButton("Savings");
    private ButtonGroup group = new ButtonGroup();
        
    JPanel radioPanel = new JPanel(new GridLayout(0, 1));

    private GoodFrame frame = new GoodFrame();

    public RadioButtonPanel(ATMPanel atmPanel) {
        this.atmPanel = atmPanel;
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