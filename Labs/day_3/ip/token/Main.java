
import java.util.StringTokenizer ;

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
			
			StringTokenizer st = new StringTokenizer(ip,".");
			
    
    			while (st.hasMoreTokens()) 
    			{
    	 		  System.out.println(st.nextToken());
     			}
			
			
			
				
		
		
		}
		else
		{
				System.out.println("Invalid Input");
		}
	}

}
