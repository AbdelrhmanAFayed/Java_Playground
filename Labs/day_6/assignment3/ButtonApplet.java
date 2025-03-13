import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;



class anim 
{
	public int xoffset = 0;
	public int yoffset = 0;
	public boolean xflag = true ;
	public boolean yflag = true ;	
		
	
	
	void anim (int x , int y) 
	{
		this.xoffset = x ;
		this.yoffset = y ;
	}
	
	
	void refresh (ButtonApplet b)
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






public class ButtonApplet extends Applet 
{
	Thread th = null; 
	
	anim ref = null ; 
	
	boolean state = false ; 
	boolean called = true ; 
	
	class task implements Runnable 
	{
	public void run()
	{
		while(true)
		{
		
		try{
	
		ref.refresh(ButtonApplet.this);
		
		
		
		Thread.sleep(5);
		
		repaint();
		
		
		
		}
		catch (InterruptedException e)
		{
		e.printStackTrace();
		}
		
		
		
		}
	}
	}
	
	int x;

	Button b;
	
	Button c;
	
	
	

	
	
	public void init(){
	
		th = new Thread(new task()) ;
		
		ref = new anim() ;
		
		
		
		
		b = new Button("Start");
		b.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					
					if(called == false)
						{
						state = true ;
						th.resume();
						}
					else if(called == true)
						{
						th.start();
						called = false ;
						state = true ;
						}
					else {}
					
					}
				});
		add(b);
		
		
		c = new Button("Pause");
		
		c.addActionListener(new MyButtonListener());
		add(c);
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.RED);
		g.fillOval(ref.xoffset,ref.yoffset,150,150);
		
		}
	
	class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev)
		{
			if(state == true)
				{
				th.suspend();
				state = false ;
				}
			else {}
		}
	}

}
