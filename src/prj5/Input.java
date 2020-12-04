// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- arielc19, adamoswald, olsenbudanur

package prj5;

import java.io.FileNotFoundException;

/**
 * This is the class that houses the main method and runs the project.
 * 
 * @author Olsen Budanur olsenbudanur
 * @version 11/14/2020
 * 
 * @author Adam Oswald adamoswald
 * @version 11/30/2020
 */
public class Input {

    /**
     * This is the main method of the project.
     * 
     * @param args
     *            [0]File where the data can be found
     * @throws FileNotFoundException
     *             if file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {
        DocumentReader reader;

        if (args.length == 1) {
            reader = new DocumentReader(args[0]);
        }
        else {
            reader = new DocumentReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }

        LinkedList<State> states = reader.getStates();
        new GUIWindow(new GUIController(states));

        for (State state : states) {
            System.out.println(state.toString());
        }

    }
}
