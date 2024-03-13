package wator.environment;

import grid.*;
import wator.fish.*;
import java.awt.Color;
import java.util.*;


/** The class of the sea for this project
*
*@author Nollet Antoine
*@version 20/05/2020
*/
public class Sea implements Grid {

  /* the width of this sea */
  private int width;
  /* the height of this sea */
  private int height;
  /* the composition of this sea */
  private Cell[][] sea;

  /** create a sea
  * @param width the width of the sea
  * @param height the height of the sea
  */
  public Sea(int width, int height) {
    this.width = width;
    this.height = height;
    this.sea = new Cell[height][width];
    for (int y = 0;y!=height;y++) {
       for (int x = 0;x!=width;x++) {
         this.sea[y][x] = new Cell();
       }
     }
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

  /** Put randomly the number of Tunas and the number of Sharks in this sea
  * @param nbTuna the number of Tunas to put in this sea
  * @param nbSharks the number of Sharks to put in this sea
  */
  public void addTunasAndSharks(int nbTuna, int nbShark) {
    int compteurTuna = nbTuna;
    int compteurShark = nbShark;
    boolean end = false;
    while(!end) {
      if(compteurTuna!=0) {
        this.addFish(new Tuna());
        compteurTuna--;
      }
      if(compteurShark!=0) {
        this.addFish(new Shark());
        compteurShark--;
      }
      if((compteurTuna==0 && compteurShark==0) || this.fullSea()) end = true;
    }
  }

  /** Put randomly the fish in this sea
  * @param f the fish to put in this sea
  */
  public void addFish(Fish f) {
    boolean notadd = true;
    Random random = new Random();
    int y;
    int x;
    while(notadd) {
      y = random.nextInt(this.height);
      x = random.nextInt(this.width);
      if (this.sea[y][x].isEmpty()) {
        this.sea[y][x].setFish(f);
        notadd = false;
      }
    }
  }

  /** Boolean to know if this sea is full or not
  *@return true if this sea is full, false otherwise
  */
  public boolean fullSea() {
    for (int y = 0;y!=this.height;y++) {
       for (int x = 0;x!=this.width;x++) {
         if (this.sea[y][x].isEmpty()) return false;
       }
     }
     return true;
  }

  /** return the color of the box at position<em>p</em>
   * @param p the position
   * @return the color
   */
  public java.awt.Color getColorAtPosition(Position p) {
    Cell pos = this.sea[p.getY()][p.getX()];
    if (pos.isEmpty()) return Color.blue;
    else return pos.getFish().getColor();
  }

  /** return the char to be displaid in the box at position<em>p</em>
   * @param p the position
   * @return the char to be displaid
   */
  public char getCharAtPosition(Position p) {
    Cell pos = this.sea[p.getY()][p.getX()];
    if (pos.isEmpty()) return '-';
    else return pos.getFish().getChar();
  }

  /** return if the position is valid for the size of this sea
  * @param p the position we check if it's valid for this sea
  * @return true if the position p is valid for this sea, false otherwise
  */
  public boolean validPosition(Position p) {
    return p.getX() > -1 && p.getX() < this.width && p.getY() > -1 && p.getY() < this.height;
  }

  public Cell getCell(Position p) {
    int x = p.getX();
    int y = p.getY();
    return this.sea[y][x];
  }

  /** Return the position of the cell where the fish is going to go
  * @param fish the fish to move
  * @param pos the actual position of the fish
  * @return position of the cell where the fish is going to go
  */
  public Position moveFish(Fish fish, Position pos) {
    List<Position> voisins = new ArrayList<Position>();
    Position voisin;
    while(voisins.size() != 8) {
      voisin = pos.randomNeighbour(this.width,this.height);
      if(fish.canMove(this.getCell(voisin)))return voisin;
      else if(!voisins.contains(voisin)) voisins.add(voisin);
    }
    return pos;
  }

  /** clean the cell at position pos
  * @param pos the position of the cell to clean
  */
  public void cleanCell(Position pos) {
    this.sea[pos.getY()][pos.getX()].cleanCell();
  }

  /** Clean the sea
  */
  public void cleanSea() {
    for (int y = 0;y!=this.height;y++) {
       for (int x = 0;x!=this.width;x++) {
         this.sea[y][x].cleanCell();
       }
     }
  }

  /** Put the fish from the position from to the position dest
  * @param from the position where the fish was
  * @param dest the position where the fish go
  * @param fish the fish to move
  */
  public void putFish(Position from, Position dest, Fish fish) {
    this.cleanCell(from);
    this.getCell(dest).setFish(fish);
  }

}
