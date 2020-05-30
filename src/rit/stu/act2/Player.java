package rit.stu.act2;

/**
 * An interface to represent a player in the game. A player is any entity that
 * can come into conflict with another player, where battle yields one victor
 * and one loser.
 *
 * @author Jesse Burdick-Pless jb4411@g.rit.edu
 */
public interface Player {
    /**
     * What to do when this player loses to another player.
     *
     * @param player the player that defeated me
     */
    void defeat(Player player);

    /**
     * What to do when this player defeats another player.
     *
     * @param player the player that I defeated
     */
    void victory(Player player);
}
