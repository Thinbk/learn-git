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
  
public class SliderExample extends JFrame{  
  
public SliderExample() {  
  
JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);  
slider.setMinorTickSpacing(2);  
slider.setMajorTickSpacing(10);  
  
slider.setPaintTicks(true);  
slider.setPaintLabels(true);  
  
JPanel panel=new JPanel();  
panel.add(slider);  
add(panel);  
}  
  
public static void main(String s[]) {  
SliderExample frame=new SliderExample();  
frame.pack();  
frame.setVisible(true);  
  
}  
}  
