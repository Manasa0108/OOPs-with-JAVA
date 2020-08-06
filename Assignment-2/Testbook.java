package testbook;
import java.util.*;
class Author
{
	private String name;
	private String email;
	private char gender;

	Author(String name,String email,char gender)
	{
	this.name=name;
	this.email=email;
	this.gender=gender;
	}
	public String getName()
	{
	return name;
	}
	public String getEmail()
	{
	return email;
	}
	public void setEmail(String email)
	{
	this.email=email;
	}
	public char getGender()
	{
	return gender;
	}
}

class Book
{
	private String name;
	private Author author;
	private double price;
	private int qty;

	Book(String name,Author author,double price)
	{
	this.name=name;
	this.author=author;
	this.price=price;
	this.qty=0;
	}
	Book(String name,Author author,double price,int qty)
	{
	this.name=name;
	this.author=author;
	this.price=price;
	this.qty=qty;
	}
	public String getName()
	{
	return name;
	}
	public Author getAuthor()
	{
	return author;
	}
	public void setPrice(double price)
	{
	this.price=price;
	}
	public double getPrice()
	{
	return price;
	}
	public void setQty(int qty)
	{
	this.qty=qty;
	}
	public int getQty()
	{
	return qty;
	}

}

public class Testbook
{
public static void main(String[] arg)
{
	Author a;//("chetan","chetan@gmail.com",'M');
	Book[] b=new Book[2];
	Scanner in=new Scanner(System.in);
	/*b[0]=new Book("Indian",a,500);
	a=new Author("Singaravelu","sing@gmail.com",'M');
	b[1]=new Book("Maths",a,900,3);
*/	String name,email;
	char gender;
	int qty;
	double price;

	for(int i=0;i<2;++i)
	{
	System.out.println("Enter Author name: ");
	name=in.nextLine();
	System.out.println("Enter Author email id: ");
	email=in.nextLine();
	System.out.println("Enter Author's gender: ");
	gender=in.next().charAt(0);
	a=new Author(name,email,gender);
	System.out.println("Enter book name: ");
	name=in.nextLine();
	name=in.nextLine();
	System.out.println("Enter book price: ");
	price=in.nextFloat();
	System.out.println("Enter book qty: ");
	qty=in.nextInt();
	b[i]=new Book(name,a,price,qty);
	name=in.nextLine();
	System.out.println("#####################################################");
	}
	for(int i=0;i<b.length;++i)
	{
	System.out.println("Book name\t: "+b[i].getName());
	a=b[i].getAuthor();
	System.out.println("Author name\t: "+a.getName());
	System.out.println("Author email\t: "+a.getEmail());
	System.out.println("Gender\t\t: "+a.getGender());
	System.out.println("Book price\t: "+b[i].getPrice());
	System.out.println("Book Qty\t: "+b[i].getQty());
	System.out.println("#####################################################");
	}

}
}