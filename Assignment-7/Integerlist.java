import java.util.*;

public class Integerlist
{
	public static void main(String a[])
	{
		int opt,num;
		boolean equal;
		System.out.println("\nInteger List operations \n");
		Scanner obj=new Scanner(System.in);
		Integerlist ali=new Integerlist();
		
		ArrayList<Integer> al1=new ArrayList<Integer>();
		ArrayList<Integer> al2=new ArrayList<Integer>();
			
		do{
			System.out.println("\nMenu :\n1.Enter elements for List's \n2.Merge the two lists\n3.Find Union of two lists\n4.Find Intersection of two lists\n5.Compare two lists\n6.exit\nEnter option: ");
			opt=obj.nextInt();
			switch(opt)
			{
				case 1:System.out.println("\nEnter integer to add : ");	
						System.out.println("\nList 1 : ");
						num=obj.nextInt();
						al1.add(num);
						System.out.println("\nList 2 : ");
						num=obj.nextInt();
						al2.add(num);
						break;
				case 2:al1.addAll(al2);
						System.out.println("List after merging : "+al1);
						break;
				case 3:Set<Integer> set = new HashSet<Integer>();
						set.addAll(al1);
						set.addAll(al2);
						System.out.println("Union of two Lists : "+set);
						break;
        		case 4: List<Integer> list = new ArrayList<Integer>();
						for (Integer t : al1) 
						{
								if(al2.contains(t))	
									list.add(t);
						}
						System.out.println("Intersection of two Lists : "+list);
						break;
        		case 5:equal=al1.equals(al2);
						if(equal==true)	System.out.println("Two List's are equal");
						else	System.out.println("Two List's are not equal");
						break;

				}
		}while(opt!=6);
	}
}
