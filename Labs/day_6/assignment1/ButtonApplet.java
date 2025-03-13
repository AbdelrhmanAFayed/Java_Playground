import java.applet.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class ButtonApplet extends Applet{
	int x;
	Button b;
	
	Button c;
	
	
	public void init(){
		b = new Button("Increment");
		b.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent ev){
					x++ ;
					repaint() ;
					}
				});
		add(b);
		
		
		c = new Button("Decrement");
		
		c.addActionListener(new MyButtonListener());
		add(c);
	}
	
	public void paint(Graphics g){
		g.drawString("Click Count =" + x, getWidth()/2, getHeight()/2);
	}
	
	class MyButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent ev)
		{
			x-- ;
			repaint() ;
		}
	}

}
