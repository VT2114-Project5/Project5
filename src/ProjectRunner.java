// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- olsenbudanur

import java.io.FileNotFoundException;
import java.util.LinkedList;

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

        DocumentReader reader = new DocumentReader(
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");

        LinkedList<State> states = reader.getStates();

        for (State state : states) {
            System.out.print(state.toString());

        }
    }

}
