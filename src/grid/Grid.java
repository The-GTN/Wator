
/**
 * Grid.java
 *
 */
package grid;

/** a Grid is an aera of width x height "boxes". Each box can have a
  * specific color and a char to be displaid.
  * */
public interface Grid {

    /** returns the width of the grid
     * @return the width of the grid
     */
    public int getWidth();
    /** returns the height of the grid
     * @return the height of the grid
     */
    public int getHeight();
    /** returns the color of the box at position<em>p</em>
     * @param p the position
     * @return the color
     */
    public java.awt.Color getColorAtPosition(Position p);
    /** returns the char to be displaid in the box at position<em>p</em>
     * @param p the position
     * @return the char to be displaid
     */
    public char getCharAtPosition(Position p);    

}// Grid
