package rit.stu.act2;

import rit.cs.Stack;
import rit.stu.act1.StackNode;

/**
 * A class that represent the chopper. The chopper can hold up to 6 passengers
 * aligned in a single columns of seats. There is only one door to the chopper
 * that is accessible by the passengers. When they enter the chopper, the
 * occupy the seat closest to the door and any existing passengers move one
 * seat down.
 *
 * In order to preserve fuel, the chopper will only fly the passengers away to safety if the chopper is full, or it is the last group of people to rescue.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class Chopper {
    /** The maximum number of passengers the chopper can hold */
    public static final int MAX_OCCUPANCY = 6;
    /** the passengers are stored in a stack */
    private Stack<Player> chopper;
    /** the number of passengers occupying seats in the chopper */
    private int numPassengers;
    /** the total number of passengers that have been flown away to safety and
     * rescued */
    private int numRescued;

    /**
     * Create the chopper so that all the passenger seats are empty and none
     * have been rescued yet.
     */
    public Chopper() {
        this.chopper = new StackNode<>();
        this.numPassengers = 0;
        this.numRescued = 0;
    }

    /**
     * Is the chopper empty?
     *
     * @return Whether the chopper is empty or not
     */
    public boolean isEmpty() {
        return this.chopper.empty();
    }

    /**
     * Is the chopper full?
     *
     * @return Whether or not the chopper has reached max occupancy or not
     */
    public boolean isFull() {
        return this.numPassengers == MAX_OCCUPANCY;
    }

    /**
     * Get the total number of passengers that were rescued.
     *
     * @return number of rescued passengers
     */
    public int getNumRescued() {
        return this.numRescued;
    }

    /**
     * When the chopper is full, or it is the last group of people to be
     * rescued, it will fly away and rescue the passengers. Each passenger
     * exits the chopper in the reverse order they entered it, e.g. the last
     * passenger to enter exits first.
     *
     * As each passenger exits the chopper, print the message "Chopper
     * transported {passenger} to safety!"
     */
    public void rescuePassengers() {
        while (!chopper.empty()) {
            this.numRescued += 1;
            this.numPassengers -= 1;
            System.out.println("Chopper transported " + chopper.pop().toString() + " to safety!");
        }
    }

    /**
     * Board a passenger onto the chopper. If the chopper is full, it must
     * first fly away and rescue the passengers on it (hint, use the
     * rescuePassengers() helper method). Otherwise, the passenger boards the
     * chopper and occupies the front seat, making everyone else in the chopper
     * move down a seat. When the passenger boards the chopper display the
     * message "{passenger} boards the chopper!".
     *
     * @param player the player boarding the chopper
     */
    public void boardPassenger​(Player player) {
        if (isFull()) {
            rescuePassengers();
        }
        numPassengers += 1;
        this.chopper.push(player);
        System.out.println(player.toString() + " boards the chopper!");
    }
}
