/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btap.giaodien;
import java.awt.Color;  
import javax.swing.*;  
/**
 *
 * @author win7
 */
public class TArea {
    
JTextArea area;  
    JFrame f;  
    TArea(){  
    f=new JFrame();  
          
    area=new JTextArea(300,300);  
    area.setBounds(10,30,300,300);  
      
    area.setBackground(Color.green);  
    area.setForeground(Color.white);  
          
    f.add(area);  
      
    f.setSize(400,400);  
    f.setLayout(null);  
    f.setVisible(true);  
}  
    public static void main(String[] args) {  
        new TArea();  
    }  
}  
