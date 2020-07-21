import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class fr extends Frame implements ActionListener{
Label l1,l2;
TextField t1,t2;
Button b1;
Connection con;Statement st;ResultSet rs;
fr(){
try{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","1999");
st = con.createStatement(); 
}
catch(Exception e){
System.out.println("EXC " + e);
}


setLayout(null);
l1 = new Label("Enter User Name ");
l2 = new Label("Enter Password ");
t1 = new TextField(20);
t2 = new TextField(20);
b1 = new Button("Log In");
l1.setBounds(50,50,150,40);
l2.setBounds(50,150,150,40);
t1.setBounds(250,50,150,40);
t2.setBounds(250,150,150,40);
b1.setBounds(150,350,150,40);
add(l1);
add(l2);
add(t1);
add(t2);
add(b1);
b1.addActionListener(this);
mywin w1=new mywin();
addWindowListener(w1);
}

public void actionPerformed(ActionEvent ae){


try{
rs = st.executeQuery("select * from user");
String s1 = t1.getText();
String s2 = t2.getText();
while(rs.next()){
String s3 = rs.getString("user_name");
String s4 = rs.getString("user_pass");
String s5 = rs.getString("role");

if(s1.equals(s3) && s2.equals(s4)){

if(s5.equals("admin")){
admin pr1 = new admin();
pr1.setSize(500,500);
pr1.setBackground(Color.pink);
pr1.setVisible(true);
dispose();
}

else{
student te1 = new student();
te1.setSize(500,500);
te1.setBackground(Color.pink);
te1.setVisible(true);
dispose();
}


}
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

class welcome{
public static void main(String args[]){
fr f1 = new fr();
f1.setSize(500,500);
f1.setBackground(Color.pink);
f1.setVisible(true);
}
}