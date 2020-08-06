package electricitybill;
import java.util.Scanner;
public class ElectricityBill {
    int custNo;
    String custName;
    char type;
    int prevReading,currentReading;
    
    void input()
    {
        Scanner in= new Scanner(System.in);
        System.out.print("Enter Consumer number: ");
        custNo=in.nextInt();
        custName=in.nextLine();
        System.out.print("Enter Consumer name: ");
        custName=in.nextLine();
        System.out.print("Enter Consumer type(d-domestic/c-commercial): ");
        type=in.next().charAt(0);                
        System.out.print("Enter Previous Reading: ");
        prevReading=in.nextInt();
        System.out.print("Enter Current Reading: ");
        currentReading=in.nextInt();
        
    }
     void bill(int units, double tarrif)
    {
        System.out.println("Customer Number: "+custNo);
        System.out.println("Customer Name: "+custName);
        if(type=='d')
            System.out.println("Customer type: Domestic" );
        else
            System.out.println("Customer type: Commercial");
        System.out.println("Previous Reading: "+prevReading);
        System.out.println("Current Reading: "+currentReading);
        System.out.println("Units consumer: "+units);
        System.out.println("Tarrif: "+tarrif);
    }
    
    void calc()
    {
        int units=currentReading-prevReading;
        double tarrif=0;
        if(type=='d')
        {
            if(units>500)
                tarrif=100*1+100*2.5+300*4+(units-500)*6;
            else if(units>200)
                tarrif=100*1+100*2.5+(units-200)*4;
            else if(units>100)
                tarrif=100*1+(units-100)*2.5;
            else
                tarrif=units*1;
        }
        if(type=='c')
        {
            if(units>500)
                tarrif=100*2+100*4.5+300*6+(units-500)*7.5;
            else if(units>200)
                tarrif=100*2+100*4.5+(units-200)*6;
            else if(units>100)
                tarrif=100*2+(units-100)*4.5;
            else
                tarrif=units*2;
        }
        System.out.println("****************");
        
        bill(units, tarrif);
    }

    public static void main(String[] args) {
        
        ElectricityBill obj=new ElectricityBill();
        obj.input();
        obj.calc();               
        
        

    }
    
}
