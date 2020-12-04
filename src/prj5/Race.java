// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- olsenbudanur, adamoswald

package prj5;
import java.util.Comparator;

/**
 * This class represents the individual Races from the Covid-19 data. It stores
 * the information for that specific race.
 * 
 *
 * @author Olsen Budanur olsenbudanur
 * @version 11/14/2020
 * 
 * @author Adam Oswald (adamoswald) 
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
     * @param nme
     *            the name of the Race
     * @param dths
     *            the deaths of the Race
     * @param cses
     *            the cases of the Race
     */
    public Race(String nme, int dths, int cses) {
        name = nme;
        deaths = dths;
        cases = cses;
        cfr = calculateCfr(deaths, cases);

    }


    /**
     * This is a helper method that calculates the CFR of the race. If the
     * deaths and/or cases are not defined, the CFR is set to be -1.
     * 
     * @param dths
     *            the deaths of the Race
     * @param cses
     *            the cases of the Race
     * @return a double of the CFR
     */
    private double calculateCfr(int dths, int cses) {
        if (dths == -1 || cses == -1) {
            return -1;
        }
        double unroundCfr = (deaths * 1.0 / cases) * 100;
        double cfrClean = (Math.round(unroundCfr * 10)) / 10.0;
        return cfrClean;
    }


    /**
     * This is a getter method for the cases field.
     * 
     * @return Integer of the number of cases
     */
    public int getCases() {
        return cases;
    }


    /**
     * This is a getter method for the deaths field.
     * 
     * @return Integer of the number of deaths
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * This is a getter method for the cfr field. Note that cfr gets
     * initially calculated during the constructor.
     * 
     * @return Returns the double of the CFR
     */
    public double getCfr() {
        return cfr;
    }


    /**
     * This is a getter method for the name field.
     * 
     * @return String of the name of the race
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
        builder.append(rewriteCfr());
        builder.append("%");
        builder.append(" CFR");
        return builder.toString();

    }


    /**
     * Checks if two races are equal.
     * 
     * @param obj 
     *          The other object to be compared.
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
            
            return this.getCases() == other.getCases() 
                && this.getDeaths() == other.getDeaths() 
                && this.getName().equals(other.getName());
        }
        else {
            return false;
        }

    }
    
    /**
     * Helper method to remove the decimal point if the CFR can be represented
     * as an integer.
     * 
     * @return Number object of the CFR.
     */
    private Number rewriteCfr() {
        if (cfr > Math.floor(cfr)) {
            return cfr;
        }
        else {
            return (int)cfr;
        }
    }


    /**
     * This is the comparator that is used to sort races in alphabetical order.
     * Compares by cases if both CFR's are -1.
     * 
     * @return a CFRComparator
     */
    public static Comparator<Race> cfrComparator() {
        return new Comparator<Race>() {

            /**
             * Compares the two objects by their Cfr
             */
            @Override
            public int compare(Race thisObject, Race other) {
                if (thisObject.getCfr() == other.getCfr()) {
                    return thisObject.getName().compareTo(other.getName());
                }
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
    public static Comparator<Race> alphaComparator() {
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
