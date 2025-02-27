import java.applet.Applet;
import java.awt.*;






public class lamp extends Applet
{

	
	
	public void init(){
		
	
	}

	public void paint(Graphics g){
	
	g.setColor(Color.YELLOW);
	g.fillOval(100,50,150,50);
	
	g.fillOval(100,170,30,60);
	g.fillOval(220,170,30,60);
	g.fillOval(150,150,50,100);
	
	g.setColor(Color.BLACK);
	
	g.drawOval(100,50,150,50);
	
	g.drawOval(150,150,50,100);
	
	g.drawOval(100,170,30,60);
	g.drawOval(220,170,30,60);
	
	g.drawLine(100,70,20,300);
	g.drawLine(250,70,320,300);
	
	g.drawLine(150,350,80,500);
	g.drawLine(200,350,280,500);
	
	g.drawRect(80,500,200,50);
	
	
	g.drawArc(20,250,300,100,180,180);


	}
}
