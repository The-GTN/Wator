package forest;

import grid.*;

/** Class of simulation of BurnForest
* @author Nollet Antoine
* @version 03/06/2020
*/
public class BurnForest {

  /* the displayer of the simulation */
  private GridDisplayer displayer;
  /* the world where we do the simulation */
  private Forest forest;

  /** Create a simulator LifeGame
  * @param displayer the displayer we use
  * @param forest the forest where we do the simulation
  */
  public BurnForest(GridDisplayer displayer, Forest forest) {
    this.displayer = displayer;
    this.forest = forest;
  }

  /** Display the world with the displayer
  * @param step the number of step (for exemple "15/300")
  */
  public void display(String step) {
    this.displayer.display(this.forest,"BurnForest : step "+step);
  }

  /** Pass one step of the simulation */
  public void oneStep() {
    this.forest.oneStep();
  }

}
