
abstract class GeoShape
{
	protected double dim1 ;
	protected double dim2 ;
	
	GeoShape(double Num1,double Num2)
	{
		this.dim1 = Num1;
		this.dim2 = Num2;
	
	}
	
	abstract public double CalacArea();
	
	
	public  static double SumAreas(GeoShape Shape1 , GeoShape Shape2 , GeoShape Shape3)
	{
		return(Shape1.CalacArea() + Shape2.CalacArea() + Shape3.CalacArea()) ;	
	}

}

class Rectangle extends GeoShape
{
	Rectangle(double Num1,double Num2)
	{
		super(Num1 , Num2);
	}
	
	public void setDim(double Num1 , double Num2 )
	{
		this.dim1 = Num1;
		this.dim2 = Num2;
	}
	
	public double CalacArea()
	{
		return (dim1 * dim2) ;
	}
	
	
	
} 

class Triangle extends GeoShape
{
	Triangle(double Num1,double Num2)
	{
		super(Num1 , Num2);
	}
	
	public void setDim(double Num1 , double Num2 )
	{
		this.dim1 = Num1;
		this.dim2 = Num2;
	}
	
	public double CalacArea()
	{
		return (0.5 * dim1 * dim2) ;
	}
		

} 

class Circle extends GeoShape
{
	Circle(double Num1)
	{
		super(Num1 , 0);
	}
	
	public void setDim(double Num1 )
	{
		this.dim1 = Num1 ;
	}
	
	public double CalacArea()
	{
		return ( 3.14 * dim1 *dim1) ;
	}
		
} 




public class Main
{
	public static void main (String [] args)
	{
	
	
	Circle Shape1 = new Circle(5) ; 
	Rectangle Shape2 = new Rectangle(5,5) ;
	Triangle Shape3 = new Triangle(5,5) ;
	
	double result = Shape1.CalacArea();
	
	System.out.println(result);
	
	result = Shape2.CalacArea(); 
	
	System.out.println(result);
	
	result = Shape3.CalacArea();
	
	System.out.println(result);
		
	result = GeoShape.SumAreas(Shape1,Shape2,Shape3) ;
	
	System.out.println(result);
	
	
	
	
	
	
	
	
	
	
	
	}

}
