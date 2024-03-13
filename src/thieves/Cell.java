package thieves;

import java.awt.Color;

/** class for cell of the Simulation of Thieves
* @author Nollet Antoine
* @version 19/08/2020
*/
public class Cell {

  /*the thief of this cell*/
  private Thief thief;

  /** Contruct a new empty cell*/
  public Cell() {
    this.thief = null;
  }

  /** Boolean to check if this cell is empty or not */
  public boolean isEmpty() {
    return this.thief == null;
  }

  /** Set a thief to this cell
  * @param thief the thief to set
  */
  public void setThief(Thief thief) {
    this.thief = thief;
  }

  /** Unset the thief of this cell
  * @return the thief we have unset of this cell
  */
  public Thief unsetThief() {
    Thief res = this.thief;
    this.thief = null;
    return res;
  }

  /** get the thief of this cell
  * @return the thief of this cell
  */
  public Thief getThief() {
    return this.thief;
  }

  /** return the color of this cell
  * @return the color of this cell
  */
  public java.awt.Color getColor() {
    if(this.isEmpty()) return Color.gray;
    else return this.thief.getColor();
  }

  /** return the char of this cell
  * @return the char of this cell
  */
  public char getChar() {
    if(this.isEmpty()) return '_';
    else return this.thief.getChar();
  }

}
