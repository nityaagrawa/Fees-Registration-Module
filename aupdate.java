import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class aupdate extends Frame implements ActionListener{
Button b1,b2,b3;
TextField t1,t2;
Label l1,l2;
Connection con;Statement st;ResultSet rs;
aupdate(){
try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","1999");
st = con.createStatement(); 
}
catch(Exception e){
System.out.println("EXC " + e);
}
setLayout(null);
l1 = new Label("Enter the name of the student");
l2 = new Label("Enter the updated value");
b1 = new Button("Update age");
b2 = new Button("Update fees");
b3 = new Button("Go back to Main Menu");
t1 = new TextField(20);
t2 = new TextField(20);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
l1.setBounds(50,50,200,40);
l2.setBounds(50,200,200,40);
t1.setBounds(250,50,200,40);
t2.setBounds(250,200,200,40);
b1.setBounds(50,300,200,40);
b2.setBounds(50,350,200,40);
b3.setBounds(50,400,200,40);
add(b1);
add(b2);
add(b3);
add(t1);
add(t2);
add(l1);
add(l2);
mywin w1=new mywin();
addWindowListener(w1);
}
public void actionPerformed(ActionEvent ae){
try{

String age = t2.getText();
String fee = t2.getText();
String name = t1.getText();
if(ae.getSource()==b1){
st.executeUpdate("UPDATE student SET stud_age=' "+age+" ' WHERE stud_name=' "+name+" ' ");
admin pr1 = new admin();
pr1.setSize(500,500);
pr1.setBackground(Color.pink);
pr1.setVisible(true);
dispose();
}
else if(ae.getSource()==b2){
st.executeUpdate("UPDATE student SET stud_fees=' "+fee+" ' WHERE stud_name=' "+name+" ' ");

admin pr1 = new admin();
pr1.setSize(500,500);
pr1.setBackground(Color.pink);
pr1.setVisible(true);
dispose();
}
else{
admin pr1 = new admin();
pr1.setSize(500,500);
pr1.setBackground(Color.pink);
pr1.setVisible(true);
dispose();
}
}catch(Exception e){
System.out.println("EXC" + e);
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