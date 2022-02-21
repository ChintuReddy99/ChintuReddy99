import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.*;


public class Cloudserver5 extends JFrame implements ActionListener
{

	JPanel p1;
	JLabel cs1;
	ImageIcon c1;
	
	JButton b1;
	

	JTable table;
	int v,h;
	String s,d,call,dt;
	JScrollPane pane;
	
	Vector heading,data;
	
	Cloudserver5()
	{
		p1=new JPanel();
		p1.setLayout(null);
		setTitle("CloudServer5::Attacking and Protecting Data Privacy in Edge Cloud Collaborative Inference Systems");
		
	
		cs1=new JLabel();
		cs1.setIcon(c1);
		cs1.setBounds(0,0,900,600);
		
		b1=new JButton("View All Files");
		b1.setBounds(350,400,150,30);
		b1.addActionListener(this);
		
		ImageIcon im1 = new ImageIcon(this.getClass().getResource("images/CS5Back.png"));
		JLabel imageLabel1 = new JLabel();
		 imageLabel1.setIcon(im1);
		 imageLabel1.setBounds(0, 0, 900, 500);
		
		
	
		
		p1.add(cs1);p1.add(b1);p1.add(imageLabel1);
		add(p1);
		setSize(920,520);
		setVisible(true);
		
		int[] ports = new int[]
			              		{ 7891};

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
            
            heading = new Vector();
   		 
   		 heading.addElement("Regenarated File");
   		 heading.addElement("Name of the Cloud");
   		
   		 data=new Vector();
   		     	 
            
            String query = "SELECT * FROM CS5";
            ResultSet rs = stmt.executeQuery(query);
            ResultSetMetaData rsm=rs.getMetaData();
            int col=rsm.getColumnCount();

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
		 
           pane.setBounds(200,130,600,200);
           p1.add(pane);
		 
			} catch(Exception ex) {ex.printStackTrace();}
		}
		
	}
	public static void main(String[] args) 
	{
		new Cloudserver5();
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
			
			if(this.port==7891)
			{
				String mac=null;
				String cname=null;
				int x=0;
				try
				{
					DBCon done=new DBCon();
					Connection db5=done.getConnection();
					ServerSocket server1 = new ServerSocket(7891);
	                Socket con10;
					while (true) 
					{
						con10 = server1.accept();
						DataInputStream dis = new DataInputStream(con10.getInputStream());
						
						String fname=dis.readUTF();
						String ct=dis.readUTF();
						cname=dis.readUTF();
						
						Statement st6=db5.createStatement();
						String s99="Select * from CS5 where RgenFile='"+fname+"'and from1='"+cname+"'";
						ResultSet rs11=st6.executeQuery(s99);
						
						if(rs11.next()==false)
						{
						
							Statement stmt = db5.createStatement();
							String query = "insert into CS5 values('" + fname + "','" + cname+ "')";
							stmt.executeUpdate(query);
						
							if(cname.equalsIgnoreCase("cs1")){x=1;}
							if(cname.equalsIgnoreCase("cs2")){x=2;}
							if(cname.equalsIgnoreCase("cs3")){x=3;}
							if(cname.equalsIgnoreCase("cs4")){x=4;}
							
							PrintStream out0 = null;
							try {
							    out0 = new PrintStream(new FileOutputStream("CS5\\"+"temp\\"+fname+x+".txt"));
							    out0.print(ct);
							    
							}
							finally {
							    if (out0 != null) out0.close();
							}
							
							
						
						
						
							DataOutputStream daas=new DataOutputStream(con10.getOutputStream());
							daas.writeUTF("Success");
						}
						else
						{
							DataOutputStream daas=new DataOutputStream(con10.getOutputStream());
							daas.writeUTF("Exist");
						}
						
					}
				}catch(Exception es){System.out.println(es);}
			}
		}

	}
}
