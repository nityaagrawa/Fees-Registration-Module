import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.util.*;
import javax.swing.table.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
class aview extends JFrame {


aview(){

JPanel panel = new JPanel();
panel.setLayout(new BorderLayout());
panel.setPreferredSize(new Dimension(1500,900));
DefaultTableModel m1 = new DefaultTableModel(new String[]{"stud_name","stud_age","stud_pass","stud_fees","stud_id"},0);
JTable table = new JTable(m1);
table.setBackground(Color.decode("#ff8080"));
table.setFont(new Font("Console",Font.BOLD,10));
table.setRowHeight(20);
panel.add(table);
JTableHeader header = table.getTableHeader();
header.setBackground(Color.RED);
header.setFont(new Font("Console",Font.BOLD,10));
header.setPreferredSize(new Dimension(60,20));
panel.add(header);
			
JScrollPane pane = new JScrollPane(table);
panel.add(pane);

JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		add(scrollBar);
			
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
			
	this.setUndecorated(true);
		    this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);

try{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/fees","root","1999");
Statement st = con.createStatement(); 
ResultSet rs = st.executeQuery("select * from student");

while(rs.next()){
String s1 = rs.getString("stud_name");
String s2 = rs.getString("stud_age");
String s3 = rs.getString("stud_pass");
String s4 = rs.getString("stud_fees");
String s5 = rs.getString("stud_id");
m1.addRow(new Object[]{s1,s2,s3,s4,s5});
}

con.close();

}
catch(Exception e){
System.out.println("EXC " + e);
}
table.setModel(m1);

}
}