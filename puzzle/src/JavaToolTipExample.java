import java.awt.*;
import javax.swing.*;

/**
 * A simple Java class to demonstrate rollover help effects
 * with the use of tool tip (tooltip) help text.
 * 
 * Created by Alvin Alexander, devdaily.com
 */
public class JavaToolTipExample
{
  public static void main(String[] args)
  {
    new JavaToolTipExample();
  }
    private PopupMenu button;
    private PopupMenu textfield;
    private PopupMenu label;

  public JavaToolTipExample()
  {
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    // create a label with tooltip help text
    JLabel tooltipLabel = new JLabel("Username");
    tooltipLabel.setToolTipText("Enter your username");
    
    // create a textfield with tooltip help text
    JTextField tooltipTextfield = new JTextField(10);
    tooltipTextfield.setToolTipText("Enter your username over here, that other thing is a label.");
    
    // create a button with tooltip help text
    JButton tooltipButton = new JButton("Click Me");
    tooltipButton.setToolTipText("Click this button to make something happen.");
    
    frame.getContentPane().setLayout(new FlowLayout());
    frame.getContentPane().add(label);
    frame.getContentPane().add(textfield);
    frame.getContentPane().add(button);

    // pack and center it
    frame.pack();
    frame.setLocationRelativeTo(null);

    frame.setVisible(true);
  }

}