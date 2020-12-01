package prj5;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GUIControllerTest {

    private DocumentReader read;
    private GUIController controller;
    
    public void setUp() throws Exception {
        read = new DocumentReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        controller = new GUIController(read.getStates());
    }


    public void testGetStateList() {
        fail("Not yet implemented");
    }


    public void testSortCfr() {
        fail("Not yet implemented");
    }


    public void testSortAlpha() {
        fail("Not yet implemented");
    }


    public void testSetCurrentState() {
        fail("Not yet implemented");
    }


    public void testGetActiveState() {
        fail("Not yet implemented");
    }


    public void testGetRaceArray() {
        fail("Not yet implemented");
    }

    
    public void testIsReady() {
        fail("Not yet implemented");
    }

}
