package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * Provides the front-end to visualize COVID-19 CFR data.
 * 
 * @author Adam Oswald (adamoswald) Ariel Carter(arielc19)
 * @version 11.30.2020
 *
 */
public class GUIWindow {

    private Window window;
    private GUIController reader;

    private Button sortAlpha;
    private Button quit;
    private Button sortCfr;

    private Button showDc;
    private Button showGa;
    private Button showMd;
    private Button showNc;
    private Button showTn;
    private Button showVa;

    private final int BAR_OFFSET = 137; // WIN_WIDTH / 6 (we need n + 1 spaces)
    private final int BAR_WIDTH = 10; // Calculated using a proportion.
    private final int BAR_Y = 233; // Calculated using a proportion.
    private final int BAR_FACTOR = 209;

    /**
     * Creates a new GUIWindow and position the buttons.
     * 
     * @param guiC
     *            A GUIController object, which provides what data should the
     *            GUI
     *            visualize.s
     */
    public GUIWindow(GUIController guiC) {
        window = new Window();
        window.setTitle("adamoswald, olsenbudanur, arielc19");
        reader = guiC;

        sortAlpha = new Button("Sort By Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        sortCfr = new Button("Sort by CFR");
        sortCfr.onClick(this, "clickedSortCfr");

        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCfr, WindowSide.NORTH);

        showDc = new Button("Represent DC");
        showDc.onClick(this, "clickedDc");
        showGa = new Button("Represent GA");
        showGa.onClick(this, "clickedGa");
        showMd = new Button("Represent MD");
        showMd.onClick(this, "clickedMd");
        showNc = new Button("Represent NC");
        showNc.onClick(this, "clickedNc");
        showTn = new Button("Represent TN");
        showTn.onClick(this, "clickedTn");
        showVa = new Button("Represent VA");
        showVa.onClick(this, "clickedVa");

        window.addButton(showDc, WindowSide.SOUTH);
        window.addButton(showGa, WindowSide.SOUTH);
        window.addButton(showMd, WindowSide.SOUTH);
        window.addButton(showNc, WindowSide.SOUTH);
        window.addButton(showTn, WindowSide.SOUTH);
        window.addButton(showVa, WindowSide.SOUTH);
    }


    /**
     * Perform action when "Sort by CFR" gets clicked
     * 
     * @param button
     *            the button that is the "Sort by CFR" button
     */
    public void clickedSortCfr(Button button) {
        if (reader.isReady()) {
            reader.sortCfr();
            update();
        }
    }


    /**
     * Perform action when "Sort by Alpha" gets clicked
     * 
     * @param button
     *            the button that is the "Sort by Alpha" button
     */
    public void clickedSortAlpha(Button button) {
        if (reader.isReady()) {
            reader.sortAlpha();
            update();
        }
    }


    /**
     * Perform action when "Quit" gets clicked
     * 
     * @param button
     *            the button that is the "Quit" button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Perform action when "Represent DC" gets clicked
     * 
     * @param button
     *            the button that is the "Represent DC" button
     */
    public void clickedDc(Button button) {
        reader.setCurrentState("DC");
        update();
    }


    /**
     * Perform action when "Represent GA" gets clicked
     * 
     * @param button
     *            the button that is the "Represent GA" button
     */
    public void clickedGa(Button button) {
        reader.setCurrentState("GA");
        update();
    }


    /**
     * Perform action when "Represent MD" gets clicked
     * 
     * @param button
     *            the button that is the "Represent MD" button
     */
    public void clickedMd(Button button) {
        reader.setCurrentState("MD");
        update();
    }


    /**
     * Perform action when "Represent NC" gets clicked
     * 
     * @param button
     *            the button that is the "Represent NC" button
     */
    public void clickedNc(Button button) {
        reader.setCurrentState("NC");
        update();
    }


    /**
     * Perform action when "Represent TN" gets clicked
     * 
     * @param button
     *            the button that is the "Represent TN" button
     */
    public void clickedTn(Button button) {
        reader.setCurrentState("TN");
        update();
    }


    /**
     * Perform action when "Represent VA" gets clicked
     * 
     * @param button
     *            the button that is the "Represent VA" button
     */
    public void clickedVa(Button button) {
        reader.setCurrentState("VA");
        update();
    }


    /**
     * Redraws everything on the screen and redraws based on the data of the
     * collection.
     */
    private void update() {
        window.removeAllShapes();
        drawBars();
        System.out.println(window.getGraphPanelHeight());
    }


    /**
     * Draws the bar graphs and the text and places them in the correct
     * positions and scale.
     */
    private void drawBars() {
        Race[] races = reader.getRaceArray();
        int barHeight = 0;

        for (int i = 0; i < 5; i++) {
            int offset = BAR_OFFSET + BAR_OFFSET * i;

            if (races[i].getCfr() >= 0) { // Don't draw when CFR = -1
                barHeight = (int)(BAR_FACTOR * (races[i].getCfr() / 10.0));

            }
            int y = BAR_Y - barHeight;
            System.out.println(barHeight);
            Shape bar = new Shape(offset, y, BAR_WIDTH, barHeight, Color.BLUE);
            window.addShape(bar);
            // builds text for the race under the bar
            TextShape race = new TextShape(offset, y - 1, races[i].getName(),
                Color.black);
            race.setBackgroundColor(Color.white);
            window.addShape(race);
            // builds text for the cfr under the race
            TextShape cfr = new TextShape(offset, y - 2, races[i].getCfr()
                + "%", Color.black);
            cfr.setBackgroundColor(Color.white);
            window.addShape(cfr);

            barHeight = 0;
        }
    }

}
