// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- arielc19, adamoswald, olsenbudanur

package prj5;

import student.TestCase;

/**
 * This class tests the functions within the State class
 * 
 * @author Ariel Carter
 * @version 11/17/2020
 * 
 * @author Adam Oswald (adamoswald)
 * @version 11/18/2020
 */

public class StateTest extends TestCase {
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

        list1 = new LinkedList<Race>();
        list1.add(white);
        list1.add(black);
        list2 = new LinkedList<Race>();
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
        assertEquals(white, state1.getRaces()[0]);
        assertEquals(black, state1.getRaces()[1]);

        state2.setRaces(list2);
        assertEquals(asian, state2.getRaces()[0]);
        assertEquals(latinx, state2.getRaces()[1]);
        assertEquals(white, state2.getRaces()[2]);
        assertEquals(black, state2.getRaces()[3]);
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
        list1.add(new Race("asian", 19764, 35678));
        state1.setRaces(list1);
        assertEquals(state1.toString(), "DC" + "\nasian: 35678 cases, 55.4% CFR"
            + "\nblack: 35678 cases, 55.4% CFR"
            + "\nwhite: 10000 cases, 50% CFR" + "\n====="
            + "\nasian: 35678 cases, 55.4% CFR"
            + "\nblack: 35678 cases, 55.4% CFR"
            + "\nwhite: 10000 cases, 50% CFR" + "\n=====");
    }


    /**
     * tests equals() method
     */
    public void testEquals() {
        State nullState = null;

        state1.setRaces(list1);
        state2.setRaces(list2);
        assertTrue(state1.equals(state1));
        assertFalse(state1.equals(nullState));
        assertFalse(state1.equals("Hello"));
        assertFalse(state1.equals(state2));

        // List same, different name
        list2.clear();
        list2.add(white);
        list2.add(black);
        state2.setRaces(list2);
        assertFalse(state1.equals(state2));
        // Equal, but different refs (cloned)
        state2 = new State("DC");
        state2.setRaces(list2);
        assertTrue(state1.equals(state2));
        // Same name, but different size
        list2.add(asian);
        assertFalse(state1.equals(state2));

        // When size and names are the same, but elements aren't
        list2.clear();
        list2.add(black);
        list2.add(asian);
        assertFalse(state1.equals(state2));
    }
}
