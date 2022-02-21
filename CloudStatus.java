

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import java.io.*;
import java.util.*;


import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;

import java.net.*;




public class CloudStatus extends JFrame 

{
 
 JPanel panel;
  Vector data;
Vector heading;
JScrollPane pane;
JTable table;
int v,h;
String s,d,call,dt;
Container c;

JLabel imglabel;
CloudStatus() 
  {

setTitle("Cloud Status Details::Attacking and Protecting Data Privacy in Edge Cloud Collaborative Inference Systems");
c= getContentPane();
c.setLayout (new FlowLayout());



c.setBackground(new Color(192,192,192));
setSize(600,400);
setVisible(true);

try { 
	
	 
	 Vector heading = new Vector();
	 
	 heading.addElement("CloudServerName");
	 heading.addElement("Cloud Status");
	 heading.addElement("Reason");
	 heading.addElement("Affected File");
	 
	 
	
	 
	 
			  Vector data=new Vector();
			  DBCon db=new DBCon();
	            Connection con=db.getConnection();
	             Statement stmt = con.createStatement();
	             
	             
	             String query = "SELECT * From CStatus";
	             ResultSet rs = stmt.executeQuery(query);



	    


	ResultSetMetaData rsm=rs.getMetaData();
	int col=rsm.getColumnCount();



	            while(rs.next())
	             {
	Vector row = new Vector();
	  for(int i = 1; i <=col; i++){
	                   row.addElement(rs.getObject(i));

	             }

	data.addElement(row);
	             }
			  
			JTable table = new JTable(data,heading);
			  
			  pane = new JScrollPane(table);
			 
			  pane.setBounds(100,50,450,500);
			  c.add(pane);
			 // c.add(image);
	 } 
	 catch(Exception ex) {ex.printStackTrace();} 




  }





}