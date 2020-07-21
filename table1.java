import java.sql.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.JScrollPane;
import java.util.*;
import javax.swing.table.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



class table1 extends JFrame
{
		table1()
		{	
			JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			
			panel.setPreferredSize(new Dimension(1500,900));
			
			DefaultTableModel m1=new DefaultTableModel(new String[]{"room_no","type"},0);
			JTable table=new JTable(m1);
			table.setBackground(Color.decode("#ff8080"));
			table.setFont(new Font("Console",Font.BOLD,20));
			table.setRowHeight(50);
			
			panel.add(table);
			JTableHeader header = table.getTableHeader();
			header.setBackground(Color.RED);
			header.setFont(new Font("Console",Font.BOLD,18));
			header.setPreferredSize(new Dimension(130,50));
			panel.add(header);
			
			JScrollPane pane = new JScrollPane(table);
			panel.add(pane);
			
			
			
		JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		add(scrollBar);
			
			
			table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
			
	this.setUndecorated(true);
		    this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
					
			
			
		
			try
			{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","pg1103");
			
			Statement st = con.createStatement();
	
			
			ResultSet rs = st.executeQuery("select * from room1");
		
			
			while(rs.next())
			{
				String s1 = rs.getString("room_no");
				String s2 = rs.getString("type");
				
				
				m1.addRow(new Object[]{s1,s2});
				
			}
			
			con.close();
			
		}catch(Exception e){System.out.println("Error"+e);}

		table.setModel(m1);
	}
}








