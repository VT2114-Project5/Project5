// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- olsenbudanur

import java.util.LinkedList;

/**
 * This class represents the individual states from the Covid-19 data. It stores
 * the race information regarding to a specific state.
 * 
 * @author Olsen Budanur olsenbudanur
 * @version 11/14/2020
 */
public class State {
    private String name;
    private LinkedList<Race> list;

    /**
     * This is the constructor of the State class. It gives the state a name.
     * 
     * @param name
     *            the name of the state
     */
    public State(String name) {
        this.name = name;
    }


    /**
     * This method sets the Race's of a state.
     * 
     * @param list
     *            the Race's of a state
     */
    public void setRaces(LinkedList<Race> list) {
        this.list = list;
    }


    /**
     * This method returns the Race's in an array format.
     * 
     * @return Race's as an array
     */
    public Race[] getRaces() {
        return (Race[])list.toArray();
    }


    /**
     * This method returns the string representation of the State.
     *
     * @return string representation of the State
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append("\n");
        for (Race race : list) {
            builder.append(race.toString());
            builder.append("\n");
        }

        return builder.toString();
    }


    /**
     * This method sorts the Race's in alphabetical order.
     */
    public void sortAlpha() {
        // Need to create an alpha comparator for race
    }


    /**
     * This method sorts the Race's in CFR order.
     */
    public void sortByCFR() {
        // Need to create a cfr comparator for race
    }

}
