public class SinglyLinkedList<E> {
    // nested Node class
    public Node<E> head = null;    // head node of the list (or null if empty)
    public Node<E> tail = null;    // last node of the list (or null if empty)
    public int size = 0;           // number of nodes in the list

    // constructor for the SinglyLinkedList
    public SinglyLinkedList() {
        // cosntructing an empty list
    }

    // constructs a list with the same elements as the given list
    // O(n) Time Complexity due to the while loop
    public SinglyLinkedList(SinglyLinkedList<E> list) {
        // constructs a list with the same elements as the given list
        Node<E> current = list.head;
        while (current != null) {
            addLast(current.getElement());
            current = current.getNext();
        }
    }

    // accessor methods
    // O(1) Time Complexity
    public int size() {
        return size;
    }

    // Method to check if the list is empty
    // O(1) Time Complexity
    public boolean isEmpty() {
        return size == 0;
    }

    // returns the first element
    // O(1) Time Complexity
    public E first() {
        // returns (but does not remove) the first element
        if (isEmpty()) return null;
        return head.getElement();
    }

    // returns the last element
    // O(1) Time Complexity
    public E last() {
        // returns (but does not remove) the last element
        if (isEmpty()) return null;
        return tail.getElement();
    }

    /* updating methods */
    // method to add an element to the front of the list
    // O(1) Time Complexity
    public void addFirst(E e) {
        // adds element e to the front of the list
        Node<E> newNode = new Node<>(e);
        newNode.setNext(head);
        head = newNode;
        // this is the first node if the list was empty
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    // method to add an element to the end of the list
    // O(1) Time Complexity
    public void addLast(E e) {
        // adds element e to the end of the list
        Node<E> newNode = new Node<>(e);
        if (isEmpty()) {
            head = newNode;  // special case: previously empty list
        } else {
            tail.setNext(newNode);  // new node after existing tail
        }
        tail = newNode;  // new node becomes the tail
        size++;
    }

    // method to remove the first element
    // O(1) Time Complexity
    public E removeFirst() {
        // removes and returns the first element
        if (isEmpty()) return null;  // nothing to remove
        E answer = head.getElement();
        head = head.getNext();  // will become null if list had only one node
        size--;
        if (size == 0) {
            tail = null;  // special case as list is now empty
        }
        return answer;
    }

    // method to remove the last element
    // O(n) Time Complexity due to the while loop
    public E removeLast(){
        if (head == null) return null; // nothing to remove
        
        E answer = tail.getElement();
        // if list had only one node
        if (head == tail) {
            head = null;
            tail = null;
            size = 0;
            return answer;
        }
        Node<E> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        size--;

        return answer;
    }
}
