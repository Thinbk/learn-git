import java.awt.*;
import java.awt.event.*;

class evttest extends Frame 
{
Label label1=new Label("This is just a label");
TextField tf1=new TextField(30);
TextArea ta1=new TextArea();
Button b1 = new Button("My Button");
Checkbox c1=new Checkbox("CheckBox",true); 

CheckboxGroup cb=new CheckboxGroup(); 
Checkbox c2=new Checkbox("Radio 1",cb,true); 
Checkbox c3=new Checkbox("Radio 2",cb,false); 
Checkbox c4=new Checkbox("Radio 3",cb,false); 
Choice ch =new Choice(); 

public evttest(String title)
{
super(title);
setLayout(new FlowLayout()); 
add(label1);
add(tf1);
add(ta1); 
add(b1); 
add(c1);
add(c2);
add(c3);
add(c4);

ch.addItem("White"); 
ch.addItem("Red"); 
ch.addItem("Orange"); 
ch.addItem("Green"); 
add(ch);


}
public static void main(String args[])
{



}
}