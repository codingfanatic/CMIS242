//NiceFrame.java
import javax.swing.*;
public class test extends JFrame { 
   static final int WIDTH = 300, HEIGHT = 300;
   public test() {
      super("Nice Frame"); 
      setFrame(WIDTH, HEIGHT);
   }	
   public test(String title) {
      super(title);  
      setFrame(WIDTH, HEIGHT);
   }
   public test(String title, int width, int height) {
      super(title);        				
      setFrame(width, height);
   }
   public void display() {
      setVisible(true);
   }
   private void setFrame(int width, int height) {
      setSize(width, height);     
      setLocationRelativeTo(null);  		
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
   }

} 
