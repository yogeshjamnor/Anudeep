import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DuplicateRemove
{
    public static void main(String[] args) 
    {
    	//arraylist with fruite names
        List<String> stringList = Arrays.asList("apple", "banana", "apple", "orange", "banana", "pear");
        //removing duplicates
        List<String> uniqueStrings = stringList.stream().distinct().collect(Collectors.toList());
        //printing Duplicates
        System.out.println("List with duplicates removed: " + uniqueStrings);
    }
}
