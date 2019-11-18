//TestInputPanel.java
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class TestInputPanel extends JPanel { 
   private TestPanel tPanel;
   private JTextField inputTxt = new JTextField(20);
   
   public TestInputPanel (TestPanel tPanel) {
      this.tPanel = tPanel;
      //setLayout(new FlowLayout(FlowLayout.CENTER));
      inputTxt.addKeyListener(new KeyAdapter() {
         @Override
         public void keyPressed(KeyEvent e) {
             char keyAsciiValue = e.getKeyChar();
             if(keyAsciiValue >= (int)'0' && keyAsciiValue <= (int)'9' || keyAsciiValue == 8){
                 inputTxt.setEditable(true);
             }
             else{
                 inputTxt.setEditable(false);
             }
         }
      });
      add(inputTxt);
   }			

   double getInput() {
       return Double.parseDouble(inputTxt.getText());
    } 

   void resetText(){
      inputTxt.setText("");
   }
     /*
   void setResultTxt(int result) {
      resultTxt.setText(String.valueOf(result)); 
   } 
   */
}