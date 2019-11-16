import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Calculator {

    private JFrame frame = new JFrame();
    final private int WIDTH = 1000, HEIGHT = 700;
    private JTextField[] firstLoanInputFields = new JTextField[3];
    private JTextField[] outputFields = new JTextField[3];
    private JTextField[] tester = new JTextField[3];
    private JPanel topPanel = new JPanel(), leftPanel = new JPanel(), rightPanel = new JPanel(), centerPanel = new JPanel();
    private JButton calculate = new JButton("Calculate");

    public Calculator() {
        frame.setBackground(Color.GRAY);
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        leftPanel.setPreferredSize(new Dimension(400, 350));
        rightPanel.setPreferredSize(new Dimension(400, 350));
    }


    public void display(){
        JLabel header = new JLabel("Amortizing Loan Calculator ");
        header.setFont(new Font("Arial", Font.BOLD, 36));
        topPanel.add(header);

        String[] inputDescription = {"Loan Amount", "Interest Rate", "Year Amount"};
        String[] outputDescription = {"Monthly Payment", "Total Interest", "Total Amount"};


        for(int i = 0; i < 3; i++){
            JPanel tmpPanel = new JPanel();
            JLabel descriptor = new JLabel(inputDescription[i]);
            tmpPanel.setPreferredSize(new Dimension(400, 40));
            firstLoanInputFields[i] = new JTextField();
            firstLoanInputFields[i].setPreferredSize(new Dimension(300, 30));
            final int FINAL_INDEX = i;
            firstLoanInputFields[i].addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    char keyAsciiValue = e.getKeyChar();
                    if(keyAsciiValue >= (int)'0' && keyAsciiValue <= (int)'9' || keyAsciiValue == 8){
                        firstLoanInputFields[FINAL_INDEX].setEditable(true);
                    }
                    else{
                        firstLoanInputFields[FINAL_INDEX].setEditable(false);
                    }
                }
            });
            tmpPanel.add(descriptor);
            tmpPanel.add(firstLoanInputFields[i]);
            leftPanel.add(tmpPanel);

            JPanel tmpOutputPanel = new JPanel();
            tmpOutputPanel.setPreferredSize(new Dimension(400, 40));

            JLabel outputDescriptor = new JLabel(outputDescription[i]);
            tmpOutputPanel.add(outputDescriptor);

            outputFields[i] = new JTextField();
            outputFields[i].setPreferredSize(new Dimension(250, 30));
            outputFields[i].setEditable(false);

            tmpOutputPanel.add(outputFields[i]);

            rightPanel.add(tmpOutputPanel);
        }

        getCalculateButton();
        frame.add(BorderLayout.CENTER, centerPanel);
        frame.add(BorderLayout.NORTH, topPanel);
        frame.add(BorderLayout.WEST, leftPanel);
        frame.add(BorderLayout.EAST, rightPanel);
        frame.setVisible(true);
    }

    private void getCalculateButton(){
        centerPanel.add(calculate);
        calculate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculateLoanDetails();
            }
        });
    }

    private void calculateLoanDetails(){
		//Loop cycles through looking if any of the text fields are blank and sends an error JOptioPane if so
        for(int i = 0; i < firstLoanInputFields.length; i++){
            if(firstLoanInputFields[i].getText().equals("")){
                JOptionPane.showMessageDialog(frame,"Please Fill In All Fields!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }else if(firstLoanInputFields[i].getText().length() > 9){
                JOptionPane.showMessageDialog(frame,"Field " + (i + 1) + " is too big!",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
		
		//Checks if the year is greater than 50 or less than one
        int year = Integer.parseInt(firstLoanInputFields[2].getText());
        if(year > 50 || year < 1){
            JOptionPane.showMessageDialog(frame,"Year must be between 1 and 50!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int loanAmount = Integer.parseInt(firstLoanInputFields[0].getText());
        double monthlyInterestRate = Integer.parseInt(firstLoanInputFields[1].getText());
		
		//checks if the monthly interest rate is above 100 and if so it will give an error message
        if(monthlyInterestRate > 100){
            JOptionPane.showMessageDialog(frame, "Interest Rate must be between 0 - 100!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
		
		
        monthlyInterestRate = monthlyInterestRate / 1200.0;
        int months = Integer.parseInt(firstLoanInputFields[2].getText()) * 12;

        double discountFactor = ((Math.pow((1 + monthlyInterestRate), months) - 1) / (monthlyInterestRate * Math.pow((1 + monthlyInterestRate), months)));
        double monthlyPayment = loanAmount / discountFactor;
        double totalAmount = (monthlyPayment * months);

		//populates the output fields with the desired format
        outputFields[0].setText(String.format("$%,.2f", monthlyPayment));
        outputFields[1].setText(String.format("$%,.2f", totalAmount - loanAmount));
        outputFields[2].setText(String.format("$%,.2f", totalAmount));

    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.display();
    }
}