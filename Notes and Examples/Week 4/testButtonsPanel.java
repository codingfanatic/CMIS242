//ButtonsPanel.java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class testButtonsPanel extends JPanel { 
   private testEval binaryOpr;
   private testSimpleCalcPanel scPanel;
   private JButton addBtn = new JButton("Add");
   private JButton subtractBtn = new JButton("Subtract");
   public testButtonsPanel (testSimpleCalcPanel scPanel) {
      this.scPanel = scPanel;	
      setLayout(new FlowLayout(FlowLayout.CENTER));
      addBtn.setToolTipText("Add the two operands.");
      subtractBtn.setToolTipText("Subtract the two operands.");
      add(addBtn); 
      add(subtractBtn);
      addBtn.addActionListener(new ActionListener(){ 
	 public void actionPerformed(ActionEvent e){ 
	    setResultLbl("Sum");
            binaryOpr = new testAdd(); 
            btnBinaryOprAction();}});
      subtractBtn.addActionListener(new ActionListener(){
	 public void actionPerformed(ActionEvent e){ 
	    setResultLbl("Difference");
	    binaryOpr = new testSubtract(); 
            btnBinaryOprAction();}});
   }	
   public void setResultLbl(String label) {
      scPanel.ioPanel.setResultLbl(label);
   }		
   public void btnBinaryOprAction() {
      int leftOperand = scPanel.ioPanel.getLeftOprTxt();
      int rightOperand = scPanel.ioPanel.getRightOprTxt();
      scPanel.ioPanel.setResultTxt( 
         binaryOpr.evaluate(leftOperand, rightOperand));
   }
}