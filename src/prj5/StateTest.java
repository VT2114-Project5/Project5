package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- arielc19

import java.util.Collections;
import java.util.LinkedList;
import student.TestCase

/**
 * This class tests the functions within the State class
 * 
 * @author Ariel Carter
 * @version 11/17/2020
 */
public StateTest extends TestCase{
    private Race white;
    private Race black;
    private Race asian;
    private Race latinx;
    
    private LinkedList<Race> list1;
    private LinkedList<Race> list2;
    
    private State state1;
    private State state2;
    
    /**
     * sets up test cases
     */
    
    public void setUp() {
        white = new Race("white", 5000, 10000);
        black = new Race("black", 19764, 35678);
        asian = new Race("asian", 6578, 12679);
        latinx = new Race("latinx", 8467, 40678);
        
        list1 = new LinkedList();
        list1.add(white);
        list1.add(black);
        list2 = new LinkedList();
        list2.add(asian);
        list2.add(latinx);
        list2.add(white);
        list2.add(black);
        
        state1 = new State("DC");
        state2 = new State("GA");
    }
    
    /**
     * tests setRaces() method
     */
    
    public void testSetRaces() {
        state1.setRaces(list1);
        assertEquals(white, state1.toArray()[0]);
        assertEquals(black, state1.toArray()[1]);
    }
    
    /**
     * tests getName() method
     */
    
    public void testGetName() {
        assertEquals("DC", state1.getName());
        assertEquals("GA", state2.getName());
    }
    
    /**
     * tests toString() method
     */
    
    public void testToString() {
        state1.setRaces(list1);
        assertEquals(list1.toString(), "DC\nblack: 35678 cases, 55.4% CFR"
            + "\nwhite: 10000 cases, 50.0% CFR\n=====\nblack: 35678 cases, "
            + "55.4% CFR\\nwhite: 10000 cases, 50.0% CFR\n=====");
    }
    
    /**
     * tests sortAlpha() method
     */
    
    public void testSortAlpha() {
        
    }
    
    /**
     * tests sortByCFR() method
     */
    
    public void testByCFR() {
        
    }
    
    /**
     * tests equals() method
     */
    
    public void testEquals() {
        state1.setRaces(list1);
        state2.setRaces(list2);
        assertTrue(state1.equals(state1));
        assertFalse(state1.equals(null));
        assertFalse(state1.equals("Hello"));
        assertFalse(state1.equals(state2));
        
        list2.clear;
        list2.add(white);
        list2.add(black);
        state2.setRaces(list2);
        assertTrue(state1.equals(state2));
    }
}