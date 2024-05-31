package Search;
import java.util.Scanner;
public class BinarySearch
{
	// static method for search element 
		public static int Search()
		{
			Scanner sc=new Scanner(System.in);
			// creating the array for linear search
			int arr[]={1,2,3,4,5,6,7,8,9};
			// printing array elements
			System.out.print("array elements:");
			for(int i=0;i<arr.length;i++)
			{
				System.out.print(arr[i]+",");			
			}
			// taking input for search elements in array
			System.out.print("\nenter no to search:");
			int se=sc.nextInt();		
			int low=0;
			int high=arr.length-1;
			while(low<=high)
			{
				int mid=low+(high-low)/2;
				if (arr[mid]==se)
				{
					return mid;
				}
				else if (arr[mid]<se)
				{
					low=mid+1;
				}
				else
				{
					high=mid-1;
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
