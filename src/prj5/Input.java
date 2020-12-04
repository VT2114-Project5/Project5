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
     *          [0]File where the data can be found
     *          [1] --gui     Opens the visualization front-end.
     * @throws FileNotFoundException
     *             if file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {


        DocumentReader reader = new DocumentReader(args[0]);

        LinkedList<State> states = reader.getStates();

        // Remove this when finished with front-end.
        if (args.length > 1 && args[1].equals("--gui")) {
            new GUIWindow(new GUIController(states));
        }
        else { 
            for (State state : states) {
                System.out.println(state.toString());

            }
        }

    }
}
