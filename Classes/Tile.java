/*
 * Nathan Smith
 * January 22, 2022
 * Tile interface to govern tiles and achieve polymorphism
 */
package bulletbox;

public interface Tile {
    static final int TILESIZE = 50;
    public int getTileType();
    public String toString();
}
