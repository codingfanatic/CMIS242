import java.awt.*;
import java.awt.event.*;
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
    //DatabasePanel and JLabel objects
    private DatabasePanel dbPanel;
    private JLabel idLbl = new JLabel("Id:", JLabel.LEFT);
    private JLabel nameLbl = new JLabel("Name:", JLabel.LEFT);
    private JLabel majorLbl = new JLabel("Major:", JLabel.LEFT);
    //TextFields
    private JTextField idText = new JTextField(20);
    private JTextField nameText = new JTextField(20);
    private JTextField majorText = new JTextField(20);

    //Might get rid of these
    //private GoodFrame frame = new GoodFrame();
    //private JTextField inputTxt = new JTextField(20);
    
    public InfoPanel (DatabasePanel dbPanel) {
       this.dbPanel = dbPanel;
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
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                    .addComponent(idText)
                    .addComponent(nameText)
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