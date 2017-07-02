/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btap.giaodien;

/**
 *
 * @author win7
 */
import javax.swing.*;  
  
public class SliderExample1 extends JFrame{  
  
public SliderExample1() {  
JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
JPanel panel=new JPanel();  
panel.add(slider);  
  
add(panel);  
}  
  
public static void main(String s[]) {  
SliderExample1 frame=new SliderExample1();  
frame.pack();  
frame.setVisible(true);  
}  
}  
