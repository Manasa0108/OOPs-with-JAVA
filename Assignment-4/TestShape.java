import java.util.Scanner;

abstract class Shape
{

	protected String color;

	public Shape()
	{
		this.color="red";
	}
	
	public Shape(String color)
	{
		this.color=color;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
	this.color=color;
	}
	abstract public String toString();
	abstract public double getArea();
	abstract public double getPerimeter();
}

class Circle extends Shape
{
	protected double radius;

	public Circle()
	{
		System.out.println("Default Constructor of Circle: ");
		radius=1.0;
	}	

	public Circle(double radius,String color)
	{
		super(color);
		this.radius=radius;
	}

	public Circle(double radius)
	{
		super();
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

class Rectangle extends Shape
{

	protected double width,length;

	public Rectangle()
	{
	width=1.0;
	length=1.0;
	}
	
	public Rectangle(double width,double length)
	{
		this.width=width;
		this.length=length;
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

	public double getPerimeter()
	{
		double peri;
		peri=2*(length+width);
		return peri;
	}
	public String toString()
	{
		return "\nLength: "+length+"\nWidth"+width+"\nColor: "+getColor()+"\nArea: "+getArea()+"\nPerimeter: "+getPerimeter();
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
public class TestShape
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
			Circle def=new Circle();
			System.out.println("****Default Constructor of Circle****");
			shapes[i]=def;
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****One parameterised Constructor of Circle****");
			System.out.println("\nEnter new radius:");
			radius=obj.nextFloat();
			Circle c=new Circle(radius);
			shapes[i]=c;
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****Two parameterised Constructor of Circle****");
			System.out.println("Enter radius and colour:");
			radius=obj.nextFloat();
			color=obj.next();
			Circle c2=new Circle(radius,color);
			shapes[i]=c2;
			System.out.println(shapes[i].toString());
		}
		else if(ch==2)
		{
			float l,w;
			String col;
			Rectangle r=new Rectangle();
			System.out.println();
			System.out.println("****Default Constructor of Rectangle****");
			shapes[i]=r;
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****Two parameterised Constructor of Rectangle****");
			System.out.println("Enter length and width");
			l=obj.nextFloat();
			w=obj.nextFloat();
			Rectangle r1=new Rectangle(l,w);
			shapes[i]=r1;
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****Three parameterised Constructor of Rectangle****");
			System.out.println("Enter length and width, color");
			l=obj.nextFloat();
			w=obj.nextFloat();
			col=obj.next();
			Rectangle r2=new Rectangle(l,w,col);
			shapes[i]=r2;
			System.out.println(shapes[i].toString());
		}
		else if(ch==3)
		{
			double side;
			String col;
			Square s=new Square();
			System.out.println();
			System.out.println("****Default Constructor of Square****");
			System.out.println("Side:"+s.getSide());
			shapes[i]=s;
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****One parameterised Constructor of Square****");
			System.out.println("Enter side of square");
			side=obj.nextDouble();
			Square s2=new Square(side);
			shapes[i]=s2;
			System.out.println(shapes[i].toString());
			System.out.println();
			System.out.println("****Two parameterised Constructor of Square****");
			System.out.println("Enter side and color");
			side=obj.nextDouble();
			col=obj.next();
			Square s3=new Square(side,col);
			shapes[i]=s3;
			System.out.println(shapes[i].toString());
		}
		else
			break;
	System.out.println();
	}	
}
}
                                                                                                                                                                                                                                        
