// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- arielc19, adamoswald, olsenbudanur
// Used Lab 09 interface as the template

package prj5;


/**
 * Provides interface necessary to implement a list.
 *
 * @author Adam Oswald (adamoswald)
 * @param <T>
 *            The data type
 * @version 11/18/2020
 */
public interface ListInterface<T>
{

    /**
     * Adds an item to a selected index of the list.
     *
     * @param index
     *            index to add the item
     * @param obj
     *            the item to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     */
    public void add(int index, T obj);

    /**
     * Adds the item to the end of the list.
     *
     * @param obj
     *            the item to add
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
     * Checks if the list is empty
     *
     * @return if the list is empty
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
     * @param index
     *              Index to be removed
     * @return The item that was just removed.s
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public T remove(int index);

    
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
     */
    public boolean contains(T obj);

    /**
     * Removes all of the elements from the list
     *
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
