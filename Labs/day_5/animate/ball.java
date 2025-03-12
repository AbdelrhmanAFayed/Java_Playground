import java.applet.*;
import java.awt.*;
import java.util.*;




class anim 
{
	public int xoffset = 0;
	public int yoffset = 0;
	public boolean xflag = true ;
	public boolean yflag = true ;	
	
	public boolean active = false ;	
	
	
	public final static int max = 5 ; 
	public static int current = 2 ;
	public static anim[] ref = new anim[max]; 
	
	
	void anim (int x , int y) 
	{
		this.xoffset = x ;
		this.yoffset = y ;
		this.active = true ;
	}
	
	
	void refresh (ball b)
	{	
		
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
		
		if(yoffset > b.getHeight() - 150 )
		{
			yflag = false ; 
		}
		
		if(yoffset < 0)
		{
			yflag = true ; 
		}
		
		if(xoffset > b.getWidth() - 150)
		{
			xflag = false ; 
		}
		
		if(xoffset < 0)
		{
			xflag = true ; 
		}
		
	
	}
	
	

}


public class ball extends Applet implements Runnable
{
	Thread th = null; 
	
	anim[] ref = null ; 
	
	Random rand = new Random();
	
	int r = 0 ;
	 
	int i = 0 ;
	
	
	public void run()
	{
		while(true)
		{
		
		try{
		
		for (i = 0 ; i < anim.current ; i++ )
		{
		ref[i].refresh(this);
			
		}
		
		
		Thread.sleep(5);
		
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
		
		for (i = 0 ; i < anim.current ; i++ )
		{
		
		ref[i] = new anim(50, 50 ) ;
		
			
		// ref[i] = new anim(( rand.nextInt( this.getWidth() ) ), ( rand.nextInt(this.getHeight() )) ) ;
		}
	
		th.start();	
	}
	public void paint(Graphics g){
	
		
		g.setColor(Color.RED);
		
		for (i = 0 ; i < anim.current ; i++ )
		{
			
		g.fillOval(ref[i].xoffset,ref[i].yoffset,150,150);
		}
		
		
	}
	
	
}
