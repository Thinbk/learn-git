import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class JButtonAction extends JFrame implements ActionListener {
    private JButton btnGreen;
    private JLabel lb;
 
    public JButtonAction() {
        // create JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 300);
        setLayout(new GridLayout(3, 1, 5, 5));
 
        // add JFrame content
        lb = new JLabel("Background default");
        lb.setOpaque(true);
        add(lb);
 
        btnGreen = createJButton("Green");
        add(btnGreen);
        add(createJButton("Blue"));
 
        // display JFrame
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    // create JButton with text is title
    private JButton createJButton(String title) {
        JButton btn = new JButton(title);
        // add action for JButton
        btn.addActionListener(this);
        return btn;
    }
 
    // change text and background of JLabel when click button
    private void changeBackgroundJLabel(Color bgcolor, String nameBgcolor) {
        lb.setBackground(bgcolor);
        lb.setText("Background is " + nameBgcolor);
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        // click button green
        if (e.getSource() == btnGreen) {
            changeBackgroundJLabel(Color.green, "Green");
        }
        // click button blue
        if (e.getActionCommand() == "Blue") {
            changeBackgroundJLabel(Color.blue, "Blue");
        }
    }
 
    public static void main(String[] args) {
        new JButtonAction();
    }
}