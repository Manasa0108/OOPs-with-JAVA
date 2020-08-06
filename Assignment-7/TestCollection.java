import java.util.*;
class ArrayList
{
	String arr[];
	int size;
	ArrayList()
	{
		arr=new String[1];
		size=0;
	}
	void add(String a)
	{
		arr[size]=a;
		size+=1;
		arr=Arrays.copyOf(arr,size+1);
	}
	void insert(String a, int pos)
	{
		if(pos > size)
		{
			System.out.println("Position more than the array size..");
			System.out.println("Insertion not possible!!!!");
			return;
		}
		for(int i=size;i>pos;--i)
			arr[i]=arr[i-1];
		arr[pos]=a;
		size+=1;
		arr=Arrays.copyOf(arr,size+1);
	}
	int contains(String a)
	{
		int c=0;
		for(int i=0;i<size;++i)
			if(arr[i].equals(a))
				c+=1;
		return c;
	}
	void display()
	{
		System.out.print("Contents are : [ ");
		for(int i=0;i<size-1;++i)
			System.out.print(arr[i]+",  ");
		System.out.println(arr[size-1]+" ]");
	}
	void startsWith(char c)
	{
		ArrayList obj= new ArrayList();
		for(int i=0;i<size;++i)
			if(arr[i].charAt(0)==c)
			{
				obj.add(arr[i]);
			}
		if(obj.size==0)
			System.out.println("No matches found!!!");
		else
			obj.display();
	}
	void subString(String a)
	{
		ArrayList obj= new ArrayList();
		for(int i=0;i<size;++i)
			if(arr[i].indexOf(a)!=-1)
			{
				obj.add(arr[i]);
			}
		if(obj.size==0)
			System.out.println("No matches found!!!");
		else
			obj.display();
	}
	void replace(String a, String b)
	{
		for(int i=0;i<size;++i)
			if(arr[i].equals(a))
				arr[i]=b;
	}
	void remove(String a)
	{
		for(int i=0;i<size;++i)
			if(arr[i].equals(a))
			{
				for(;i<size-1;++i)
					arr[i]=arr[i+1];
				break;
			}
		size-=1;
		arr=Arrays.copyOf(arr,size+1);

	}
	void duplicate()
	{
		ArrayList obj=new ArrayList();
		for(int i=0;i<size;++i)
		{
			if(obj.contains(arr[i])==0)
				obj.add(arr[i]);
		}
		arr=Arrays.copyOf(obj.arr,obj.size);
		size=obj.size;
	}
}
public class TestCollection{
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		Scanner in=new Scanner(System.in);
		int op,pos;
		String a,b;
		char c;
		do
		{
			System.out.println("\n\n------String Operations-----");
			System.out.println("\nMenu: \n1.Add\n2.Insert\n3.Find\n4.Starts with given letter\n5.Substring Match\n6.Replace\n7.Remove\n8.Remove duplicates\n9.Display\n10.Exit\nEnter option: ");
			op=in.nextInt();
			switch(op)
			{
				case 1:
					System.out.println("\n-----Add Element-----");
					System.out.print("Enter Element : ");
					a=in.nextLine();
					a=in.nextLine();
					al.add(a);
					System.out.println("Element added Successfully!!!!");
					break;
				case 2:
					System.out.println("\n-----Insert Element-----");
					System.out.print("Enter pos : ");
					pos=in.nextInt();
					System.out.print("Enter Element : ");
					a=in.nextLine();
					a=in.nextLine();
					al.insert(a,pos);
					System.out.println("Element inserted Successfully!!!!");
					break;
				case 3:
					System.out.println("\n-----Find Element-----");
					System.out.print("Enter Element to search: ");
					a=in.nextLine();
					a=in.nextLine();
					pos=al.contains(a);
					if(pos==0)
						System.out.println(a+" does not occur in the list");
					else
						System.out.println(a+" occurs "+pos+" time(s)");
					break;
				case 4:
					System.out.println("\n-----StartsWith------");
					System.out.print("Enter a character: ");
					c=in.next().charAt(0);
					al.startsWith(c);
					break;
				case 5:
					System.out.println("\n-----Substring Match-----");
					System.out.print("Enter substring: ");
					a=in.nextLine();
					a=in.nextLine();
					al.subString(a);
					break;
				case 6:
					System.out.println("\n-----Replace Element------");
					System.out.print("Enter Element to replace: ");
					a=in.nextLine();
					a=in.nextLine();
					System.out.print("Enter Replacement String: ");
					b=in.nextLine();
					al.replace(a,b);
					System.out.println("Element replaced Successfully!!!!");
					break;
				case 7:
					System.out.println("\n-----Remove Element------");
					System.out.print("Enter Element: ");
					a=in.nextLine();
					a=in.nextLine();
					al.remove(a);
					System.out.println("Element removed Successfully!!!!");
					break;
				case 8:
					System.out.println("\n-----Remove duplicates------");
					al.duplicate();
					System.out.println("\nDuplicate elements removed Successfully!!!");
					al.display();
					break;
				case 9:
					System.out.println("\n-----Display List------");
					al.display();

			}

		}while(op!=10);
		
	}
}