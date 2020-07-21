import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class UpdateBook extends JFrame implements ActionListener
{
	JButton b1,b2,b3,b4,b5;
	String str1,str2,str3,str4,str5,str6,str7,str8,stext,strs;
	String str11,str12,str13,str14,str15,str16,str17,str18;
	String stemp1,stemp2,stemp3,stemp4,stemp5;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
	// Connection con;
	// Statement st;ResultSet rs;
	JLabel lt1,ta;
	JTextField tt1;
	UpdateBook()
	{
		this.setLayout(null);
		
		Font font1=new Font("ARIAL",Font.BOLD,20);
										setFont(font1);

										MenuBar mBar = new MenuBar();
									    setMenuBar(mBar);   // add menu bar to frame
									                                // create menus
									    Menu files = new Menu("Files");
									    Menu date = new Menu("Date");
									    Menu exit = new Menu("Exit");
									                                 // add menus to menu bar
									    mBar.add(files);
									    mBar.add(date);
									    mBar.add(exit);
									                             // create menu items to menus
									    date.add(new MenuItem("Today"));
									    exit.add(new MenuItem("Close"));
									                               // linking listener
									    files.addActionListener(this);
									    date.addActionListener(this);
									    exit.addActionListener(this);




		ta=new JLabel();
   		ta.setBounds(25,5,500,100);
   		ta.setFont (ta.getFont ().deriveFont (20.0f));
   		ta.setForeground(Color.yellow);
    	add(ta);
		lt1=new JLabel("Enter Serial Number");
		lt1.setBounds(100,100,400,60);
		lt1.setFont (lt1.getFont ().deriveFont (25.0f));
		lt1.setForeground(Color.yellow);
		add(lt1);
		tt1=new JTextField();
		tt1.setBounds(550,100,150,60);
		tt1.setFont (tt1.getFont ().deriveFont (25.0f));
		add(tt1);
		
		b1=new JButton("Search");
		b1.setBounds(750,100,150,50);
		b1.setFont (b1.getFont ().deriveFont (25.0f));
		b1.setForeground(Color.red);
		add(b1);
		b1.addActionListener(this);

		b2=new JButton("Confirm Booking");
		b2.setBounds(100,700,250,40);
		b2.setFont (b2.getFont ().deriveFont (25.0f));
		b2.setForeground(Color.red);
		add(b2);
		b2.addActionListener(this);

		b3=new JButton("Cancel");
		b3.setBounds(400,700,250,40);
		b3.setFont (b3.getFont ().deriveFont (25.0f));
		b3.setForeground(Color.red);
		add(b3);
		b3.addActionListener(this);

		b4=new JButton("Exit");
		b4.setBounds(700,700,250,40);
		b4.setFont (b4.getFont ().deriveFont (25.0f));
		b4.setForeground(Color.red);
		add(b4);
		b4.addActionListener(this);



		wadapt w1=new wadapt();
		addWindowListener(w1);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
					Statement st=con.createStatement();
					
					ResultSet rs=st.executeQuery("SELECT * FROM guest_details" );
					stext=tt1.getText();

						while(rs.next())
						{
							strs=rs.getString("serial_number");
							str1=rs.getString("first_name");
							str2=rs.getString("last_name");
							str3=rs.getString("phone");
							str4=rs.getString("email");
							stemp1=rs.getString("arrival_date");
							stemp2=rs.getString("departure_date");
							stemp3=rs.getString("adults");
							stemp4=rs.getString("children");
							if(stext.equals(strs))
							{
									break;
							}	
						}
						
					 rs=st.executeQuery("SELECT * FROM roomdetails");
						while(rs.next())
						{
							strs=rs.getString("serial_number");
							str5=rs.getString("rooms");
							str6=rs.getString("payment");
							str7=rs.getString("id_proof");
							str8=rs.getString("total_charges");
							stemp5=rs.getString("days");
							if(stext.equals(strs))
							{
									break;
							}	
						}
						
						
					
				}
					catch(Exception e)
					{	
						System.out.println("EXE" +" "+e);
					}


				l1=new JLabel("First Name:");
				l1.setBounds(150,200,200,40);
				l1.setFont (l1.getFont ().deriveFont (25.0f));
				l1.setForeground(Color.yellow);
				add(l1);

				t1=new JTextField(str1);
				
				t1.setBounds(450,200,250,40);
				t1.setFont (t1.getFont ().deriveFont (25.0f));
				add(t1);

				l2=new JLabel("Last Name:");
				l2.setBounds(150,260,200,40);
				l2.setFont (l2.getFont ().deriveFont (25.0f));
				l2.setForeground(Color.yellow);
				add(l2);

				t2=new JTextField(str2);
				
				t2.setBounds(450,260,250,40);
				t2.setFont (t2.getFont ().deriveFont (25.0f));
				add(t2);

				l3=new JLabel("Phone Number:");
				l3.setBounds(150,320,200,40);
				l3.setFont (l3.getFont ().deriveFont (25.0f));
				l3.setForeground(Color.yellow);
				add(l3);

				t3=new JTextField(str3);
				
				t3.setBounds(450,320,250,40);
				t3.setFont (t3.getFont ().deriveFont (25.0f));
				add(t3);


				l4=new JLabel("E-Mail:");
				l4.setBounds(150,380,200,40);
				l4.setFont (l4.getFont ().deriveFont (25.0f));
				l4.setForeground(Color.yellow);
				add(l4);

				t4=new JTextField(str4);
				
				t4.setBounds(450,380,250,40);
				t4.setFont (t4.getFont ().deriveFont (25.0f));
				add(t4);


				l5=new JLabel("Rooms:");
				l5.setBounds(150,440,200,40);
				l5.setFont (l5.getFont ().deriveFont (25.0f));
				l5.setForeground(Color.yellow);
				add(l5);

				t5=new JTextField(str5);
				
				t5.setBounds(450,440,250,40);
				t5.setFont (t5.getFont ().deriveFont (25.0f));
				add(t5);	

				l6=new JLabel("Identification proof:");
				l6.setBounds(150,500,250,40);
				l6.setFont (l6.getFont ().deriveFont (25.0f));
				l6.setForeground(Color.yellow);
				add(l6);

				t6=new JTextField(str7);
				
				t6.setBounds(450,500,250,40);
				t6.setFont (t6.getFont ().deriveFont (25.0f));
				add(t6);	

				
				l7=new JLabel("Payment Options:");
				l7.setBounds(150,560,250,40);
				l7.setFont (l7.getFont ().deriveFont (25.0f));
				l7.setForeground(Color.yellow);
				add(l7);

				t7=new JTextField(str6);
			
				t7.setBounds(450,560,250,40);
				t7.setFont (t7.getFont ().deriveFont (25.0f));
				add(t7);	



				l8=new JLabel("Total Charges:");
				l8.setBounds(150,620,200,40);
				l8.setFont (l8.getFont ().deriveFont (25.0f));
				l8.setForeground(Color.yellow);
				add(l8);
				
				t8=new JTextField(str8);
				
				t8.setBounds(450,620,250,40);
				t8.setFont (t8.getFont ().deriveFont (25.0f));
				add(t8);	

				

		}
		if(ae.getSource()==b2)
		{

			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
				Statement st=con.createStatement();
				//ResultSet rs=st.executeQuery("SELECT * FROM guest_details where serial_number ='1' " );

				stext=tt1.getText();
				st.executeUpdate("DELETE FROM guest_details WHERE serial_number='"+stext+"' ");
				st.executeUpdate("DELETE FROM roomdetails WHERE serial_number='"+stext+"' ");
			}
			catch(Exception e)
			{System.out.println("EXE"+e);}


			try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel","root","root");
					Statement st=con.createStatement();
					
					str11=t1.getText();
					str12=t2.getText();
					str13=t3.getText();
					str14=t4.getText();
					str15=t5.getText();
					str16=t6.getText();
					str17=t7.getText();
					str18=t8.getText();
					
					st.executeUpdate("Insert into guest_details  (serial_number,first_name,last_name,phone,email,arrival_date,departure_date,adults,children) values ('"+stext+"','"+str11+"','"+str12+"','"+str13+"','"+str14+"','"+stemp1+"','"+stemp2+"','"+stemp3+"','"+stemp4+"')");
					
					st.executeUpdate("Insert into roomdetails  (serial_number,rooms,days,id_proof,payment,total_charges) values ('"+stext+"','"+str15+"','"+stemp5+"','"+str16+"','"+str17+"','"+str18+"')");
										
				}
				catch(Exception e)
				{	
					System.out.println("EXE" +" "+e);
				}

			Bookstep5 f1=new Bookstep5();
			Color c1=new Color(0,76,153);
			f1.getContentPane().setBackground(c1);
			f1.setVisible(true);
			f1.setTitle("Thanks");
			f1.setSize(950,950);
			f1.setBackground(Color.pink);
		}
		if(ae.getSource()==b3)
			dispose();
		if(ae.getSource()==b4)
		{
			System.exit(0);
		}

			String str = ae.getActionCommand();
    if(str.equals("Close"))
      System.exit(0);
    else if(str.equals("Today"))
      ta.setText("Today: " + new java.util.Date());
		
	}
	class wadapt extends WindowAdapter
	{
		public void windowClosing(WindowEvent we)
		{
			dispose();
		}
		public void windowDeactivated(WindowEvent we)
		{
			setBackground(Color.orange);
		}
		public void windowActivated(WindowEvent we)
		{
			setBackground(Color.pink);
		}
	}
}