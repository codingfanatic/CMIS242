//SimpleCalculatorPanel.java
import java.awt.*;
import javax.swing.*;

class testSimpleCalcPanel extends JPanel { 
   public testIOPanel ioPanel = new testIOPanel(this); 
   public testButtonsPanel btnPanel = new testButtonsPanel(this); 
   public testSimpleCalcPanel () {
      setLayout(new BorderLayout());
      setBackground(Color.lightGray);
      add(ioPanel, BorderLayout.CENTER); 
      add(btnPanel, BorderLayout.SOUTH); 
   }			
}




/*
//SimpleCalculatorPanel.java
import java.awt.*;
import javax.swing.*;
class testSimpleCalcPanel extends JPanel { 
   //create input/output components
   private JLabel leftOprLbl = new JLabel("Left Operand", JLabel.CENTER);
   private JLabel rightOprLbl = 
       new JLabel("Right Operand", JLabel.CENTER);
   private JLabel resultLbl = new JLabel("Result", JLabel.CENTER);
   private JTextField leftOprTxt = new JTextField("");
   private JTextField rightOprTxt = new JTextField("");
   private JTextField resultTxt = new JTextField("");
   //create bottons
   private JButton addBtn = new JButton("Add");
   private JButton subtractBtn = new JButton("Subtract");
   
   public testSimpleCalcPanel () {
      setLayout(new BorderLayout());
      setBackground(Color.lightGray);
      //create the input/output panel
      JPanel inputOutputPanel = new JPanel();   
      inputOutputPanel.setLayout(new GridLayout(2, 3, 0, 5)); 
      resultTxt.setBackground(Color.lightGray);
      resultTxt.setEditable(false);
      inputOutputPanel.add(leftOprLbl);
      inputOutputPanel.add(rightOprLbl);
      inputOutputPanel.add(resultLbl);
      inputOutputPanel.add(leftOprTxt);
      inputOutputPanel.add(rightOprTxt);
      inputOutputPanel.add(resultTxt);			
      add(inputOutputPanel, BorderLayout.CENTER); 
      //create the buttons panel
      JPanel buttonsPanel = new JPanel(); 
      buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER)); 
      addBtn.setToolTipText("Add the two operands.");
      subtractBtn.setToolTipText("Subtract the two operands.");
      buttonsPanel.add(addBtn);
      buttonsPanel.add(subtractBtn);
      add(buttonsPanel, BorderLayout.SOUTH); 
   }			
}
*/