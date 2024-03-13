package thieves;

import grid.*;
import java.awt.Color;
import java.util.*;


/** The class of the container for this project
*
*@author Nollet Antoine
*@version 19/08/2020
*/
public class Container implements Grid {

  /* the width of this container */
  private int width;
  /* the height of this container */
  private int height;
  /* the composition of this container */
  private Cell[][] container;

  /** create a container
  * @param width the width of the container
  * @param height the height of the container
  */
  public Container(int width, int height, int perThief, int maxCoin) {
    this.width = width;
    this.height = height;
    this.container = new Cell[height][width];
    for (int y = 0;y!=height;y++) {
       for (int x = 0;x!=width;x++) {
         this.container[y][x] = new Cell();
       }
     }
     int nbThief = perThief*width*height/100;
     this.affectThieves(nbThief,maxCoin);
  }

  /** return the width of the grid
   * @return the width of the grid
   */
  public int getWidth() {
    return this.width;
  }

  /** return the height of the grid
   * @return the height of the grid
   */
  public int getHeight() {
    return this.height;
  }

  public Cell getCell(Position p) {
    int x = p.getX();
    int y = p.getY();
    return this.container[y][x];
  }

  public void affectThieves(int nbThief, int maxCoin) {
    for(int i = 0;i!=nbThief;i++) this.affectThief(maxCoin);
  }

  public void affectThief(int maxCoin) {
    boolean notadd = true;
    Random random = new Random();
    int y;
    int x;
    int coins;
    while(notadd) {
      y = random.nextInt(this.height);
      x = random.nextInt(this.width);
      coins = random.nextInt(maxCoin);
      if (this.container[y][x].isEmpty()) {
        this.container[y][x].setThief(new Thief(coins));
        notadd = false;
      }
    }
  }

  /** return the color of the box at position<em>p</em>
   * @param p the position
   * @return the color
   */
  public java.awt.Color getColorAtPosition(Position p) {
    return this.getCell(p).getColor();
  }

  /** return the char to be displaid in the box at position<em>p</em>
   * @param p the position
   * @return the char to be displaid
   */
  public char getCharAtPosition(Position p) {
    return this.getCell(p).getChar();
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

  public Position destPos(Position pos) {
    Position res = null;
    List<Position> neighbourhood = this.getPositionsVoisines(pos);
    for(Position p : neighbourhood) if(res == null && this.getCell(p).isEmpty()) res = p;
    return res;
  }

  public void move(Position from, Position dest) {
    Thief thief = this.getCell(from).unsetThief();
    this.getCell(dest).setThief(thief);
    this.getMoney(dest);
  }

  private void getMoney(Position pos) {
    List<Position> neighbourhood = this.getPositionsVoisines(pos);
    for(Position p : neighbourhood) if(!this.getCell(p).isEmpty()) this.transaction(p,pos);
  }

  private void transaction(Position from, Position dest) {
    if(this.getCell(from).getThief().removeCoin()) this.getCell(dest).getThief().addCoin();
  }

}
