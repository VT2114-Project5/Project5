package prj5;
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- olsenbudanur

import java.util.Collections;
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
     * Getter method for the name field.
     * 
     * @return name field
     */
    public String getName() {
        return name;
    }


    /**
     * This method returns the string representation of the State.
     *
     * @return string representation of the State
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        this.sortAlpha();
        builder.append(name);
        builder.append("\n");

        for (Race race : list) {
            builder.append(race.toString());
            builder.append("\n");
        }

        builder.append("=====");
        builder.append("\n");
        this.sortByCFR();

        for (Race race : list) {
            builder.append(race.toString());
            builder.append("\n");
        }

        builder.append("=====");
        return builder.toString();
    }


    /**
     * This method sorts the Race's in alphabetical order.
     */
    public void sortAlpha() {
        Collections.sort(list, Race.AlphaComparator());
    }


    /**
     * This method sorts the Race's in CFR order.
     */
    public void sortByCFR() {
        Collections.sort(list, Race.CFRComparator());
    }


    /**
     * Checks if two races are equal.
     * 
     * @param obj 
     *          The other object to be compared.
     * @return whether the two races are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            State other = (State)obj;
            
            return this.getRaces().equals(other.getRaces()) 
                && this.getName().equals(other.getName());
        }
        else {
            return false;
        }

    }

}
