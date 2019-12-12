import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class test extends JFrame implements ActionListener
{
   public test()
   {
       JButton okButton = new JButton("OK");
       add(okButton);
   }

   public void actionPerformed(ActionEvent e)
   {
       System.out.println("The OK button is clicked");
   }

   public static void main(String[] args)
   {
       JFrame frame = new test();
       frame.setSize(300, 300);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setVisible(true);
   }
}