
public class Main
{
	public static void main (String [] args)
	{
		if(args.length == 3)
		{
		double first = Double.parseDouble(args[0]);
		double second = Double.parseDouble(args[2]);
		double result ;
		switch(args[1])
		{
		
		case "+":   
		result = first + second ;
		System.out.println(result);
		break;
		case "-":
		result = first - second ;
		System.out.println(result);
		break;
		case "x":   
		result = first * second ;
		System.out.println(result);
		break;
		case "/":   
		
		if(second == 0)
		{
		System.out.println("Invalid Input");
		
		}
		else
		{
		result = first / second ;
		System.out.println(result);
		
		}
		break;		
		
		default:
		System.out.println("Invalid Input");
		}
		}
		else
		{
		System.out.println("Invalid Input");
		}
	}

}
