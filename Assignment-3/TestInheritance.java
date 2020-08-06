package testinheritance;
import java.util.*;
class Person{
    private int aadhaar;
    private String name,address;
    private char gender;
    public Person(int aadhaar,String name,String address,char gender)
    {
        this.aadhaar=aadhaar;
        this.name=name;
        this.address=address;
        this.gender=gender;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String address)
    {
        this.address=address;
    }
    public char getGender()
    {
        return gender;
    }
}
class Student extends Person{
    private String program;
    private int year;
    private float totalmark;
    public Student(int aadhaar,String name,String address,char gender,String program,int year,float totalmark)
    {
        super(aadhaar,name,address,gender);
        this.program=program;
        this.year=year;
        this.totalmark=totalmark;
    }
    public String getProgram()
    {
        return program;
    }
    public int getYear()
    {
        return year;
    }
    public void setYear(int year)
    {
        this.year=year;
    }
    public float getTotal()
    {
        return totalmark;
    }
    public void setTotal(float tot)
    {
        totalmark=tot;
    }
    public float calGPA()
    {
        return (int)((totalmark/10)+1);
    }
}
class Faculty extends Person{
    private String designation,department;
    private float basicpay;
    public Faculty(int aadhaar,String name,String address,char gender,String designation,String dept,float pay)
    {
        super(aadhaar,name,address,gender);
        this.designation=designation;
        department=dept;
        basicpay=pay;
    }
    public String getDesig()
    {
        return designation;
    }
    public void setDesig(String desig)
    {
        designation=desig;
    }
    public void setBasic(float basic)
    {
        basicpay=basic;
    }
    public float getBasic()
    {
        return basicpay;
    }
    public float getSalary()
    {
        return basicpay;
    }
    public float calSalary()
    {
        float DA,HRA,med,PF,ded,gross,net;
        DA=(float)(0.6*basicpay);
        HRA=(float)(0.1*basicpay);
        med=(float)(0.085*basicpay);
        PF=(float)(0.08*basicpay);
        gross=basicpay+DA+HRA;
        ded=med+PF;
        net=gross-ded;
        System.out.println("Gross Salary: "+gross);
        System.out.println("Deductions: "+ded);
        return net;
    }
}
public class TestInheritance {
    public static void main(String[] args) {
        int ch;
        do
        {
		String Name,Address;
		char Gender;
		int Aadhaar;
		
            Scanner in=new Scanner(System.in);
            System.out.println("\nMenu:\n1.Student\n2.Faculty\n3.Exit\nenter choice :");
            ch=in.nextInt();
		if(ch==3)
                    break;
		System.out.print("Enter Name : ");
                Name=in.next();
                System.out.print("Enter address : ");
                Address=in.nextLine();
                Address=in.nextLine();
                System.out.print("Enter Aadhaar : ");
                Aadhaar=in.nextInt();
                System.out.print("Enter gender : ");
                Gender=in.next().charAt(0);
            if(ch==1)
            {
                int Year;
                String Program;
                float Totalmark;
                System.out.print("Enter Program: ");
                Program=in.next();
                System.out.print("Enter Year of join : ");
                Year=in.nextInt();
                System.out.print("Enter Total Marks : ");
                Totalmark=in.nextInt();
                Student obj=new Student(Aadhaar,Name,Address,Gender,Program,Year,Totalmark);
                System.out.println("\n\nName : "+obj.getName());
                System.out.println("Gender : "+obj.getGender());
                System.out.println("Current address : "+obj.getAddress());
                System.out.println("Program : "+obj.getProgram());
                System.out.println("Current year : "+obj.getYear());
                System.out.println("Current total  : "+obj.getTotal());
                System.out.println("Current gpa : "+obj.calGPA());

                String newadd;
                System.out.print("Enter the new address : ");
                newadd=in.next();
                obj.setAddress(newadd);

                int newyr;
                System.out.print("Enter the year to be changed : ");
                newyr=in.nextInt();
                obj.setYear(newyr);

                int newtot;
                System.out.print("Enter the new total : ");
                newtot=in.nextInt();
                obj.setTotal(newtot);

                System.out.println("New address : "+obj.getAddress());
                System.out.println("New year : "+obj.getYear());
                System.out.println("New total : "+obj.getTotal());		
            }
            if(ch==2)
            {
                String Designation,Department;
                float Basicpay;
                System.out.print("\nEnter designation: ");
		Designation=in.nextLine();                
		Designation=in.nextLine();
                System.out.print("\nEnter department: ");
                Department=in.nextLine();
                System.out.print("Enter Basic pay : ");
                Basicpay=in.nextFloat();
                Faculty obj=new Faculty(Aadhaar,Name,Address,Gender,Designation,Department,Basicpay);
                System.out.println("\n\nName : "+obj.getName());
                System.out.println("Gender : "+obj.getGender());
                System.out.println("Current address : "+obj.getAddress());
                System.out.println("Designation : "+obj.getDesig());
                System.out.println("Basic pay : "+obj.getBasic());
                System.out.println("Net salary : "+obj.calSalary());		

                String newdes;
                System.out.print("Enter the new designation : ");
                newdes=in.next();
                obj.setDesig(newdes);

                float newbasic;
                System.out.print("Enter the new salary : ");
                newbasic=in.nextFloat();
                obj.setBasic(newbasic);
                System.out.println("\nNew Designation : "+obj.getDesig());
                System.out.println("\nNew basic pay : "+obj.getBasic());
            }
        }while(ch!=3);
    }
}