package color_splash;

import grid.*;
import java.awt.Color;
import java.util.*;

/** Class for the field for Color Splash
* @author Nollet Antoine
* @version 19/08/2020
*/
public class Field implements Grid {

  /* the width of this forest */
  private int width;
  /* the height of this forest */
  private int height;
  /* the composition of this forest */
  private Cell[][] field;

  /** construct a field of width width, height height and with percentages for differents states
  * @param width the width
  * @param height the height
  * @param perOne the percentage of cell of state one
  * @param perTwo the percentage of cell of state two
  * @param perThree the percentage of cell of state three
  */
  public Field(int width, int height, int perOne, int perTwo, int perThree) {
    this.width = width;
    this.height = height;
    this.field = new Cell[height][width];
    int nbOne = perOne*width*height/100;
    int nbTwo = perTwo*width*height/100;
    int nbThree = perThree*width*height/100;
    this.affectField(nbOne,nbTwo,nbThree);
  }

  /** Affect this field
  * @param nbOne the number of cells of state one to put in this field
  * @param nbTwo the number of cells of state two to put in this field
  * @param nbThree the number of cells of state three to put in this field
  */
  private void affectField(int nbOne, int nbTwo, int nbThree) {
    this.giveEmptyCell();
    this.giveOne(nbOne);
    this.giveTwo(nbTwo);
    this.giveThree(nbThree);
  }

  /** Fill this Field with cell of state 0 */
  private void giveEmptyCell() {
    for (int y = 0;y!=this.height;y++) for (int x = 0;x!=this.width;x++) this.field[y][x] = new Cell();
  }

  /** Put nbOne cell of state one in this Field
  * @param nbOne the cells of state one to put in this forest
  */
  private void giveOne(int nbOne) {
    for(int i = 0; i!=nbOne; i++) this.giveCell(1);
  }

  /** Put nbOne cell of state one in this Field
  * @param nbOne the cells of state one to put in this forest
  */
  private void giveTwo(int nbTwo) {
    for(int i = 0; i!=nbTwo; i++) this.giveCell(2);
  }

  /** Put nbOne cell of state one in this Field
  * @param nbOne the cells of state one to put in this forest
  */
  private void giveThree(int nbThree) {
    for(int i = 0; i!=nbThree; i++) this.giveCell(3);
  }

  /** Put one cell of state state to this Field
  * @param state the state we want to put to a cell of this field */
  private void giveCell(int state) {
    boolean notadd = true;
    Random random = new Random();
    int y;
    int x;
    while(notadd) {
      y = random.nextInt(this.height);
      x = random.nextInt(this.width);
      if (this.field[y][x].get_state() == 0) {
        for(int i = 0;i!=state;i++) this.field[y][x].next_state();
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
    return this.field[p.getY()][p.getX()];
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
    Cell[][] newField;
    newField = new Cell[this.height][this.width];
    for(int y = 0; y!=this.height;y++) for(int x = 0; x!=this.width;x++) newField[y][x] = this.futureState(new Position(x,y));
    this.field = newField;
  }

  /** return the cell that the cell at position p will become
  * @param p the position of the cell that will change
  * @return the cell that the cell at position p will become
  */
  private Cell futureState(Position p) {
    List<Position> positionsVoisines = getPositionsVoisines(p);
    Cell actualCell = this.getCellAtPosition(p);
    int nblevelup = getNbLevelUp(positionsVoisines,actualCell.get_state());
    if(nblevelup > 1) actualCell.next_state();
    return actualCell;
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

  /** get the number of state of level up in a list of position
  * @param positionsVoisines the list to check
  * @param state the state to compare with
  * @return the number of living in a list of position
  */
  private int getNbLevelUp(List<Position> positionsVoisines, int state) {
    int res = 0;
    for(Position p : positionsVoisines) if(this.getCellAtPosition(p).get_state() == (state+1)%4) res++;
    return res;
  }

}
