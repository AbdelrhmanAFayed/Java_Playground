
public class Main
{
	public static void main (String [] args)
	{
		if(args.length == 1)
		{
			boolean flag ;
			flag = true ;
			int startind = 0 ;
			int endind = 0 ;
			String ip = args[0] ;
			String out ;
			while(flag)
			{
				endind = ip.indexOf(".",startind);
			
			if(endind == -1)
			{
				flag = false ;
				out = ip.substring(startind,ip.length());	
			
				System.out.println(out);
			
			}
			else
			{
				out = ip.substring(startind,endind);	
			
				startind = endind + 1 ;
		
				System.out.println(out);
			}
			
			}	
		
		
			}
			else
			{
				System.out.println("Invalid Input");
			}
	}

}
