import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.util.*;
import javax.swing.table.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JFrame;

class sview extends JFrame{
JButton b1,b2;
JLabel l1;
JTextField t1;
JPanel panel;
JTableHeader header;
JTable table;
JScrollPane pane;
JScrollPane scrollBar;
Statement st;
ResultSet rs;
Connection con;
sview(){

try{
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","pg1103");
st = con.createStatement();
rs = st.executeQuery("select * from student");

}catch(Exception e){
System.out.println("EXC " + e);
}
setLayout( new FlowLayout() );
l1 = new JLabel("Enter your id: ");
t1 = new JTextField(20);
b1 = new JButton("View Information");
b2 = new JButton("Go Back");

l1.setBounds(50,50,200,40);
t1.setBounds(250,50,200,40);
b1.setBounds(150,500,200,40);

add(l1);
add(t1);
add(b1);
add(b2);

ButtonHandler handler = new ButtonHandler();
b1.addActionListener(handler);
b2.addActionListener(handler);


}

class ButtonHandler implements ActionListener{
public void actionPerformed(ActionEvent ae){
panel = new JPanel();
panel.setLayout(new BorderLayout());
			
panel.setPreferredSize(new Dimension(1500,900));
DefaultTableModel m1=new DefaultTableModel(new String[]{"stud_name","stud_age","stud_pass","stud_fees","stud_id"},0);
table=new JTable(m1);
table.setBackground(Color.decode("#ff8080"));
table.setFont(new Font("Console",Font.BOLD,10));
table.setRowHeight(20);
			
panel.add(table);
header = table.getTableHeader();
header.setBackground(Color.RED);
header.setFont(new Font("Console",Font.BOLD,10));
header.setPreferredSize(new Dimension(60,20));
panel.add(header);
			
pane = new JScrollPane(table);
panel.add(pane);
			
			
			
scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
	add(scrollBar);
			
			
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
			
	this.setUndecorated(true);
		this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

try
{

while(rs.next())
{
String s1 = rs.getString("stud_name");
String s2 = rs.getString("stud_age");
String s3 = rs.getString("stud_pass");
String s4 = rs.getString("stud_fees");
String s5 = rs.getString("stud_id");	
String s6 = t1.getText();			
if(ae.getSource()==b1){			
if(s6.equalsIgnoreCase(s5)){	
m1.addRow(new Object[]{s1,s2,s3,s4,s5});
}
}
else{
student pr1 = new student();
pr1.setSize(500,500);
pr1.setBackground(Color.pink);
pr1.setVisible(true);
dispose();
}
}
con.close();
			
}catch(Exception e){System.out.println("Error"+e);}

table.setModel(m1);

}
}

}


