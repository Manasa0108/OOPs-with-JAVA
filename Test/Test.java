import java.util.*;
import MyPack.Cylinder;

public class Test
{
public static void main(String args[])
{
Scanner in= new Scanner(System.in);
int op,x,y;
String color;
do
{
System.out.println("Test Cylinder: ");
try{
System.out.print("Enter radius: ");
if(!in.hasNextInt())
{
	in.next();
	throw new NumberFormatException();
}
x=in.nextInt();
System.out.print("Enter height: ");
if(!in.hasNextInt())
{
	in.next();
	throw new NumberFormatException();
}
y=in.nextInt();
System.out.print("Enter color: ");
color=in.nextLine();
color=in.nextLine();
Cylinder obj=new Cylinder(color,x,y);
System.out.println("\n\nCylinder Details: \n"+obj);

}
catch(NumberFormatException e)
{
	System.out.println("Invalid Input Format ");

}
System.out.print("Enter 1 to continue: ");
op=in.nextInt();
}while(op==1);
}

}
