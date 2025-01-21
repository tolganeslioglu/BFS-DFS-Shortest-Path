public class Node<E> {
    public E element;  // reference to the element stored at this node
    public Node<E> next;  // reference to the subsequent node in the list

    // Constructor for the Node class
    public Node(E e) {
        element = e;
    }

    // Accessor methods
    // O(1) Time Complexity
    public E getElement() {
        return element;
    }

    // Accessor methods
    // O(1) Time Complexity
    public Node<E> getNext() {
        return next;
    }

    // Modifier methodts
    // O(1) Time Complexity
    public void setNext(Node<E> n) {
        next = n;
    }
}
