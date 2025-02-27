import java.applet.Applet;
import java.awt.*;
import java.awt.Font;


public class myFont extends Applet
{
	String[] s ;
	
	
	public void init(){
		
		GraphicsEnvironment t = GraphicsEnvironment.getLocalGraphicsEnvironment();  
		
		s = t.getAvailableFontFamilyNames();

	}

	public void paint(Graphics g){
		
		int i ; 
		

		for ( i = 0 ; i < s.length ; i++)
			{
			Font current = new Font(s[i], Font.PLAIN, 30) ;
			g.setFont ( current  );
			
			g.drawString(s[i],50,(i*30));
			}


	}
}
