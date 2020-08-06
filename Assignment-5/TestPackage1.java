import mypack.CurrConvertor;
import java.util.Scanner;

public class TestPackage1
	{
	public static void main(String args[])
		{
		
		mypack.CurrConvertor obj=new mypack.CurrConvertor();
		
		Scanner in=new Scanner(System.in);
		
		double x;
		int opt=0;
		do
		{
			try
			{
				System.out.println("\nChoose input currency format\n 1-INR\n 2-USD");
				System.out.println(" 3-Euro\n 4-Yen\n 0-Exit");
				System.out.print(" Your choice: ");
				opt=in.nextInt();
				
				if(opt==0)
					System.exit(0);
				System.out.print(" Enter value ");
				if(!in.hasNextDouble())
				{
					in.next();
					throw new NumberFormatException();
				}
				if(opt==1){
					
					x=in.nextDouble();
					obj.fromINR(x);
					obj.Display();
				}
				else if(opt==2){
					x=in.nextDouble();
					obj.fromUSD(x);
					obj.Display();
				}
				else if(opt==3){
					x=in.nextDouble();
					obj.fromEuro(x);
					obj.Display();
				}
				else if(opt==4){
					x=in.nextDouble();
					obj.fromYen(x);
					obj.Display();
				}
				else;
			}
			catch(NumberFormatException e)
			{
				System.out.println("Invalid Input Format ");
				
			}
			
		}while(opt!=0);
	}
}

