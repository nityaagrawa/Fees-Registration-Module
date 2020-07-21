import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class schange extends Frame implements ActionListener{
Button b1,b2;
TextField t1,t2,t3;
Label l1,l2,l3;
Connection con;Statement st;ResultSet rs;
schange(){
try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","1999");
st = con.createStatement(); 
}
catch(Exception e){
System.out.println("EXC " + e);
}
setLayout(null);
l1=new Label("Enter name");
l2=new Label("Enter new password");
l3=new Label("Re-enter password");
b1 = new Button("Change the password");
b2 = new Button("Go Back to Main Menu");
t1 = new TextField(20);
t2 = new TextField(20);
t3 = new TextField(20);
b1.addActionListener(this);
b2.addActionListener(this);
l1.setBounds(50,50,200,40);
l2.setBounds(50,100,200,40);
l3.setBounds(50,150,200,40);
t1.setBounds(250,50,200,40);
t2.setBounds(250,100,200,40);
t3.setBounds(250,150,200,40);
b1.setBounds(50,300,200,40);
b2.setBounds(50,350,200,40);
add(b1);
add(b2);
add(t1);
add(t2);
add(l1);
add(l2);
add(l3);
add(t3);
mywin w1=new mywin();
addWindowListener(w1);
}
public void actionPerformed(ActionEvent ae){
try{
String gid = t1.getText();
String po = t2.getText();
String pnew = t3.getText();
if(ae.getSource()==b1){
if(po.equals(pnew)){
st.executeUpdate("UPDATE student SET stud_pass=' "+pnew+" ' WHERE stud_name=' "+gid+" ' ");
st.executeUpdate("UPDATE user SET user_pass='"+pnew+"' WHERE user_name='"+gid+"'");
student pr1 = new student();
pr1.setSize(500,500);
pr1.setBackground(Color.pink);
pr1.setVisible(true);
dispose();
}
}
else{
student pr1 = new student();
pr1.setSize(500,500);
pr1.setBackground(Color.pink);
pr1.setVisible(true);
dispose();
}

}catch(Exception e){
System.out.println("EXC"+e);
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