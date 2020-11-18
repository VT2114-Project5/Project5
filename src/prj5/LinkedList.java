package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements ListInterface<T>, Iterable<T> {

    public LinkedList() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void add(int index, T obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void add(T obj) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public T getEntry(int index) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean remove(T obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void replace(int index, T newEntry) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean contains(T obj) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public String toString() {
     // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public boolean equals(Object obj) {
     // TODO Auto-generated method stub
        return false;
    }
    
    public static <T> void sort(Comparator<? super T> comp, LinkedList<T> list) {
        
    }

    @Override
    public Iterator<T> iterator() {
        // TODO Auto-generated method stub
        return null;
    }
    
    /**
     * Iterator for LinkedList
     * 
     * @author Adam Oswald <adamoswald>
     * @version 11/18/2020
     *
     * @param <A> The type our iterator accepts.
     */
    private class ListIterator<E> implements Iterator<T>  {

        public ListIterator() {
         // TODO Auto-generated method stub
        }
        
        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            // TODO Auto-generated method stub
            return false;
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
            // TODO Auto-generated method stub
            return null;
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
            // TODO Auto-generated method stub
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
