import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.net.Socket;


public class Regenarate 
{
	public static void Generate(String file,String cname)
	{
		try
		
		{
			
			System.out.println("ReQuest For regeneration");
			if(cname.equalsIgnoreCase("cs1"))
			{
				FileInputStream fs = new FileInputStream("Trustee\\temp\\"+file+"1"+".txt");
				byte bs1[] = new byte[fs.available()];
				fs.read(bs1);
				String f1 = new String(bs1);
				
				Socket st=new Socket("localhost",7891);   //CS5 ip
				DataOutputStream ds1=new DataOutputStream(st.getOutputStream());
				ds1.writeUTF(file);
				ds1.writeUTF(f1);
				ds1.writeUTF("cs1");
				
				DataInputStream dis2=new DataInputStream(st.getInputStream());
				String msg=dis2.readUTF();
				
				if(msg.equalsIgnoreCase("success"))
				{
					PrintStream out0 = null;
					try {
					    out0 = new PrintStream(new FileOutputStream("Trustee\\REGEN\\"+file+"1"+".txt"));
					    out0.print(f1);
					    
					}
					finally {
					    if (out0 != null) out0.close();
					}
					
					System.out.println("Regenarated Successfully");
				}
				
				
			}
			if(cname.equalsIgnoreCase("cs2"))
			{
				FileInputStream fs = new FileInputStream("Trustee\\temp\\"+file+"2"+".txt");
				byte bs1[] = new byte[fs.available()];
				fs.read(bs1);
				String f2 = new String(bs1);
				
				Socket st1=new Socket("localhost",7891);   //CS5 ip
				DataOutputStream ds2=new DataOutputStream(st1.getOutputStream());
				ds2.writeUTF(file);
				ds2.writeUTF(f2);
				ds2.writeUTF("cs2");
				
				DataInputStream dis2=new DataInputStream(st1.getInputStream());
				String msg=dis2.readUTF();
				
				if(msg.equalsIgnoreCase("success"))
				{
					PrintStream out0 = null;
					try {
					    out0 = new PrintStream(new FileOutputStream("Trustee\\REGEN\\"+file+"2"+".txt"));
					    out0.print(f2);
					    
					    System.out.println("File Stored In REGEN");
					    
					}
					finally {
					    if (out0 != null) out0.close();
					}
					
					System.out.println("Regenarated Successfully");
				}
			}
			
			if(cname.equalsIgnoreCase("cs3"))
			{
				FileInputStream fs = new FileInputStream("Trustee\\temp\\"+file+"3"+".txt");
				byte bs1[] = new byte[fs.available()];
				fs.read(bs1);
				String f3 = new String(bs1);
				
				Socket st2=new Socket("localhost",7891);   //CS5 ip
				DataOutputStream ds3=new DataOutputStream(st2.getOutputStream());
				ds3.writeUTF(file);
				ds3.writeUTF(f3);
				ds3.writeUTF("cs3");
				
				DataInputStream dis2=new DataInputStream(st2.getInputStream());
				String msg=dis2.readUTF();
				
				if(msg.equalsIgnoreCase("success"))
				{
					PrintStream out0 = null;
					try {
					    out0 = new PrintStream(new FileOutputStream("Trustee\\REGEN\\"+file+"3"+".txt"));
					    out0.print(f3);
					    
					}
					finally {
					    if (out0 != null) out0.close();
					}
					
					
				}
				System.out.println("Regenarated Successfully");
				
				
			}
			if(cname.equalsIgnoreCase("cs4"))
			{
				FileInputStream fs = new FileInputStream("Trustee\\temp\\"+file+"4"+".txt");
				byte bs1[] = new byte[fs.available()];
				fs.read(bs1);
				String f4 = new String(bs1);
				
				Socket st3=new Socket("localhost",7891);   //CS5 ip
				DataOutputStream ds4=new DataOutputStream(st3.getOutputStream());
				ds4.writeUTF(file);
				ds4.writeUTF(f4);
				ds4.writeUTF("cs4");
				
				DataInputStream dis2=new DataInputStream(st3.getInputStream());
				String msg=dis2.readUTF();
				
				if(msg.equalsIgnoreCase("success"))
				{
					PrintStream out0 = null;
					try {
					    out0 = new PrintStream(new FileOutputStream("Trustee\\REGEN\\"+file+"4"+".txt"));
					    out0.print(f4);
					    
					}
					finally {
					    if (out0 != null) out0.close();
					}
					
					
				}
				System.out.println("Regenarated Successfully");
			}
		
		}catch(Exception es){System.out.println(es);}
		
	
	}
	
}
