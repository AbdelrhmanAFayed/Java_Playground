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
		if(state < lines.length)
		{

		lines[state] = new MyLine() ; 
		
		
		
		lines[state].startPoint.x = e.getX();
		lines[state].startPoint.y = e.getY();
		
		lines[state].endPoint.x = e.getX();
		lines[state].endPoint.y = e.getY();
		
		repaint();
		
		
		
		
		}

		
		}
		
		public void mouseReleased(MouseEvent e){
		
		if (state < lines.length) {
			lines[state].endPoint.x = e.getX();
			lines[state].endPoint.y = e.getY();
			repaint();
			
			state++ ;

     
  			  }
		}
		

		/*MouseMotionListener*/
		public void mouseDragged(MouseEvent e){
		
		  if (state < lines.length && lines[state] != null) {  
			 lines[state].endPoint.x = e.getX();
			lines[state].endPoint.y = e.getY();
			repaint();
   		 }
		
		}
		public void mouseMoved(MouseEvent e){
		
		

		}
		
	}
	
	
	
	
	MyLine[] lines = new MyLine[3]; 
	
	MouseHandler handler = null ;
	
	int state = 0 ;
	int itr = 0  ;
	

	
	public void init()
	{
		
		handler = new MouseHandler(); 
		
		addMouseListener(handler) ;
		addMouseMotionListener(handler);
		
		
	}


		
	public void paint(Graphics g)
	{
		for(itr = 0 ; itr < state ; itr++)
		{
	if (lines[itr] != null) {	g.drawLine(lines[itr].startPoint.x,lines[itr].startPoint.y,lines[itr].endPoint.x,lines[itr].endPoint.y);
		}
		}
	}


}

