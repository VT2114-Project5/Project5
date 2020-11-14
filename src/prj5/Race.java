package prj5;

import java.util.Comparator;

// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- olsenbudanur

/**
 * This class represents the individual Races from the Covid-19 data. It stores
 * the information for that specific race.
 * 
 *
 * @author Olsen Budanur olsenbudanur
 * @version 11/14/2020
 */
public class Race {
    private String name;
    private int deaths;
    private int cases;
    private double cfr;

    /**
     * This is the constructor of the Race class. It creates a Race object with
     * the desired name, deaths, and cases. It also calculates the CFR of the
     * Race given the deaths and cases.
     * 
     * @param name
     *            the name of the Race
     * @param deaths
     *            the deaths of the Race
     * @param cases
     *            the cases of the Race
     */
    public Race(String name, int deaths, int cases) {
        this.name = name;
        this.deaths = deaths;
        this.cases = cases;
        cfr = calculateCfr(deaths, cases);

    }


    /**
     * This is a helper method that calculates the CFR of the race. If the
     * deaths and/or cases are not defined, the CFR is set to be -1.
     * 
     * @param deaths
     *            the deaths of the Race
     * @param cases
     *            the cases of the Race
     * @return the CFR
     */
    private double calculateCfr(int deaths, int cases) {
        if (deaths == -1 || cases == -1) {
            return -1;
        }
        double cfr = (deaths * 1.0 / cases) * 100;
        double cfrClean = (int)(Math.round(cfr * 10)) / 10.0;
        return cfrClean;
    }


    /**
     * This is a getter method for the cases field.
     * 
     * @return cases field
     */
    public int getCases() {
        return cases;
    }


    /**
     * This is a getter method for the deaths field.
     * 
     * @return deaths field
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * This is a getter method for the cfr field.
     * 
     * @return cfr field
     */
    public double getCfr() {
        return cfr;
    }


    /**
     * This is a getter method for the name field.
     * 
     * @return name field
     */
    public String getName() {
        return name;
    }


    /**
     * This method returns the string representation of the Race.
     * 
     * @return string representation of the Race
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(": ");
        builder.append(cases);
        builder.append(" cases, ");
        builder.append(cfr);
        builder.append("%");
        builder.append(" CFR");
        return builder.toString();

    }


    /**
     * Checks if two races are equal.
     * 
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
            Race other = (Race)obj;
            return this.getCases() == other.getCases() && this
                .getDeaths() == other.getDeaths() && this.getName().equals(other
                    .getName()) && this.getCfr() == other.getCfr();
        }
        else {
            return false;
        }

    }


    /**
     * This is the comparator that is used to sort races in alphabetical order.
     * 
     * @return a CFRComparator
     */
    static Comparator<Race> CFRComparator() {
        return new Comparator<Race>() {

            /**
             * Compares the two objects by their Cfr
             */
            @Override
            public int compare(Race thisObject, Race other) {
                double doubleCfr = (other.getCfr() - thisObject.getCfr()) * 10;

                return (int)doubleCfr;
            }

        };
    }


    /**
     * This is the comparator that is used to sort races in alphabetical order.
     * 
     * @return an AlphaComparator
     */
    static Comparator<Race> AlphaComparator() {
        return new Comparator<Race>() {

            /**
             * Compares the two objects by their name
             */
            @Override
            public int compare(Race thisObject, Race other) {

                return thisObject.getName().compareTo(other.getName());
            }

        };
    }

}