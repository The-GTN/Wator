package wator.environment;

import wator.fish.*;
import grid.*;
import java.util.Random;

/** class of simulator for wator project
*
* @author Nollet Antoine
* @version 20/05/2020
*/
public class Wator {

  /* the displayer of the simulation */
  private GridDisplayer displayer;
  /* the sea where we do the simulation */
  private Sea sea;

  /** Create a simulator wator
  * @param displayer the displayer we use
  * @param sea the sea where we do the simulation
  */
  public Wator(GridDisplayer displayer, Sea sea) {
    this.displayer = displayer;
    this.sea = sea;
  }

  /** Display the sea with the displayer
  * @param step the number of step (for exemple "15/300")
  */
  public void display(String step) {
    this.displayer.display(sea,"Wator : step "+step);
  }

  /** Pass one step of the simulation */
  public void oneStep() {
    Random random = new Random();
    int y = random.nextInt(this.sea.getHeight());
    int x = random.nextInt(this.sea.getWidth());
    Position step = new Position(x,y);
    Cell theOne = this.sea.getCell(step);
    if(!theOne.isEmpty()) this.action(theOne.getFish(),step);
  }

  /** The action that a fish do when he's selected to move */
  private void action(Fish fish, Position pos) {
    fish.timePass();
    Position dest = this.sea.moveFish(fish,pos);
    this.sea.putFish(pos,dest,fish);
    if(fish.haveToDie()) {
      if(!pos.equals(dest)) this.sea.cleanCell(dest);
      else this.sea.cleanCell(pos);
    }
    else if(fish.getGestation() == 0) {
      Fish littleFish = fish.giveBorn();
      if(!pos.equals(dest)) this.sea.getCell(pos).setFish(littleFish);
    }
  }

}
