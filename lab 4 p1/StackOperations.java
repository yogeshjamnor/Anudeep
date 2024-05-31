package Stack;
public class Stack 
{
    private Integer[] stackArray;
    private int top;
    private int capacity;

    // defining size of stack 
    public Stack(int size) 
    {
        stackArray = new Integer[size];
        capacity = size;
        top = -1;
    }

    // performing insertion
    public void push(Integer item) 
    {
        if (top == capacity - 1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        stackArray[++top] = item;
    }
// removing element
    public Integer pop() 
    {
        if (top == -1) 
        {
            System.out.println("Stack Underflow");
            return null;
        }
        return stackArray[top--];
    }
// top element
    public Integer peek() 
    {
        if (top == -1) 
        {
            System.out.println("Stack is empty");
            return null;
        }
        return stackArray[top];
    }
    
    // checking stack empty
    public boolean isEmpty() 
    {
        return top == -1;
    }
}



public class Main
{
    public static void main(String[] args) 
    {
    	//creating object of stack class perform operation 
        Stack stack = new Stack(5);
        
        // performing insertion
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // getting top element
        System.out.println("Peek: " + stack.peek());
        // remove and return element
        System.out.println("Pop: " + stack.pop());
        
        System.out.println("Peek: " + stack.peek());
        // checking stack is empty
        System.out.println("Is Empty: " + stack.isEmpty());
    }
}
