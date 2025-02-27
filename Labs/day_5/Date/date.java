import java.applet.*;
import java.awt.*;
import java.util.*;



public class date extends Applet implements Runnable
{
	Thread th = null; 
	// Date dt = new Date() ;

	public void run()
	{
		while(true)
		{
		
		try{
		Thread.sleep(100);
		repaint();
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		
		}
	}
	
	public void init(){
	
	th = new Thread(this) ;
	
	th.start();	
	}
	public void paint(Graphics g){
	Date dt = new Date()       ;
	g.drawString(dt.toString(), (int)(this.getWidth() * 0.5) , (int)(this.getHeight() * 0.5) );
	}
	
	
}
