package life;

import grid.*;
import java.awt.Color;
import java.util.*;

/** Class for the world for LifeGame
* @author Nollet Antoine
* @version 01/06/2020
*/
public class World implements Grid {

  /* the width of this world */
  private int width;
  /* the height of this world */
  private int height;
  /* the composition of this world */
  private Cell[][] world;

  /** construct a world of width width, height height and with perDeath percentage of Death
  * @param width the width
  * @param height the height
  * @param perDeath the percentage of death
  */
  public World(int width, int height, int perDeath) {
    this.width = width;
    this.height = height;
    this.world = new Cell[height][width];
    int nbDeath = perDeath*width*height/100;
    this.affectWorld(nbDeath);
  }

  /** Affect this world
  * @param nbDeath the deads to put in this world
  */
  private void affectWorld(int nbDeath) {
    this.giveLife();
    this.giveDeath(nbDeath);
  }

  /** Fill this World with life */
  private void giveLife() {
    for (int y = 0;y!=this.height;y++) for (int x = 0;x!=this.width;x++) this.world[y][x] = new Cell(true);
  }

  /** Put nbDeath deads in this World
  * @param nbDeath the deads to put in this world
  */
  private void giveDeath(int nbDeath) {
    for(int i = 0; i!=nbDeath; i++) this.giveOneDeath();
  }

  /** Put one Death to this World */
  private void giveOneDeath() {
    boolean notadd = true;
    Random random = new Random();
    int y;
    int x;
    while(notadd) {
      y = random.nextInt(this.height);
      x = random.nextInt(this.width);
      if (this.world[y][x].isAlive()) {
        this.world[y][x].giveDeath();
        notadd = false;
      }
    }
  }

  /** returns the width of the world
   * @return the width of the world
   */
  public int getWidth() {
    return this.width;
  }

  /** returns the height of the world
   * @return the height of the world
   */
  public int getHeight() {
    return this.height;
  }

  /** get the cell at position p
  * @param p the position where we want to get the cell
  */
  public Cell getCellAtPosition(Position p) {
    return this.world[p.getY()][p.getX()];
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


  /** return if the position is valid for the size of this world
  * @param p the position we check if it's valid for this world
  * @return true if the position p is valid for this world, false otherwise
  */
  public boolean validPosition(Position p) {
    return p.getX() > -1 && p.getX() < this.width && p.getY() > -1 && p.getY() < this.height;
  }

  /** change the world by one step */
  public void oneStep() {
    Cell[][] newWorld;
    newWorld = new Cell[this.height][this.width];
    for(int y = 0; y!=this.height;y++) for(int x = 0; x!=this.width;x++) newWorld[y][x] = this.futureState(new Position(x,y));
    this.world = newWorld;
  }

  /** return the cell that the cell at position p will become
  * @param p the position of the cell that will change
  * @return the cell that the cell at position p will become
  */
  private Cell futureState(Position p) {
    List<Position> positionsVoisines = getPositionsVoisines(p);
    int nbLifeAround = getNbLife(positionsVoisines);
    if(this.getCellAtPosition(p).isAlive()) {
      if(nbLifeAround==2 || nbLifeAround==3) return new Cell(true);
      else return new Cell(false);
    }
    else {
      if(nbLifeAround==3) return new Cell(true);
      else return new Cell(false);
    }
  }

  /** get the neighbourhood of the cell at position p
  * @param p the position of the cell that we want the neighbourhood
  * @return the neighbourhood of the cell at position p
  */
  private List<Position> getPositionsVoisines(Position p) {
    List<Position> res = new ArrayList<Position>();
    Position voisin;
    while(res.size() != 8) {
      voisin = p.randomNeighbour(this.width,this.height);
      if(!res.contains(voisin)) res.add(voisin);
    }
    return res;
  }

  /** get the number of living in a list of position
  * @param positionsVoisines the list to check
  * @return the number of living in a list of position
  */
  private int getNbLife(List<Position> positionsVoisines) {
    int res = 0;
    for(Position p : positionsVoisines) if(this.getCellAtPosition(p).isAlive()) res++;
    return res;
  }

}
