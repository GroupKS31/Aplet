/*Простой аплет заголовка
Этот аплет создает поток для прокрутки сообщения,
содержащегося в переменой msg.
*/

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SimpleBanner extends JApplet implements ActionListener {

	
	
	//Connection con = DataSource.getConnection("user,",);
	ResultSet rs =null;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<String> search = new ArrayList<String>();
	ArrayList<Sector> sectors = new ArrayList<>();
	Connection c = null;
	JButton button;
	Color red;
	Container cp = getContentPane();
	  public void init() 
	  {
		  try {
			Class.forName("com.mysql.jdbc.Driver");	
			c = DriverManager.getConnection("jdbc:mysql://localhost/site", "root", "");
			Statement st = c.createStatement();
			rs = st.executeQuery("Select * FROM sector WHERE id_area = 28");
			while(rs.next()){
				sectors.add(new Sector(rs.getString("Name"),rs.getInt("RowCount"),rs.getInt("ColCount"),
						2.5*rs.getInt("positionX"),2.5*rs.getInt("positionY"), rs.getBoolean("scene"),
						2.5*rs.getInt("Width"),2.5*rs.getInt("Height"),rs.getInt("id")));
           
			}
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
System.out.println(sectors.size());
			
		  JPanel jp= new JPanel();
		  
		  jp.setLayout(null);
		  for(int i =0;i< sectors.size();i++){
			  Sector sector = sectors.get(i);
			  jp.add(getSector((int)sector.x,(int)sector.y,(int)sector.wi,(int)sector.he,sector.SectorName ,(int)sector.col,(int)sector.row,sector.scene,sector.Sector_id));
		  }

		  cp.add(jp);
	  }	  
	  
	  public class Sector
	  {
		  int Sector_id;
		  String SectorName ;
		  double row;
		  double col;
		  double x;
		  double y;
		  boolean scene = false;
		  double wi;
		  double he;
		  
		  public Sector(String SectorName,double row, double col,double x, double y, boolean scene,double wi,double he, int Sector_id)
		  {
			  this.Sector_id=Sector_id;
			  this.SectorName=SectorName;
			  this.row=row;
			  this.col=col;
			  this.x=x;
			  this.y=y;
			  this.scene=scene;
			  this.wi=wi;
			  this.he=he;
		  }
	  }
	  

	  
	  private JPanel getSector(int x,int y,int width, int height,String name,int row, int col, boolean scene, int Sector_id) 
	  {
		  JPanel jp= new JPanel();

		  jp.setBackground(Color.BLUE);	
		  jp.setBounds(x, y, width, height);
		  jp.setLayout(new GridLayout(row,col));
		  
		  for(int i = 1; i <=row*col && scene!=true; i++)
	    	{
	    		button =new JButton(name+i);
	    		buttons.add(button);
	    		jp.add(button);
	    		search.add(name+i);
	    		button.setBackground(Color.green);
	    		button.setFont(new Font("Arial",Font.CENTER_BASELINE,10));
				button.addActionListener(this);				
	    	
	    	}
		
		  return jp;
	  }
	  
	  
	  public void actionPerformed(ActionEvent e) 
	  {	

		  search.indexOf(e.getActionCommand());
		//  System.out.println(search.indexOf(e.getActionCommand()));
		  String str1 = new StringBuffer(e.getActionCommand()).substring(1);
		  int position = Integer.parseInt(str1);
			 int i =0;
			 int index = 0;
			 Sector sector = null;
			 while(i< sectors.size()){
				 String str=e.getActionCommand();
				 
				 sector = sectors.get(i);
				 if(sector.SectorName.equals("B")) break;
				 i++;
			 }
			
			 int col = (int) (position%sector.row);
			 int row = (int)(position/sector.row)+1;
			 System.out.println("sector"+sector.SectorName+"col ="+col+"row="+row);
		  buttons.get(search.indexOf(e.getActionCommand())).setBackground(Color.RED);
		 //rs = st.executeQuery("INSERT INTO bought_place(`id`,`Sector_id`, `row_number`, `col_number`, `user_card`, `user_name`, `user_phone`) VALUES ([value-1],[value-2],[value-3],[value-4],[value-5],[value-6],[value-7])
		//			");
		    //button.setBackground(Color.red);
		  
		  
	  }
	  public static void main(String[] args) {
		 
	  }
	  
}  