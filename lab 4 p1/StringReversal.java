package Stack;

import java.util.Stack;
import java.util.Scanner;

public class StringReversal {
    public static String reverseString(String input)
    {
    	// creating character stack 
        Stack<Character> stack = new Stack<>();
        StringBuilder reversed = new StringBuilder();
        
        // inserting the character in stack
        for (char c : input.toCharArray()) 
        {
            stack.push(c);
        }
        // checking stack is empty
        while (!stack.isEmpty()) 
        {
            reversed.append(stack.pop());
        }
        // return reverse string
        return reversed.toString();
    }

    public static void main(String[] args) 
    {
    	
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter String for Reverse: ");
    	
    	// getting the input from user
        String input = sc.nextLine();
        String reversedString = reverseString(input);
        // original string
        System.out.println("Original String: " + input);
        // reverse string
        System.out.println("Reversed String: " + reversedString);
    }
}
