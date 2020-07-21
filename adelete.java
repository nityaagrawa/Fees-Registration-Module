import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class adelete extends Frame implements ActionListener{
Button b1,b2;
Label l1;
TextField t1;
Connection con;Statement st;
adelete(){
try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","1999");
st = con.createStatement(); 
}
catch(Exception e){
System.out.println("EXC " + e);
}

setLayout(null);
b1=new Button("Delete");
b2=new Button("Back to main menu");
t1 = new TextField(20);
l1 = new Label("Enter the id of the student");
b1.addActionListener(this);
b2.addActionListener(this);
l1.setBounds(50,50,200,40);
t1.setBounds(250,50,250,40);
b1.setBounds(50,150,250,40);
b2.setBounds(50,250,250,40);
add(b1);
add(b2);
add(l1);
add(t1);
mywin w1=new mywin();
addWindowListener(w1);
}
public void actionPerformed(ActionEvent ae){
try{
String id1 = t1.getText();
String id2 = t1.getText();
if(ae.getSource() == b1){

st.executeUpdate("DELETE FROM student WHERE stud_id = '"+id1+"'");
st.executeUpdate("DELETE FROM user WHERE user_id='"+id2+"'");
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

st.close();
con.close();
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