package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- arielc19

import student.TestCase;

/**
 * This class tests all of the methods in the Race Class
 * 
 * @author Ariel Carter
 * @version 11/17/2020
 */

public class RaceTest extends TestCase {
    private Race white;
    private Race black;
    private Race asian;
    private Race latinx;

    private Race white2;
    private Race black2;
    private Race asian2;

    /**
     * sets up the test cases
     */

    public void setUp() {
        white = new Race("white", 5000, 10000);
        black = new Race("black", 19764, 35678);
        asian = new Race("asian", 6578, 12679);
        latinx = new Race("latinx", 8467, 40678);

        white2 = new Race("white", 19764, 100000);
        black2 = new Race("black", 6578, 12679);
        asian2 = new Race("asian", 6578, 12679);
    }


    /**
     * tests getCases() methods
     */

    public void testGetCases() {
        assertEquals(10000, white.getCases());
        assertEquals(35678, black.getCases());
        assertEquals(12679, asian.getCases());
        assertEquals(40678, latinx.getCases());
    }


    /**
     * tests getDeaths() method
     */

    public void testGetDeaths() {
        assertEquals(5000, white.getDeaths());
        assertEquals(19764, black.getDeaths());
        assertEquals(6578, asian.getDeaths());
        assertEquals(8467, latinx.getDeaths());
    }


    /**
     * tests getCfr() method
     */

    public void testGetCfr() {
        assertEquals(50.0, white.getCfr(), 0.001);
        assertEquals(55.4, black.getCfr(), 0.001);
        assertEquals(51.9, asian.getCfr(), 0.001);
        assertEquals(20.8, latinx.getCfr(), 0.001);
        white = new Race("white", -1, 500);
        black = new Race("black", 9283, -1);
        asian = new Race("Asian", -1, -1);
        assertEquals(-1, white.getCfr(), 0.001);
        assertEquals(-1, black.getCfr(), 0.001);
        assertEquals(-1, asian.getCfr(), 0.001);
    }


    /**
     * tests getName()
     */

    public void testGetName() {
        assertEquals("white", white.getName());
        assertEquals("black", black.getName());
        assertEquals("asian", asian.getName());
        assertEquals("latinx", latinx.getName());
    }


    /**
     * tests toString() method
     */

    public void testToString() {
        assertEquals("white: 10000 cases, 50% CFR", white.toString());
        assertEquals("black: 35678 cases, 55.4% CFR", black.toString());
        assertEquals("asian: 12679 cases, 51.9% CFR", asian.toString());
        assertEquals("latinx: 40678 cases, 20.8% CFR", latinx.toString());
    }


    /**
     * tests equals() method
     */

    public void testEquals() {
        Race nullRace = null;

        assertTrue(white.equals(white));
        assertFalse(black.equals(nullRace));
        assertFalse(asian.equals("Hello"));
        assertFalse(white.equals(latinx));

        assertFalse(white.equals(white2));
        assertFalse(asian.equals(black2));
        assertTrue(asian.equals(asian2));

        Race whiteAlmost = new Race("white", 429, 10000);
        Race whiteAlmost2 = new Race("white", 858, 20000);
        assertFalse(white.equals(whiteAlmost));
        assertFalse(white.equals(whiteAlmost2));

    }

}
