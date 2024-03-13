package wator.fish;

import wator.environment.*;
import java.awt.Color;

/** Abstract concept of fish
* @author Nollet Antoine
* @version 01/05/2020
*/
public abstract class Fish {

  /* personalGestation time of this fish */
  protected int personalGestation;

  /** Get the gestation time of this fish
  * @return the gestation time of this fish
  */
  public int getGestation() {
    return this.personalGestation;
  }

  /** The damaged of time on this poor fish */
  public void timePass() {
    this.personalGestation--;
  }

  /** GiveBorn to an other fish
  * @return the fish who is born
  */
  public abstract Fish giveBorn();

  /** Boolean to know if this fish can move to the cell d
  * @param d the cell we want to know if this fish can move
  * @return true if the fish can move to the cell d, false otherwise
  */
  public abstract boolean canMove(Cell d);

  /** Boolean to say if this fish have to die
  * @return true if this fish have to die, false otherwise
  */
  public abstract boolean haveToDie();

  /** get the character corresponding to this fish
  * @return the character corresponding to this fish
  */
  public abstract char getChar();

  /** get the color corresponding to this fish
  * @return the color corresponding to this fish
  */
  public abstract java.awt.Color getColor();

  /** return if this fish is a prey
  * @return if this fish is a prey
  */
  public abstract boolean isPrey();

}
