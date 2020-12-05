// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- arielc19, adamoswald, olsenbudanur

package prj5;

/**
 * This class represents the individual states from the Covid-19 data. It stores
 * the race information regarding to a specific state.
 * 
 * @author Olsen Budanur olsenbudanur
 * @version 11/14/2020
 * 
 * @author Ariel Carter (arielc19)
 * @version 11/17/2020
 */
public class State {
    private String name;
    private LinkedList<Race> list;

    /**
     * This is the constructor of the State class. Creates a State object
     * 
     * @param nme
     *            the name of the state
     */
    public State(String nme) {
        name = nme;
    }


    /**
     * Sets the State's list of Race objects
     * 
     * @param lst
     *            the Race's of a state
     */
    public void setRaces(LinkedList<Race> lst) {
        list = lst;
    }


    /**
     * Returns the State's list as an array of Races
     * 
     * @return Race's as an array
     */
    public Race[] getRaces() {
        Object[] temp = list.toArray();
        Race[] raceArr = new Race[temp.length];
        for (int i = 0; i < temp.length; i++) {
            raceArr[i] = (Race)temp[i];
        }
        return raceArr;
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
     * Returns a string representation of the State's CFR information by Race
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
     * Sorts the State's list of Races in alphabetical order.
     */
    public void sortAlpha() {
        LinkedList.sort(list, Race.alphaComparator());
    }


    /**
     * Sorts the State's list of Races by CFR 
     */
    public void sortByCFR() {
        LinkedList.sort(list, Race.cfrComparator());
    }


    /**
     * Checks if two States are the same 
     * 
     * @param obj
     *            The other object to be compared.
     * @return true if the States are the same
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

            // Check if name or size of Race list does not equal
            if (this.getRaces().length != other.getRaces().length || !this
                .getName().equals(other.getName())) {

                return false;
            }

            Race[] thisArr = this.getRaces();
            Race[] otherArr = other.getRaces();

            // Then check each element of the array.
            for (int i = 0; i < thisArr.length; i++) {
                if (!thisArr[i].equals(otherArr[i])) {
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }

    }

}
