// Making a LIFO stack using a Singly Linked List.
public class LinkedStack<E> {
    // Implementing the stack as an adaptation of a SinglyLinkedList
    public SinglyLinkedList<E> list = new SinglyLinkedList<>();

    // Constructs an initially empty stack.
    public LinkedStack() { 
        // new stack relies on the initially empty list
    }

    // Returns the number of elements in the stack.
    // O(1) Time Complexity
    public int size() {
        return list.size();
    }

    // Tests whether the stack is empty.
    // O(1) Time Complexity
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Inserts an element at the top of the stack.
    // O(1) Time Complexity
    public void push(E element) {
        list.addLast(element);
    }

    // Returns, but does not remove, the top element of the stack.
    // O(1) Time Complexity
    public E top() {
        return list.last();
    }

    // Removes and returns the top element of the stack.
    // O(1) Time Complexity
    public E pop() {
        return list.removeLast();
    }

    // Returns a string representation of the stack as a list of elements.
    // O(n) Time Complexity due to the while loop
    @Override
    public String toString() {
        // Using StringBuilder to build the string representation of the stack
        StringBuilder sb = new StringBuilder();
        Node<E> current = list.head;
        // Iterating through the stack
        // O(n) Time Complexity
        while (current.next != null) {
           sb.append(current.element + " -> ");
            current = current.next;
        }
        sb.append(current.element);
        return sb.toString();
    }
}