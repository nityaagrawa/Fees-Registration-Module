import java.awt.*;
import java.awt.event.*;
class student extends Frame implements ActionListener{
MenuBar mb;Menu m1,m2;MenuItem m11,m12,m13,m14,m21,m22;
student(){
setLayout(null);
mb = new MenuBar();
setMenuBar(mb);
m1 = new Menu("Menu");
m2 = new Menu("Exit");

m11 = new MenuItem("View");
m12 = new MenuItem("Delete");
m13 = new MenuItem("Change Password");
m21 = new MenuItem("Log Out");
m22 = new MenuItem("Close the window");
m11.addActionListener(this);
m12.addActionListener(this);
m13.addActionListener(this);
m21.addActionListener(this);
m22.addActionListener(this);
mb.add(m1);
mb.add(m2);
m1.add(m11);
m1.add(m12);
m1.add(m13);
m2.add(m21);
m2.add(m22);
mywin w1 = new mywin();
addWindowListener(w1);
}
public void actionPerformed(ActionEvent ae){
if(ae.getSource() == m11){
sview sv1 = new sview();
sv1.createUI();
sv1.setSize(500,500);
sv1.setBackground(Color.pink);
sv1.setForeground(Color.black);
sv1.setVisible(true);
dispose();
}
else if(ae.getSource() == m12){
adelete sd1 = new adelete();
sd1.setSize(500,500);
sd1.setBackground(Color.pink);
sd1.setForeground(Color.black);
sd1.setVisible(true);
dispose();
}
else if(ae.getSource() == m13){
schange sc1 = new schange();
sc1.setSize(500,500);
sc1.setBackground(Color.pink);
sc1.setForeground(Color.black);
sc1.setVisible(true);
dispose();
}
else if(ae.getSource() == m21){
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