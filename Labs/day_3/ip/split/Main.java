
public class Main
{
	public static void main (String [] args)
	{
		if(args.length == 1)
		{
			boolean flag ;
			flag = true ;
			int arr_size = 0 ;
			String ip = args[0] ;
			String[] out ;
			
			
			out = ip.split("\\.") ;
			
			  
			
			int i = 0 ;
			for ( i = 0 ; i < out.length ; i++)
			{
			System.out.println(out[i]);
			}
				
		
		
		}
		else
		{
				System.out.println("Invalid Input");
		}
	}

}
