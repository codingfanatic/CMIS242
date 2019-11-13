//InputOutputPanel.java
import java.awt.*;
import javax.swing.*;
class testIOPanel extends JPanel { 
   private testSimpleCalcPanel scPanel;
   private JLabel leftOprLbl = new JLabel("Left Operand", JLabel.CENTER);
   private JLabel rightOprLbl = 
      new JLabel("Right Operand", JLabel.CENTER);
   private JLabel resultLbl = new JLabel("Result", JLabel.CENTER);
   private JTextField leftOprTxt = new JTextField("");
   private JTextField rightOprTxt = new JTextField("");
   private JTextField resultTxt = new JTextField("");
   public testIOPanel (testSimpleCalcPanel scPanel) {
      this.scPanel = scPanel;
      setLayout(new GridLayout(2, 3));
      resultTxt.setBackground(Color.lightGray);
      resultTxt.setEditable(false);
      add(leftOprLbl); add(rightOprLbl); add(resultLbl);
      add(leftOprTxt); add(rightOprTxt); add(resultTxt);		
   }			
   int getLeftOprTxt() {return Integer.parseInt(leftOprTxt.getText());} 
   int getRightOprTxt() {return Integer.parseInt(rightOprTxt.getText());}
   void setResultLbl(String lable) {resultLbl.setText(lable);}
   void setResultTxt(int result) {
      resultTxt.setText(String.valueOf(result)); 
   } 
}