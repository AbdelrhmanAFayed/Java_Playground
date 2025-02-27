import java.applet.*;
import java.awt.*;
import java.util.*;



public class txt extends Applet implements Runnable
{
	Thread th = null; 
	int offset = 0;
	

	public void run()
	{
		while(true)
		{
		
		try{
		Thread.sleep(5);
		
		offset += 10 ;
		repaint();
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		
		if(offset > this.getWidth())
		{
		offset = 0 ;
		}
		
		}
	}
	
	public void init(){
	
		th = new Thread(this) ;
	
		th.start();	
	}
	public void paint(Graphics g){
		
		
		g.setColor(Color.RED);
		g.setFont(new Font("Times New Roman",Font.BOLD,50));
		
		g.drawString("JAVA World", offset , (int)(this.getHeight() * 0.5) );
		
	}
	
	
}
