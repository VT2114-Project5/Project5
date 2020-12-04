// Virginia Tech Honor Code Pledge://
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- adamoswald

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Controller between model and view. Provides the necessary logic needed
 * for the front-end
 * 
 * @author Adam Oswald (adamoswald)
 * @version 11.30.2020
 *
 */
public class GUIController {

    private LinkedList<State> states;
    private State activeState;
    
    /**
     * Creates a new GUIController targeting a LinkedList of State objects.
     * 
     * @param stateList
     *          LinkedList of State Objects the controller should interact with
     * @throws IllegalArgumentException
     *          If list that was passed is null.
     */
    public GUIController(LinkedList<State> stateList) {
        if (stateList == null) {
            throw new IllegalArgumentException("List passed to GUI is null");
        }
        
        states = stateList;
    }
    
    /**
     * Returns the states that the controller can choose from.
     * 
     * @return A LinkedList of State objects
     */
    public LinkedList<State> getStateList() {
        return states;
    }
    
    /**
     * Sorts the Races of the state from CFR, descending.
     */
    public void sortCfr() {
        activeState.sortByCFR();
    }
    
    /**
     * Sorts the Races of the state to lexical alphabetical order.
     */
    public void sortAlpha() {
        activeState.sortAlpha();
    }

    /**
     * Sets the active state the controller is currently using.
     * @param state 
     *          The String of the state to look for. Case-insensitive
     * @throws NoSuchElementException 
     *              The State could not be found from the collection
     * @return String of the state that was found.
     */
    public String setCurrentState(String state) {
        State currentState;
        state = state.toLowerCase();
        
        Iterator<State> iter = states.iterator();
        while (iter.hasNext()) {
            currentState = iter.next();
            if (state.equals(currentState.getName().toLowerCase())) {
                activeState = currentState;
                return currentState.getName();
            }
        }
        throw new NoSuchElementException("State could not be found.");
    }
    
    /**
     * Returns the state the controller is currently on. (The active state)
     * 
     * @return Null if not on a state, the String of the state if not null.
     */
    public String getActiveState() {
        if (activeState == null) {
            return null;
        }
        return activeState.getName();
    }
    
    /**
     * Gets the Races in the current state and prints it to an array.
     * 
     * @throws IllegalArgumentException
     *          A state has not be set in the controller.
     * @return An array of Race objects
     */
    public Race[] getRaceArray() {
        if (activeState == null) {
            throw new IllegalArgumentException("A state hasn't been selected");
        }
        return activeState.getRaces();
    }
    
    /**
     * See if a state is currently loaded into the controller.
     * 
     * @return True if the controller is set to a state, false if it is not.
     */
    public boolean isReady() {
        return activeState != null;
    }
}
