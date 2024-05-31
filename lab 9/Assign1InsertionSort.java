package sorting;
import java.util.Scanner;
public class Assign1InsertionSort 
{	
	// insertion Sort
	public static void insertionSort(String[] arr)
	{
		for (int i = 1; i < arr.length; i++) 
		{
			String key = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j].compareTo(key) > 0) 
			{
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}
	public static void display(String arr[])
	{
		for(String i:arr)
		{
			System.out.print(i+"  ");
		}
			
	}

	    public static void main(String[] args) 
	    {
	    	// creating input object
	        Scanner input = new Scanner(System.in);
	        // taking number of element inserting in array
	        System.out.print("Enter the size of array strings: ");
	        int n = input.nextInt();
	        input.nextLine(); // Consume the newline character
	        
	        String[] strings = new String[n];
	        System.out.println("Enter the strings:");
	        // taking string inputs
	        for (int i = 0; i < n; i++)
	        {
	            strings[i] = input.nextLine();
	        }
	        // sorting by insertion sort
	        insertionSort(strings);
	        // 
	        System.out.println("\nSorted Strings:");
	        display(strings);
	        input.close();
	    }

	   
	}
