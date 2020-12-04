// Virginia Tech Honor Code Pledge://
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- olsenbudanur

package prj5;

import student.TestCase;

/**
 * This class tests the functions within the GUIController class.
 * 
 * @author Olsen Budanur olsenbudanur
 * @version 12/3/2020
 */
public class GUIControllerTest extends TestCase {

    private DocumentReader read;
    private GUIController controller;

    public void setUp() throws Exception {
        read = new DocumentReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        controller = new GUIController(read.getStates());
    }


    public void testInitializeNull() {
        LinkedList<State> nullList = null;
        GUIController testControl;
        
        try {
            testControl = new GUIController(nullList);
            fail("Tried to setup a controller that uses a null object.");
        }
        catch (IllegalArgumentException e) {
            // This catch block has been left blank.
        }
    }
    
    public void testGetStateList() {
        assertEquals(controller.getStateList(), read.getStates());
    }


    public void testSortCfr() {
        controller.setCurrentState("VA");
        controller.sortCfr();
        Race[] array = controller.getRaceArray();
        Boolean flag = true;

        for (int i = 0; i < array.length - 1; i++) {
            if (Race.cfrComparator().compare(array[i], array[i + 1]) > 0) {
                flag = false;
            }
        }

        assertTrue(flag);

    }


    public void testSortAlpha() {
        controller.setCurrentState("VA");
        controller.sortAlpha();
        Race[] arra = controller.getRaceArray();
        Boolean flag = true;

        for (int i = 0; i < arra.length - 1; i++) {
            if (Race.alphaComparator().compare(arra[i], arra[i + 1]) > 0) {
                flag = false;
            }
        }

        assertTrue(flag);

    }


    public void testSetCurrentState() {
        controller.setCurrentState("VA");
        assertEquals(controller.getActiveState(), "VA");

        controller.setCurrentState("MD");
        assertEquals(controller.getActiveState(), "MD");

        controller.setCurrentState("TN");
        assertEquals(controller.getActiveState(), "TN");

        controller.setCurrentState("NC");
        assertEquals(controller.getActiveState(), "NC");

        controller.setCurrentState("GA");
        assertEquals(controller.getActiveState(), "GA");

        controller.setCurrentState("DC");
        assertEquals(controller.getActiveState(), "DC");

        Exception exception = null;

        try {
            controller.setCurrentState("DNA");
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

    }


    public void testGetActiveState() {
        assertNull(controller.getActiveState());

        controller.setCurrentState("VA");
        assertEquals(controller.getActiveState(), "VA");
    }


    public void testGetRaceArray() {
        Exception exception = null;

        try {
            controller.getRaceArray();
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

        controller.setCurrentState("VA");

        Exception exception2 = null;

        try {
            controller.getRaceArray();
        }
        catch (Exception e) {
            exception2 = e;
        }
        assertNull(exception2);

    }


    public void testIsReady() {
        assertFalse(controller.isReady());

        controller.setCurrentState("VA");

        assertTrue(controller.isReady());
    }

}
