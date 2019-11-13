//SimpleCalculatorApplication.java
import java.awt.*;

public class testSimpleCalcApp extends test {
   
   public testSimpleCalcApp() {
      super("Simple Calculator Application", 320, 120);
      add(new testSimpleCalcPanel()); 
   }
   static public void main(String[] args) {
      testSimpleCalcApp scApp = 
         new testSimpleCalcApp();
      scApp.display();
   }
}
