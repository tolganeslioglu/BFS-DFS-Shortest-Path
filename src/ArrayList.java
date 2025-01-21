public class ArrayList<E> {
    // instance variables
    public static final int CAPACITY = 16; // default array capacity
    private E[] data; // a generic array used for storage
    private int size = 0; // current number of elements
    
    // constructors
    public ArrayList() { 
        this(CAPACITY); 
    }

    // Copy constructor from another ArrayList
    // O(n) time complexity, where n is the number of elements in the list.
    @SuppressWarnings("unchecked")
    public ArrayList(ArrayList<E> list) {
        this.size = list.size;
        this.data = (E[]) new Object[list.data.length];
        for (int i = 0; i < list.size; i++) {
            this.data[i] = list.data[i];
        }
    }
    
    // constructs list with given capacity
    // O(1) time complexity
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity]; // safe cast; compiler may give warning
    }
    
    /* public methods */
    // Returns the number of elements in the array list. */
    // O(1) time complexity
    public int size() { 
        return size; 
    }
    
    // Returns whether the array list is empty.
    // O(1) time complexity
    public boolean isEmpty() { 
        return size == 0; 
    }
    
    // Returns (but does not remove) the element at index i.
    // O(1) time complexity because it is a direct access to the data array.
    public E get(int i) throws IndexOutOfBoundsException {
            checkIndex(i, size);
            return data[i];
    }
    
    // Replacing the element at i with e and returning the replaced element.
    // O(1) time complexity because it is a direct access to the data array.
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    // Doubles the array capacity when it is full.
    // O(n) time complexity in the worst case when the array is full.
    protected void resize(int capacity) {
        @SuppressWarnings("unchecked")
        // safe cast; compiler may give warning
        E[] temp = (E[]) new Object[capacity];
        // copy the elements from the old array to the new array
        for (int k = 0; k < size; k++)
            temp[k] = data[k];
        data = temp; 
    }
    

    // Adds element e to the array list at index i, shifting subsequent elements later.
    // O(n) time complexity in the worst case when resizing or shifting elements is needed. 
    public void add(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size + 1);
        if (size == data.length)
            // not enough capacity
            resize(2 * data.length); 
            // so double the current capacity
        for (int k = size - 1; k >= i; k--) { // start by shifting rightmost
            data[k + 1] = data[k];
        }
        data[i] = e; // placing the new element
        size++;
    }

    // Adds element e to the end of the list.
    // O(1) time complexity in the best case when the array does not need to be resized.
    // O(n) time complexity in the worst case when resizing is needed.
    public void add(E e) {
        add(size, e);
    }
    
    // Removes/returns the element at index i, shifting subsequent elements earlier.
    // O(n) time complexity in the worst case when shifting elements is needed.
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for (int k = i; k < size - 1; k++) {// shift elements to fill hole
            data[k] = data[k + 1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }

    // Returns whether the array list contains element e.
    // O(n) time complexity in the worst case when the element is not found.
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }
    
    // Checks whether the given index is in the range [0, n-1].
    // O(1) time complexity
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i >= n)
            throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

    
    // Custom toString method to print the path for BFS in a more readable format.
    // O(n) time complexity where n is the number of elements in the list. 
    public String toString(String[] vertices) {
    // Returns a string representation of the ArrayList
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < size; i++) {
        sb.append(vertices[(int) data[i]]); // Get the city name from the header
        if (i < size - 1) {
            sb.append(" -> ");
        }
    }
    return sb.toString();
    }
}