import java.util.Scanner;

class Cart
{   final static int max=5;
    int id[]=new int[max];
    int quantity[]=new int[max];
	double[] price=new double[max];
	String name[]=new String[max];
	static int count=0;
	Scanner sc1=new Scanner(System.in);
	void insert()
	{   if(count==max)
		System.out.println("no more item can be inserted #max limit");
	else
	{
		id[count]=(int)(Math.random()*100);
		System.out.print("product name:");
		name[count]=sc1.next();
        System.out.print("product quantity:");
        quantity[count]=sc1.nextInt();
        System.out.print("product price:");
        price[count]=sc1.nextDouble();
		
	  count++;
	}
	}
	
	void display()
	{
		for(int i=0;i<count;i++)
			System.out.println(id[i]+"\t\t"+name[i]+"\t"+quantity[i]+"\t"+price[i]);
	}
	
	double totalAmount()
	{   double bill=0;
		for(int i=0;i<count;i++)
			bill=bill+(price[i] * quantity[i]);
		return bill;
	}
	
	void remove(int a)
	{
		for(int i=0;i<count;i++)
		{
			if(a==id[i])
			{  
				for(int j=i;j<count;j++)
				{   id[j]=id[j+1];
					name[j]=name[j+1];
					price[j]=price[j+1];
					quantity[j]=quantity[j+1];
				}
				count=count-1;
				break;
			}
		}
	}
}
public class ShoppingCart {
public static void main(String args[])
{   int choice;
    Cart obj=new Cart();
	Scanner sc=new Scanner(System.in);
  while(true)
  {
	  System.out.println("enter the following to perform various operations:");
	  System.out.print("1 enter the element in cart \n2 remove element from cart \n3 display all items in cart with total amount\n 4 exit");
	  choice=sc.nextInt();
	  switch(choice)
	  {
	  case 1:
	         obj.insert();
		  break;
	  case 2:System.out.print("enter the id of element to be removed:");
	       obj.remove(sc.nextInt());
		  break;
	  case 3:System.out.println("elements of cart are:");
	         System.out.println("id\t\t name\t quantity\t price");
	        obj.display();
	        System.out.println("total amount=\t"+obj.totalAmount());
	         
		  break;
	  default: System.out.println("enter your choice correctly");
	  }
  }
	
}

}
