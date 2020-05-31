package rit.stu.act2;

import rit.cs.Queue;
import rit.stu.act1.QueueNode;

/**
 * A class that represents the bunker of soldiers.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class Bunker {
    /** the queue of soldiers in the bunker */
    private Queue<Soldier> bunker;
    /** the number of soldiers currently in the bunker */
    private int numSoldiers;

    /**
     * Create the bunker. Based on the total number of soldiers, each one
     * should be created here and then added to the bunker, with id's ranging from 1-numSoldiers.
     *
     * @param numSoldiers the total number of soldiers that start in the bunker
     */
    public Bunker(int numSoldiers) {
        this.bunker = new QueueNode<Soldier>();
        this.numSoldiers = numSoldiers;
        for (int i = 1; i <= this.numSoldiers; i++) {
            this.bunker.enqueue(new Soldier(i));
        }
    }

    /**
     * Are their soldiers left in the bunker?
     *
     * @return whether the bunker has soldiers or not
     */
    public boolean hasSoldiers() {
        return this.bunker.empty();
    }

    /**
     * Get how many soldiers are in the bunker.
     *
     * @return number of soldiers in the bunker
     */
    public int getNumSoldiers() {
        return this.numSoldiers;
    }

    /**
     * Remove the next soldier from the front of the bunker to be deployed on a
     * rescue attempt.
     *
     * @return the soldier at the front of the bunker
     * @rit.pre the bunker is not empty
     */
    public Soldier deployNextSoldier() {
        this.numSoldiers -= 1;
        return this.bunker.dequeue();
    }

    /**
     * Add a new soldier to the end of the bunker.
     *
     * @param soldier the new soldier to add
     */
    public void fortifySoldiers​(Soldier soldier) {
        this.numSoldiers += 1;
        this.bunker.enqueue(soldier);
    }
}
