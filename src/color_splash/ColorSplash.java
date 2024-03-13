package color_splash;

import grid.*;

/** Class of simulation of Color Splash
* @author Nollet Antoine
* @version 19/08/2020
*/
public class ColorSplash {

  /* the displayer of the simulation */
  private GridDisplayer displayer;
  /* the field where we do the simulation */
  private Field field;

  /** Create a simulator ColorSplash
  * @param displayer the displayer we use
  * @param field the field where we do the simulation
  */
  public ColorSplash(GridDisplayer displayer, Field field) {
    this.displayer = displayer;
    this.field = field;
  }

  /** Display the field with the displayer
  * @param step the number of step (for exemple "15/300")
  */
  public void display(String step) {
    this.displayer.display(this.field,"Color Splash : step "+step);
  }

  /** Pass one step of the simulation */
  public void oneStep() {
    this.field.oneStep();
  }

}
