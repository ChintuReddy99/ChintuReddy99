import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.net.Socket;
import java.security.DigestInputStream;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.crypto.Cipher;
import javax.swing.*;
import javax.swing.border.Border;

public class DataOwner extends JFrame implements ActionListener
{
	JPanel p1;
	JTextArea t1;
	JScrollPane pane;
	JButton up,br,del,encrypt;
	
	MenuBar mbr;
	Menu File;
	MenuItem i1;
	
	JLabel l1,l2;
	public Font f = new Font("Bookman Old Style", Font.BOLD, 25);
	public Font f1 = new Font("Bookman Old Style", Font.BOLD, 18);
	public Font f2 = new Font("Bookman Old Style", Font.BOLD, 16);
	public Font f3 = new Font("Bookman Old Style", Font.BOLD, 23);
	public Font f4 = new Font("Bookman Old Style", Font.BOLD, 15);
	
	String path1;
	Cipher encoder = null; 
	Key prKey;
	public static Key pubKey;
	
	String keyWord = "ef50a0ef2c3e3a5fdf803ae9752c8c66";
	
	DataOwner()
	{
		p1=new JPanel();
		p1.setLayout(null);
		setTitle("DataOwner ::Attacking and Protecting Data Privacy in Edge Cloud Collaborative Inference Systems");
		
		t1=new JTextArea();
		pane=new JScrollPane();
		
		t1.setColumns(100);
		t1.setBackground(new Color(193,205,205));
		t1.setFont(f1);
		t1.setRows(200);
		t1.setName("tf");
		pane.setName("pane");
		pane.setViewportView(t1);
		pane.setBounds(80,125,450,350);
		
		Border b11 = BorderFactory.createBevelBorder(0);
		l1 = new JLabel();
		l1.setBorder(b11);
		l1.setBounds(35, 485, 540, 70);
		
		Border b22 = BorderFactory.createBevelBorder(0);
		l2 = new JLabel();
		l2.setBorder(b22);
		l2.setBounds(35, 115, 540, 370);
		
		
		mbr=new MenuBar();
		setMenuBar(mbr);
		File=new Menu("File");
		i1=new MenuItem("exit");
		File.add(i1);
		mbr.add(File);
		
		i1.addActionListener(this);
		
		br  = new JButton ("Browse");
		up  = new JButton ("Upload");
		del = new JButton("Delete ");
		encrypt=new JButton("Encrypt");
	
		
		
		br.setBounds(70,505,100,30);
		up.setBounds(190,505,100,30);
		del.setBounds(320,505,100,30);
		encrypt.setBounds(440,505,100,30);
		
		
		br.addActionListener(this);
		up.addActionListener(this);
		del.addActionListener(this);
		encrypt.addActionListener(this);
		
		ImageIcon im1 = new ImageIcon(this.getClass().getResource("images/DOBack.png"));
		JLabel imageLabel1 = new JLabel();
		 imageLabel1.setIcon(im1);
		 imageLabel1.setBounds(10, 30, 620, 550);
		
		
		p1.setBackground(Color.orange);
		p1.add(pane);
		p1.add(br);
		p1.add(up);
		p1.add(del);
		p1.add(encrypt);
		p1.add(l1);p1.add(l2);p1.add(imageLabel1);
		
		add(p1);
		setSize(700,650);
		setVisible(true);
		
		
	}

	
	public void actionPerformed(ActionEvent ae) 
	{
		String strLine = null;
		String newline = "\n";
		
		
		if(ae.getSource()==br)
		{
			JFileChooser chooser = new JFileChooser();

			try {

				File f = new File(new File("filename.txt").getCanonicalPath());

				chooser.setSelectedFile(f);
			} catch (IOException e1) {
			}

			
			int retval = chooser.showOpenDialog(br);
			if (retval == JFileChooser.APPROVE_OPTION) {
				File field = chooser.getSelectedFile();
				 path1=field.getAbsolutePath();
			}

			File curFile = chooser.getSelectedFile();

			try {

				FileInputStream fstream = new FileInputStream(curFile);

				DataInputStream ins = new DataInputStream(fstream);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						ins));

				StringBuffer buffer = new StringBuffer();
				while ((strLine = br.readLine()) != null) {

					System.out.println(strLine);
					buffer.append(strLine + "\n");

				}
				t1.setText(buffer.toString());

			} catch (Exception e1) {
				System.err.println("Error: " + e1.getMessage());
			}
		}
		
		if(ae.getSource()==del)
		{
			
			
			String cs1="CS1";
			String cs2="CS2";
			String cs3="CS3";
			String cs4="CS4";
				Socket client ;
				DataInputStream dis1,dis2,dis3,dis4;

				String fname = JOptionPane.showInputDialog(null, "Please Enter the File Name");
				
				
				String request="delete";
				
					Socket client1,client2,client3,client4;
					DataOutputStream ds1,ds2,ds3,ds4;
					if(cs1.equalsIgnoreCase("CS1"))
					{
						try
						{
							client1 = new Socket("localhost",3637);
							ds1 = new DataOutputStream(client1.getOutputStream());
							ds1.writeUTF(fname);
							
							
							dis1 = new DataInputStream(client1.getInputStream());
							String msg=dis1.readUTF();
						
							
							
						
						}
						catch(Exception e1){e1.printStackTrace();}
					}
					if(cs2.equalsIgnoreCase("CS2"))
					{
						try
						{
							client2 = new Socket("localhost",3638);
							ds2 = new DataOutputStream(client2.getOutputStream());
							ds2.writeUTF(fname);
							
							
							dis2 = new DataInputStream(client2.getInputStream());
							String msg=dis2.readUTF();
							
							
						
						}
						catch(Exception e1){e1.printStackTrace();}
					}
					if(cs3.equalsIgnoreCase("CS3"))
					{
						try
						{
							client3 = new Socket("localhost",3639);
							ds3 = new DataOutputStream(client3.getOutputStream());
							ds3.writeUTF(fname);
							
							
							dis3 = new DataInputStream(client3.getInputStream());
							String msg=dis3.readUTF();
							
							
						
						}
						catch(Exception e1){e1.printStackTrace();}
					}
					if(cs4.equalsIgnoreCase("CS4"))
					{
						try
						{
							client4 = new Socket("localhost",3630);
							ds4 = new DataOutputStream(client4.getOutputStream());
							ds4.writeUTF(fname);
							
							
							dis4 = new DataInputStream(client4.getInputStream());
							String msg=dis4.readUTF();
							
							
						
						}
						catch(Exception e1){e1.printStackTrace();}
					}
					
					JOptionPane.showMessageDialog(null,"File Deleted Successfully");
					

		}
		
		
		if(ae.getSource()==encrypt)
		{
			AES a1=new AES();
			try
			{
				String data=t1.getText();
				String encdata=a1.encrypt(data,keyWord);
				
				t1.setText("");
				t1.setText(encdata);
				
			}catch(Exception ess){System.out.println(ess);}
		}
		if(ae.getSource()==up)
		{

			DBCon db=new DBCon();
			String fname = JOptionPane.showInputDialog(null, "Please Enter the File Name");
			String ip = JOptionPane.showInputDialog(null, "Please Enter the IP Address Of Edge Cloud");
		
			try
			{
				 KeyPairGenerator kg = KeyPairGenerator.getInstance("RSA"); 
				 encoder = Cipher.getInstance("RSA"); 
				 KeyPair kp = kg.generateKeyPair(); 
				 prKey = kp.getPrivate(); 
				 pubKey = kp.getPublic(); 
				 
				 
				 
				// RSA produces 1024 bits Key
				 
					byte[] pub = pubKey.getEncoded();
				 byte[] priv = prKey.getEncoded();
				 
				 System.out.println("PRIVATE KEY"+priv);
				 System.out.println("PUBLIC KEY"+pub);
				 System.out.println("File Name"+fname);
				 
				 KeyGenerator gen = new KeyGenerator();
				 String sk=String.valueOf(gen.getKeys());
				 
				 //Now read the Contents from file and store it into owner Folder
				 
				 FileInputStream fis = new FileInputStream(path1);
				 byte b[] = new byte[fis.available()];
				 fis.read(b);
				 String content2 = new String(b);
				 
				 AES a2=new AES();
				 String content=a2.encrypt(content2,keyWord);
				 
				 PrintStream out = null;
					try {
					    out = new PrintStream(new FileOutputStream("Owner\\"+"temp\\"+fname));
					    out.print(content);
					}
					finally {
					    if (out != null) out.close();
					}
					
			// Now calling Split function to split the file into 8 packets 		
					
					
					SplitFile sp = new SplitFile();
					sp.splitFile(new File("Owner\\"+"temp\\"+fname),4, 1024);
					int len = fname.length();
					String fil = fname.substring(0, len-5);
					
					
					System.out.println("The file is " +fname );
					System.out.println("the length of the File is "+ len);
					System.out.println("The file name without extension " +fil);
					
					
					MessageDigest md = MessageDigest.getInstance("SHA1");
					System.out.println("....Splitting Started...,");
					
					// Packet 1
					FileInputStream fis1 = new FileInputStream("Owner\\"+"temp\\"+fil+"1"+".txt");
					byte bs1[] = new byte[fis1.available()];
					fis1.read(bs1);
					
					String split1 = new String(bs1);
					fis1.close();
					FileInputStream fis11 = new FileInputStream("Owner\\"+"temp\\"+fil+"1"+".txt");
					DigestInputStream dis1 = new DigestInputStream(fis11, md);
					BufferedInputStream bis1 = new BufferedInputStream(dis1);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b1 = bis1.read();
						if (b1 == -1)
							break;
					}
		 
					BigInteger bi1 = new BigInteger(md.digest());
					String spl1 = bi1.toString();
					String	 h1 = bi1.toString(16);
					System.out.println("The Mac address for Packet1 " + h1);
					
				 //Packet 2
					
					FileInputStream fis2=new FileInputStream("owner\\"+"temp\\"+fil+"2"+".txt");
					byte bs2[]=new byte[fis2.available()];
					fis2.read(bs2);
					
					String split2=new String(bs2);
					fis2.close();
					FileInputStream fis22=new FileInputStream("owner\\"+"temp\\"+fil+"2"+".txt");
					DigestInputStream dis2 = new DigestInputStream(fis22, md);
					BufferedInputStream bis2 = new BufferedInputStream(dis2);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b2 = bis2.read();
						if (b2 == -1)
							break;
					}
		 
					BigInteger bi2 = new BigInteger(md.digest());
					String  h2 = bi2.toString(16);
					System.out.println("the Mac address of Second Packet"+ h2);
			
				 ///Packet 3
					FileInputStream fis3 = new FileInputStream("Owner\\"+"temp\\"+fil+"3"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
					byte bs3[] = new byte[fis3.available()];
					fis3.read(bs3);
					String split3 = new String(bs3);
					FileInputStream fis33 = new FileInputStream("Owner\\"+"temp\\"+fil+"3"+".txt");
					DigestInputStream dis3 = new DigestInputStream(fis33, md);
					BufferedInputStream bis3 = new BufferedInputStream(dis3);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b3 = bis3.read();
						if (b3 == -1)
							break;
					}
		 
					BigInteger bi3 = new BigInteger(md.digest());
				String h3 = bi3.toString(16);
					System.out.println("The Mac address of Packet 3" +h3);
					
					
					//Packet 4
					
					FileInputStream fis4 = new FileInputStream("Owner\\"+"temp\\"+fil+"4"+".txt");//C:\java\mtechproject\cloudcomputing\pra1.txt
					byte bs4[] = new byte[fis4.available()];
					fis4.read(bs4);
					String split4 = new String(bs4);
					
					FileInputStream fis44 = new FileInputStream("Owner\\"+"temp\\"+fil+"4"+".txt");
					DigestInputStream dis4 = new DigestInputStream(fis4, md);
					BufferedInputStream bis4 = new BufferedInputStream(dis4);
		 
					//Read the bis so SHA1 is auto calculated at dis
					while (true) {
						int b4 = bis4.read();
						if (b4 == -1)
							break;
					}
		 
					BigInteger bi4 = new BigInteger(md.digest());
					String	 h4 = bi4.toString(16);
					System.out.println("The Mac address of Packet 4" +h4);
					
					
					
					
					
					Connection connect=db.getConnection();
					Statement stmt = connect.createStatement();
					String query = "insert into OwnerFiles(Fname,PubK,PrivK,SK,s1hash,s2hash,s3hash,s4hash) values('"+fname+"','"+pub+"','"+priv+"','"+sk+"','"+h1+"','"+h2+"','"+h3+"','"+h4+"')";	
					stmt.executeUpdate(query);
					
					
					Statement stmt2 = connect.createStatement();
					String query2 = "select * from OwnerFiles where FName='"+fname+"'   ";
					ResultSet rs=stmt.executeQuery(query2);
					
					if(rs.next()==true)
					{
						 String pk=rs.getString(2);
						 String privk=rs.getString(3);
						 String key=rs.getString(4);
						
						 String s1hash = rs.getString(5);
						 String s2hash = rs.getString(6);
						 String s3hash = rs.getString(7);
						 String s4hash = rs.getString(8);
						
						 
						 
						 Socket socket2 = new Socket(ip, 1111);
						 DataOutputStream dos2 = new DataOutputStream(socket2.getOutputStream());
						 
						 
							dos2.writeUTF(fil);
							dos2.writeUTF(pk);
							dos2.writeUTF(privk);
							dos2.writeUTF(key);
							
							dos2.writeUTF(s1hash);
							dos2.writeUTF(s2hash);
							dos2.writeUTF(s3hash);
							dos2.writeUTF(s4hash);
							
							dos2.writeUTF(content);
							dos2.writeUTF(split1);
							dos2.writeUTF(split2);
							dos2.writeUTF(split3);
							dos2.writeUTF(split4);
							
							
							
							
							DataInputStream dis55=new DataInputStream(socket2.getInputStream());
							String msg=dis55.readUTF();
							
							
							if(msg.equalsIgnoreCase("doz"))
							{
								String cname=dis55.readUTF();
								String date=dis55.readUTF();
								JOptionPane.showMessageDialog(null,cname+" Cloud is IN dOZE OFF STATE till "+date);
							}
							else 
							{
								JOptionPane.showMessageDialog(null, "File Details Uploaded Successfully ", "Message From TPA", JOptionPane.INFORMATION_MESSAGE);
							}
							
							
					}
					
					
					
					
					
					
				
			}catch(Exception es){System.out.println(es);}
		
			
				
		}
	}
	
	public static void main(String[] args) 
	{
		new DataOwner();
	}
	
}