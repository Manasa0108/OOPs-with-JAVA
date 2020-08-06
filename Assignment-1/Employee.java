package employee;
import java.util.Calendar;
import java.util.Scanner;

class record
{
    String name,designation,dob,doj;
    int id,basic,da,hra,lic,pf,hours,hourlywage,liccounter,exp;
    float ded,grosssalary,netsalary;
 
    void getinput()
    {
       Scanner get=new Scanner(System.in);
       System.out.print("Enter name:");
       name=get.next();
       System.out.print("Enter designation:");
       designation=get.next();
       dob = get.nextLine();
       System.out.println("Date of Birth(DD/MM/YYYY): ");
       dob = get.nextLine();
       System.out.println("Date of Join(DD/MM/YYYY): ");
       doj = get.nextLine();
       System.out.print("Enter id:");
       id=get.nextInt();
       if(designation.equals("intern"))
       {
       System.out.print("Enter no of hours:");
       hours=get.nextInt();
       System.out.print("Enter hourly wage:");
       hourlywage=get.nextInt();
       basic=0;
       }
       else
       {
       System.out.print("Enter basic pay:");
       basic=get.nextInt();
       hours=0;
       hourlywage=0;
       } 

       System.out.print("Enter 1 if you want lic or 0 if not:");
       liccounter=get.nextInt();
       exp=Calendar.getInstance().get(Calendar.YEAR);
       exp-=Integer.parseInt(doj.substring(6));
   }
    void giveoutput()
    {
        System.out.println("\nName \t\t:"+name);
        System.out.println("Designation \t:"+designation);
        System.out.println("Date of birth \t:"+dob);
        System.out.println("date oof join \t:"+doj);
        System.out.println("Employee id \t:"+id);
        System.out.println("Experience\t: "+exp+"yrs");
        if(!designation.equals("intern"))
        System.out.println("Basic pay \t: "+basic);
        System.out.println("DA \t\t: "+da);
        System.out.println("HRA \t\t: "+hra);
        System.out.println("LIC \t\t: "+lic);
        System.out.println("PF \t\t: "+pf);
        if(designation.equals("intern"))
        {
        System.out.println("Hours \t\t: "+hours);
        System.out.println("Hourly wage: "+hourlywage);
        }
        System.out.println("Gross salary \t: "+grosssalary);
        System.out.println("Deductions \t: "+ded);        
        System.out.println("Net salary \t: "+netsalary);

    }
    void givepayroll()
    {
            System.out.println(id+"\t"+name+"\t"+designation+"\t"+dob+"\t"+doj+"\t"+netsalary);
    }
   void calculatesal()
   {

       if(designation.equals("intern"))
       {
           da=2000;
           hra=1000;
           grosssalary=hours*hourlywage+da+hra;
           if(liccounter==1)
               lic=1000;
           else
               lic=0;
           pf=500;
           netsalary=grosssalary-lic-pf;

       }
       else if(designation.equals("manager")) 
       {
           da=(int) (0.4*basic);
           hra=(int) (0.1*basic);
           grosssalary=basic+da+hra;
            if(liccounter==1)
               lic=1000;
           else
               lic=0;
           pf=(int) (0.08*basic);
           netsalary=grosssalary-lic-pf;
       }
       else
       {
           da=(int) (0.3*basic);
           hra=(int) (0.1*basic);
           grosssalary=basic+da+hra;
           if(liccounter==1)
               lic=1000;
           else
               lic=0;
           pf=     (int) (0.08*basic);
           netsalary=grosssalary-lic-pf; 
       }
       ded=grosssalary-netsalary;
   }
   void promote()
   {
       char ch;
       Scanner in=new Scanner(System.in);
       System.out.println("Do you want to apply for promotion?(y/n): ");
       ch=in.next().charAt(0);
       if(designation.equals("manager")&&ch!='n')
            System.out.println("You are a Manager and cannot be promoted further!!!");
       else if(designation.equals("intern")&&exp>5&&ch!='n')
       {
           designation="others";
           System.out.print("Enter Basic pay: ");
           basic=in.nextInt();
           System.out.println("Promoted successfully");
       }
       else if(exp>5&&ch!='n')
       {
           designation="manager";
           System.out.println("Promoted successfully as a manager");
       }
       else
           System.out.println("More experience required...Better luck next time!!");
       calculatesal();        
   }
}

public class Employee
{
    public static void main(String args[])
    {
        Scanner get=new Scanner(System.in);
        record[] a=new record[10];
        
        int n,i;
        for(i=0;i<10;i++)
            a[i]=new record();
        
        
        System.out.print("Enter number of employees:");
        n=get.nextInt();
        
        do
        {
        int ch;
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("\tMENU");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
       
        System.out.println("1.Enter employee Details\n2.Payroll of n employees\n3.Payslip of particular employee\n4.Promotion\n5.Exit ");
        System.out.println("Enter choice:");
        ch=get.nextInt();
        if(ch==1)
        {
            for(i=0;i<n;i++)
        {
            System.out.println("\nInput details of employee "+(i+1));
            a[i].getinput();
            a[i].calculatesal();
        }
            
        }
        else if(ch==2)
        {
                 int j;
                 System.out.println("ID\tName\tDesignation\tDOB\tDOJ\tNetSalary");
                 for(j=0;j<n;j++)
                     a[j].givepayroll();
        }
        else if(ch==3)
        {
            int id;
         int flag=0;
         System.out.print("Enter Employee ID:");
         id=get.nextInt();   
         int j;
         for(j=0;j<n;j++)
             if(a[j].id==id)
             {
                 flag=1;
                 a[j].giveoutput();         
             }
         if(flag==0)
             System.out.println("Record not found!!!");
        }
        else if(ch==4)
        {
         int id;
         int flag=0;
         System.out.print("Enter Employee ID:");
         id=get.nextInt();   
         int j;
         for(j=0;j<n;j++)
             if(a[j].id==id)
             {
                 flag=1;
                 a[j].promote();
                 a[j].calculatesal();
             }
         if(flag==0)
             System.out.println("Record not found!!!");
                 
        }
        else
            break;
        }while(1==1);
    }
}
