package color_splash;

import java.awt.Color;

/** class for cell of the Simulation of Color Splash
* @author Nollet Antoine
* @version 19/08/2020
*/
public class Cell {

  /*the state of this cell*/
  private int state;

  /** Contruct a new cell at state 0 */
  public Cell() {
    this.state = 0;
  }


  public void next_state() {
    this.state = (this.state + 1)%4;
  }

  public int get_state() {
    return this.state;
  }

  /** return the color of this cell
  * @return the color of this cell
  */
  public java.awt.Color getColor() {
    if(this.get_state() == 0) return Color.red;
    else if(this.get_state() == 1) return Color.orange;
    else if(this.get_state() == 2) return Color.yellow;
    else return Color.magenta;
  }

  /** return the char of this cell
  * @return the char of this cell
  */
  public char getChar() {
    if(this.get_state() == 0) return '0';
    else if(this.get_state() == 1) return '1';
    else if(this.get_state() == 2) return '2';
    else return '3';
  }

}
