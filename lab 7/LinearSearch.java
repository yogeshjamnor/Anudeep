package Search;
import java.util.Scanner;
public class LinearSearch 
{
	// static method for search element 
	public static int Search()
	{
		Scanner sc=new Scanner(System.in);
		// creating the array for linear search
		int arr[]={1,5,6,4,3,2,8,9,7};
		// printing array elements
		System.out.print("array elements:");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+",");			
		}
		// taking input for search elements in array
		System.out.print("\nenter no to search:");
		int se=sc.nextInt();		
		
		// checking element in array
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==se)
			{
				return i;
			}			
		}
		return -1;
	}
	public static void main(String[] args) 
	{	
		// calling  search method 
		int re=Search();
		// printing the element if present 
		if(re!=-1)
		{
			System.out.println("element found at index :"+re);
		}
		else
		{
			System.out.println("element not present in array");
		}
	}

}
