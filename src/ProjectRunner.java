// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- olsenbudanur

import java.io.FileNotFoundException;
import java.util.LinkedList;

/**
 * This is the class that houses the main method and runs the project.
 * 
 * @author Olsen Budanur olsenbudanur
 * @version 11/14/2020
 */
public class ProjectRunner {

    /**
     * This is the main method of the project. This is what eclipse exacutes.
     * 
     * @param args
     *            the input
     * @throws FileNotFoundException
     *             if file is not found
     */
    public static void main(String[] args) throws FileNotFoundException {

        DocumentReader reader = new DocumentReader(args[0]);

        LinkedList<State> states = reader.getStates();

        for (State state : states) {
            System.out.println(state.toString());

        }
    }

}
