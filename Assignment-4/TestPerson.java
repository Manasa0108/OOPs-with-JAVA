import java.util.*;
class Person
{
	private String name;
	private String address;
	Person(String name,String address)
	{
		this.name=name;
		this.address=address;
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
}

class Employee extends Person
{
	private int empid,basic;
	private String dept;
	Employee(String name,String address,int empid,String dept,int basic)
	{
		super(name,address);
		this.empid=empid;
		this.dept=dept;
		this.basic=basic;
	}
	public int getEmpid()
	{
		return empid;
	}
	public String getDept()
	{
		return dept;
	}
	public void setDept(String dept)
	{
		this.dept=dept;
	}
	void setBasic(int basic)
	{
		this.basic=basic;
	}
	public int getBasic()
	{
		return basic;
	}
	public float calSalary()
	{
		float gross,ded,ins,pf,net;
		gross=(float)(basic+(0.6*basic)+(0.1*basic));
		ded=(float)((0.085*basic)+(0.08*basic));
		net=gross-ded;
		return net;
	}
}

class Faculty extends Employee
{
	private String designation;
	private String course;
	Faculty(String name,String address,int empid,String dept,int basic,String designation,String course)
	{
		super(name,address,empid,dept,basic);
		this.designation=designation;
		this.course=course;
	}
	public String getDesig()
	{
		return designation;
	}
	public void setDesig(String desig)
	{
		this.designation=desig;
	}
	public void setCourse(String course)
	{
		this.course=course;
	}
	public String getCourse()
	{
		return course;
	}

	public float calSalary()
	{
		float gross,ded,ins,pf,net,basic;
		basic=getBasic();
		gross=(float)(basic+(0.5*basic)+(0.08*basic));
		ded=(float)((0.085*basic)+(0.08*basic));
		net=gross-ded;
		return net;
	}
	
}
interface Student
{
	public float[] getMarks();
	public float calcGPA();

}

class ResearchAssistant extends Employee implements Student
{
	private String project;
	private String course;
	private float marks[];
	ResearchAssistant(String name,String address,int empid,String dept,int basic,String project,String course,float marks[])
	{
		super(name,address,empid,dept,basic);
		this.project=project;
		this.course=course;
		this.marks=marks;
	}
	public String getProject()
	{
		return project;
	}
	public String getCourse()
	{
		return course;
	}
	public void setCourse(String course)
	{
		this.course=course;
	}
	public float[] getMarks()
	{
		return marks;
	}
	public float calcGPA()
	{
		float total;
		//marks=getMarks();
		total=(marks[0]+marks[1]+marks[2])/30;
		return total;
	}
	public float calSalary()
	{
		float gross,ded,ins,pf,net,basic;
		basic=getBasic();
		gross=(float)(basic+(0.4*basic)+(0.1*basic));
		ded=(float)((0.085*basic)+(0.08*basic));
		net=gross-ded;
		return net;
	}

}
public class TestPerson
{
	public static void printResearch(ResearchAssistant r)
	{

	}

	public static void printFaculty(Faculty f)
	{

	}

	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		String name, address, course, project, newl, desig, dept;
		int empid,ch,basic;
		Employee e;
		//float marks[] = new float[5];

		//System.out.println("MENU\n1-Research Assistant\n2-Faculty\n3-EXIT\nyour choice: ");
		do
		{

			System.out.println("MENU\n1-Research Assistant\n2-Faculty\n3-Employee\n4-Exit\nyour choice: ");
			ch = in.nextInt();
			if(ch==4)
				break;
			{
				System.out.println("ENTER DETAILS-");
				System.out.print("Name\t:");
				name = in.next();
				System.out.print("Emp_ID\t:");
				empid = in.nextInt();
				newl = in.nextLine();
				System.out.print("Address\t:");
				address = in.nextLine();
				System.out.print("Dept\t:");
				dept = in.nextLine();
				System.out.print("Basic\t:");
				basic = in.nextInt();
				newl = in.nextLine();
			}
			switch(ch)
			{
				case 1:
					
					System.out.print("Project\t:");
					project = in.nextLine();
					System.out.print("Course\t:");
					course = in.nextLine();
					float marks[]=new float[3];
					System.out.print("Enter the mark 1: ");
					marks[0]=in.nextFloat();
					System.out.print("Enter the mark 2: ");
					marks[1]=in.nextFloat();
					System.out.print("Enter the mark 3: ");
					marks[2]=in.nextFloat();
					ResearchAssistant r = new ResearchAssistant(name,address,empid,dept,basic,project,course,marks);
					System.out.println("\nDETAILS\n");
					System.out.println("Name\t:"+r.getName());
					System.out.println("Address\t:"+r.getAddress());
					System.out.println("Emp_id\t:"+r.getEmpid());
					System.out.println("Dept\t:"+r.getDept());
					System.out.println("Basic\t:"+r.getBasic());
					System.out.println("Project\t:"+r.getProject());
					System.out.println("Course\t:"+r.getCourse());
					marks=r.getMarks();
					System.out.println("Marks\t:"+marks[0]+"\t"+marks[1]+"\t"+marks[2]);
					System.out.println("GPA\t:"+r.calcGPA());
					//System.out.println("Salary using class Research-assistant\t:"+r.calSalary());
					e=r;
					System.out.println("Salary\t:"+e.calSalary());
					break;

				case 2:
					System.out.print("Desig\t:");
					desig = in.nextLine();
					System.out.print("Course\t:");
					course = in.nextLine();
					Faculty f = new Faculty(name,address,empid,dept,basic,desig,course);
					System.out.println("\nDETAILS\n");
                        		System.out.println("******************************");                    
					System.out.println("Name\t:"+f.getName());
					System.out.println("Address\t:"+f.getAddress());
					System.out.println("Emp_id\t:"+f.getEmpid());
					System.out.println("Dept\t:"+f.getDept());
					System.out.println("Basic\t:"+f.getBasic());
					System.out.println("Desig\t:"+f.getDesig());
					System.out.println("Course\t:"+f.getCourse());
					//System.out.println("Salary using class Faculty\t:"+f.calSalary());
					e=f;
					System.out.println("Salary\t:"+e.calSalary());
					
					break;
				case 3:
					e = new Employee(name,address,empid,dept,basic);
					System.out.println("\nDETAILS\n");
				        System.out.println("******************************");                    	
					System.out.println("Name\t:"+e.getName());
					System.out.println("Address\t:"+e.getAddress());
					System.out.println("Emp_id\t:"+e.getEmpid());
					System.out.println("Dept\t:"+e.getDept());
					System.out.println("Basic\t:"+e.getBasic());
					System.out.println("Salary\t:"+e.calSalary());
					break;

			}
                        System.out.println("******************************");                    
		}while(ch!=4);
	}
}
