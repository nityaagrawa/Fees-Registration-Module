import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class aadd extends Frame implements ActionListener{
Button b1,b2;

Label l1,l2,l3,l4,l5;
TextField t1,t2,t3,t4,t5;
Connection con;Statement st;
aadd(){

try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","1999");
st = con.createStatement(); 
}
catch(Exception e){
System.out.println("EXC " + e);
}

setLayout(null);


l1 = new Label("Enter the name of the student: ");
l2 = new Label("Enter the age of the student: ");
l3 = new Label("Enter the password of the student: ");
l4 = new Label("Fess Paid/Unpaid");
l5 = new Label("Enter the student id");
t1 = new TextField(20);
t2 = new TextField(10);
t3 = new TextField(6);
t4 = new TextField(6);
t5 = new TextField(10);
b1 = new Button("Submit");
b2 = new Button("Go Back");
b1.addActionListener(this);
b2.addActionListener(this);
l1.setBounds(50,50,200,40);
l2.setBounds(50,100,200,40);
l3.setBounds(50,150,200,40);
l4.setBounds(50,200,200,40);
l5.setBounds(50,250,200,40);
t1.setBounds(250,50,150,40);
t2.setBounds(250,100,150,40);
t3.setBounds(250,150,150,40);
t4.setBounds(250,200,150,40);
t5.setBounds(250,250,150,40);
b1.setBounds(150,350,70,40);
b2.setBounds(250,350,70,40);
add(l1);
add(l2);
add(l3);
add(l4);
add(t1);
add(t2);
add(t3);
add(t4);
add(b1);
add(b2);
add(l5);
add(t5);
mywin w1=new mywin();
addWindowListener(w1);
}

public void actionPerformed(ActionEvent ae){
try{

String name = t1.getText();
String age = t2.getText();
String pass  = t3.getText();
String fees = t4.getText();
String id = t5.getText();
if(ae.getSource() == b1){
st.executeUpdate("INSERT INTO student VALUES (' "+name+" ' , ' "+age+" ' , ' "+pass+" ' , ' "+fees+" ','"+id+"')");
st.executeUpdate("INSERT INTO user VALUES (' "+name+" ' , ' "+pass+" ' , ' student ' , ' "+id+" ')");
admin pr1 = new admin();
pr1.setSize(500,500);
pr1.setBackground(Color.pink);
pr1.setVisible(true);
dispose();
}
else{
admin a1 = new admin();
a1.setSize(500,500);
a1.setBackground(Color.pink);
a1.setVisible(true);
dispose();
}

}catch(Exception e){
System.out.println("ECX "+e);
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