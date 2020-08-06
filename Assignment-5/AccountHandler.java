import java.util.Scanner;

class PanRequiredException extends Exception
{
    public String toString()
    {
        return "PanRequiredException: PAN Number Required";
    }
}
class MinBalRequiredException extends Exception
{
    double detail;
    MinBalRequiredException(double d)
    {
        detail=d;
    }
    public String toString()
    {
        return "MinBalRequiredException: Balance Tending Below Minimum  : "+ detail;
    }
}

class NotEnoughMoneyInAccountException extends Exception
{
    public String toString()
    {
        return "NotEnoughMoneyInAccountException: Insufficient Funds To Process  Request";
    }
}

class AccountNotFoundException extends Exception
{
    public String toString()
    {
        return "AccountNotFoundException: Requested Account Non-Existent";
    }
}

class Account
{
    private String cname;
    private int pan;
    private int accno;
    private String branch;
    private double balance;

    public Account(String cname,int pan,int accno,String branch,double balance)
    {
        this.cname=cname;
        this.pan=pan;
        this.accno=accno;
        this.branch=branch;
        this.balance=balance;
    }
    public Account(String cname,int accno,String branch,double balance)
    {
        this.cname=cname;
        this.pan=0;
        this.accno=accno;
        this.branch=branch;
        this.balance=balance;
    }
    public String getCName()
    {
        return cname;
    }
    public int getPAN()
    {
        return pan;
    }
    public int getAccNo()
    {
        return accno;
    }
    public String getBranch()
    {
        return branch;
    }
    public double getBalance()
    {
        return balance;
    }
    public void setPan(int pan)
    {
        this.pan=pan;
    }
    public void setBalance(double amt)
    {
        balance=amt;
    }
    public void deposit(int accno,double amt) throws PanRequiredException
    {
        if(amt>50000&& pan==0)
            throw new PanRequiredException();
        else
            balance+=amt;
    }

    public void withdraw(int accno,double amt) throws MinBalRequiredException,NotEnoughMoneyInAccountException
    {
        if(balance<amt)
            throw new NotEnoughMoneyInAccountException();
        else if((balance-amt)<1000.0)
            throw new MinBalRequiredException(1000);
        else 
            balance-=amt;
    }

    public static Account search(Account acc[],int n,int accno)
    {
	for(int i=0;i<n;++i)
	{
		if(accno==acc[i].accno){
		System.out.println("\nName: "+acc[i].getCName());
		    if(acc[i].getPAN()!=0)
		    System.out.println("PAN: "+acc[i].getPAN());
		    System.out.println("Account Number: "+acc[i].getAccNo());
		    System.out.println("Branch: "+acc[i].getBranch());
		    System.out.println("Current Balance: "+acc[i].getBalance());
	
			return acc[i];
		}
	}
	return null;
    }

    public String toString()
    {
        return "Account Number "+accno+" has produced ";
    }
}
public class AccountHandler{
    public static void main(String args[]){

        String name,branch;
        int pan,accno;
        double bal;
        int num;
        double amt;
        int ano;
        int opt;

        Scanner in=new Scanner(System.in);
        System.out.print("\nEnter no of accounts: ");
        num=in.nextInt();

        Account acc[]=new Account[100];
	Account temp;
        for(int i=0;i<num;i++){
            System.out.println("Enter Account Details ");
            in.nextLine();
            System.out.print("Enter Name: ");name=in.nextLine();
            System.out.print("Enter Account number: ");accno=in.nextInt();
            in.nextLine();
            System.out.print("Enter Branch: ");branch=in.nextLine();
            System.out.print("Enter Balance: ");bal=in.nextDouble();
            System.out.print("E-Enter PAN/S-Skip: ");
            if(in.next().charAt(0)=='E')
            {
                System.out.print("Enter PAN number: ");pan=in.nextInt();
                acc[i]=new Account(name,pan,accno,branch,bal);
            }
            else
                acc[i]=new Account(name,accno,branch,bal);
            System.out.println("********************************");
        }

        do
        {
            System.out.println("\nMenu:  \n 1-Deposit\n 2-Withdraw");
            System.out.println(" 0-Exit");
            System.out.print(" Your choice: ");	opt=in.nextInt();

            if(opt==1)
            {
                System.out.print("Enter amount to deposit: ");
                amt=in.nextDouble();
                System.out.print("Enter account number: ");
                ano=in.nextInt();
                    try
                    {
			temp=Account.search(acc,num,ano);
			if(temp==null)
				throw new AccountNotFoundException();
		  	try
                        {
                            temp.deposit(ano,amt);
                            System.out.println("\nAfter DEPOSIT ");
                            temp=temp.search(acc,num,ano);
                        }
                        catch(PanRequiredException pre)
                        {
                            System.out.println(temp.toString()+pre.toString());
                            System.out.print("Enter PAN number: ");
                            pan=in.nextInt();
                            temp.setPan(pan);
                            try{temp.deposit(ano,amt);
                            System.out.println("\nAfter DEPOSIT ");
                            temp=temp.search(acc,num,ano);
                            }
                            catch(PanRequiredException pre1){}
                        }
                    }
                    catch(AccountNotFoundException anfe){
			System.out.println(anfe.toString());}
            }
            else if(opt==2)
            {
                System.out.print("Enter amount to withdraw: ");
                amt=in.nextDouble();
                System.out.print("Enter account number: ");
                ano=in.nextInt();
                    try{
			temp=Account.search(acc,num,ano);
			if(temp==null)
				throw new AccountNotFoundException();
                           
                            try{
                                    temp.withdraw(ano,amt);
                                    System.out.println("\nAfter WITHDRAWAL ");
                                    temp=temp.search(acc,num,ano);
                            }
                            catch(MinBalRequiredException pre){
                                System.out.println(temp.toString()+pre.toString());
                            }
                            catch(NotEnoughMoneyInAccountException nemiae){
                                System.out.println(temp.toString()+nemiae.toString());
                            }
                        }
                        catch(AccountNotFoundException anfe){
			System.out.println(anfe.toString());}
           
                
            }
            else if(opt!=0)
                System.out.println("Invalid option ");
            System.out.println("******************************");
        }while(opt!=0);		
    }
}	
