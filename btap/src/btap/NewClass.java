package btap;

import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

public class NewClass {
    public static void main(String[] args) {
        //cretae jframe 
   JFrame frame = new JFrame("JFrame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(20,30,200,200);

    // Add a close button
    JButton closeButton = new JButton("Close");
    Container contentPane = frame.getContentPane();
    contentPane.add(closeButton);

    // Calculates and sets appropriate size for the frame
    frame.pack();

    frame.setVisible(true);
  }
}