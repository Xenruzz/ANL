/*
 * Nathan Smith
 * January 22, 2022
 * Tile interface to govern tiles and achieve polymorphism
 */
package finalproject;

import java.awt.Image;

public interface Tile {
    static final int TILESIZE = 50;
    public int getTileType();
    public int getX();
    public int getY();
    public Image getImage();
    public String toString();
}