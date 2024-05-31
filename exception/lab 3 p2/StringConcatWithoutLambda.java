import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class StringConcatWithoutLambda 
{

	    public static void main(String[] args) 
	    {
	    	//creating list
	        List<String> stringList = Arrays.asList("Hello", "Yogesh", "Using", "Stream", "API");
	        //joining list
	        String concatenatedString = stringList.stream().collect(Collectors.joining());
	        // printing list
	        System.out.println("Concatenated String: " + concatenatedString);
	    }
}