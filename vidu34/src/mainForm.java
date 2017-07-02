import java.awt.Component; 
import java.awt.FlowLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent; 

import javax.swing.JButton; 
import javax.swing.JFrame; 
import javax.swing.JLabel; 

public class mainForm extends JFrame implements ActionListener{ 

    private JButton button; // nút button cần click 
     
    private subForm form; 
     
    public mainForm(){ 
        super("Main Form"); 
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); 
        this.addWindowListener(new WindowAdapter(){ 
            public void windowClosing(WindowEvent e){ 
                System.exit(0); 
            } 
        }); 
        //tạo button 
        button = new JButton("Click Me"); 
        // add sự kiện vào 
        button.addActionListener(this); 
         
        setLayout(new FlowLayout(FlowLayout.CENTER)); 
        add(new JLabel("Đây là Form chính của bạn.")); 
        add(button); 
         
        form = new subForm(); 
         
        setSize(200, 100); 
        setVisible(true); 
    } 
     
    // sự kiện cho nút Button cần click 
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==button){ 
            form.setVisible(true); 
        } 
    } 
    //hàm main 
    public static void main(String[] args) { 
        new mainForm(); 
    } 
} 
