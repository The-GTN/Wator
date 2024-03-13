package life;

import grid.*;

/** Class of simulation of LifeGame
* @author Nollet Antoine
* @version 01/06/2020
*/
public class LifeGame {

  /* the displayer of the simulation */
  private GridDisplayer displayer;
  /* the world where we do the simulation */
  private World world;

  /** Create a simulator LifeGame
  * @param displayer the displayer we use
  * @param world the world where we do the simulation
  */
  public LifeGame(GridDisplayer displayer, World world) {
    this.displayer = displayer;
    this.world = world;
  }

  /** Display the world with the displayer
  * @param step the number of step (for exemple "15/300")
  */
  public void display(String step) {
    this.displayer.display(this.world,"LifeGame : step "+step);
  }

  /** Pass one step of the simulation */
  public void oneStep() {
    this.world.oneStep();
  }

}
