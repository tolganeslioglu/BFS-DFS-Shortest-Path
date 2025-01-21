// Making of a FIFO queue using a Singly Linked List
public class LinkedQueue<E> {
    // Implementing the queue as an adaptation of a SinglyLinkedList
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    // Constructs an initially empty queue.
    public LinkedQueue() {
        // new queue relies on the initially empty list
    }

    // Returns the number of elements in the queue.
    // O(1) Time Complexity
    public int size() {
        return list.size();
    }

    // Tests whether the queue is empty.
    // O(1) Time Complexity
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Inserts an element at the rear of the queue.
    // O(1) Time Complexity
    public void enqueue(E element) {
        list.addLast(element);
    }

    // Returns, but does not remove, the first element of the queue.
    // O(1) Time Complexity
    public E first() {
        return list.first();
    }

    // Removes and returns the first element of the queue.
    // O(1) Time Complexity
    public E dequeue() {
        return list.removeFirst();
    }
}