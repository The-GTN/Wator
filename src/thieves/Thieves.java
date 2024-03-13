package thieves;

import java.util.*;
import grid.*;

/** Class for simulation of thieves
* @author Nollet Antoine
* @version 19/08/2020
*/
public class Thieves {

  /* the displayer of the simulation */
  private GridDisplayer displayer;
  /* the container where we do the simulation */
  private Container container;

  /** Create a simulator wator
  * @param displayer the displayer we use
  * @param container the container where we do the simulation
  */
  public Thieves(GridDisplayer displayer, Container container) {
    this.displayer = displayer;
    this.container = container;
  }

  /** Display the sea with the displayer
  * @param step the number of step (for exemple "15/300")
  */
  public void display(String step) {
    this.displayer.display(this.container,"Thieves : step "+step);
  }

  /** Pass one step of the simulation */
  public void oneStep() {
    Random random = new Random();
    int y = random.nextInt(this.container.getHeight());
    int x = random.nextInt(this.container.getWidth());
    Position step = new Position(x,y);
    Cell theOne = this.container.getCell(step);
    if(!theOne.isEmpty()) this.action(step);
  }

  /** The action that a thief do when he's selected to move */
  private void action(Position pos) {
    Position dest = this.container.destPos(pos);
    if(dest != null) this.container.move(pos,dest);
  }

}
