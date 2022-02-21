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


public class Cloudserver1 extends JFrame implements ActionListener
{

	JPanel p1;
	JLabel cs1;
	ImageIcon c1;
	
	JButton b1,b2,b3;
	

	JTable table;
	int v,h;
	String s,d,call,dt;
	JScrollPane pane,pane2;
	JTextArea t1;
	
	Vector heading,data;
	
	Cloudserver1()
	{
		p1=new JPanel();
		p1.setLayout(null);
		setTitle("CloudServer1:Attacking and Protecting Data Privacy in Edge Cloud Collaborative Inference Systems");
	
		
	
		cs1=new JLabel();
		cs1.setIcon(c1);
		cs1.setBounds(0,0,900,600);
		
		b1=new JButton("View All Files");
		b1.setBounds(150,400,150,30);
		b1.addActionListener(this);
		
		b2=new JButton("Attack File");
		b2.setBounds(320,400,150,30);
		b2.addActionListener(this);
		
		b3=new JButton("Delete File");
		b3.setBounds(490,400,150,30);
		b3.addActionListener(this);
		
		t1=new JTextArea();
		pane2=new JScrollPane();
		pane2.setViewportView(t1);
		t1.setRows(150);
		t1.setColumns(150);
		pane2.setBounds(620,130,230,190);
		p1.add(pane2);
		
		ImageIcon im1 = new ImageIcon(this.getClass().getResource("images/CS1Back.png"));
		JLabel imageLabel1 = new JLabel();
		 imageLabel1.setIcon(im1);
		 imageLabel1.setBounds(0, 0, 900, 500);
		
		p1.add(cs1);p1.add(b1);p1.add(b2);
		p1.add(b3);p1.add(imageLabel1);
		add(p1);
		setSize(920,520);
		setVisible(true);
		
		int[] ports = new int[]
			              		{ 2222,5551,7722,8822,2201,3637};

			              		for (int i = 0; i < 6; i++)
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
            
            
            String query = "SELECT * FROM CS1";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsm=rs.getMetaData();
            int col=rsm.getColumnCount();

            heading = new Vector();
   		 
   		 heading.addElement("File Name");
   		 heading.addElement("Public Key");
   		 heading.addElement("Private Key");
   		 heading.addElement("Secret Key");
   		 heading.addElement("B1-MAC");
   		 
   		 
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
		 
          pane.setBounds(10,130,600,200);
          p1.add(pane);
		
			} catch(Exception ex) {ex.printStackTrace();}
		}
		
		if(a1.getSource()==b2)
		{
			
			String fname=JOptionPane.showInputDialog(null,"Enter the File Name to be Modified");
			try
			{
				DBCon db=new DBCon();
				Connection connect=db.getConnection();
	            Statement stmt = connect.createStatement();
				
				String mdata=t1.getText();
				System.out.println("Malacious Data-->" +mdata);
				
				
				FileInputStream fis1 = new FileInputStream("CS1\\"+"temp\\"+fname+"1"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
				byte bs1[] = new byte[fis1.available()];
				fis1.read(bs1);
				String file1= new String(bs1);
				
				  
				  StringBuffer d1=new StringBuffer(file1);
				  StringBuffer file2=d1.append(mdata);
				  
				  String data=file2.toString();
				  
				  System.out.println("MODIFIED fILE " +data);
				  
				  
				  PrintStream out1 = null;
					try {
					    out1 = new PrintStream(new FileOutputStream("CS1\\"+"temp\\"+fname+"1"+".txt"));
					    out1.print(data);
					   
					}
					finally {
					    if (out1 != null) out1.close();
					}
				
				
				MessageDigest md = MessageDigest.getInstance("SHA1");
				FileInputStream fis44 = new FileInputStream("CS1\\"+"temp\\"+fname+"1"+".txt");
				DigestInputStream dis4 = new DigestInputStream(fis1, md);
				BufferedInputStream bis4 = new BufferedInputStream(dis4);
	 
				//Read the bis so SHA1 is auto calculated at dis
				while (true) {
					int b4 = bis4.read();
					if (b4 == -1)
						break;
				}
	 
				BigInteger bi4 = new BigInteger(md.digest());
				String	 h4 = bi4.toString(16);
				System.out.println(" Mac address Generated " +h4);
				
				String s1="update CS1 set hash1='"+h4+"' where FName='"+fname+"'";
				stmt.executeUpdate(s1);
				
				System.out.println("Data Modified");
				
				
				Socket Update=new Socket("localhost",9797);   //Enter trustee Ip address here
				DataOutputStream dos22=new DataOutputStream (Update.getOutputStream());
				dos22.writeUTF("CS1");
				dos22.writeUTF("Failure");
				dos22.writeUTF("Modified");
				dos22.writeUTF(fname);
				
				
				DataInputStream dis22=new DataInputStream(Update.getInputStream());
				String msg=dis22.readUTF();
				
				
				
				
				
			
			}catch(Exception es){System.out.println(es);}
		}
		
		
		if(a1.getSource()==b3)
		{
			String fname=JOptionPane.showInputDialog(null,"Enter The File Name to be Deleted");
			DBCon db=new DBCon();
			Connection c2=db.getConnection();
			try
			{
				new File("CS1\\temp\\"+fname+"1"+".txt").delete();
				
				Statement st=c2.createStatement();
				String s1="delete * from  CS1 where FName='"+fname+"'";
				st.executeUpdate(s1);
				
				Socket Update=new Socket("localhost",9797);   //Enter trustee Ip address here
				DataOutputStream dos22=new DataOutputStream (Update.getOutputStream());
				dos22.writeUTF("CS1");
				dos22.writeUTF("Failure");
				dos22.writeUTF("Deleted");
				dos22.writeUTF(fname);
				
				DataInputStream dis22=new DataInputStream(Update.getInputStream());
				String msg=dis22.readUTF();
				
				
				
				
				
			}catch(Exception es){System.out.println(es);}
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
			
			if(this.port==5551)
			{
				
				DBCon db=new DBCon();
				Connection c10=db.getConnection();
				try
				{
					
					ServerSocket server1 = new ServerSocket(5551);
	                Socket con;
	                DBCon d1=new DBCon();
	                Connection c1=d1.getConnection();
					while (true) 
					{
						con = server1.accept();
						DataInputStream dis = new DataInputStream(con.getInputStream());
						
						String fn= dis.readUTF();
						String mac= dis.readUTF();
						
						String s1="select * from CS1 where FName='"+fn+"' and hash1='"+mac+"'";
						Statement st=c1.createStatement();
						ResultSet rs=st.executeQuery(s1);
						
						if(rs.next()==true)
						{
							File check = new File("CS1\\temp\\"+fn+"1"+".txt");
							if(check.exists())
							{
							
								  FileInputStream fs = new FileInputStream("CS1\\temp\\"+fn+"1"+".txt");
								  byte bs1[] = new byte[fs.available()];
								  
								  
								  fs.read(bs1);
								  String file = new String(bs1);
							 
							 DataOutputStream ds = new DataOutputStream(con.getOutputStream());		 
							 ds.writeUTF(file);
							 ds.writeUTF("success");
							}
							else
							{
								DataOutputStream ds = new DataOutputStream(con.getOutputStream());		 
								 ds.writeUTF("No file");
								 ds.writeUTF("success");
							}
						}
						else
						{
								DataOutputStream ds = new DataOutputStream(con.getOutputStream());		 
							 ds.writeUTF("failure");
							 ds.writeUTF("failure");
						}
								  
					}
				}catch(Exception es){System.out.println(es);}

			}
			
			 if(this.port==3637)
			 {
				 ServerSocket sc =null;
				 Socket s = null;
				 DataInputStream in =null;
				 
				 try
				 {
					DBCon d1=new DBCon();
					Connection con=d1.getConnection();
					 Statement stmt = con.createStatement();
					 sc = new ServerSocket(3637);
					 s = sc.accept();
					 in = new DataInputStream(s.getInputStream());
					 
					 String file = in.readUTF();
					 String sql = "Delete * from CS1 where FName='"+file+"'";
					 stmt.executeUpdate(sql);
					 
					  new File("CS1\\temp\\"+file+"1"+".txt").delete();
			
					 
					 DataOutputStream ds = new DataOutputStream(s.getOutputStream());
					 ds.writeUTF("Files Deleted");
				 
				 }
				 catch(Exception e)
				 {
					 e.printStackTrace();
				 } 
			 }
			 if(this.port==2222)
					
				{
					
					DBCon db=new DBCon();
					Connection c1=db.getConnection();
					
					try
					{
						
						ServerSocket server1 = new ServerSocket(2222);
		                Socket con;
						while (true) 
						{
							con = server1.accept();
							DataInputStream dis = new DataInputStream(con.getInputStream());
							
							String fname= dis.readUTF();
							String pubk= dis.readUTF();
							String privk= dis.readUTF();
							String sk= dis.readUTF();
							String s1hash = dis.readUTF();
							String part1=dis.readUTF();
							
							
							
								Statement stmt = c1.createStatement();
								String query = "insert into CS1 values('" + fname + "','" + pubk+ "','" + privk+ "','" + sk+ "','"+s1hash+"')";
								stmt.executeUpdate(query);
								
					
								PrintStream out = null;
								try {
								    out = new PrintStream(new FileOutputStream("CS1\\"+"temp\\"+fname+"1"+".txt"));
								    out.print(part1);
								    
								}
								finally {
								    if (out != null) out.close();
								}
							
						}	
							
						}
						catch(Exception e){System.out.println(e);}
					
					
					
					
					
				}
		}
	}

	
	public static void main(String[] args) 
	{
		new Cloudserver1();
	}

	
	
}
