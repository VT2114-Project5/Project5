package prj5;


/**
 * Provides interface necessary to implement a list.
 *
 * @author Adam Oswald (adamoswald)
 * @param <T>
 *            The class that you want it to store
 * @version 11/18/2020
 */
public interface ListInterface<T>
{

    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public void add(int index, T obj);

    /**
     * Adds the object to the end of the list.
     *
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public void add(T obj);

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
    public T getEntry(int index);
    
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public int size();
    
    /**
     * Checks if the array is empty
     *
     * @return if the array is empty
     */
    public boolean isEmpty();

    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public boolean remove(T obj);

    /**
     * Removes the object at the given position
     *
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public void remove(int index);

    
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
    public void replace(int index, T newEntry); 
    
    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     * @throws IndexOutOfBoundsException
     *             if an element does not exist at the given index
     */
    public boolean contains(T obj);

    /**
     * Removes all of the elements from the list
     *
     * @postcondition size = 0 and all of the nodes are removed
     */
    public void clear();

    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    public String toString();
    
    /**
     * Checks if two lists are equal to each other in terms of items and order.
     * 
     * @param obj
     *          The other list to be compared
     * @return True if lists are equal, false if they are different.
     */
    public boolean equals(Object obj);
}
