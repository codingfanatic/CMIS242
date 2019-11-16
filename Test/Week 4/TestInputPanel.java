//TestInputPanel.java
import java.awt.*;
import javax.swing.*;

class TestInputPanel extends JPanel { 
   private TestPanel tPanel;
   private JTextField inputTxt = new JTextField(20);
   
   public TestInputPanel (TestPanel tPanel) {
      this.tPanel = tPanel;
      //setLayout(new FlowLayout(FlowLayout.CENTER));
      add(inputTxt); 		
   }			

   double getInput() {
       return Double.parseDouble(inputTxt.getText());
    } 
     /*
   void setResultTxt(int result) {
      resultTxt.setText(String.valueOf(result)); 
   } 
   */
}