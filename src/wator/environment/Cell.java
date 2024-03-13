package wator.environment;

import wator.fish.*;

/** The class of the cell which constitute the sea for this project
*
*@author Nollet Antoine
*@version 20/05/2020
*/
public class Cell {

  /* the fish in the cell */
  private Fish fish;

  /** create the empty cell
  */
  public Cell() {
    this.fish = null;
  }

  /** boolean for verify if this cell is empty or not
  * @return true if this cell is empty, false otherwise
  */
  public boolean isEmpty() {
    return this.fish == null;
  }

  /** Clean this cell */
  public void cleanCell() {
    this.fish = null;
  }

  /** set the fish in this cell
  */
  public void setFish(Fish fish) {
    this.fish = fish;
  }

  /** get the fish of this cell
  * @return the fish of this cell
  */
  public Fish getFish() {
    return this.fish;
  }

}
