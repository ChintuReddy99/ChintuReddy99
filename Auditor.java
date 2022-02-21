import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;


public class Auditor extends JFrame implements ActionListener
{

	JPanel p1;
	JLabel cs1;
	ImageIcon c1;
	JButton b1;
	JTable table;
	int v,h;
	String s,d,call,dt;
	JScrollPane pane,pane2;	
	Vector heading,data;
	
	Auditor()
	{
		p1=new JPanel();
		p1.setLayout(null);
		setTitle("Auditor::Attacking and Protecting Data Privacy in Edge Cloud Collaborative Inference Systems");
	
		
	
		cs1=new JLabel();
		cs1.setIcon(c1);
		cs1.setBounds(0,0,900,600);
		
		b1=new JButton("View Auditing Details");
		b1.setBounds(350,500,200,30);
		b1.addActionListener(this);
		
		ImageIcon im1 = new ImageIcon(this.getClass().getResource("images/TPABack.png"));
		JLabel imageLabel1 = new JLabel();
		 imageLabel1.setIcon(im1);
		 imageLabel1.setBounds(0, 0, 875, 475);
		
		
		p1.add(cs1);p1.add(b1);p1.add(imageLabel1);
		p1.setBackground(Color.RED);
		add(p1);
		setSize(900,600);
		setVisible(true);
		
		int[] ports = new int[]
			              		{ 6000};

			              		for (int i = 0; i < 1; i++)
			              		{
			              			Thread t = new Thread(new PortListener(ports[i]));
			              			t.setName("Listener-" + ports[i]);
			              			t.start();

			              		}
	}
	
	public void actionPerformed(ActionEvent a1)
	{
		if(a1.getSource()==b1)
		{
			try
			{
			DBCon db=new DBCon();
			Connection connect=db.getConnection();
            Statement stmt = connect.createStatement();
            
            
            String query = "SELECT * FROM TPA";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsm=rs.getMetaData();
            int col=rsm.getColumnCount();

            heading = new Vector();
            heading.addElement("CS Name");
   		 	heading.addElement("Audit Result");
   		 	heading.addElement("Reason");
   		 	heading.addElement("File Name");
   		 	heading.addElement("Packet Name");
   		 	heading.addElement("Date&Time");
   		    data=new Vector();
            
            while(rs.next())
            {
        	   Vector row = new Vector();
        	   for(int i = 1; i <=col; i++)
        	   {
               row.addElement(rs.getObject(i));

        	   }

        	   data.addElement(row);
            }
		  
           table = new JTable(data,heading);
		
           pane = new JScrollPane(table);
		 
          pane.setBounds(130,150,600,200);
          p1.add(pane);
		
			} catch(Exception ex) {ex.printStackTrace();}
		}
		
		}
	
	
	class PortListener implements Runnable
	{

		BufferedOutputStream bos = null;
		ServerSocket ss1, ss2;
		Socket s1, s2;
		ServerSocket server, server1,server2,server3;
		Socket connection, so;
		BufferedReader br = null;
		int port;

		public PortListener(int port)
		{
			this.port = port;
		}

		public void run()
		{
			Connection connect;
			

			 if(this.port==6000)
					
				{
					
					DBCon db=new DBCon();
					Connection c1=db.getConnection();
					
					try
					{
						
						ServerSocket server1 = new ServerSocket(6000);
		                Socket con;
						while (true) 
						{
							con = server1.accept();
							DataInputStream dis = new DataInputStream(con.getInputStream());
							
							String cname= dis.readUTF();
							String Ar= dis.readUTF();
							String Reason= dis.readUTF();
							String fname= dis.readUTF();
							String pname = dis.readUTF();
							
							
							 SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy");
			       		      SimpleDateFormat sdfTime = new SimpleDateFormat("HH:mm:ss");
			       		      					    
			       		      	 Date now = new Date();
			       		      					    
			       		              String strDate = sdfDate.format(now);
			       		      	String strTime = sdfTime.format(now);

			       		             String dt=strDate+"   "+strTime;
							
								Statement stmt = c1.createStatement();
								String query = "insert into TPA values('" + cname + "','" + Ar+ "','" + Reason+ "','" + fname+ "','"+pname+"','"+dt+"')";
								stmt.executeUpdate(query);
								
					
							
						}	
							
						}
						catch(Exception e){System.out.println(e);}
					
					
					
				
					
				}
		}
	}

	
	public static void main(String[] args) 
	{
		new Auditor();
	}

	
	
}
