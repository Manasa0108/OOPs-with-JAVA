package MyPack;

abstract class Shape{
	private int dim1;

	public Shape(int dim1)
	{
	this.dim1=dim1;
	}

	public int getDim1()
	{
	return dim1;
	}

	public abstract double calVolume(); 

	public abstract double surfaceArea();
}


public class Cylinder extends Shape{
	private String color;
	private int dim2;

	public Cylinder(String color,int x, int y)
	{
	super(x);
	this.color=color;
	dim2=y;
	}

	public double calVolume()
	{
		int r=getDim1();
		return 3.14*r*r*dim2;
	}

	public double surfaceArea()
	{
		int r=getDim1();
		return 3.14*2*r*(dim2 + r);
	}
	public String toString()
	{
	return "\nRadius: "+ getDim1()+"\nHeight: "+dim2+"\nColor: "+color+"\nVolume: "+calVolume()+"\nSurface Area: "+surfaceArea();
	}

}


