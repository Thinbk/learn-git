/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btap.giaodien;

import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author win7
 */
public class vd1 {
    
  JFrame f;  
vd1(){  
    f=new JFrame();  
      
    String data[][]={ {"101","Amit","670000"},  
              {"102","Jai","780000"},  
                          {"101","Sachin","700000"}};  
    String column[]={"ID","NAME","SALARY"};  
      
    JTable jt=new JTable(data,column);  
    jt.setBounds(30,40,200,300);  
      
    JScrollPane sp=new JScrollPane(jt);  
    f.add(sp);  
  
    f.setSize(300,400);  
//  f.setLayout(null);  
    f.setVisible(true);  
}  
public static void main(String[] args) {  
    new vd1();  
}  
}  