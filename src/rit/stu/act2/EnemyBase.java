package rit.stu.act2;

import rit.cs.Queue;
import rit.cs.Stack;
import rit.stu.act1.QueueNode;
import rit.stu.act1.StackNode;

/**
 * This class represents the enemy base. It contains a guard line of guerillas
 * that are guarding a group of hostages stored in a narrow cave with only an
 * entrance and no way for the hostages to reorder themselves.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class EnemyBase {
    /** the guard line of guerillas is a queue */
    private Queue<Guerilla> guerillas;
    /** the cave of hostages is a stack */
    private Stack<Hostage> hostages;
    /** the number of guerillas in the guard line */
    private int numGuerillas;
    /** how many hostages are currently being detained in the cave */
    private int numHostages;

    /**
     * Create the enemy base with a number of hostages, 1-numHostages, pushed
     * into the cave in order, and a number of guerillas, 1-numGuerillas, added
     * to the guard line in order.
     *
     * @param numHostages the number of hostages to start in enemy base
     * @param numGuerillas the number of guerillas to start in enemy base
     */
    public EnemyBase(int numHostages, int numGuerillas) {
        this.guerillas = new QueueNode<>();
        this.hostages = new StackNode<>();
        this.numHostages = numHostages;
        this.numGuerillas = numGuerillas;

        for (int i = 1; i <= this.numHostages; i++) {
            this.hostages.push(new Hostage(i));
        }
        for (int i = 1; i <= this.numGuerillas; i++) {
            this.guerillas.enqueue(new Guerilla(i));
        }
    }

    /**
     * Add a guerilla to the end of the guard line.
     *
     * @param guerilla guerilla to add
     */
    private void addGuerilla​(Guerilla guerilla) {
        this.numGuerillas += 1;
        this.guerillas.enqueue(guerilla);
    }

    /**
     * Add a hostage to the front of the cave.
     *
     * @param hostage hostage to add
     */
    private void addHostage​(Hostage hostage) {
        this.numHostages += 1;
        this.hostages.push(hostage);
    }

    /**
     * Remove a guerilla from the front of the guard line.
     *
     * @rit.pre the guerilla line is not empty
     * @return the front guerilla
     */
    private Guerilla getGuerilla() {
        this.numGuerillas -= 1;
        return this.guerillas.dequeue();
    }

    /**
     * Remove a hostage from the head of the cave.
     *
     * @rit.pre the cave is not empty
     * @return the hostage at the head of the cave
     */
    private Hostage getHostage() {
        this.numHostages -= 1;
        return this.hostages.pop();
    }

    /**
     * Get the number of hostages in the cave.
     *
     * @return number of hostages
     */
    public int getNumHostages() {
        return this.numHostages;
    }

    /**
     * Get the number of guerillas in the guard line.
     *
     * @return number of guerillas
     */
    public int getNumGuerillas() {
        return this.numGuerillas;
    }

    /**
     * A soldier enters the enemy base and attempts to rescue a hostage. First
     * the must defeat the guerilla at the front of the guard line, then they
     * can rescue one hostage at the front of the cave. Follow these steps:
     *
     * 1. Print the message "{soldier} enters enemy base...".
     *
     * 2. Remove and hold onto the hostage at the front of the cave.
     *
     * 3. If there are no guerillas left in the base, return the hostage to the
     * caller.
     *
     * 4. Otherwise get the next guerilla from the guard line.
     *
     * 5. Have the guerilla roll the die, 1-100, and print the message,
     * "{soldier} battles {guerilla} who rolls a #'.
     *
     * 6. If the die roll is greater than the chance to defeat the soldier, the
     * soldier declares victory over the guerilla and the guerilla declares
     * defeat to the soldier. The front hostage is then returned from the
     * method.
     *
     * 7. Otherwise the guerilla declares victory over the soldier and the
     * soldier declares defeat to the guerilla. The hostage is pushed back onto
     * the head of cave and the guerilla is added to the end of the guard line.
     * No hostage is returned, e.g. null.
     *
     * @param soldier the rescuing solder.
     * @return if a hostage was rescued the hostage, otherwise if the soldier
     * failed, null
     */
    public Hostage rescueHostage​(Soldier soldier) {
        //step 1
        System.out.println(soldier.toString() + " enters enemy base...");
        //step 2
        Hostage hostage = this.hostages.pop();
        //step 3
        if (this.numHostages == 0) {
            return hostage;
        } else {
            //step 4
            Guerilla guerilla = guerillas.dequeue();
            //step 5
            int roll = Battlefield.nextInt(1, 100);
            System.out.println(soldier.toString() + " battles " + guerilla.toString() + "who rolls a " + Integer.toString(roll) + ".");
            //step 6
            if (roll > Guerilla.CHANCE_TO_BEAT_SOLDIER) {
                soldier.victory(guerilla);
                guerilla.defeat(soldier);
                return hostage;
            } else {
                //step 7
                guerilla.victory(soldier);
                soldier.defeat(guerilla);
                addHostage​(hostage);
                addGuerilla​(guerilla);
                return null;
            }
        }
    }
}
