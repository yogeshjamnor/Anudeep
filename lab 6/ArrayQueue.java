package Queue;

public class ArrayQueue 
{
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;
    
    // creating Queue
    public ArrayQueue(int size) 
    {
        maxSize = size;
        queueArray = new int[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    // inserting element
    public void enqueue(int item)
    {
        if (rear == maxSize - 1)
        {
            System.out.println("Queue is full. Cannot enqueue.");
        } 
        else 
        {
            queueArray[++rear] = item;
            nItems++;
        }
    }
    // removing element from queue
    public int dequeue() 
    {
        if (isEmpty()) 
        {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        } 
        else 
        {
            int temp = queueArray[front];
            front++;
            nItems--;
            return temp;
        }
    }
    // checking the queue is empty
    public boolean isEmpty() 
    {
        return (nItems == 0);
    }
    
    // size of queue
    public int size() 
    {
        return nItems;
    }

    public static void main(String[] args)
    {
        ArrayQueue queue = new ArrayQueue(5);
        // checking queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());
        // inserting element in queue
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        // removing element
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        // printing size
        System.out.println("Queue size: " + queue.size());
        // checking queue is empty
        System.out.println("Queue is empty: " + queue.isEmpty());
    }
}
