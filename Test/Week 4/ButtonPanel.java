//Panel for the submission button
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ButtonPanel extends JPanel {
    //private Formattable fullName;
    private TestPanel tPanel;
    private JButton withdrawButton = new JButton("Withdraw");
    private JButton depositButton = new JButton("Deposit");
    private JButton transferButton = new JButton("Transfer");
    private JButton balanceButton = new JButton("Balance");
    private GoodFrame frame = new GoodFrame();
    private TestAccount tAcc = new TestAccount();
    private TestAccount savingsAccount = new TestAccount();

    public ButtonPanel(TestPanel tPanel) {
        this.tPanel = tPanel;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        withdrawButton.setToolTipText("Click to withdraw the amount entered");
        add(withdrawButton);
        depositButton.setToolTipText("Click to deposit the amount entered");
        add(depositButton);
        transferButton.setToolTipText("Click to transfer the amount entered");
        add(transferButton);
        balanceButton.setToolTipText("Click to display your balance.");
        add(balanceButton);

        balanceButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
                    if(tPanel.tRadioPanel.checkingSelected()){
                        JOptionPane.showMessageDialog(frame, tAcc.getBalance(),
                            "Balance", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, savingsAccount.getBalance(),
                            "Balance", JOptionPane.INFORMATION_MESSAGE);
                    }

                /*
                fullName = new nameLastFirstMiddle();
                btnFullNameAction();
                */
            }
        });

        withdrawButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
//Check the input is not a multiple of 20
                    if(tPanel.tInputPanel.getInput() % 20 != 0){
                        JOptionPane.showMessageDialog(frame, "Please enter a multiple of $20 and try again.",
                            "Warning", JOptionPane.ERROR_MESSAGE);
                        tPanel.tInputPanel.resetText();
                    }
//Check if the Checking account is selected
                    else if (tPanel.tRadioPanel.checkingSelected()){
                        try {
                            tAcc.withdraw(tPanel.tInputPanel.getInput());
                        }
                        catch (brukAssException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
//If Savings account is selected
                    else {
                        try {
                            savingsAccount.withdraw(tPanel.tInputPanel.getInput());
                        }
                        catch (brukAssException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                tPanel.tInputPanel.resetText();
            }
        });

        depositButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
//Check the input is a multiple of 20
                    if(tPanel.tInputPanel.getInput() % 20 != 0){
                        JOptionPane.showMessageDialog(frame, "Please enter a multiple of $20 and try again.",
                            "Warning", JOptionPane.ERROR_MESSAGE);
                        tPanel.tInputPanel.resetText();
                    }
                    else if (tPanel.tRadioPanel.checkingSelected()){
                        tAcc.deposit(tPanel.tInputPanel.getInput());
                    }
                    else {
                        savingsAccount.deposit(tPanel.tInputPanel.getInput());
                    }
                tPanel.tInputPanel.resetText();
            }
        });

        transferButton.addActionListener(new ActionListener(){
            public void actionPerformed (ActionEvent e){
//Check the input is a multiple of 20
                    if(tPanel.tInputPanel.getInput() % 20 != 0){
                        JOptionPane.showMessageDialog(frame, "Please enter a multiple of $20 and try again.",
                            "Warning", JOptionPane.ERROR_MESSAGE);
                    }
                    else if(tPanel.tRadioPanel.checkingSelected()){
                        try{
                            tAcc.transfer(tPanel.tInputPanel.getInput(), savingsAccount);
                        }
                        catch (brukAssException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                    else{
                        try {
                            savingsAccount.transfer(tPanel.tInputPanel.getInput(), tAcc);
                        }
                        catch (brukAssException ex){
                            System.out.println(ex.getMessage());
                        }
                    }
                tPanel.tInputPanel.resetText();
                /*
                fullName = new nameLastFirstMiddle();
                btnFullNameAction();
                */
            }
        });
        

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