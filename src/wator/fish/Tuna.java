package wator.fish;

import wator.environment.*;
import java.awt.Color;

/** Class of Tuna, the prey of this project
* @author Nollet Antoine
* @version 20/05/2020
*/
public class Tuna extends Fish {

  /* the basic gestation's time of the tunas */
  public static int GESTATION = 2;

  /** create a new tuna
  */
  public Tuna() {
    this.personalGestation = GESTATION;
  }

  /** Give born to a new Tuna
  * @return a baby tuna
  */
  public Fish giveBorn() {
    this.personalGestation = GESTATION;
    return new Tuna();
  }

  /** Boolean to know if this fish can move to the cell d
  * @param d the cell we want to know if this fish can move
  * @return true if the fish can move to the cell d, false otherwise
  */
  public boolean canMove(Cell d) {
    return d.isEmpty();
  }

  /** Boolean to say if this fish have to die
  * @return true if this fish have to die, false otherwise
  */
  public boolean haveToDie() {
    return false;
  }

  /** String representation for Tuna
  * @return String representation for Tuna
  */
  public String toString() {
      return "Tuna with personalGestation time to "+this.personalGestation;
  }

  /** Equals method
  * @param o an other object
  * @return true if o equals to this tuna, false otherwise
  */
  public boolean equals(Object o) {
    if(o instanceof Tuna){
      Tuna other = (Tuna) o;
      return this.personalGestation == other.getGestation();
    }
    return false;
  }

  /** get the character corresponding to this tuna
  * @return the character corresponding to this tuna
  */
  public char getChar() {
    return 'T';
  }

  /** get the color corresponding to this tuna
  * @return the color corresponding to this tuna
  */
  public java.awt.Color getColor() {
    return Color.white;
  }

  /** return if this tuna is a prey
  * @return if this tuna is a prey
  */
  public boolean isPrey() {
    return true;
  }

}
