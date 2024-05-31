package sorting;

import java.util.Arrays;

public class BubbleSort 
{
	// sorting algorithm 
	public static void sort(int arr[])
	{
		System.out.println("sort using the bubble: ");
		// loop for sorting to swap adjucent elements
		for(int i=0;i<arr.length;i++)
		{
			boolean loop=false;
			for(int j=0;j<arr.length-i-1; j++)
			{
				if(arr[j]>arr[j+1])
				{
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					loop=true;
					
				}
			}
			// braking loop after iteration 
			if(!loop)
			{
				System.out.println("\n\nsorting complete after "+i+" loop iteration \n ");
				break;
			}
		}
		
	}
	// printing array 
	public static void display(int arr[])
	{
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"  ");
		}
		
	}
	// sort using array.sort

	public static void main(String[] args) 
	{
		// creating array
		int arr[]= {8,7,4,3,9,2,1,10,12};
		// displaying array
		System.out.print("original array: ");
		display(arr);
		
		// call sorting algorithm 
		
		// using bubble sort
		System.out.print("\nusing Bubble sort:");
		sort(arr);
		display(arr);
		// printing sorted array
		System.out.print("sorted using Arrays.Sort() :");
		Arrays.sort(arr);
		display(arr);
		
	}

}
