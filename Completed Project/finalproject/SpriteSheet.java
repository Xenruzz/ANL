/** Alex, Lado, Nathan
 * January 26, 2022
 * An interface to hold all of the players sprites
 */

package finalproject;

import javax.swing.ImageIcon;

public interface SpriteSheet {
    //Facing down sprites
    ImageIcon playerDownStand = new ImageIcon("src//finalproject//player//player_down//playerStandDown.png");
    ImageIcon playerDownWalk1 = new ImageIcon("src//finalproject//player//player_down//playerDownWalk1.png");
    ImageIcon playerDownWalk2 = new ImageIcon("src//finalproject//player//player_down//playerDownWalk2.png");
    //Facing left sprites
    ImageIcon playerLeftStand = new ImageIcon("src//finalproject//player//player_left//playerLeftStand.png");
    ImageIcon playerLeftWalk1 = new ImageIcon("src//finalproject//player//player_left//playerLeftWalk1.png");
    ImageIcon playerLeftWalk2 = new ImageIcon("src//finalproject//player//player_left//playerLeftWalk2.png");
    //Facing right sprites
    ImageIcon playerRightStand = new ImageIcon("src//finalproject//player//player_right//playerRightStand.png");
    ImageIcon playerRightWalk1 = new ImageIcon("src//finalproject//player//player_right//playerRightWalk1.png");
    ImageIcon playerRightWalk2 = new ImageIcon("src//finalproject//player//player_right//playerRightWalk2.png");
    //Facing up sprites
    ImageIcon playerUpStand = new ImageIcon("src//finalproject//player//player_up//playerForwardStand.png");
    ImageIcon playerUpWalk1 = new ImageIcon("src//finalproject//player//player_up//playerForwardWalk1.png");
    ImageIcon playerUpWalk2 = new ImageIcon("src//finalproject//player//player_up//playerForwardWalk2.png");
    //Hp sprites
    ImageIcon heart = new ImageIcon("src//finalproject//heart.png");
}
