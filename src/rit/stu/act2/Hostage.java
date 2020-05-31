package rit.stu.act2;

/**
 * A class to represent a hostage, each whom has a unique ID.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class Hostage implements Player {
    /** the id of this hostage */
    private int id;

    /**
     * Create a new hostage.
     * @param id the id of the hostage
     */
    public Hostage(int id) {
        this.id = id;
    }

    /**
     * If the hostage losses to player, it displays the message,
     * "{hostage} cries, 'Defeated by {player}!'".
     *
     * @param player the player that defeated me
     */
    @Override
    public void defeat(Player player) {
        System.out.println(toString() + " cries, 'Defeated by " + player.toString() + "!'");
    }

    /**
     * If the hostage is triumphant over player, it displays the message,
     * "{hostage} yells, 'Victory over {player}!'".
     *
     * @param player the player that I defeated
     */
    @Override
    public void victory(Player player) {
        System.out.println(toString() + " yells, 'Victory over " + player.toString() + "!'");
    }

    /**
     * The string representation of a hostage is: "Hostage #n", where n is
     * their id.
     *
     * @return the hostage string
     */
    @Override
    public String toString() {
        return "Hostage #" + Integer.toString(this.id);
    }
}
