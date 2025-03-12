import java.applet.*;
import java.awt.*;
import java.util.*;





public class ball extends Applet implements Runnable
{
	Thread th = null; 
	int xoffset = 0;
	int yoffset = 0;
	boolean xflag = true ;
	boolean yflag = true ;	

	public void run()
	{
		while(true)
		{
		
		try{
		Thread.sleep(5);
		
		repaint();
		if(xflag)
		{
		xoffset++;
		}
		else
		{
		xoffset-- ;
		}
		
		if(yflag)
		{
		yoffset++;
		}
		else
		{
		yoffset-- ;
		}
		
		if(yoffset > this.getHeight() - 150 )
		{
		yflag = false ; 
		}
		
		if(yoffset < 0)
		{
		yflag = true ; 
		}
		
		if(xoffset > this.getWidth() - 150)
		{
		xflag = false ; 
		}
		
		if(xoffset < 0)
		{
		xflag = true ; 
		}
		
		
		
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		
		//if(offset > this.getWidth())
		//{
		//offset = 0 ;
		//}
		
		}
	}
	
	public void init(){
	
		th = new Thread(this) ;
	
		th.start();	
	}
	public void paint(Graphics g){
		
		
		g.setColor(Color.RED);
	
		
		g.fillOval(xoffset,yoffset,150,150);
		
	}
	
	
}
