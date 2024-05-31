package Hashmap;

import java.util.ArrayList;

public class GenericList<T> 
{
    private ArrayList<T> elements = new ArrayList<>();

    public void addElement(T element) 
    {
        elements.add(element);
    }

    public T getElement(int index)
    {
        return elements.get(index);
    }

    public void printList()
    {
        for (T element : elements)
        {
            System.out.println(element);
        }
    }
}
class GenericAccess 
{
    public static void main(String[] args)
{
    	// creating object of GenericList class
        GenericList<String> stringList = new GenericList<>();
        // adding element
        stringList.addElement("Apple");
        stringList.addElement("Banana");
        stringList.addElement("Cherry");
        //Printing List
        stringList.printList();
        // accessing  by it's index
        System.out.println("Element at index 1: " + stringList.getElement(1));
    }
}