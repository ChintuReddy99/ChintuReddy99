import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.*;

public class EdgeCloud extends JFrame implements ActionListener
{
	JPanel p1;
	ImageIcon cs1,cs2,cs3,cs4,cs5,css1,css2,css3,css4,css5,rcs1;
	ImageIcon ps1,ps2,rain,Rec1,Rec2,fail,Green,rain3,GArrow;
	ImageIcon dot,dot2;;
	JLabel bcs1,bcs2,bcs3,bcs4,bcs5,stext,user;
	JLabel proxy1,proxy2,Rain,Rain2,dash1,dash2;
	
	MenuBar mbr;
	Menu file, Reset;
	MenuItem view,rest,Analyzer;
	
	ImageIcon Blackline1,Blackline2,Blackline3,Blackline4,Blackline5;
	JLabel LB1,LB2,LB3,LB4,LB5;
	JLabel LLB1,LLB2,LLB3,LLB4,LLB5;
	JLabel remote,Failure;
	
	public Font f = new Font("Bookman Old Style", Font.BOLD, 20);
	public Font f1 = new Font("Bookman Old Style", Font.BOLD, 18);
	public Font f2 = new Font("Bookman Old Style", Font.BOLD, 16);
	public Font f3 = new Font("Bookman Old Style", Font.BOLD, 23);
	public Font f4 = new Font("Bookman Old Style", Font.BOLD, 15);
	
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";
	
	JLabel t1,t2,t3,t4,t5,t6;
	int count=0;
	
	EdgeCloud()
	{
		p1=new JPanel();
		p1.setLayout(null);
		setTitle("Edge Cloud-->Attacking and Protecting Data Privacy in Edge Cloud Collaborative Inference Systems");
		
		mbr=new MenuBar();
		setMenuBar(mbr);
		
		file=new Menu("File");
		view=new MenuItem("view Cloud Status");
		rest=new MenuItem("Reset Edge Cloud");
		Reset=new Menu("Reset ");
		file.add(view);
		Reset.add(rest);
		mbr.add(file);
		mbr.add(Reset);
		
		view.addActionListener(this);
		rest.addActionListener(this);
		
		t1=new JLabel();
		p1.add(t1);
		
		t2=new JLabel();
		p1.add(t2);
		
		t3=new JLabel();
		p1.add(t3);
		
		t4=new JLabel();
		p1.add(t4);
		
		t5=new JLabel();
		p1.add(t5);
		
		t6=new JLabel();
		p1.add(t6);
		
		dot=new ImageIcon(this.getClass().getResource("images/GLine2.png"));
		dot2=new ImageIcon(this.getClass().getResource("images/GLine1.png"));
		dash1=new JLabel();
		dash2=new JLabel();
		
		
		ImageIcon im1 = new ImageIcon(this.getClass().getResource("images/ProxyServer.png"));
		JLabel imageLabel1 = new JLabel();
		 imageLabel1.setIcon(im1);
		 imageLabel1.setBounds(10, 0, 860, 100);
		
		
		
		rcs1=new ImageIcon(this.getClass().getResource("images/red.png"));
		cs1=new ImageIcon(this.getClass().getResource("images/cs1.png"));
		css1=new ImageIcon(this.getClass().getResource("images/csg1.png"));
		bcs1=new JLabel();
		bcs1.setIcon(cs1);
		bcs1.setBounds(400,130, 350,100);
		
		cs2=new ImageIcon(this.getClass().getResource("images/cs2.png"));
		css2=new ImageIcon(this.getClass().getResource("images/csg2.png"));
		bcs2=new JLabel();
		bcs2.setIcon(cs2);
		bcs2.setBounds(400,200, 350,100);
		
		cs3=new ImageIcon(this.getClass().getResource("images/cs3.png"));
		css3=new ImageIcon(this.getClass().getResource("images/csg3.png"));
		bcs3=new JLabel();
		bcs3.setIcon(cs3);
		bcs3.setBounds(400,270, 350,100);
		
		
		cs4=new ImageIcon(this.getClass().getResource("images/cs4.png"));
		css4=new ImageIcon(this.getClass().getResource("images/csg4.png"));
		bcs4=new JLabel();
		bcs4.setIcon(cs4);
		bcs4.setBounds(400,340, 350,100);
		
	
		cs5=new ImageIcon(this.getClass().getResource("images/cs5.png"));
		css5=new ImageIcon(this.getClass().getResource("images/bcs1.png")); 
		bcs5=new JLabel();
	
		
		stext =new JLabel();
		stext.setText("Edge Cloud");
		stext.setBounds(80,340, 180,30);
		stext.setFont(f2);
		
		
		user =new JLabel();
		user.setText("Remote user");
		user.setBounds(698,350, 250,30);
		user.setFont(f);
	
		ps1=new ImageIcon(this.getClass().getResource("images/trustee.jpg"));
		proxy1=new JLabel();
		proxy1.setIcon(ps1);
		proxy1.setBounds(180,90, 350,400);
	
		rain=new ImageIcon(this.getClass().getResource("images/Line.png"));
		rain3=new ImageIcon(this.getClass().getResource("images/Line2.png"));
		
		Rain=new JLabel();
		Rain.setIcon(rain);
		Rain.setBounds(340,110,100,360);
	
		Rain2=new JLabel();
		//Rain2.setIcon(rain);
		Rain2.setBounds(650,110,100,360);
	
	////// BLACK LINES	
		Green	  =new ImageIcon(this.getClass().getResource("images/Gline.png"));
		GArrow	  =new ImageIcon(this.getClass().getResource("images/GArrow.png"));
		Blackline1=new ImageIcon(this.getClass().getResource("images/Bline1.png"));
		Blackline3=new ImageIcon(this.getClass().getResource("images/Bline2.png"));
	
		LB1=new JLabel();
		LB1.setIcon(Blackline1);
		LB1.setBounds(345,174,100,20);
		
		LB2=new JLabel();
		LB2.setIcon(Blackline1);
		LB2.setBounds(345,235,100,20);         
		
		LB3=new JLabel();
		LB3.setIcon(Blackline1);
		LB3.setBounds(345,305,100,20);
		
		LB4=new JLabel();
		LB4.setIcon(Blackline1);
		LB4.setBounds(345,385,100,20);   
		
		LB5=new JLabel();
		LB5.setIcon(Blackline3);
		LB5.setBounds(225,270,350,30);
		
		
		Rec1=new ImageIcon(this.getClass().getResource("images/Rec.jpg"));
	//	Rec2=new ImageIcon(this.getClass().getResource("images/Rec2.jpg"));
		
		remote=new JLabel();
		remote.setIcon(Rec1);
		remote.setBounds(690,300,280,300);
		
		
		p1.setBackground(Color.WHITE);
		
		p1.add(bcs1);p1.add(bcs2);p1.add(bcs3);p1.add(bcs4);p1.add(bcs5);p1.add(remote);
		p1.add(proxy1);
		p1.add(stext);
		p1.add(Rain);p1.add(Rain2);p1.add(user);
		p1.add(LB1);p1.add(LB2);p1.add(LB3);p1.add(LB4); p1.add(LB5);
		//p1.add(LLB1);p1.add(LLB2);p1.add(LLB3);p1.add(LLB4);  
		p1.add(dash1);p1.add(dash2); p1.add(imageLabel1);
		
		add(p1);
		setSize(900,600);
		setVisible(true);
		
		int[] ports = new int[]
			              		{ 1111,405,7777,6666,9797,12345};

			              		for (int i = 0; i < 6; i++)
			              		{
			              			Thread t = new Thread(new PortListener(ports[i]));
			              			t.setName("Listener-" + ports[i]);
			              			t.start();

			              		}
		
		
	}

	
	public void actionPerformed(ActionEvent a3) 
	{
		if(a3.getSource()==view)
		{
			new CloudStatus();
		}
		if(a3.getSource()==rest)
		{
			
			count=0;
			
			bcs1.setIcon(cs1);
			bcs1.setBounds(400,130, 350,100);
			
			bcs2.setIcon(cs2);
			bcs2.setBounds(400,200, 350,100);
			
			bcs3.setIcon(cs3);
			bcs3.setBounds(400,270, 350,100);
			
			bcs4.setIcon(cs4);
			bcs4.setBounds(400,340, 350,100);
			
			LB1.setIcon(Blackline1);
			LB1.setBounds(345,174,100,20);
			
			LB2.setIcon(Blackline1);
			LB2.setBounds(345,235,100,20);  
			
			LB3.setIcon(Blackline1);
			LB3.setBounds(345,305,100,20);
			
			LB4.setIcon(Blackline1);
			LB4.setBounds(345,385,100,20);   
			
			LB5.setIcon(Blackline3);
			LB5.setBounds(225,270,350,30);
			
			Rain.setIcon(rain);
			Rain.setBounds(340,110,100,360);
			
		  	dash2.setIcon(dot2);
			dash2.setBounds(0,0,0,0);
		  
		  	dash1.setIcon(dot);
			dash1.setBounds(0,0,0,0);
			
			bcs5.setIcon(cs5);
			bcs5.setBounds(0,0,0,0);
			
			t6.setBounds(0,0,0,0);
			t1.setBounds(0,0,0,0);
			t2.setBounds(0,0,0,0);
			t3.setBounds(0,0,0,0);
			t4.setBounds(0,0,0,0);
			
			
		}
		
	}
	
	public static void main(String[] args) 
	{
		new EdgeCloud();
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
			
			if(this.port==9797)
			{
				try
				{
					
					DBCon db=new DBCon();
					Connection ccc=db.getConnection();
					ServerSocket ss=new ServerSocket(9797);
					Socket m1;
					while(true)
					{
						m1=ss.accept();
						
						DataInputStream dis=new DataInputStream(m1.getInputStream());
						String csname=dis.readUTF();
						String status=dis.readUTF();
						String reason=dis.readUTF();
						String fname=dis.readUTF();
					
						
						System.out.println(csname);
						System.out.println(status);
						System.out.println(reason);
						System.out.println(fname);
						
						
							Statement sss=ccc.createStatement();
							String str3="insert into CStatus values ('"+csname+"','"+status+"','"+reason+"','"+fname+"')";
							sss.executeUpdate(str3);
							System.out.println("Cloud Status updated");
							
					 DataOutputStream dos33=new DataOutputStream(m1.getOutputStream());
					 dos33.writeUTF("success");
					 
							
					}
					
					
				}catch(Exception es){System.out.println(es);}
			}
			if(this.port==405)
			{
				try
				{
					ServerSocket sc1 = new ServerSocket(405);
					Socket s;
					while(true)
					{
						 s = sc1.accept();
						ObjectInputStream dout1 = new ObjectInputStream(s.getInputStream());
						String msg1 = (String) dout1.readObject();
						
						ArrayList l1 = new ArrayList();
						
						DBCon db = new DBCon();
						Connection con = db.getConnection();
						Statement stmt = con.createStatement();
						
						String sql1 = "select * from Trustee";
						ResultSet rs = stmt.executeQuery(sql1);
						
						while(rs.next()==true)
						{
							String fname= rs.getString(1);
							l1.add(fname);
						}
						
						ObjectOutputStream dout2 = new ObjectOutputStream(s.getOutputStream());
						dout2.writeObject(l1);
					
						
						
					}
				}
				catch(Exception e1)
				{
					e1.printStackTrace();
				}
			}		
			

			if(this.port==7777)
			{
				DBCon db=new DBCon();
				Connection c22=db.getConnection();
				ServerSocket ss;
				
				try
				{
					ss=new ServerSocket(7777);
					Socket m1=ss.accept();
					while(true)
					{
						DataInputStream dis=new DataInputStream(m1.getInputStream());
						String req=dis.readUTF();
						String fn=dis.readUTF();
						
						if(req.equalsIgnoreCase("Key Request"))
						{
							Statement st=c22.createStatement();
							String str="Select * from Trustee where FName='"+fn+"'";
							ResultSet rs=st.executeQuery(str);
							
							if(rs.next()==true)
							{
								String sk=rs.getString("Sk");
								
								DataOutputStream dos2=new DataOutputStream(m1.getOutputStream());
								dos2.writeUTF("SUCCESS");
								dos2.writeUTF(sk);
							}
							else
							{
								DataOutputStream dos2=new DataOutputStream(m1.getOutputStream());
								dos2.writeUTF("fAILURE");
								
							}
						}
					}
					
					
					
				}catch(Exception es){System.out.println(es);}
			}
			
			if(this.port==12345)
			{
				try
				{
					ServerSocket ss=new ServerSocket(12345);
					Socket m33=ss.accept();
					while(true)
					{
						DataInputStream dis=new DataInputStream(m33.getInputStream());
						String res1=dis.readUTF();
						String res2=dis.readUTF();
						String res3=dis.readUTF();
						String res4=dis.readUTF();
						
						Socket soc6=new Socket("localhost",4567);
						DataOutputStream dos1=new DataOutputStream(soc6.getOutputStream());
						dos1.writeUTF(res1);
						dos1.writeUTF(res2);
						dos1.writeUTF(res3);
						dos1.writeUTF(res4);
						
						soc6.close();
					}
				}catch(Exception es){System.out.println(es);}
			}
			
			if(this.port==6666)
			{
				String status="Normal";
				String csname="Safe";
				
				String p1="Packet1";
				String p2="Packet2";
				String p3="packet3";
				String p4="packet4";
				
				
				
				String part1=null; String part11=null;
				String part2=null; String part22=null;
				String part3=null; String part33=null;
				String part4=null; String part44=null;
				
		
				 AES dec=new AES();
				try
				{
					DBCon db=new DBCon();
					Connection c=db.getConnection();
					ServerSocket ss1 = new ServerSocket(6666);
	                Socket con;
	                
	               
					while (true) 
					{
						con = ss1.accept();
						DataInputStream dis=new DataInputStream(con.getInputStream());
						String req=dis.readUTF();
						String fname=dis.readUTF();
						String skey=dis.readUTF();
						
						System.out.println(req);
						System.out.println(fname);
						
						Statement st=c.createStatement();
						String d1="select * from Trustee where FName='"+fname+"'and Sk ='"+skey+"'";
						ResultSet rs=st.executeQuery(d1);
						
						
						if(rs.next()==true)
						{
							System.out.println("File Exist in Cloud Server ");
							
							String mac1=rs.getString("s1hash");
							String mac2=rs.getString("s2hash");
							String mac3=rs.getString("s3hash");
							String mac4=rs.getString("s4hash");
							
							
							stext.setText("Edge Cloud");
							stext.setBounds(120,340, 180,30);
							
							stext.setVisible(true);
							Thread.sleep(1000);
							stext.setVisible(false);
							Thread.sleep(1000);
							stext.setVisible(true);
							Thread.sleep(1000);
							stext.setVisible(false);
							Thread.sleep(1000);
							stext.setVisible(true);
							
							Thread.sleep(2000);
							LB5.setIcon(Green);      
							LB5.setBounds(225,270,350,30);
							
							Thread.sleep(2000);
							Rain.setIcon(rain3);
							Rain.setBounds(340,110,100,360);
						
							
							
							if(p1.equalsIgnoreCase("packet1"))
							{
								Socket st1=new Socket("localhost",5551);  //Enter cs1 ip
								DataOutputStream dos1=new DataOutputStream(st1.getOutputStream());
								dos1.writeUTF(fname);
								dos1.writeUTF(mac1);
								
								DataInputStream dis1=new DataInputStream(st1.getInputStream());
								part1=dis1.readUTF();
								String res=dis1.readUTF();
								
								Thread.sleep(2000);
								LB1.setIcon(GArrow);
								LB1.setBounds(345,174,100,20);
								
								if(part1.equals("failure"))
								{
									
									Thread.sleep(2000);
									bcs1.setIcon(rcs1);
									bcs1.setBounds(400,130, 350,100);
									

									t1.setText("P1 Attacked");
									t1.setBounds(550,130, 350,100);
									
									t1.setVisible(true);
									Thread.sleep(1000);
									t1.setVisible(false);
									Thread.sleep(1000);
									t1.setVisible(true);
									Thread.sleep(1000);
									t1.setVisible(false);
									Thread.sleep(1000);
									t1.setVisible(true);
									Thread.sleep(1000);
									t1.setVisible(false);
									Thread.sleep(1000);
									t1.setVisible(true);
									Thread.sleep(1000);
									
									count++;
									
									Regenarate.Generate(fname,"CS1");
									
									System.out.println("Data Regenerated");
									
									  FileInputStream fs = new FileInputStream("Trustee\\REGEN\\"+fname+"1"+".txt");
									  byte bs1[] = new byte[fs.available()];
									  fs.read(bs1);
									  part11 = new String(bs1);
									  
									  PrintStream out = null;
										try {
										    out = new PrintStream(new FileOutputStream("Trustee\\"+"Merge\\"+fname+"1"+".txt"));
										    out.print(part11);
										    
										}
										finally {
										    if (out != null) out.close();
										}
										
										
										Socket st11=new Socket("localhost",6000);  
										DataOutputStream dos11=new DataOutputStream(st11.getOutputStream());
										dos11.writeUTF("CS1");
										dos11.writeUTF("P1 is Not Safe");
										dos11.writeUTF("Modified");
										dos11.writeUTF(fname);
										dos11.writeUTF("Packet1");
										
										
										
										
										
									
								}
								else
								{
									Thread.sleep(2000);
									bcs1.setIcon(css1);
									bcs1.setBounds(400,130, 350,100);
									
									
									t1.setText("P1 Safe");
									t1.setBounds(550,130, 350,100);
									
									t1.setVisible(true);
									Thread.sleep(1000);
									t1.setVisible(false);
									Thread.sleep(1000);
									t1.setVisible(true);
									Thread.sleep(1000);
									t1.setVisible(false);
									Thread.sleep(1000);
									t1.setVisible(true);
									Thread.sleep(1000);
									t1.setVisible(false);
									Thread.sleep(1000);
									t1.setVisible(true);
									Thread.sleep(1000);
									
									PrintStream out = null;
									try {
									    out = new PrintStream(new FileOutputStream("Trustee\\"+"Merge\\"+fname+"1"+".txt"));
									    out.print(part1);
									    
									}
									finally {
									    if (out != null) out.close();
									}
								}
								
								Socket st11=new Socket("localhost",6000);  
								DataOutputStream dos11=new DataOutputStream(st11.getOutputStream());
								dos11.writeUTF("CS1");
								dos11.writeUTF("P1 is  Safe");
								dos11.writeUTF("No Modified");
								dos11.writeUTF(fname);
								dos11.writeUTF("Packet1");
								
				
								
							}
							if(p2.equalsIgnoreCase("packet2"))
							{
								Socket st2=new Socket("localhost",5552);  //Enter cs2 ip
								DataOutputStream dos2=new DataOutputStream(st2.getOutputStream());
								dos2.writeUTF(fname);
								dos2.writeUTF(mac2);
								
								DataInputStream dis2=new DataInputStream(st2.getInputStream());
								part2=dis2.readUTF();
								String res=dis2.readUTF();
								
								
								Thread.sleep(2000);
								LB2.setIcon(GArrow);
								LB2.setBounds(345,235,100,20);  
								
								if(part2.equals("failure"))
								{
									Thread.sleep(2000);
									bcs2.setIcon(rcs1);
									bcs2.setBounds(400,200, 350,100);
									
									t2.setText("P2 Attacked");
									t2.setBounds(550,200, 350,100);
									
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									
									count++;
									
									Regenarate.Generate(fname,"CS2");
									
									System.out.println("Data Regenerated");
									
									Thread.sleep(2000);
									
									 FileInputStream fs = new FileInputStream("Trustee\\REGEN\\"+fname+"2"+".txt");
									 byte bs1[] = new byte[fs.available()];
									 fs.read(bs1);
									 part22 = new String(bs1);
									 
									 PrintStream out1 = null;
										try {
										    out1 = new PrintStream(new FileOutputStream("Trustee\\"+"Merge\\"+fname+"2"+".txt"));
										    out1.print(part22);
										    
										}
										finally {
										    if (out1 != null) out1.close();
										}
										Socket st11=new Socket("localhost",6000);  
										DataOutputStream dos11=new DataOutputStream(st11.getOutputStream());
										dos11.writeUTF("CS2");
										dos11.writeUTF("P2 is Not Safe");
										dos11.writeUTF("Modified");
										dos11.writeUTF(fname);
										dos11.writeUTF("Packet1");
										
								}
								else
								{
									Thread.sleep(2000);
									bcs2.setIcon(css2);
									bcs2.setBounds(400,200, 350,100);
									
									t2.setText("P2 Safe");
									t2.setBounds(550,200, 350,100);
									
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									
									PrintStream out1 = null;
									try {
									    out1 = new PrintStream(new FileOutputStream("Trustee\\"+"Merge\\"+fname+"2"+".txt"));
									    out1.print(part2);
									    
									}
									finally {
									    if (out1 != null) out1.close();
									}
								}
								Socket st11=new Socket("localhost",6000);  
								DataOutputStream dos11=new DataOutputStream(st11.getOutputStream());
								dos11.writeUTF("CS2");
								dos11.writeUTF("P2 is  Safe");
								dos11.writeUTF("No Modified");
								dos11.writeUTF(fname);
								dos11.writeUTF("Packet2");
							}
							if(p3.equalsIgnoreCase("packet3"))
							{
								Socket st3=new Socket("localhost",5553);  //Enter cs3 ip
								DataOutputStream dos3=new DataOutputStream(st3.getOutputStream());
								dos3.writeUTF(fname);
								dos3.writeUTF(mac3);
								
								DataInputStream dis3=new DataInputStream(st3.getInputStream());
								part3=dis3.readUTF();
								String res=dis3.readUTF();
								
								Thread.sleep(2000);
								LB3.setIcon(GArrow);
								LB3.setBounds(345,305,100,20);
								
								
								if(part3.equals("failure"))
								{
									Thread.sleep(2000);
									bcs3.setIcon(rcs1);
									bcs3.setBounds(400,270, 350,100);
									
									t3.setText("P3 Attacked");
									t3.setBounds(550,270, 350,100);
									
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									
									Regenarate.Generate(fname,"CS3");
									
									count++;
									
									System.out.println("Data Regenerated");
									
									Thread.sleep(2000);
									
									 FileInputStream fs = new FileInputStream("Trustee\\REGEN\\"+fname+"3"+".txt");
									 byte bs1[] = new byte[fs.available()];
									 fs.read(bs1);
									 part33 = new String(bs1);
									 
									 PrintStream out2 = null;
										try {
										    out2 = new PrintStream(new FileOutputStream("Trustee\\"+"Merge\\"+fname+"3"+".txt"));
										    out2.print(part33);
										    
										}
										finally {
										    if (out2 != null) out2.close();
										}
										
										Socket st11=new Socket("localhost",6000);  
										DataOutputStream dos11=new DataOutputStream(st11.getOutputStream());
										dos11.writeUTF("CS3");
										dos11.writeUTF("P3 is Not Safe");
										dos11.writeUTF("Modified");
										dos11.writeUTF(fname);
										dos11.writeUTF("Packet3");
										
										
								}
								else
								{
									Thread.sleep(2000);
									bcs3.setIcon(css3);
									bcs3.setBounds(400,270, 350,100);
									
									t3.setText("P3 Safe");
									t3.setBounds(550,270, 350,100);
									
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									
									PrintStream out2 = null;
									try {
									    out2 = new PrintStream(new FileOutputStream("Trustee\\"+"Merge\\"+fname+"3"+".txt"));
									    out2.print(part3);
									    
									}
									finally {
									    if (out2 != null) out2.close();
									}
									
									Socket st11=new Socket("localhost",6000);  
									DataOutputStream dos11=new DataOutputStream(st11.getOutputStream());
									dos11.writeUTF("CS3");
									dos11.writeUTF("P3 is  Safe");
									dos11.writeUTF("No Modified");
									dos11.writeUTF(fname);
									dos11.writeUTF("Packet3");
									
									
								}
							}
							if(p4.equalsIgnoreCase("packet4"))
							{
								Socket st4=new Socket("localhost",5554);  //Enter cs3 ip
								DataOutputStream dos4=new DataOutputStream(st4.getOutputStream());
								dos4.writeUTF(fname);
								dos4.writeUTF(mac4);
								
								DataInputStream dis4=new DataInputStream(st4.getInputStream());
								part4=dis4.readUTF();
								String res=dis4.readUTF();
								
								Thread.sleep(2000);
								LB4.setIcon(GArrow);
								LB4.setBounds(345,385,100,20);   
								
								if(part4.equals("failure"))
								{
									Thread.sleep(2000);
									bcs4.setIcon(rcs1);
									bcs4.setBounds(400,340, 350,100);
									
									t4.setText("P4 Attacked");
									t4.setBounds(550,340, 350,100);
									
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									
									count++;
									
									Regenarate.Generate(fname,"CS4");
									
									System.out.println("Data Regenerated");
									
									Thread.sleep(2000);
									
									 FileInputStream fs = new FileInputStream("Trustee\\REGEN\\"+fname+"4"+".txt");
									 byte bs1[] = new byte[fs.available()];
									 fs.read(bs1);
									 part44 = new String(bs1);
									
									 
									 PrintStream out3 = null;
										try {
										    out3 = new PrintStream(new FileOutputStream("Trustee\\"+"Merge\\"+fname+"4"+".txt"));
										    out3.print(part44);
										    
										}
										finally {
										    if (out3 != null) out3.close();
										}
										
										
										Socket st11=new Socket("localhost",6000);  
										DataOutputStream dos11=new DataOutputStream(st11.getOutputStream());
										dos11.writeUTF("CS4");
										dos11.writeUTF("P4 is Not Safe");
										dos11.writeUTF("Modified");
										dos11.writeUTF(fname);
										dos11.writeUTF("Packet4");
										
								}
								else
								{
									Thread.sleep(2000);
									bcs4.setIcon(css4);
									bcs4.setBounds(400,340, 350,100);
									
									t4.setText("P4 Safe");
									t4.setBounds(550,340, 350,100);
									
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									
									PrintStream out3 = null;
									try {
									    out3 = new PrintStream(new FileOutputStream("Trustee\\"+"Merge\\"+fname+"4"+".txt"));
									    out3.print(part4);
									    
									}
									finally {
									    if (out3 != null) out3.close();
									}
								}
								
								Socket st11=new Socket("localhost",6000);  
								DataOutputStream dos11=new DataOutputStream(st11.getOutputStream());
								dos11.writeUTF("CS4");
								dos11.writeUTF("P4 is  Safe");
								dos11.writeUTF("No Modified");
								dos11.writeUTF(fname);
								dos11.writeUTF("Packet4");
								
								
							}
							
							
						

							  MergeFile mf = new MergeFile();
							  mf.mergeFiles(fname,"Trustee");
							  
							  FileInputStream fs = new FileInputStream("Trustee\\Merge\\"+fname+"o"+".txt");
							  byte bs1[] = new byte[fs.available()];
							  fs.read(bs1);
							  String filec = new String(bs1);
							  
							  if(count==0)
							  {
							  
							  	Thread.sleep(2000);
							  	dash2.setIcon(dot2);
								dash2.setBounds(140,340, 50,120);
							  
								Thread.sleep(2000);
							  	dash1.setIcon(dot);
								dash1.setBounds(140,435, 550,20);
								
								user.setText("Remote user");
								user.setBounds(698,350, 250,30);
								
								user.setVisible(true);
								Thread.sleep(1000);
								user.setVisible(false);
								Thread.sleep(1000);
								user.setVisible(true);
								Thread.sleep(1000);
								user.setVisible(false);
								Thread.sleep(1000);
								user.setVisible(true);
								
							  }
							  else
							  {
								  	Thread.sleep(2000);
								  	dash2.setIcon(dot2);
									dash2.setBounds(140,340, 50,120);
									
								  	Thread.sleep(2000);
									bcs5.setIcon(cs5);
									bcs5.setBounds(80,400, 350,100);
									
									Thread.sleep(2000);
									t6.setText("Regenarated");
									t6.setBounds(100,470, 300,30);
									
									t6.setVisible(true);
									Thread.sleep(1000);
									t6.setVisible(false);
									Thread.sleep(1000);
									t6.setVisible(true);
									Thread.sleep(1000);
									t6.setVisible(false);
									Thread.sleep(1000);
									t6.setVisible(true);
									
									Thread.sleep(2000);
								  	dash1.setIcon(dot);
									dash1.setBounds(140,435, 550,20);
									
									
									
									user.setText("Remote user");
									user.setBounds(698,350, 250,30);
									
									user.setVisible(true);
									Thread.sleep(1000);
									user.setVisible(false);
									Thread.sleep(1000);
									user.setVisible(true);
									Thread.sleep(1000);
									user.setVisible(false);
									Thread.sleep(1000);
									user.setVisible(true);
							  }
								
							  
							  String fdata=dec.decrypt(filec,keyWord);
						 
								  DataOutputStream ds = new DataOutputStream(con.getOutputStream());
							
								  ds.writeUTF("success");
								  ds.writeUTF(fdata);
							
							
						}
						
						
						
						
					}
				
				}catch(Exception es){System.out.println(es);}
			}
			 if(this.port==1111)
					
				{
					
					 DBCon db=new DBCon();
					Connection c1=db.getConnection();
					
					try
					{
						
						ServerSocket server1 = new ServerSocket(1111);
		                Socket con;
		                String cloud="Normal";
		                String Reason1="Doze off";
						while (true) 
						{
							con = server1.accept();
							DataInputStream dis = new DataInputStream(con.getInputStream());
							
							//String csname=dis.readUTF();
							String fname= dis.readUTF();
							
							String pubk= dis.readUTF();
						
							String privk= dis.readUTF();

							String sk= dis.readUTF();
							
			
							String s1hash = dis.readUTF();
							String s2hash = dis.readUTF();
							String s3hash = dis.readUTF();
							String s4hash = dis.readUTF();
						
							String ct=dis.readUTF();
							String part1=dis.readUTF();
							String part2=dis.readUTF();
							String part3=dis.readUTF();
							String part4=dis.readUTF();
				
			
							
								Statement stmt = c1.createStatement();
								String query = "insert into Trustee values('" + fname + "','" + pubk+ "','" + privk+ "','" + sk+ "','"+s1hash+"','"+s2hash+"','"+s3hash+"','"+s4hash+"')";
								stmt.executeUpdate(query);
								
								
								PrintStream out0 = null;
								try {
								    out0 = new PrintStream(new FileOutputStream("Trustee\\"+"temp\\"+fname+".txt"));
								    out0.print(ct);
								    
								}
								finally {
								    if (out0 != null) out0.close();
								}
								
								
								PrintStream out = null;
								try {
								    out = new PrintStream(new FileOutputStream("Trustee\\"+"temp\\"+fname+"1"+".txt"));
								    out.print(part1);
								    
								}
								finally {
								    if (out != null) out.close();
								}
								
								PrintStream out1 = null;
								try {
								    out1 = new PrintStream(new FileOutputStream("Trustee\\"+"temp\\"+fname+"2"+".txt"));
								    out1.print(part2);
								    
								}
								finally {
								    if (out1 != null) out1.close();
								}
								
								PrintStream out2 = null;
								try {
								    out2 = new PrintStream(new FileOutputStream("Trustee\\"+"temp\\"+fname+"3"+".txt"));
								    out2.print(part3);
								    
								}
								finally {
								    if (out2 != null) out2.close();
								}
								
								
								PrintStream out3 = null;
								try {
								    out3 = new PrintStream(new FileOutputStream("Trustee\\"+"temp\\"+fname+"4"+".txt"));
								    out3.print(part4);
								    
								}
								finally {
								    if (out3 != null) out3.close();
								}
								
								
								stext.setText("EDGE CLOUD");
								stext.setBounds(120,340, 280,30);
								
								stext.setVisible(true);
								Thread.sleep(1000);
								stext.setVisible(false);
								Thread.sleep(1000);
								stext.setVisible(true);
								Thread.sleep(1000);
								stext.setVisible(false);
								Thread.sleep(1000);
								stext.setVisible(true);
								
								
								Thread.sleep(2000);
								LB5.setIcon(Green);      
								LB5.setBounds(225,270,350,30);
								
								Thread.sleep(2000);
								Rain.setIcon(rain3);
								Rain.setBounds(340,110,100,360);
								
								Thread.sleep(2000);
								LB1.setIcon(GArrow);
								LB1.setBounds(345,174,100,20);
					
								Thread.sleep(2000);
								bcs1.setIcon(css1);
								bcs1.setBounds(400,130, 350,100);
								
								
								t1.setText("Packet1");
								t1.setBounds(550,130, 350,100);
								
								t1.setVisible(true);
								Thread.sleep(1000);
								t1.setVisible(false);
								Thread.sleep(1000);
								t1.setVisible(true);
								Thread.sleep(1000);
								t1.setVisible(false);
								Thread.sleep(1000);
								t1.setVisible(true);
								Thread.sleep(1000);
								t1.setVisible(false);
								Thread.sleep(1000);
								t1.setVisible(true);
								Thread.sleep(1000);
				
									
									System.out.println("Data will be Sent to Cloudserver1 ");
									
									DataOutputStream dos333=new DataOutputStream(con.getOutputStream());
									dos333.writeUTF("success");
									
									
									Socket st=new Socket("localhost",2222);
									DataOutputStream dos3=new DataOutputStream(st.getOutputStream());
									
									dos3.writeUTF(fname);
									dos3.writeUTF(pubk);
									dos3.writeUTF(privk);
									dos3.writeUTF(sk);
									
									dos3.writeUTF(s1hash);
									dos3.writeUTF(part1);
									
							
									
									DataOutputStream dos444=new DataOutputStream(con.getOutputStream());
									dos444.writeUTF("success");
									
									
									Thread.sleep(2000);
									LB2.setIcon(GArrow);
									LB2.setBounds(345,235,100,20);  
									
									Thread.sleep(2000);
									bcs2.setIcon(css2);
									bcs2.setBounds(400,200, 350,100);
									
									t2.setText("Packet2");
									t2.setBounds(550,200, 350,100);
									
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									t2.setVisible(false);
									Thread.sleep(1000);
									t2.setVisible(true);
									Thread.sleep(1000);
									
									
									
									System.out.println("Data will be Sent to Cloud server2");
									
									Socket st2=new Socket("localhost",3333);
									DataOutputStream dos4=new DataOutputStream(st2.getOutputStream());
									
									dos4.writeUTF(fname);
									dos4.writeUTF(pubk);
									dos4.writeUTF(privk);
									dos4.writeUTF(sk);
									
								
									dos4.writeUTF(s2hash);
									dos4.writeUTF(part2);
								
									
								
									
								
								
									
									DataOutputStream dos555=new DataOutputStream(con.getOutputStream());
									dos555.writeUTF("success");
									
									
									Thread.sleep(2000);
									LB3.setIcon(GArrow);
									LB3.setBounds(345,305,100,20);
									
								
									Thread.sleep(2000);
									bcs3.setIcon(css3);
									bcs3.setBounds(400,270, 350,100);
									
									
									t3.setText("Packet3");
									t3.setBounds(550,270, 350,100);
									
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									t3.setVisible(false);
									Thread.sleep(1000);
									t3.setVisible(true);
									Thread.sleep(1000);
									
									System.out.println("Data will be Sent to Cloudserver3");
									
									Socket st3=new Socket("localhost",4444);
									DataOutputStream dos5=new DataOutputStream(st3.getOutputStream());
									
									dos5.writeUTF(fname);
									dos5.writeUTF(pubk);
									dos5.writeUTF(privk);
									dos5.writeUTF(sk);
									
								
									dos5.writeUTF(s3hash);
							
									dos5.writeUTF(part3);
									
									
									
					
									
									
									DataOutputStream dos777=new DataOutputStream(con.getOutputStream());
									dos777.writeUTF("success");
									
									System.out.println("Data will be Sent to Cloudserver4");
									
									
									Thread.sleep(2000);
									LB4.setIcon(GArrow);
									LB4.setBounds(345,385,100,20);   
									
								
									Thread.sleep(2000);
									bcs4.setIcon(css4);
									bcs4.setBounds(400,340, 350,100);
									
									t4.setText("Packet4");
									t4.setBounds(550,340, 350,100);
									
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									t4.setVisible(false);
									Thread.sleep(1000);
									t4.setVisible(true);
									Thread.sleep(1000);
									
									
									t5.setText("Success");
									t5.setBounds(120,190, 200,50);
									
									t5.setVisible(true);
									Thread.sleep(1000);
									t5.setVisible(false);
									Thread.sleep(1000);
									t5.setVisible(true);
									Thread.sleep(1000);
									t5.setVisible(false);
									Thread.sleep(1000);
									t5.setVisible(true);
									Thread.sleep(1000);
									
									
									
									Socket st4=new Socket("localhost",5555);
									DataOutputStream dos6=new DataOutputStream(st4.getOutputStream());
									
									dos6.writeUTF(fname);
									dos6.writeUTF(pubk);
									dos6.writeUTF(privk);
									dos6.writeUTF(sk);
									
				
									dos6.writeUTF(s4hash);
									dos6.writeUTF(part4);
							
									
									
						
								

						// To refresh	
									
									t1.setBounds(0,0,0,0);
									t2.setBounds(0,0,0,0);
									t3.setBounds(0,0,0,0);
									t4.setBounds(0,0,0,0);
									t5.setBounds(0,0,0,0);
									
						
								
									bcs1.setIcon(cs1);
									bcs1.setBounds(400,130, 350,100);
									
									bcs2.setIcon(cs2);
									bcs2.setBounds(400,200, 350,100);
									
									bcs3.setIcon(cs3);
									bcs3.setBounds(400,270, 350,100);
									
									bcs4.setIcon(cs4);
									bcs4.setBounds(400,340, 350,100);
									
									LB1.setIcon(Blackline1);
									LB1.setBounds(345,174,100,20);
									
									LB2.setIcon(Blackline1);
									LB2.setBounds(345,235,100,20);  
									
									LB3.setIcon(Blackline1);
									LB3.setBounds(345,305,100,20);
									
									LB4.setIcon(Blackline1);
									LB4.setBounds(345,385,100,20);   
									
									LB5.setIcon(Blackline3);
									LB5.setBounds(225,270,350,30);
									
									Rain.setIcon(rain);
									Rain.setBounds(340,110,100,360);
									
								  	dash2.setIcon(dot2);
									dash2.setBounds(0,0,0,0);
								  
								  	dash1.setIcon(dot);
									dash1.setBounds(0,0,0,0);
									
									bcs5.setIcon(cs5);
									bcs5.setBounds(0,0,0,0);
							
							}
						}
						catch(Exception e){System.out.println(e);}
					
					
					
					
					
				}
		}
	}

	
}