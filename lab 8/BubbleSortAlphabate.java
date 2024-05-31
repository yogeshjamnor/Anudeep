package sorting;
import java.util.Arrays;

public class BubbleSortAlphabate 

{
	// sorting algorithm 
	public static void sort(String arr[])
	{
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) 
        {
            for (int j = 0; j < n - i - 1; j++) 
            {
                if (arr[j].compareTo(arr[j + 1]) > 0) 
                {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println( Arrays.toString(arr));
    }
	// printing array 
	public static void display(String arr[])
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
		String[] arr = {"banana", "apple", "grape", "orange", "kiwi", "mango"};
		// displaying array
		System.out.print("original array: ");
		display(arr);
		
		// call sorting algorithm 
		
		// using bubble sort
		System.out.print("\nusing Bubble sort:");
		sort(arr);

		// printing sorted array
		System.out.print("\n sorted using Arrays.Sort() :");
		Arrays.sort(arr);
		display(arr);
		
	}

}

