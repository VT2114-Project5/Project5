package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- olsenbudanur

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This is the reader class that imports an text file containing the Covid-19
 * information and
 * transfers it in the form of arrays.
 *
 * @author Olsen Budanur olsenbudanur
 * @version 11/14/2020
 */
public class DocumentReader {
    private LinkedList<State> states;

    /**
     * This is the constructor of the DocumentReader class. It specifies the
     * file that the DocumentReader will read.
     * 
     * @param fileName
     *            the location of the file
     * @throws FileNotFoundException
     *             if the file does not exist
     */
    public DocumentReader(String fileName) throws FileNotFoundException {
        states = readFile(fileName);
    }


    /**
     * This method reads through the file of a known format, and transcribes it
     * into State objects consisting of Race objects.
     * 
     * @param fileName
     *            the location of the file
     * @return LinkedList of States
     * @throws FileNotFoundException
     *             if the file does not exist
     */
    private LinkedList<State> readFile(String fileName)
        throws FileNotFoundException {
        Scanner file = new Scanner(new File(fileName));
        LinkedList<State> states = new LinkedList<State>();
        String currentLine = file.nextLine();

        while (file.hasNextLine()) {
            LinkedList<Race> races = new LinkedList<Race>();
            currentLine = file.nextLine();
            String[] lineSplit = currentLine.split(", *");
            State newState = new State(lineSplit[0]);

            Race white = new Race("white", turnInt(lineSplit[6]), turnInt(
                lineSplit[1]));
            Race black = new Race("black", turnInt(lineSplit[7]), turnInt(
                lineSplit[2]));
            Race latinx = new Race("latinx", turnInt(lineSplit[8]), turnInt(
                lineSplit[3]));
            Race asian = new Race("asian", turnInt(lineSplit[9]), turnInt(
                lineSplit[4]));
            Race other = new Race("other", turnInt(lineSplit[10]), turnInt(
                lineSplit[5]));

            races.add(white);
            races.add(black);
            races.add(latinx);
            races.add(asian);
            races.add(other);

            newState.setRaces(races);

            states.add(newState);

        }
        return states;

    }


    /**
     * This is a helper method to convert strings into integers. It checks if
     * the input is "NA" when it should be an integer. If so, the input is
     * turned into -1.
     * 
     * @param string
     *            the string that's to be converted to an integer
     * @return integer version of the string
     */
    private int turnInt(String string) {

        if (string.equals("NA")) {
            return -1;
        }
        return Integer.parseInt(string);

    }


    /**
     * Getter method for the states field.
     * 
     * @return states field
     */
    public LinkedList<State> getStates() {
        return states;
    }

}
