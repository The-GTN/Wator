package life;

import java.awt.Color;

/** Class for cell of the LifeGame
* @author Nollet Antoine
* @version 01/06/2020
*/
public class Cell {

  /** boolean who say if this cell is alive or not */
  protected boolean isAlive;

  /** create a new cell and is isAlive that this cell is alive
  * @param isAlive boolean who say if this cell is alive or not
  */
  public Cell(boolean isAlive) {
    this.isAlive = isAlive;
  }

  /** Boolean who say if this cell is alive or not
  * @return true if this cell is alive, false otherwise
  */
  public boolean isAlive() {
    return this.isAlive;
  }

  /** give death to this cell */
  public void giveDeath() {
    this.isAlive = false;
  }

  /** give life to this cell */
  public void giveLife() {
    this.isAlive = true;
  }

  /** return the color of this cell
  * @return the color of this cell
  */
  public java.awt.Color getColor() {
    if(this.isAlive) return Color.white;
    else return Color.darkGray;
  }

  /** return the char of this cell
  * @return the char of this cell
  */
  public char getChar() {
    if(this.isAlive) return 'O';
    else return '-';
  }

}
