
class Complex
{
	private double real ;
	private double img  ;
	
	
	public void setReal(double r)
	{
		this.real = r ;
	}
	
	public void setImg(double i)
	{
		this.img = i ;
	}
	
	public double getReal()
	{
		return real ;
	}
	
	public double getImg()
	{
		return img ;
	}
	
	public void printReal()
	{
		System.out.print(this.real) ;
	
	}
	
	public void printImg()
	{
		System.out.print(this.img) ;
	
	}
		
	public static Complex add(Complex Num1 , Complex Num2 )
	{ 
		Complex result = new Complex() ;
		
		result.real = Num1.real + Num2.real ;
		result.img = Num1.img + Num2.img ;
		
		return result ;
		
	
	}
	
	public static Complex sub(Complex Num1 , Complex Num2 )
	{
		Complex result = new Complex() ;
		
		result.real = Num1.real - Num2.real ;
		result.img = Num1.img - Num2.img ;
		
		return result ;
	}		
	
	public void printComplex()
	{
		System.out.print(this.real) ;
		if(this.img < 0)
		{
		System.out.print(" - ") ;
		System.out.print(Math.abs(this.img)) ;
		System.out.print("i") ;
		}
		else
		{
		System.out.print(" + ") ;
		System.out.print(this.img) ;
		System.out.print("i") ;
		}
		System.out.println() ;
		
	}
}


public class Main
{
	public static void main (String [] args)
	{
	Complex Num1 = new Complex() ;
	Complex Num2 = new Complex() ;
	Complex Num3 = new Complex() ;
	
	Num1.setReal(5);
	Num1.setImg(-6);
	
	Num2.setReal(-3);
	Num2.setImg(10);
	
	Num3 = Complex.add(Num1,Num2) ;
	
	Num3.printComplex() ;
	
	Num3 = Complex.sub(Num1,Num2) ;
	
	Num3.printComplex() ;
	
	
	}

}
