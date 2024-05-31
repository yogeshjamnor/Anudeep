package Stack;

import java.util.Stack;

public class PalidromeChecker 
{
	// crating static method for palindrome
    public static boolean isPalindrome(String str) 
    {
        Stack<Character> stack = new Stack<>();

        int mid = str.length() / 2;
        int i;
        
        // inserting element in stack
        for (i = 0; i < mid; i++) 
        {
            stack.push(str.charAt(i));
        }

        if (str.length() % 2 != 0) 
        {
            i++;
        }
        // checking stack length 
        while (i < str.length()) 
        {
            if (stack.isEmpty() || stack.pop() != str.charAt(i)) 
            {
                return false;
            }
            i++;
        }

        return true;
    }

    public static void main(String[] args) 
    {
    	
        String testString = "racecar";
        // printing palindrome or not
        if (isPalindrome(testString)) 
        {
            System.out.println(testString + " is a palindrome.");
        }
        else 
        {
            System.out.println(testString + " is not a palindrome.");
        }
    }
}
