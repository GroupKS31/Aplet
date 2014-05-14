/*Простой аплет заголовка
Этот аплет создает поток для прокрутки сообщения,
содержащегося в переменой msg.
*/

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SimpleBanner extends JApplet implements ActionListener {
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<String> search = new ArrayList<String>();
	JButton button;
	Color red;
	Container cp = getContentPane();
	int col =10 ;
	int row =3 ;
	  public void init() 
	  {
		  JPanel jp= new JPanel();
		  String name[]={"a","b","c","d","e"};
		  int x[] = {0,400,200,300,500};
		  int y[] = {0,200,200,400,500};
		  jp.setLayout(null);
		  for(int i =0;i< 5;i++){
			  jp.add(getSector(x[i],y[i], 200, 200,name[i] ,col,row));
		  }
		  /*
		  JPanel jp= new JPanel();
		  JPanel jp1= new JPanel();
		  JPanel jp2= new JPanel();

		  jp1.setBackground(Color.BLUE);	
		  jp1.setBounds(100, 100, 350, 350);

		  jp2.setBackground(Color.BLUE);	
		  jp2.setBounds(500, 500, 350, 350);
		  jp.add(jp2);
		  jp.add(jp1);
		  
		  jp.setLayout(null);
		  jp1.setLayout(new GridLayout(row,col));
		  for(int i = 1; i <=row*col; i++)
	    	{
	    		button =new JButton("A"+i);
	    		buttons.add(button);
	    		jp1.add(button);
	    		button.setBackground(Color.green);
				button.addActionListener(this);				
	    	
	    	}
		  jp2.setLayout(new GridLayout(row,col));
		  for(int i = 1; i <=row*col; i++)
	    	{
	    		button =new JButton("B"+i);
	    		buttons.add(button);
	    		jp2.add(button);
	    		button.setBackground(Color.green);
				button.addActionListener(this);				
	    	
	    	}*/
		  cp.add(jp);
	  }	  
	  
	  private JPanel getSector(int x,int y,int width, int height,String name,int row, int col) 
	  {
		  JPanel jp= new JPanel();

		  jp.setBackground(Color.BLUE);	
		  jp.setBounds(x, y, width, height);
		  jp.setLayout(new GridLayout(row,col));
		  for(int i = 1; i <=row*col; i++)
	    	{
	    		button =new JButton(name+i);
	    		buttons.add(button);
	    		jp.add(button);
	    		search.add(name+i);
	    		button.setBackground(Color.green);
				button.addActionListener(this);				
	    	
	    	}
		  return jp;
	  }
	  
	  
	  public void actionPerformed(ActionEvent e) 
	  {	

		  search.indexOf(e.getActionCommand());
		  System.out.println(search.indexOf(e.getActionCommand()));
		  buttons.get(search.indexOf(e.getActionCommand())).setBackground(Color.RED);
		  //button.setBackground(Color.red);
		  
		  
	  }
	  public static void main(String[] args) {
		  
	  }
	}  ///:~
/*public class SimpleBanner extends JApplet {
  JButton b1 = new JButton("Button 1"),  b2 = new JButton("Button 2");
  public void init() {
    Container cp = getContentPane();
    cp.setLayout(new FlowLayout());
    cp.add(b1);
    cp.add(b2);
	b1.setBackground(Color.PINK);
	b1.setVisible(true);
	b1.setBounds(10, 50, 500, 20);
	//b1.addActionListener((ActionListener) this);
  }
  public static void main(String[] args) {
   // Console.run(new SimpleBanner(), 200, 50);
  }
} ///:~*/







/*
public class SimpleBanner extends Applet implements Runnable {
  String msg = " A Simple Moving Banner.";
  Thread t = null;
  
  // Установка цветов и инициализация потока
  public void init() {
    setBackground(Color.cyan);
    setForeground(Color.red);
    t = new Thread(this);
    t.start(); // Запуск потока
    t.suspend();
  }
    // Ожидание завершения инициализации потока.
   
  // Продолжение работы потока.
  public void start() {
    t.resume();
  }
  
  public void run() {
    char ch;
   // Бесконечный вывод заголовка на экран.
   for( ; ; ) {
      try {
        repaint();
        Thread.sleep(250);
        ch = msg.charAt(0);
        msg = msg.substring(1, msg.length());
      msg += ch;
       } catch(InterruptedException e){}
    }
   }
  // Пауза.
  public void stop() {
    t.suspend();
  }
  
  // Остановка потока при завершении аплета.
  public void destroy() {
    if(t != null) {
      t.stop();
      t = null;
    }
  }

  // Отображение заголовка на экране.
  public void paint(Graphics g) {
    g.drawString(msg, 50, 30);
  }
}*/



/*
StringBuffer string = new StringBuffer(e.getActionCommand());
System.out.print(string);
String sector = new String(""+string.charAt(0));
string =	 string.deleteCharAt(0);

if (sector.endsWith("a"))
{
	 JButton button = buttons.get(Integer.parseInt(string.toString())-1);
	 button.setBackground(Color.red);
	 System.out.println("sector = "+sector);
}
else
{
	 JButton button = buttons.get((row*col)+Integer.parseInt(string.toString())-1);	
	 button.setBackground(Color.red);		 
}*/