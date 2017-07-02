import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JTextFieldTooltipExample{
  public static void main(String args[]) {
    JFrame frame = new JFrame("Tool Tips");
    Container contentPane = frame.getContentPane();
    JButton b = new JButton("Button");
    b.setToolTipText("Go Away");
    contentPane.add(b, BorderLayout.NORTH);
    frame.setSize(300, 200);
    frame.show();
  }
}
 