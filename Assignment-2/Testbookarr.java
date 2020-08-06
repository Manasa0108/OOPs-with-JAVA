package testbookarr;
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
	private Author author[];
	private double price;
	private int qty;

	Book(String name,Author author[],double price)
	{
	this.name=name;
	this.author=author;
	this.price=price;
	this.qty=0;
	}
	Book(String name,Author author[],double price,int qty)
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
	public Author[] getAuthor()
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

public class Testbookarr
{
public static void main(String[] arg)
{
	Book[] b=new Book[2];
	Scanner in=new Scanner(System.in);
	String name,email;
	char gender;
	int qty,n;
	double price;

	for(int i=0;i<2;++i)
	{
	System.out.println("Enter  no. of Authors: ");
	n=in.nextInt();
Author[] a=new Author[n];
	for(int j=0;j<n;++j)
	{
	System.out.println("Enter Author name: ");
	name=in.nextLine();
	name=in.nextLine();
	System.out.println("Enter Author email id: ");
	email=in.nextLine();
	System.out.println("Enter Author's gender: ");
	gender=in.next().charAt(0);
	a[j]=new Author(name,email,gender);
	}
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
	{Author[] a;
	System.out.println("Book name\t: "+b[i].getName());
	for(int j=0;j<b[i].getAuthor().length;++j)
	{
	System.out.println("Author name\t: "+b[i].getAuthor()[j].getName());
	System.out.println("Author email\t: "+b[i].getAuthor()[j].getEmail());
	System.out.println("Gender\t\t: "+b[i].getAuthor()[j].getGender());
	}
	System.out.println("Book price\t: "+b[i].getPrice());
	System.out.println("Book Qty\t: "+b[i].getQty());
	System.out.println("#####################################################");
	}

}
}