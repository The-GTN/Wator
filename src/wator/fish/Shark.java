package wator.fish;

import wator.environment.*;
import java.awt.Color;

/** Class of Shark, the predator of this project
* @author Nollet Antoine
* @version 20/05/2020
*/
public class Shark extends Fish {

  /* the basic gestation's time of the sharks */
  public static int GESTATION = 2;
  /* energy of the sharks */
  public static int ENERGY = 2;
  /* energy of this shark */
  protected int energy;

  /** Create a Shark
  */
  public Shark() {
    this.personalGestation = GESTATION;
    this.energy = ENERGY;
  }

  /**get the energy og this shark
  * @return the energy og this shark
  */
  public int getEnergy() {
    return this.energy;
  }

  /** The damaged of time on this poor shark */
  public void timePass() {
    super.timePass();
    this.energy--;
  }

  /** Give birth to a new Shark
  * @return a new shark
  */
  public Fish giveBorn() {
    this.personalGestation = GESTATION;
    return new Shark();
  }

  /** Boolean to know if this shark can move to the cell d
  * @param d the cell we want to know if this shark can move
  * @return true if the shark can move to the cell d (if the cell is empty or if it's a tuna in this cell), false otherwise
  */
  public boolean canMove(Cell d) {
    if (!d.isEmpty()) {
      if (d.getFish().isPrey()) {
        this.energy = ENERGY;
        return true;
      }
    }
    return d.isEmpty();
  }

  /** Boolean to say if this fish have to die
  * @return true if this fish have to die, false otherwise
  */
  public boolean haveToDie() {
    return this.energy == 0;
  }

  /** toString method of Sharks
  * @return string representation for sharks
  */
  public String toString() {
      return "Shark with personalGestation time to "+this.personalGestation+" energylevel to "+this.energy;
  }

  /** Equals method
  * @param o an other object
  * @return true if o equals to this shark, false otherwise
  */
  public boolean equals(Object o) {
    if(o instanceof Shark){
      Shark other = (Shark) o;
      return this.personalGestation == other.getGestation();
    }
    return false;
  }

  /** get the character corresponding to this shark
  * @return the character corresponding to this shark
  */
  public char getChar() {
    return 'S';
  }

  /** get the color corresponding to this shark
  * @return the color corresponding to this shark
  */
  public java.awt.Color getColor() {
    return Color.red;
  }

  /** return if this shark is a prey
  * @return if this shark is a prey
  */
  public boolean isPrey() {
    return false;
  }

}
