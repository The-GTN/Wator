package forest;

import java.awt.Color;

/** class for cell of the Simulation of BurnForest
* @author Nollet Antoine
* @version 03/06/2020
*/
public class Cell {

  /** the state of this cell */
   private int content;

   /** construct a new empty cell */
   public Cell() {
     this.content = 0;
   }

   /** boolean to check if this cell is empty or not
   * @return true if this cell is empty, false otherwise
   */
   public boolean isEmpty() {
     return this.content==0;
   }

   /** put a tree in this cell */
   public void putTree() {
     this.content = 1;
   }

   /** boolean to check if there a tree in this cell
   * @return true if this cell contains a tree, false otherwise
   */
   public boolean isTree() {
     return this.content == 1;
   }

   /** set fire to this cell */
   public void setFire() {
     this.content = 2;
   }

   /** boolean to check if this cell is on fire or not
   * @return true if this cell is on fire, false otherwise
   */
   public boolean isOnFire() {
     return this.content == 2;
   }

   /** set ash to this cell */
   public void setAsh() {
     this.content = 3;
   }

   /** boolean to check if this cell is ash or not
   * @return true if this cell is on fire, false otherwise
   */
   public boolean isAsh() {
     return this.content == 3;
   }

   /** return the color of this cell
   * @return the color of this cell
   */
   public java.awt.Color getColor() {
     if(this.isEmpty()) return Color.white;
     else if(this.isTree()) return Color.green;
     else if(this.isOnFire()) return Color.red;
     else return Color.gray;
   }

   /** return the char of this cell
   * @return the char of this cell
   */
   public char getChar() {
     if(this.isEmpty()) return ' ';
     else if(this.isTree()) return 'T';
     else if(this.isOnFire()) return '&';
     else return '_';
   }
}
