/*
 * Alex, Lado, Nathan
 * January 22, 2022
 * Tile interface to govern tiles and achieve polymorphism
 */
package finalproject;

import java.awt.Image;

public interface Tile {
    static final int TILESIZE = 50; //ALl tiles are 50 x 50
    public int getTileType(); //All tiles must have these methods
    public double getX();
    public double getY();
    public Image getImage();
    public String toString();
}