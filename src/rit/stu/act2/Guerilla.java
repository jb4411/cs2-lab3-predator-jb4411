package rit.stu.act2;

/**
 * A class to represent a guerilla, each whom has a unique ID.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public class Guerilla implements Player {
    /** The chance the guerilla has to defeat a soldier. If a die roll of 1-100
     *  is less than or equal to this, the guerilla defeats the soldier,
     *  otherwise the guerilla loses.
     */
    public static final int CHANCE_TO_BEAT_SOLDIER = 20;
    /** the id of this guerilla */
    private int id;

    /**
     * Create a new guerilla.
     *
     * @param id the id of the guerilla
     */
    public Guerilla(int id) {
        this.id = id;
    }

    /**
     * If the guerilla losses to player, it displays the message, "{guerilla}
     * cries, 'Derrotado por {player}!'".
     *
     * @param player the player that defeated me
     */
    @Override
    public void defeat(Player player) {
        System.out.println(toString() + " cries, 'Derrotado por " + player.toString() + "!'");
    }

    /**
     * If the guerilla is triumphant over player, it displays the message,
     * "{guerilla} yells, 'Victoria sobre {player}!'".
     *
     * @param player the player that I defeated
     */
    @Override
    public void victory(Player player) {
        System.out.println(toString() + " yells, 'Victoria sobre " + player.toString() + "!'");
    }

    /**
     * The string representation of a guerilla is: "Guerilla #n", where n is
     * their id.
     *
     * @return the guerilla string
     */
    @Override
    public String toString() {
        return "Guerilla #" + Integer.toString(this.id);
    }
}
