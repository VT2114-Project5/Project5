package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- arielc19

import student.TestCase;

/**
 * This class tests all of the methods in the LinkedList Class
 * 
 * @author Ariel Carter
 * @version 11/17/2020
 */

public class LinkedListTest<T> extends TestCase {
    private LinkedList<Race> list1;
    private LinkedList<Race> list2;

    private Race white;
    private Race black;
    private Race asian;
    private Race latinx;

    /**
     * sets up test cases
     */

    public void setUp() {
        list1 = new LinkedList<Race>();
        list2 = new LinkedList<Race>();

        white = new Race("white", 5000, 10000);
        black = new Race("black", 19764, 35678);
        asian = new Race("asian", 6578, 12679);
        latinx = new Race("latinx", 8467, 40678);
    }


    /**
     * tests add(int index, T obj) method
     */
    
    public void testAdd() {
        assertTrue(list1.isEmpty());
        list1.add(0, white);
        assertFalse(list1.isEmpty());
        list1.add(1, black);
        assertEquals(2, list1.size());
        list1.add(0, asian);
        assertEquals(3, list1.size());
        list1.add(2, white);
        
        assertEquals(asian, list1.getEntry(0));
        assertEquals(white, list1.getEntry(1));
        assertEquals(white, list1.getEntry(2));
        assertEquals(black, list1.getEntry(3));
        
        Exception exception = null;
        try {
            list1.add(5, latinx);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception); 
        exception = null;
        try {
            list1.add(-1, latinx);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);  
    }


    /**
     * tests add(T obj) method
     */

    public void testAdd2() {
        list1.add(white);
        assertFalse(list1.isEmpty());
        list1.add(black);
        assertEquals(2, list1.size());
    }


    /**
     * tests getEntry() method
     */

    public void testGetEntry() {
        list1.add(white);
        list1.add(black);
        assertEquals(white, list1.getEntry(0));
        assertEquals(black, list1.getEntry(1));
        
        Exception exception = null;
        try {
            list1.getEntry(-1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception); 
        exception = null;
        try {
            list1.getEntry(5);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception); 
    }


    /**
     * tests size() method
     */

    public void testSize() {
        assertEquals(0, list1.size());
        list1.add(white);
        assertEquals(1, list1.size());
        list1.add(black);
        assertEquals(2, list1.size());
        list1.add(latinx);
        assertEquals(3, list1.size());
    }


    /**
     * tests isEmpty() method
     */

    public void testIsEmpty() {
        assertTrue(list1.isEmpty());
        list1.add(white);
        assertFalse(list1.isEmpty());
    }


    /**
     * tests remove(T obj) method
     */
    public void testRemove() {
        list1.add(white);
        list1.add(black);
        list1.add(latinx);
        list1.add(asian);
        assertTrue(list1.remove(latinx));
        assertTrue(list1.remove(asian));
        assertFalse(list1.remove(asian));
        assertTrue(list1.remove(white));
        assertEquals(1, list1.size());
        assertTrue(list1.remove(black));
        assertEquals(0, list1.size());
    }


    /**
     * tests remove(int index) method
     */
    public void testRemove2() {
        list1.add(white);
        list1.add(black);
        list1.add(latinx);
        assertTrue(list1.remove(0).equals(white));
        assertTrue(list1.remove(1).equals(latinx));
        assertEquals(1, list1.size());

        Exception exception = null;
        try {
            list1.remove(-1);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

        exception = null;
        try {
            list1.remove(3);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * tests replace() method
     */

    public void testReplace() {
        list1.add(white);
        list1.add(black);
        list1.add(latinx);
        list1.replace(0, asian);
        list1.replace(2, white);
        assertTrue(list1.contains(white));
        assertFalse(list1.contains(latinx));
        assertEquals(3, list1.size());

        Exception exception = null;
        try {
            list1.replace(-1, asian);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);

        exception = null;
        try {
            list1.replace(4, asian);
        }
        catch (IndexOutOfBoundsException e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * tests contains() method
     */

    public void testContains() {
        list1.add(white);
        list1.add(black);
        list1.add(latinx);
        assertTrue(list1.contains(white));
        assertTrue(list1.contains(black));
        assertTrue(list1.contains(latinx));
        assertFalse(list1.contains(asian));
    }


    /**
     * tests clear() method
     */

    public void testClear() {
        list1.add(white);
        list1.add(black);
        list1.add(latinx);
        assertEquals(3, list1.size());
        list1.clear();
        assertEquals(0, list1.size());
    }


    /**
     * tests toString() method
     */

    public void testToString() {
        assertEquals("{}", list1.toString());
        list1.add(white);
        list1.add(black);
        list1.add(latinx);
        assertEquals("{white: 10000 cases, 50% CFR, "
            + "black: 35678 cases, 55.4% CFR, "
            + "latinx: 40678 cases, 20.8% CFR}", list1.toString());
    }


    /**
     * tests equals() method
     */

    public void testEquals() {
        list1.add(white);
        list1.add(black);
        list1.add(latinx);

        assertTrue(list1.equals(list1));
        assertFalse(list1.equals(null));
        assertFalse(list1.equals("Hello"));

        list2.add(white);
        list2.add(black);

        assertFalse(list2.equals(list1));

        list2.clear();
        list2.add(white);
        list2.add(asian);
        list2.add(black);

        assertFalse(list2.equals(list1));

        list2.clear();
        list2.add(white);
        list2.add(black);
        list2.add(latinx);

        assertTrue(list1.equals(list2));
    }


    /**
     * tests toArray() method
     */

    public void testToArray() {
        list1.add(white);
        list1.add(black);
        list1.add(latinx);
        list1.add(asian);

        assertEquals(white, list1.toArray()[0]);
        assertEquals(black, list1.toArray()[1]);
        assertEquals(latinx, list1.toArray()[2]);
        assertEquals(asian, list1.toArray()[3]);
    }


    /**
     * tests iterator() method
     */

    public void testIterator() {
        // TO_DO
    }
}
