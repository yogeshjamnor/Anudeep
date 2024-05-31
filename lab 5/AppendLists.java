package SingleLinkedList;

import java.util.ArrayList;
import java.util.List;

public class AppendLists 
{
	// crating static method for append the values
    public static void appendList(List<Integer> list1, List<Integer> list2) 
    {
        for (Integer num : list2)
        {
            list1.add(num);
        }
    }

    public static void main(String[] args) 
    {
    	// crating list 1 and adding elements in list
        List<Integer> list1 = new ArrayList<>();
        list1.add(22);
        list1.add(33);
        list1.add(44);
        list1.add(55);
        
        //creating list 2 
        List<Integer> list2 = new ArrayList<>();
        list2.add(66);
        list2.add(77);
        list2.add(88);
        list2.add(99);
        
        // printing list 1
        System.out.println("List1 before appending: " + list1);
        // appending element
        appendList(list1, list2);
        // printing the list 
        System.out.println("List1 after appending List2: " + list1);
    }
}
