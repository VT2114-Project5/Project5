// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- adamoswald

package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A list implementation using linked chains. Has a head and tail, but the
 * chain is singly-linked.
 * 
 * @author Adam Oswald (adamoswald)
 * @version 11/19/2020
 *
 * @param <T>
 */
public class LinkedList<T> implements ListInterface<T>, Iterable<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Create a new Linked List
     */
    public LinkedList() {
        size = 0;
    }

    /**
     * Adds the object to the end of the list.
     *
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             Index is under 0 or not within the size.
     */
    @Override
    public void add(int index, T obj) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException("Index is not within bounds.");
        }

        Node<T> newNode = new Node<T>(obj);
        if (index == 0) {
            newNode.setNext(head);
            head = newNode;
            if (isEmpty()) {
                tail = newNode;
            }
        }
        else if (index == size()) {
            tail.next = newNode;
            tail = newNode;
        }
        else {
            Node<T> nodeBefore = getNodeBefore(index);
            newNode.setNext(nodeBefore.next);
            nodeBefore.next = newNode;
        }
        size++;
    }

    /**
     * Gets the node right before the specified. Returns the node at index - 1.
     * @param index 
     *          The index of the node right after the target node
     * @return The Node object of the target node.
     */
    private Node<T> getNodeBefore(int index) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException("Index is not within bounds.");
        }
        Node<T> nodeBefore = head;
        for (int i = 1; i < index; i++) {
            nodeBefore = nodeBefore.next;
        }
        return nodeBefore;
    }

    /**
     * Adds the object to the start of the list.
     *
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    @Override
    public void add(T obj) {
        add(size(), obj);
    }

    /**
     * Gets the entry at a specific index without removing the element from
     * the list
     * 
     * @param index 
     *              The index of the element to access
     * @throws IndexOutOfBoundsException
     *              if index is less than zero or greater than size
     * @return The element at the given index.
     */
    @Override
    public T getEntry(int index) {
        if (index == 0) {
            return head.getData();
        }
        Node<T> beforeNode = getNodeBefore(index); // throws IndexOOB
        return beforeNode.next.getData();


    }

    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty
     *
     * @return if the list is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Removes the first instance of the given item from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful, false if could not be found
     */
    @Override
    public boolean remove(T obj) {
        Node<T> currentNode = head;

        if (head.getData().equals(obj)) {   // Case 1: head needs to be removed
            head = head.next;
            size--;
            return true;
        }

        while (currentNode.next != null) {
            if (currentNode.next.getData().equals(obj)) {
                System.out.println(tail.getData().toString());
                if (currentNode.next == tail) {
                    tail = currentNode;
                    currentNode.next = null;
                }
                else {
                    currentNode.next = currentNode.next.next;
                }
                size--;
                return true;
            }

            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Removes the object at the given position
     *
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    @Override
    public T remove(int index) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException("Index is not within bounds.");
        }
        T temp = null;
        if (index == 0) {
            temp = head.getData();
            head = head.next;

        }
        else {
            Node<T> nodeBefore = getNodeBefore(index);
            temp = nodeBefore.next.getData();
            nodeBefore.next = nodeBefore.next.next;
        }
        size--;
        return temp;

    }

    /**
     * Replaces a selected element data based on index with a new one. Doesn't
     * change the size of the list.
     * 
     * @param index
     *              The index to have it's data replaced
     * @param newEntry 
     *              The new data that is replacing the existing data at the
     * current index
     * @throws IndexOutOfBoundsException
     *              if index is less than zero or greater than size
     */
    @Override
    public void replace(int index, T newEntry) {
        if (index < 0 || size < index) {
            throw new IndexOutOfBoundsException("Index is not within bounds.");
        }
        if (index == 0) {
            head.setData(newEntry);
        }
        else {
            Node<T> nodeBefore = getNodeBefore(index);
            nodeBefore.next.setData(newEntry);
        }
    }

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object, false if it does not.
     */
    @Override
    public boolean contains(T obj) {
        Node<T> currentNode = head;

        while (currentNode != null) {
            if (currentNode.getData().equals(obj)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;
    }

    /**
     * Removes all of the elements from the list
     *
     */
    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * Prints the contents as a String. Items are in curly brackets ("{}"),
     * with each item separate by a comma (",").
     * 
     * @return String representation of the list
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        if (!isEmpty()) {
            Node<T> currNode = head;
            while (currNode != null) {
                T element = currNode.getData();
                builder.append(element.toString());
                if (currNode.next != null) {
                    builder.append(", ");
                }  
                currNode = currNode.getNext();
            }
        }

        builder.append("}");
        return builder.toString();
    }

    /**
     * Checks if two lists are equal to each other in terms of items and order.
     * 
     * @param obj
     *          The other list to be compared
     * @return True if lists are equal, false if they are different.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<T> other = ((LinkedList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.getNext();
                    otherCurrent = otherCurrent.getNext();
                }
                return true;
            }
        }

        return false;
    }

    /**
     * Turn the contents of the list into an array
     * @return Array representation of the current list.
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];
        Iterator<T> iter = iterator();
        for (int i = 0; i < size; i++) {
            array[i] = iter.next();
        }

        return array;
    }


    /**
     * Sorts items respective to the comparator given.
     * 
     * @param <T>
     *          The data type
     * @param comp
     *          The Comparator used to compare the items
     * @param list
     *          The list to be sorted.
     */
    public static <T> void sort(LinkedList<T> list, 
        Comparator<? super T> comp) {

        Iterator<T> iter = list.iterator();
        LinkedList<T> sortedList = new LinkedList<T>();
        while (iter.hasNext()) {
            T curElement = iter.next();
            int index = 0;

            while (index < sortedList.size 
                && comp.compare(curElement, sortedList.getEntry(index)) >= 0) {

                index++;
            }

            sortedList.add(index, curElement);
        }
        list.head = sortedList.head;
    }

    /**
     * Returns an Iterator object of the list.
     * 
     * @return The iterator of the list
     */
    @Override
    public Iterator<T> iterator() {
        return new ListIterator<T>();
    }

    /**
     * Iterator for LinkedList
     * 
     * @author Adam Oswald <adamoswald>
     * @version 11/18/2020
     *
     * @param <T> The type our iterator accepts.
     */
    private class ListIterator<E> implements Iterator<T>  {

        // Running node method
        private Node<T> prevNode;
        private Node<T> cursorNode;

        /**
         * Initialize the iterator by creating a dummy Node that links to
         * the head.
         */
        public ListIterator() {
            cursorNode = new Node<T>(null, head);
        }

        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return (cursorNode.next != null);
        }

        /**
         *Gets the next value in the list
         *
         * @return the next value
         * @throws NoSuchElementException
         *             if there are no nodes left in the list
         */
        @Override
        public T next() {
            if (cursorNode.next == null) {
                throw new NoSuchElementException("No more elements");
            }
            T temp = cursorNode.next.getData();
            prevNode = cursorNode;
            cursorNode = cursorNode.next;

            return temp;
        }

        /**
         * Removes the last object returned with next() from the list
         *
         * @throws IllegalStateException
         *             if next has not been called yet
         *        and  if the element has already been removed
         */
        @Override
        public void remove() {
            if (prevNode.next != cursorNode || prevNode == null) {
                throw new IllegalStateException("Cursor not on active element");
            }
            prevNode.next = cursorNode.next;
            size--;
        }
    }

    /**
     * Basic Node implementation.
     * 
     * @param <T> the data type
     * 
     * @author Adam Oswald (adamoswald)
     * @version 2020.11.18
     */
    private static class Node<T> {

        private T data;
        private Node<T> next;

        /**
         * Create a new node with no specified next node
         * @param data
         *          The data to be set for the new node.
         */
        public Node(T data) {
            this(data, null);
        }

        /**
         * Create a new node with preset values.
         * @param data
         *          Data contained in node
         * @param next
         *          The next referenced node
         */
        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * Sets the data for the current Node object.
         * 
         * @param newData
         *          Data of the new Node object.
         */
        public void setData(T newData) {
            data = newData;
        }

        /**
         * Sets the next node in the chain
         * 
         * @param newNext
         *          The new node to be inserted
         */
        public void setNext(Node<T> newNext) {
            next = newNext;
        }

        /**
         * Get the next node in the chain
         * 
         * @return The next node
         */
        public Node<T> getNext() {
            return next;
        }

        /**
         * Get the data contained in the node.
         * 
         * @return The data in the node.
         */
        public T getData() {
            return data;
        }

    }

}
