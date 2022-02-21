

 
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.*;
 
public class Results {
    public static void main(String[] args) {
        
    
  int count=0;
  int count1=0;
 
  
  String sname1=null;
  String sname2=null;
  
  

    	try
    	{
    		 DBCon db = new DBCon();
			 Connection con = db.getConnection();
             Statement stmt = con.createStatement();
             
    		ResultSet rs=stmt.executeQuery("select * from TPA");
    	
    		while(rs.next()==true)
    		{
    			String ar=rs.getString("Reason");
    		
    			
    			if(ar.equals("No Modified"))
    			{
    				sname1="No Modified";
    				count++;
    			}
    			
    			if(ar.equals("Modified"))
    			{
    				sname2="Modified";
    				count1++;
    			}
    			
    		}
    		
    		
    		
    	
    		
    		
    		   	DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    	        dataSet.setValue(count, sname1, "No Modification");
    	        dataSet.setValue(count1,  sname2,"Modifyied");
    	        
    	      
    	        JFreeChart chart = ChartFactory.createBarChart3D("Attacking and Protecting Data Privacy in Edge Cloud Collaborative Inference Systems", "Auditing Results", "Total Packets",
    	        dataSet, PlotOrientation.VERTICAL, true, true, true);
    	        ChartFrame chartFrame=new ChartFrame("Auditing Results:: No of Auditing Details",chart);
    	        chartFrame.setVisible(true);
    	        chartFrame.setSize(800,500);
    	}
    	catch(Exception ex)
    	{
    	System.out.println(ex);	
    		
    	}
    
}
}