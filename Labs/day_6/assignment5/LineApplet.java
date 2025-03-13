import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;





public class LineApplet extends Applet{
	
	class MyLine
	{
		class point
		{
		public int x = 0 ;
		public int y = 0 ;
		}
	
		public point startPoint ;
		public point endPoint ;
		
		public MyLine() {
		    startPoint = new point();
		    endPoint = new point();
        			}
		
		
	}
	
	
	class MouseHandler implements MouseListener, MouseMotionListener
	{
		/*MouseListener*/
	
		public void mouseClicked(MouseEvent e)
		{
		
		
		}
		
		public void mouseEntered(MouseEvent e){}
		
		public void mouseExited(MouseEvent e){}
		 
		public void mousePressed(MouseEvent e){
		
		if(Pressed == false)
		{
		
		line1.startPoint.x = e.getX();
		line1.startPoint.y = e.getY();
		
		line1.endPoint.x = e.getX();
		line1.endPoint.y = e.getY();
		
		repaint();
		
		Pressed = true ; 
		}
		

		
		}
		
		public void mouseReleased(MouseEvent e){
		
			Released = true ; 
			line1.endPoint.x = e.getX();
			line1.endPoint.y = e.getY();
			repaint();
		}
		

		/*MouseMotionListener*/
		public void mouseDragged(MouseEvent e){
		
		
		
		line1.endPoint.x = e.getX();
		
		line1.endPoint.y = e.getY();
		
		repaint();
		
		}
		public void mouseMoved(MouseEvent e){
		
		

		}
		
	}
	
	
	
	
	MyLine line1 = null ;
	
	MouseHandler handler = null ;
	
	boolean Pressed = false ; 
	boolean Released = false ; 
	
	public void init()
	{
		line1 = new MyLine();
		
		handler = new MouseHandler(); 
		
		addMouseListener(handler) ;
		addMouseMotionListener(handler);
		
		
	}


		
	public void paint(Graphics g)
	{
		g.drawLine(line1.startPoint.x,line1.startPoint.y,line1.endPoint.x,line1.endPoint.y);
	}


}

