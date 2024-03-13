package forest;

import grid.*;
import java.awt.Color;
import java.util.*;

/** Class for the forest for BurnForest
* @author Nollet Antoine
* @version 03/06/2020
*/
public class Forest implements Grid {

  /* the width of this forest */
  private int width;
  /* the height of this forest */
  private int height;
  /* the composition of this forest */
  private Cell[][] forest;

  /** construct a forest of width width, height height and with perTree percentage of trees
  * @param width the width
  * @param height the height
  * @param perTree the percentage of trees
  */
  public Forest(int width, int height, int perTree) {
    this.width = width;
    this.height = height;
    this.forest = new Cell[height][width];
    int nbTree = perTree*width*height/100;
    this.affectForest(nbTree);
  }

  /** Affect this forest
  * @param nbTree the trees to put in this forest
  */
  private void affectForest(int nbTree) {
    this.giveEmptyCell();
    this.giveTrees(nbTree);
    if(nbTree > 0) this.putOneFire();
  }

  /** Fill this Forest with empty cell */
  private void giveEmptyCell() {
    for (int y = 0;y!=this.height;y++) for (int x = 0;x!=this.width;x++) this.forest[y][x] = new Cell();
  }

  /** Put nbTree trees in this Forest
  * @param nbTree the trees to put in this forest
  */
  private void giveTrees(int nbTree) {
    for(int i = 0; i!=nbTree; i++) this.giveOneTree();
  }

  /** Put one Tree to this Forest */
  private void giveOneTree() {
    boolean notadd = true;
    Random random = new Random();
    int y;
    int x;
    while(notadd) {
      y = random.nextInt(this.height);
      x = random.nextInt(this.width);
      if (this.forest[y][x].isEmpty()) {
        this.forest[y][x].putTree();
        notadd = false;
      }
    }
  }

  /** put one fire in this forest */
  private void putOneFire() {
    boolean notadd = true;
    Random random = new Random();
    int y;
    int x;
    while(notadd) {
      y = random.nextInt(this.height);
      x = random.nextInt(this.width);
      if (this.forest[y][x].isTree()) {
        this.forest[y][x].setFire();
        notadd = false;
      }
    }
  }

  /** returns the width of the forest
   * @return the width of the forest
   */
  public int getWidth() {
    return this.width;
  }

  /** returns the height of the forest
   * @return the height of the forest
   */
  public int getHeight() {
    return this.height;
  }

  /** get the cell at position p
  * @param p the position where we want to get the cell
  */
  public Cell getCellAtPosition(Position p) {
    return this.forest[p.getY()][p.getX()];
  }

  /** returns the color of the box at position<em>p</em>
   * @param p the position
   * @return the color
   */
  public java.awt.Color getColorAtPosition(Position p) {
    Cell pos = this.getCellAtPosition(p);
    return pos.getColor();
  }

  /** returns the char to be displaid in the box at position<em>p</em>
   * @param p the position
   * @return the char to be displaid
   */
  public char getCharAtPosition(Position p) {
    Cell pos = this.getCellAtPosition(p);
    return pos.getChar();
  }

  /** change the forest by one step */
  public void oneStep() {
    Cell[][] newForest;
    newForest = new Cell[this.height][this.width];
    for(int y = 0; y!=this.height;y++) for(int x = 0; x!=this.width;x++) newForest[y][x] = this.futureState(new Position(x,y));
    this.forest = newForest;
  }

  /** return the cell that the cell at position p will become
  * @param p the position of the cell that will change
  * @return the cell that the cell at position p will become
  */
  private Cell futureState(Position p) {
    List<Position> positionsVoisines = p.vonNeumannNeighbourHood(this.width, this.height);
    Cell actualCell = this.getCellAtPosition(p);
    Cell newCell = new Cell();
    boolean thereFire = false;
    for(Position voisin : positionsVoisines) if(this.getCellAtPosition(voisin).isOnFire()) thereFire = true;
    if(actualCell.isTree()) newCell.putTree();
    if(actualCell.isTree() && thereFire) newCell.setFire();
    if(actualCell.isOnFire()) newCell.setAsh();
    if(actualCell.isAsh()) newCell.setAsh();
    return newCell;
  }

}
