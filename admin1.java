import java.awt.*;
import java.awt.event.*;
class admin extends Frame implements ActionListener{
Button b1;MenuBar mb;Menu m1,m2;MenuItem m11,m12,m13,m14,m21,m22;
admin(){
setLayout(null);
mb = new MenuBar();
setMenuBar(mb);
m1= new Menu("Edit");
m2 = new Menu("Exit");
m11 = new MenuItem("Add");
m12 = new MenuItem("View");
m13 = new MenuItem("Update");
m14 = new MenuItem("Delete");
m21 = new MenuItem("Log Out");
m22 = new MenuItem("Close the window");
m11.addActionListener(this);
m12.addActionListener(this);
m13.addActionListener(this);
m14.addActionListener(this);
m21.addActionListener(this);
m22.addActionListener(this);
mb.add(m1);
mb.add(m2);
m1.add(m11);
m1.add(m12);
m1.add(m13);
m1.add(m14);
m2.add(m21);
m2.add(m22);
mywin w1=new mywin();
addWindowListener(w1);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource()==m11){

aadd a1 = new aadd();
a1.setSize(500,500);
a1.setBackground(Color.pink);
a1.setForeground(Color.black);
a1.setVisible(true);
dispose();
}
else if(ae.getSource()==m12){
aview v1 = new aview();
v1.setSize(500,500);
v1.setBackground(Color.pink);
v1.setForeground(Color.black);
v1.setVisible(true);
dispose();
}
else if(ae.getSource()==m13){
aupdate u1 = new aupdate();
u1.setSize(500,500);
u1.setBackground(Color.pink);
u1.setForeground(Color.black);
u1.setVisible(true);
dispose();
}
else if(ae.getSource()==m14){
adelete d1 = new adelete();
d1.setSize(500,500);
d1.setBackground(Color.pink);
d1.setForeground(Color.black);
d1.setVisible(true);
dispose();
}
else if(ae.getSource()==m21){
alogout l1 = new alogout();
l1.setSize(500,500);
l1.setBackground(Color.pink);
l1.setForeground(Color.black);
l1.setVisible(true);
dispose();
}
else{
dispose();
}
}
class mywin extends WindowAdapter{
public void windowDeactivated(WindowEvent we){
setBackground(Color.gray);
}
public void windowClosing(WindowEvent we){
dispose();
}
}
}