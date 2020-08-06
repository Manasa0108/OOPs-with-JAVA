import java.util.*;
class ArrMax
{
      <T extends Comparable> T[] Arrange(T []arr)
      {
              T temp;
              for(int i=0;i<arr.length;i++)
              {
                    for(int j=i+1;j<arr.length;j++)
                    {
                              if(arr[j].compareTo(arr[i])<0)
                              {
                                  temp=arr[i];
                                  arr[i]=arr[j];
                                  arr[j]=temp;
                              }
                    }
              }
              return arr;
      }

      <T> void display(T []a)
      { 
            int i;
             for(i=0;i<a.length;i++)
             {
                      System.out.println(a[i]);
             }

      }
}

public class TestSort
{
  public static void main(String []args)
  {
      Scanner s=new Scanner(System.in);
      int num,i,ch;
      do
      {
          System.out.println("\nEnter the type of elements:\n0-Exit\n1-Integer\n2-Float\n3-String\n4-Character\n ");
      ch=s.nextInt();
      switch (ch)
      {
          case 1:System.out.println("Enter the number of elements: ");
                  num=s.nextInt();
                  Integer []a=new Integer[num];
                  System.out.println("Enter the elements: ");
                  for(i=0;i<num;i++)
                  {
                      a[i]=s.nextInt();
                  }      
                  ArrMax m=new ArrMax();
                  a=m.<Integer> Arrange(a);
                  System.out.println("The Sorted list is: \n");
                  m.<Integer> display(a);
                  break;
         case 2:System.out.println("Enter the number of elements: ");
                  num=s.nextInt();
                  Float []a1=new Float[num];
                  System.out.println("Enter the elements: ");
                  for(i=0;i<num;i++)
                  {
                      a1[i]=s.nextFloat();
                  }      
                  ArrMax m1=new ArrMax();
                  a1=m1.<Float> Arrange(a1);
                  System.out.println("The Sorted list is: \n");
                  m1.<Float> display(a1);
                  break;
          case 3:System.out.println("Enter the number of elements: ");
                  num=s.nextInt();
                  String []a2=new String[num];
                  System.out.println("Enter the elements: ");
                  for(i=0;i<num;i++)
                  {
                      a2[i]=s.next();
                  }      
                  ArrMax m2=new ArrMax();
                  a2=m2.<String> Arrange(a2);
                  System.out.println("The Sorted list is: \n");
                  m2.<String> display(a2);
                  break;
          case 4:System.out.println("Enter the number of elements: ");
                  num=s.nextInt();
                  Character []a3=new Character[num];
                  System.out.println("Enter the elements: ");
                  for(i=0;i<num;i++)
                  {
                      a3[i]=s.next().charAt(0);
                  }      
                  ArrMax m3=new ArrMax();
                  a3=m3.<Character> Arrange(a3);
                  System.out.println("The Sorted list is: \n");
                  m3.<Character> display(a3);
                  break;
      }
      }while(ch!=0);
  }
}
