/*������� ����� ���������
���� ����� ������� ����� ��� ��������� ���������,
������������� � ��������� msg.
*/

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JApplet;
import javax.swing.JButton;

public class SimpleBanner extends JApplet implements ActionListener {
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	JButton button;
	Color red;
	Container cp = getContentPane();
	  public void init() 
	  {
		  int col =2 ;
		  int row =3 ;
		cp.setLayout(new GridLayout(row,col));
	    for(int i = 1; i <=row*col; i++)
	    	{
	    		button =new JButton("����� "+i);
	    		buttons.add(button);
	    		cp.add(button);
	    		button.setBackground(Color.green);
				button.addActionListener(this);
				
	    	
	    	}
	    
	  }
	  public void actionPerformed(ActionEvent e) 
	  {			
		 
		 StringBuffer buffer = new StringBuffer(e.getActionCommand());
		 String string = buffer.substring(6);
		 JButton button = buttons.get(Integer.parseInt(string)-1);
		 button.setBackground(Color.red);
		// System.out.println(string);
	
		  
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
  
  // ��������� ������ � ������������� ������
  public void init() {
    setBackground(Color.cyan);
    setForeground(Color.red);
    t = new Thread(this);
    t.start(); // ������ ������
    t.suspend();
  }
    // �������� ���������� ������������� ������.
   
  // ����������� ������ ������.
  public void start() {
    t.resume();
  }
  
  public void run() {
    char ch;
   // ����������� ����� ��������� �� �����.
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
  // �����.
  public void stop() {
    t.suspend();
  }
  
  // ��������� ������ ��� ���������� ������.
  public void destroy() {
    if(t != null) {
      t.stop();
      t = null;
    }
  }

  // ����������� ��������� �� ������.
  public void paint(Graphics g) {
    g.drawString(msg, 50, 30);
  }
}*/