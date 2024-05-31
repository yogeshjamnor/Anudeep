package SingleLinkedList;

// creating node
class Node
{
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList 
{
    Node head;
    
    // reverse the linked list elements 
    void reverse()
    {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }
    
    // printing the elemets in linked list
    void printList() 
    {
        Node temp = head;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) 
    {
    	// object of linked list
        LinkedList list = new LinkedList();
        // adding 4 nodes in linked list
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        
        // printing the original linked list
        System.out.println("Original Linked List:");
        list.printList();
        // calling reverse
        list.reverse();
        // printing the reverse linked list
        System.out.println("\nReversed Linked List:");
        list.printList();
    }
}
