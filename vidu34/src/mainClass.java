import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
 
public class mainClass extends JFrame {
    private JLabel lb;
 
    public mainClass() {
        // create JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(2, 1, 5, 5));
 
        // create JLabel
        lb = new JLabel("My JLabel");
        lb.setHorizontalAlignment(JLabel.CENTER);
        add(lb);
 
        // create JButton with text "Click Button"
        JButton btn = new JButton("Click Button");
        // add action
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                changeTextJLabel();
 
            }
        });
        add(btn);
 
        // display JFrame
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
    // change text of lb
    private void changeTextJLabel() {
        lb.setText("You are clicked JButton");
    }
 
    public static void main(String[] args) {
        new mainClass();
    }
}
