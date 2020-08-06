package testshapeinterface;
import java.util.Scanner;
interface Shape
{

	public void setColor(String color);
	public String getColor();
	abstract public String toString();
	abstract public double getArea();
	abstract public double getPerimeter();
}

class Circle implements Shape
{
	protected double radius;
	protected String color;

	public Circle()
	{
		setColor("red");
		radius=1.0;
	}	

	public Circle(double radius,String color)
	{
		setColor(color);
		this.radius=radius;
	}

	public Circle(double radius)
	{
		super();
		setColor("red");
		this.radius=radius;
	}

	public double getRadius()
	{
		return radius;
	}
	
	public void setRadius(double radius)
	{
		this.radius=radius;
	}


	public void setColor(String color)
	{
	this.color=color;
	}

	public String getColor()
	{
		return color;
	}

	public double getArea()
	{
		double area=3.14*radius*radius;
		return area;
	}

	public double getPerimeter()
	{
		double peri=2*3.14*radius;
		return peri;
	}
	public String toString()
	{
		return "Radius: "+radius+"\nColor: "+getColor()+"\nArea: "+getArea()+"\nPerimeter: "+getPerimeter();
	}
}

class Rectangle implements Shape
{

	protected double width,length;
	protected String color;

	public Rectangle()
	{
	width=1.0;
	length=1.0;
	setColor("red");
	}
	
	public Rectangle(double width,double length)
	{
		this.width=width;
		this.length=length;
		setColor("red");
	}

	public Rectangle(double width,double length,String color)
	{
		this.width=width;
		this.length=length;
		this.color=color;
	}

	public double getWidth()
	{
		return width;
	}
	
	public void setWidth(double width)
	{
		this.width=width;
	}

	public double getLength()
	{
		return length;
	}

	public void setLength(double length)
	{
		this.length=length;
	}

	public double getArea()
	{
		double area=length*width;
		return area;
	}


	public void setColor(String color)
	{
	this.color=color;
	}

	public String getColor()
	{
		return color;
	}

	public double getPerimeter()
	{
		double peri;
		peri=2*(length+width);
		return peri;
	}
	public String toString()
	{
		return "\nLength: "+length+"\nWidth: "+width+"\nColor: "+getColor()+"\nArea: "+getArea()+"\nPerimeter: "+getPerimeter();
	}
}

class Square extends Rectangle
{

	public Square()
	{
		length=width=1;
	}

	public Square(double side)
	{
		length=side;
		width=side;
	}	

	public Square(double side,String color)
	{
		length=width=side;
		this.color=color;
	}

	public double getSide()
	{
		return length;
	}

	public void setSide(double side)
	{
		length=width=side;
	}

	public void setColor(String color)
	{
	this.color=color;
	}

	public String getColor()
	{
		return color;
	}
	public double getArea()
	{
		double area=length*length;
		return area;
	}

	public double getPerimeter()
	{
		double peri;
		peri=4*length;
		return peri;
	}
	public String toString()
	{
		return "\nSide: "+length+"\nColor: "+getColor()+"\nArea: "+getArea()+"\nPerimeter: "+getPerimeter();
	}
}
public class TestShapeInterface
{
public static void main(String Args[])
{
	Scanner obj=new Scanner(System.in);
	int ch;
	Shape shapes[]=new Shape[9];
	for(int i=0;i<9;i++)
	{
		System.out.println("\nEnter shape \n1)Circle \n2)Rectangle \n3)Square\nenter choice: ");
		ch=obj.nextInt();
		if(ch==1)
		{
			double radius;
			String color;
			shapes[i]=new Circle();
			System.out.println("****Default Constructor of Circle****");
			//shapes=def;
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****One parameterised Constructor of Circle****");
			System.out.println("\nEnter new radius:");
			radius=obj.nextFloat();
			shapes[i]=new Circle(radius);
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****Two parameterised Constructor of Circle****");
			System.out.println("Enter radius and colour:");
			radius=obj.nextFloat();
			color=obj.next();
			shapes[i]=new Circle(radius,color);
			System.out.println(shapes[i].toString());
		}
		else if(ch==2)
		{
			float l,w;
			String col;
			shapes[i]=new Rectangle();
			System.out.println();
			System.out.println("****Default Constructor of Rectangle****");
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****Two parameterised Constructor of Rectangle****");
			System.out.println("Enter length and width");
			l=obj.nextFloat();
			w=obj.nextFloat();
			shapes[i]=new Rectangle(l,w);
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****Three parameterised Constructor of Rectangle****");
			System.out.println("Enter length and width, color");
			l=obj.nextFloat();
			w=obj.nextFloat();
			col=obj.next();
			shapes[i]=new Rectangle(l,w,col);
			System.out.println(shapes[i].toString());
		}
		else if(ch==3)
		{
			double side;
			String col;
			shapes[i]=new Square();
			System.out.println();
			System.out.println("****Default Constructor of Square****");
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****One parameterised Constructor of Square****");
			System.out.println("Enter side of square");
			side=obj.nextDouble();
			shapes[i]=new Square(side);
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****Two parameterised Constructor of Square****");
			System.out.println("Enter side and color");
			side=obj.nextDouble();
			col=obj.next();
			shapes[i]=new Square(side,col);
			System.out.println(shapes[i].toString());
		}
		else
			break;
	System.out.println();
	}	
}
}