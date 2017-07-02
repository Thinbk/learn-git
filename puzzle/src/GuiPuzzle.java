import java.awt.*;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class GuiPuzzle extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6,b7,b8,b9;
    JButton tron;
    JButton ok;
    JButton anhgoc;
    JRadioButton tt1, tt2, tt3;
    
    Icon icgoc =new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\main.jpg"); 
    Icon ic1 = new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\1.jpg");
    Icon ic2 = new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\2.jpg");
    Icon ic3 = new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\3.jpg");
    Icon ic4 = new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\4.jpg");
    Icon ic5 = new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\5.jpg");
    Icon ic6 = new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\6.jpg");
    Icon ic7 = new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\7.jpg");
    Icon ic8 = new ImageIcon("D:\\source netbean\\puzzle\\src\\puzzle\\pic\\8.jpg");
    Icon ic9 = new ImageIcon("");
          
GuiPuzzle(){
    super("GuiPuzzle");

    b1=new JButton(ic1);  
    b1.setBounds(10,80,100,100);  
    b2=new JButton(ic2);  
    b2.setBounds(110,80,100,100);  
    b3=new JButton(ic3);  
    b3.setBounds(210,80,100,100);  
    b4=new JButton(ic4);  
    b4.setBounds(10,180,100,100);  
    b5=new JButton(ic5);  
    b5.setBounds(110,180,100,100);  
    b6=new JButton(ic6);  
    b6.setBounds(210,180,100,100);  
    b7=new JButton(ic7);  
    b7.setBounds(10,280,100,100);  
    b8=new JButton(ic8);  
    b8.setBounds(110,280,100,100);  
    b9=new JButton(ic9);  
    b9.setBounds(210,280,100,100);
    anhgoc = new JButton(icgoc);
    anhgoc.setBounds(380,230,150,150);
    
    tron=new JButton(" TRỘN ");
    tron.setBounds(200,400 ,100, 40);
    
    JLabel l2=new JLabel("ARE YOU READY !!! ");  
    l2.setBounds(35,15,500,20); 
    
    // goi ý 
    JLabel l1=new JLabel("Gợi ý :");  
    l1.setBounds(350,100,50,20); 
    tt1=new JRadioButton("Thuât toán A* ");    
    tt1.setBounds(400,80,200,30);      
    tt2=new JRadioButton("Thuật toán BFS ");    
    tt2.setBounds(400,100,200,30); 
    tt3=new JRadioButton("Thuât toán tham lam ");    
    tt3.setBounds(400,120,200,30);
    ok = new JButton("OK");
    ok.setBounds(400, 150,70,20);
    
      
// add button, LABEL in frame 
    add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);add(b9);add(tron);
    add(anhgoc);
    add(ok);
    add(l1);add(l2);
    add(tt1);add(tt2);add(tt3);
    
    b1.addActionListener(this);  
    b2.addActionListener(this);  
    b3.addActionListener(this);  
    b4.addActionListener(this);  
    b5.addActionListener(this);  
    b6.addActionListener(this);  
    b7.addActionListener(this);  
    b8.addActionListener(this);  
    b9.addActionListener(this);
    ok.addActionListener(this);
    tron.addActionListener(this);
    
    tron.setBackground(Color.red); 
    ok.setBackground(Color.yellow);
    
    setLayout(null);  
    setSize(600,500);  
    setVisible(true);  
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}
    public static void main(String[] args) {
        new GuiPuzzle();
    }
}