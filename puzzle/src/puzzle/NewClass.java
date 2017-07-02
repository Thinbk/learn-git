import java.awt.event.*;  
import java.awt.*;  
import javax.swing.*;  
class newClass extends JFrame {  
JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,sample,starB;  
Icon star;  
  
Icon ic10=new ImageIcon("pic/starB10.jpg");  
Icon ic20=new ImageIcon("pic/starB20.jpg");    

Icon ic1=new ImageIcon("pic/1.jpg");  
Icon ic2=new ImageIcon("pic/5.jpg");  
Icon ic3=new ImageIcon("pic/2.jpg");  
Icon ic4=new ImageIcon("pic/7.jpg");  
Icon ic5=new ImageIcon("pic/4.jpg");  
Icon ic6=new ImageIcon("pic/6.jpg");  
Icon ic7=new ImageIcon("pic/8.jpg");  
Icon ic8=new ImageIcon("pic/9.jpg");  
Icon ic9=new ImageIcon("pic/3.jpg");  
  
Icon ic11=new ImageIcon("pic/12.jpg");  
Icon ic12=new ImageIcon("pic/13.jpg");  
Icon ic13=new ImageIcon("pic/16.jpg");  
Icon ic14=new ImageIcon("pic/11.jpg");  
Icon ic15=new ImageIcon("pic/14.jpg");  
Icon ic16=new ImageIcon("pic/19.jpg");  
Icon ic17=new ImageIcon("pic/17.jpg");  
Icon ic18=new ImageIcon("pic/15.jpg");  
Icon ic19=new ImageIcon("pic/18.jpg");  
  
Icon ic21=new ImageIcon("pic/24.jpg");  
Icon ic22=new ImageIcon("pic/25.jpg");  
Icon ic23=new ImageIcon("pic/21.jpg");  
Icon ic24=new ImageIcon("pic/27.jpg");  
Icon ic25=new ImageIcon("pic/23.jpg");  
Icon ic26=new ImageIcon("pic/29.jpg");  
Icon ic27=new ImageIcon("pic/28.jpg");  
Icon ic28=new ImageIcon("pic/22.jpg");  
Icon ic29=new ImageIcon("pic/26.jpg");  
  
newClass (){  
  
super("pic puzzle");  
  
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

JLabel l2=new JLabel("GAME SEP HINH ");  
l2.setBounds(5,15,500,20);  
 
  
  
add(b1);add(b2);add(b3);add(b4);add(b5);add(b6);add(b7);add(b8);  
add(b9);add(sample);add(l2); 

setLayout(null);  
setSize(600,500);  
setVisible(true);  
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
}  
  
public static void main(String args[]){  
new picpuzzle2();  
}
}