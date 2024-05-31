// program for String Manipulation using lambada

interface StringManipulator 
    {
        String manipulateString(String str);
    }
public class StringManupulationProgram 
{
    public static void main(String[] args) 
    {
    	// convert string to upper lower and reverse
        StringManipulator upperCase = str -> str.toUpperCase();
        StringManipulator lowerCase = str -> str.toLowerCase();
        StringManipulator reverse = str -> new StringBuilder(str).reverse().toString();
        // original string or user given string
        String inputString = "Hello, Yogesh Good Morning";
        // printing stringS
        System.out.println("Original String: " + inputString);
        System.out.println("Uppercase: " + upperCase.manipulateString(inputString));
        System.out.println("Lowercase: " + lowerCase.manipulateString(inputString));
        System.out.println("Reversed: " + reverse.manipulateString(inputString));
    }

   
}
