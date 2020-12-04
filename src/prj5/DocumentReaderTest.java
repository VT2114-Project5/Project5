// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- arielc19, adamoswald, olsenbudanur

package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import student.testingsupport.annotations.Hint;

/**
 * Test text output for Music Visualization Project
 * 
 * @author margaretellis
 * @version 11-12-2015
 * @author Molly Hickman <mollygh>
 * @version Fall 2020
 */
public class DocumentReaderTest extends student.TestCase {
    private String fileName;
    private Scanner fileData;

    /**
     * sets up any needed variables for test methods
     */
    public void setUp() {

        fileData = null;
    }


    /**
     * Test the program with the actual data aggregated between March
     * and September 2020, which includes some NA fields.
     * Gathers the output from StdOut and compares it to the expected
     * output (stored in CovidOutput_1.txt)
     * 
     */
    @Hint("The main method is not working properly with input file "
        + "Cases_and_Deaths_by_race_CRDT_Sep2020.csv")
    public void testMain01() throws java.io.IOException {

        Input.main(new String[] {
            "Cases_and_Deaths_by_race_CRDT_Sep2020.csv" });

        fileName = "CovidOutput_1.txt";

        String output1 = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            output1 += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for input file "
            + "Cases_and_Deaths_by_race_CRDT_Sep2020.csv", output1,
            systemOut().getHistory());

    }


    /**
     * Test the program with randomly generated data that have no
     * NA fields.
     * Gathers the output from StdOut and compares it to
     * the expect output (stored in CovidOutput_2.txt)
     * 
     */
    @Hint("The main method is not working properly with input files "
        + "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv")
    public void testMain02() throws java.io.IOException {

        Input.main(new String[] {
            "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv" });

        fileName = "CovidOutput_2.txt";

        String output2 = "";
        fileData = null;
        try {
            // Can throw FileNotFoundException
            fileData = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            System.out.println("Scanner error opening the file " + fileName);
            System.out.println(e.getMessage());
        }

        while (fileData.hasNextLine()) {
            output2 += fileData.nextLine() + "\n";
        }

        assertFuzzyEquals("Output not as expected for input file "
            + "Cases_and_Deaths_by_race_RANDOM_NUMBERS.csv", output2,
            systemOut().getHistory());

    }

}
