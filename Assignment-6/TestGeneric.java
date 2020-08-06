import java.util.Scanner;
class Stack<T>{
	private static final int CAPACITY=10;
	T[] Arr;
	private int capacity;
	int top=-1;
	public Stack(){
		this.capacity=CAPACITY;
		Arr=(T[])new Object[CAPACITY];
	}
	public Stack(int capacity){
		this.capacity=capacity;
		Arr=(T[])new Object[capacity];
	}
	public int isEmpty(){
		if(top==-1)
		return 1;
		else
		return 0;
	}
	public int isFull(){
		if(top==capacity-1)
		return 1;
		else
		return 0;
	}
	public void push(T val){
		if(isFull()==1)
		{
		System.out.println("\nStack is Full!");
		return;
		}
		else
		{
		this.Arr[++top]=val;
		}
	}
	public T pop(){
		if(isEmpty()==1)
		{
		System.out.println("\nStack is Empty!");
		      return null;
		}
	else{
		T val=this.Arr[top--];
		return val;
		}
	}
	public void display(){
		int temp=top;
		System.out.println("\n\n*****STACK CONTENTS*****");
		while(temp>=0){
		T val=this.Arr[temp--];
		System.out.println(val+" ");}
	}

}
class TestGeneric{
	public static void main(String args[]){
	int capacity,choice;
	int ch;
	do{
		Scanner in=new Scanner(System.in);
		System.out.println("Oject type: \n1-String\n2-Integer\n3-Float\n4-Double\nEnter your choice: ");
		choice=in.nextInt();
		if(choice==1)
		{
			System.out.println("\nCapacity : ");
			capacity=in.nextInt();
			Stack<String> s = new Stack<String>(capacity);
			int c,opt;
			String elem;
			do{
				System.out.println("1-push\n2-pop\n3-Display\n4-quit\nOption: ");
				c=in.nextInt();
				if(c==1){

				System.out.println("Element: ");
				elem=in.next();
				s.push(elem);
				}
				else if(c==2){
				System.out.println("The element popped is: "+s.pop());
				}
				else if(c==3)
				 	s.display();
				else	
				   break;
				System.out.println("****************************");
				}while(c!=4);

		}
		else if(choice==2)
		{
			System.out.println("\nCapacity of the stack: ");
			capacity=in.nextInt();
			Stack<Integer> s = new Stack<Integer>(capacity);
			int c,opt;
			int elem;
			do{
				System.out.println("1-push\n2-pop\n3-Display\n4-quit\nOption: ");
				c=in.nextInt();
				if(c==1){

				System.out.println("Element: ");
				elem=in.nextInt();
				s.push(elem);
				}
				else if(c==2){
				System.out.println("The element popped is: "+s.pop());
				}
				else if(c==3)
					s.display();
				else	
				   break;
				System.out.println("****************************");
			}while(c!=4);
			
		}
		else if(choice==3){
			System.out.println("\nCapacity of the stack: ");
			capacity=in.nextInt();
			Stack<Float> s = new Stack<Float>(capacity);
			int c,opt;
			Float elem;
			do{
				System.out.println("1-push\n2-pop\n3-Display\n4-quit\nOption: ");
				c=in.nextInt();
				if(c==1){

				System.out.println("Element: ");
				elem=in.nextFloat();
				s.push(elem);
				}
				else if(c==2){
				System.out.println("The element popped is: "+s.pop());
			}
			else if(c==3)
			s.display();
			else	
			break;
				System.out.println("****************************");
			}while(c!=4);
			
		}
		else if(choice==4)
		{
			System.out.println("\nCapacity of the stack: ");
			capacity=in.nextInt();
			Stack<Double> s = new Stack<Double>(capacity);
			int c,opt;
			Double elem;
			do{
				System.out.println("1-push\n2-pop\n3-Display\n4-quit\nOption: ");
				c=in.nextInt();
				if(c==1){

				System.out.println("Element: ");
				elem=in.nextDouble();
				s.push(elem);
				}
				else if(c==2){
				System.out.println("The element popped is: "+s.pop());
				}
				else if(c==3)
				s.display();
				else	
				   break;
				System.out.println("****************************");
			}while(c!=4);
			
		}

		System.out.println("\nDo you want to continue? (1/0): ");
		ch=in.nextInt();
		}while(ch==1);
	}
}


