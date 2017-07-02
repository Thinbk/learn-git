import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GoiY  {
 
     GoiY(){
        
        JFrame f= new JFrame(); 
        JTextArea area=new JTextArea("");
        
        area.setBounds(10,30, 200,200);  
        f.add(area);
        
        f.setSize(300,300);  
        f.setLayout(null); 
        f.setVisible(true);
     }  
public static void main(String [] args){
    new GoiY();
}
}
