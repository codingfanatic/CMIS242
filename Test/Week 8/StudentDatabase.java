import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;

public class StudentDatabase extends GoodFrame{
    StudentDatabase(){
        super();
        add(new DatabasePanel());
    }

    public static void main (String[] args){
        StudentDatabase sdb = new StudentDatabase();
        sdb.display();
       
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
        super("Student Database");
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
//Database Panel class for displaying the Panel
//////////////////////////////////////////
class DatabasePanel extends JPanel {
    //Instantiate the Button, Input, and RadioButton Panels
    //public ButtonPanel btnPanel = new ButtonPanel(this);
    public InfoPanel iPanel = new InfoPanel(this);
    //public RadioButtonPanel rbPanel = new RadioButtonPanel(this);

    public DatabasePanel(){
        setLayout(new FlowLayout());
        setBackground(Color.lightGray);
        //add(btnPanel, BorderLayout.PAGE_START);
        add(iPanel, FlowLayout.LEFT);
        //add(rbPanel, BorderLayout.EAST);
    }
}

//Add the different panels below
//StudentInfo
//Selection
//Process Request

//////////////////////////////////////////
//Info Panel class
//////////////////////////////////////////
class InfoPanel extends JPanel { 
    //DatabasePanel, JLabel objects and button
    private DatabasePanel dbPanel;
    private GoodFrame frame = new GoodFrame();
    private JLabel idLbl = new JLabel("Id:", JLabel.LEFT);
    private JLabel nameLbl = new JLabel("Name:", JLabel.LEFT);
    private JLabel majorLbl = new JLabel("Major:", JLabel.LEFT);
    private JLabel selectLbl = new JLabel("Choose Selection:", JLabel.LEFT);
    private Button processButton = new Button("Process Request");

    //TextFields, String array, and JCombobox
    private JTextField idText = new JTextField(20);
    private JTextField nameText = new JTextField(20);
    private JTextField majorText = new JTextField(20);
    private String options[] = {"Insert", "Delete", "Find", "Update"};
    private JComboBox selectBox = new JComboBox(options);

    //HashMap for storing database information
    Map<Integer, Student> studentMapping = new HashMap<>();

    public InfoPanel (DatabasePanel dbPanel) {
       this.dbPanel = dbPanel;
       processButton.addActionListener(new ActionListener(){
        public void actionPerformed (ActionEvent e){
                
                //Insertion logic
                if(selectBox.getSelectedItem().equals("Insert")) {
                            //Check for previously entered keys in the id field
                            if (studentMapping.containsKey(Integer.parseInt(idText.getText()))){
                                JOptionPane.showMessageDialog(
                                    frame, 
                                    "The key you entered, " + 
                                        Integer.parseInt(idText.getText()) + ", already exists.",
                                    "Warning", 
                                    JOptionPane.INFORMATION_MESSAGE
                                );
                            }
                            //Instantiate a Student object and insert the record
                            else {
                                studentMapping.putIfAbsent(
                                    Integer.parseInt(idText.getText()), 
                                    new Student(nameText.getText(), majorText.getText())
                                );
                                JOptionPane.showMessageDialog(
                                    frame, 
                                    "Insertion Successful",
                                    "Success", 
                                    JOptionPane.INFORMATION_MESSAGE
                                ); 
                            }
                    System.out.println(studentMapping);    
                }
                
                //Deletion Logic
                else if(selectBox.getSelectedItem().equals("Delete")) {
                    //Warning if the key or Student do not exist
                    if (!studentMapping.containsKey(
                        Integer.parseInt(
                            idText.getText()
                        ))
                    ||
                    (!studentMapping.get(
                        Integer.parseInt(
                            idText.getText()
                        ))
                        .getName()
                        .equals(
                            nameText.getText()
                        )
                    )
                    ||
                    (!studentMapping.get(
                        Integer.parseInt(
                            idText.getText()
                        ))
                        .getMajor()
                        .equals(
                            majorText.getText()
                        )
                    ))
                    {
                        JOptionPane.showMessageDialog(
                                frame, 
                                "The record you entered does not exist",
                                "Warning", 
                                JOptionPane.INFORMATION_MESSAGE
                        );
                        System.out.println(studentMapping);  
                    }
                    //Confirm the key, name, and major are stored in the HashMap
                    else if (studentMapping.containsKey(
                            Integer.parseInt(
                                idText.getText()
                            )
                        )
                        &&
                        (studentMapping.get(
                            Integer.parseInt(
                                idText.getText()
                            ))
                            .getName()
                            .equals(
                                nameText.getText()
                            )
                        )

                        &&
                        (studentMapping.get(
                            Integer.parseInt(
                                idText.getText()
                            ))
                            .getMajor()
                            .equals(
                                majorText.getText()
                            )
                        ))
                    {
                            System.out.println(studentMapping);
                            studentMapping.remove(
                                Integer.parseInt(
                                    idText.getText()
                                ),
                                studentMapping.get(
                                    Integer.parseInt(
                                        idText.getText()
                                    )
                                )
                            );
                            System.out.println(studentMapping);    
                    }
                }


/*
                    //Insert the record
                    else {
                        studentMapping.putIfAbsent(
                            Integer.parseInt(idText.getText()), 
                            nameText.getText() + "," + majorText.getText()
                        );

                    }
            System.out.println(studentMapping);    
        */

                else if(selectBox.getSelectedItem().equals("Find")) {
                    JOptionPane.showMessageDialog(frame, "Find selected",
                        "Warning", JOptionPane.INFORMATION_MESSAGE);
                }

                else if (selectBox.getSelectedItem().equals("Update")) {
                    JOptionPane.showMessageDialog(frame, "Update selected",
                        "Warning", JOptionPane.INFORMATION_MESSAGE);
                }
/*
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
*/
        }
        });
       
       /*
       I'll leave this here for the time being.
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
        */

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        
        //Only add idLabel for now
        //### Horiz = GROUP Comp GROUP Vert = GROUP Comp Comp
        //#-#
        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(idLbl)
                    .addComponent(nameLbl)
                    .addComponent(majorLbl)
                    .addComponent(selectLbl)
                    .addComponent(processButton)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(idText)
                    .addComponent(nameText)
                    .addComponent(majorText)
                    .addComponent(selectBox)
                )

        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(idLbl)
                .addComponent(idText)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(nameLbl)
                .addComponent(nameText)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(majorLbl)
                .addComponent(majorText)
            )
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
            .addComponent(selectLbl)
            .addComponent(selectBox)
            )
            .addComponent(processButton)
        );
    }			
    
    //Return the amount entered by the user
    double getInput() {
        return 5.0;//Double.parseDouble(inputTxt.getText());
     } 
     
    //Reset the text field after each transaction
    void resetText(){
       //inputTxt.setText("");
       //inputTxt.setEditable(true);
    }
}