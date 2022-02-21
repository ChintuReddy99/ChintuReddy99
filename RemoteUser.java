import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
public class RemoteUser extends JFrame implements ActionListener 
{
	JPanel p1;
	ImageIcon icon;
	JLabel a1;
	
	JTextArea t1;
	JScrollPane pane;
	JButton view,Req,DF;
	
	public Font f = new Font("Bookman Old Style", Font.BOLD, 25);
	public Font f1 = new Font("Bookman Old Style", Font.BOLD, 18);
	public Font f2 = new Font("Bookman Old Style", Font.BOLD, 16);
	public Font f3 = new Font("Bookman Old Style", Font.BOLD, 23);
	public Font f4 = new Font("Bookman Old Style", Font.BOLD, 15);
	
	
	RemoteUser()
	{
		p1=new JPanel();
		p1.setBackground(new Color(0,51,80));
		p1.setLayout(null);
		setTitle("RemoteUser::Attacking and Protecting Data Privacy in Edge Cloud Collaborative Inference Systems");
		
		t1=new JTextArea();
		pane=new JScrollPane();
		
		t1.setColumns(100);
		t1.setBackground(new Color(255,255,255));
		t1.setFont(f1);
		t1.setRows(200);
		t1.setName("tf");
		pane.setName("pane");
		pane.setViewportView(t1);
		pane.setBounds(70,125,550,350);
		
		view =new JButton ("V-CloudFiles");
		view .setFont(f1);
		view .setBackground(new Color(160,120,90));
		//br.setForeGround();
		Req =new JButton ("Req SK");
		Req.setFont(f1);
		
		DF = new JButton("Download");
		DF.setFont(f1);
	
		view.setBounds(65,500,150,35);
		view.setBackground(new Color(0,51,102));
		view.setForeground(new Color(193,205,205));
		
		Req.setBounds(255,500,150,35);
		Req.setBackground(new Color(0,51,102));
		Req.setForeground(new Color(193,205,205));
		
		DF.setBounds(445,500,150,35);
		DF.setBackground(new Color(0,51,102));
		DF.setForeground(new Color(193,205,205));
		
		
		view.addActionListener(this);
		Req.addActionListener(this);
		DF.addActionListener(this);
		
		
		ImageIcon im1 = new ImageIcon(this.getClass().getResource("images/EUBackup.png"));
		JLabel imageLabel1 = new JLabel();
		 imageLabel1.setIcon(im1);
		 imageLabel1.setBounds(50, 30, 620, 550);
	

		p1.add(DF);p1.add(view);p1.add(Req);
		p1.add(pane);p1.add(imageLabel1);
		add(p1);
		setSize(700,625);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent a1) 
	{
		
		if(a1.getSource()==Req)
		{
			String ip=JOptionPane.showInputDialog(null,"Enter the Edge Cloud address");
			String fname=JOptionPane.showInputDialog(null,"Enter the file Name");
			try
			{
				Socket sock=new Socket(ip,7777);
				DataOutputStream dos=new DataOutputStream(sock.getOutputStream());
				dos.writeUTF("Key Request");
				dos.writeUTF(fname);
				
				
				DataInputStream dis3=new DataInputStream (sock.getInputStream());
				String res=dis3.readUTF();
				
				if(res.equalsIgnoreCase("Success"))
				{
					String key=dis3.readUTF();
					JOptionPane.showMessageDialog(null,"Note Down ur Secret Key "+key);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"File Not Found ");
				}
				
			}catch(Exception es){System.out.println(es);}
		}
		
		
		if(a1.getSource()==DF)
		{
			String ip=JOptionPane.showInputDialog(null,"Enter the Cloud Edge Ipaddress");
			String fn=JOptionPane.showInputDialog(null,"Enter the file Name");
			String key=JOptionPane.showInputDialog(null,"Enter the Secret key");
		
			
			try
			{
				Socket proxy=new Socket(ip,6666);
				DataOutputStream dos9=new DataOutputStream(proxy.getOutputStream());
				
				dos9.writeUTF("File Request");
				dos9.writeUTF(fn);
				dos9.writeUTF(key);
				
				DataInputStream dis9=new DataInputStream(proxy.getInputStream());
				String res=dis9.readUTF();
				String data=dis9.readUTF();
				
				if(res.equalsIgnoreCase("Success"))
				{
					t1.setText(data);
					JOptionPane.showMessageDialog(null,"Data Recieved And Stored into user Folder");
					
					PrintStream out0 = null;
					try {
					    out0 = new PrintStream(new FileOutputStream("User\\"+fn+".txt"));
					    out0.print(data);
					    
					}
					finally {
					    if (out0 != null) out0.close();
					}
				}
				else if(res.equalsIgnoreCase("Failure"))
				{
					if(data.equalsIgnoreCase("No data"))
					{
						JOptionPane.showMessageDialog(null,"File Does'nt Exist in CloudServer");
					}
				
					else
						
					JOptionPane.showMessageDialog(null,"THe Secret is Wrong u r Blocked");
				}
				
				
			}catch(Exception es){System.out.println(es);}
		
				
		}
		
		
		if(a1.getSource()==view)
		{
			String ip=JOptionPane.showInputDialog(null,"Enter the Edge Cloud Ip address");
			

			DBCon db = new DBCon();
			Connection con = db.getConnection();
			try
			{
				
				Socket sc = new Socket(ip,405);
				ObjectOutputStream dout = new ObjectOutputStream(sc.getOutputStream());
				dout.writeObject("send");
				
				ObjectInputStream din = new ObjectInputStream(sc.getInputStream());
				ArrayList l1 = (ArrayList)din.readObject();
				
				
				Iterator i1 = l1.iterator();
				
				
				
				Statement stmt = con.createStatement();
				Statement stmt1 = con.createStatement();
				while(i1.hasNext())
				{
						
						String fname = (String)i1.next();
						
						
						String sql = "select * from Rec where fname='"+fname+"'";
						ResultSet rs = stmt.executeQuery(sql);
						if(rs.next()==true)
						{
						}
						else if(rs.next()==false)
						{
							
							String sql1 = "insert into Rec values('"+fname+"')";
							stmt1.executeUpdate(sql1);
						}
							
				}
			new Viewfiles();
				
				
				
			}
			catch(Exception e1)
			{
				e1.printStackTrace();
			}

		}
		
	}
	public static void main(String[] args) 
	{
		new RemoteUser();
	}

}
