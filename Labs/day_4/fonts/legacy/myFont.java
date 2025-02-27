import java.applet.Applet;
import java.awt.*;
import java.awt.Font;


public class myFont extends Applet
{
	String[] s ;
	
	
	public void init(){
		
		Toolkit t= Toolkit.getDefaultToolkit();
		s = t.getFontList();

	}

	public void paint(Graphics g){
		
		int i ; 
		//Font current ;
		for ( i = 0 ; i < s.length ; i++)
			{
			Font current = new Font(s[i], Font.PLAIN, 50) ;
			g.setFont ( current  );
			g.drawString(s[i],50,(100+i*50));
			}


	}
}
