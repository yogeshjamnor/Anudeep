package Hashmap;
public class MaxElementFinder
{

    public static <T extends Comparable<T>> T findMaxElement(T[] array) 
    {
        if (array == null || array.length == 0) 
        {
            return null;
        }

        T max = array[0];
        for (int i = 1; i < array.length; i++) 
        {
            if (array[i].compareTo(max) > 0)
            {
                max = array[i];
            }
        }

        return max;
    }

    public static void main(String[] args) 
    {
    	//create and adding arrays 
        Integer[] intArray = {1, 5, 3, 9, 2};
        Double[] doubleArray = {2.5, 1.2, 3.7, 2.0};
        String[] stringArray = {"apple", "banana", "orange", "kiwi","grape"};
        // printing maximum 
        System.out.println("Maximum Integer: " + findMaxElement(intArray));
        System.out.println("Maximum Double: " + findMaxElement(doubleArray));
        System.out.println("Maximum String: " + findMaxElement(stringArray));
    }
}
