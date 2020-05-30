package rit.stu.act2;

public class Soldier implements Player {
    /** the id of this soldier */
    private int id;

    /**
     * Create a new soldier.
     *
     * @param id the id of the soldier
     */
    public Soldier(int id) {
        this.id = id;
    }

    /**
     * If the soldier losses to player, it displays the message, "{soldier}
     * cries, 'Besiegt von {player}!'".
     *
     * @param player the player that defeated me
     */
    @Override
    public void defeat(Player player) {
        System.out.println(toString() + " yells, 'Sieg über " + player.toString() + "!'");
    }

    /**
     * If the soldier is triumphant over player, it displays the message,
     * "{soldier} yells, 'Sieg über {player}!'". Please note that if the umlaut
     * character is not displaying correctly in your browser it is because it
     * is not rendering UTF-8. Refer to the Soldier section in the writeup to
     * see how you insert the character in Java.
     *
     * @param player the player that I defeated
     */
    @Override
    public void victory(Player player) {
        System.out.println(toString() + " yells, 'Sieg über " + player.toString() + "!'");
    }

    /**
     * The string representation of a soldier is: "Soldier #n", where n is
     * their id.
     *
     * @return the soldier string
     */
    @Override
    public String toString() {
        return "Soldier #" + Integer.toString(id);
    }
}
