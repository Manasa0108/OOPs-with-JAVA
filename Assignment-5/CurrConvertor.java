package mypack;

public class CurrConvertor
	{
	double INR;
	double USD;
	double Euro;
	double Yen;
	
	public CurrConvertor()
		{
		INR=0.0;Euro=0.0;
		USD=0.0;Yen=0.0;
		}
	
	public void fromINR(double INR)
		{

		this.INR=INR;
		USD=0.014*INR;
		Euro=0.013*INR;
		Yen=1.49*INR;
		}
	
	public void fromUSD(double USD)
		{
		this.USD=USD;		
		INR=71.18*USD;
		Euro=0.9*USD;
		Yen=106.16*USD;
		}
	
	public void fromEuro(double Euro)
		{
		this.Euro=Euro;		
		USD=1.11*Euro;
		INR=78.92*Euro;
		Yen=117.69*Euro;
		}
	
	public void fromYen(double Yen)
		{
		this.Yen=Yen;		
		USD=0.0094*Yen;
		Euro=0.0085*Yen;
		INR=0.67*Yen;
		}

	public void Display()
		{
		System.out.println("\nINR: "+INR);
		System.out.println("USD: "+USD);
		System.out.println("Euro: "+Euro);
		System.out.println("Yen: "+Yen);
		}
	}


