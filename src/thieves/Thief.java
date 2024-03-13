package thieves;

import java.awt.Color;

/** Class for Thief
* @version 19/08/2020
* @author Nollet Antoine
*/
public class Thief {

  /* money of this thief */
  protected int coins;

  /** Constructor for Thief with a number of coins
  * @param coins the coins of this thief
  */
  public Thief(int coins) {
    this.coins = coins;
  }

  /** Constructor for Thief with 1 coin */
  public Thief() {
    this(1);
  }

  /** Get the coins of this thief
  * @return the coins of this thief
  */
  public int getCoins() {
    return this.coins;
  }

  /** add one coin to this thief */
  public void addCoin() {
    this.coins += 1;
  }

  /** remove one coin to this thief
  * @return true if this thief has lost one coin, false otherwise
  */
  public boolean removeCoin() {
    if(this.coins > 0) {
      this.coins -= 1;
      return true;
    }
    else return false;
  }

  /** get the color of this thief
  * @return the color of this thief
  */
  public java.awt.Color getColor() {
    if(this.coins == 0) return Color.white;
    else if(this.coins ==1) return Color.green;
    else if(this.coins ==2) return Color.green;
    else if(this.coins ==3) return Color.green;
    else if(this.coins ==4) return Color.green;
    else return Color.red;
  }

  /** get the char of this thief
  * @return the char of this thief
  */
  public char getChar() {
    if(this.coins == 0) return '_';
    else if(this.coins ==1) return '1';
    else if(this.coins == 2) return '2';
    else if(this.coins == 3) return '3';
    else if(this.coins == 4) return '4';
    else return '+';
  }

}
