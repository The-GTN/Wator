/**
 * Position.java
 *
 */
package grid;

import java.util.*;

/**
 * a position in a grid
 */
public class Position {

    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * returns one of 8 neighbours of this position assuming environment is a
     * tore
     *
     * @param width
     *            width of environment
     * @param height
     *            height of environment
     */
    public Position randomNeighbour(int width, int height) {
        int dx = 0;
        int dy = 0;
        do {
            dx = (((int) (Math.random() * 1000)) % 3) - 1;
            dy = (((int) (Math.random() * 1000)) % 3) - 1;
        } while (dx == 0 && dy == 0);
        return new Position((width + x + dx) % width, (height + y + dy) % height);
    }

    public List<Position> vonNeumannNeighbourHood(int width, int height) {
      List<Position> neighbours = new ArrayList<Position>();
      if(this.x > 0) neighbours.add(new Position(this.x-1,this.y));
      if(this.x < width-1) neighbours.add(new Position(this.x+1,this.y));
      if(this.y > 0) neighbours.add(new Position(this.x,this.y-1));
      if(this.y < height-1) neighbours.add(new Position(this.x,this.y+1));
      return neighbours;
    }

    public boolean equals(Position p) {
        return (x == p.getX()) && (y == p.getY());
    }

    public boolean equals(Object o) {
        if (o instanceof Position) {
            return equals((Position) o);
        } else {
            throw new ClassCastException(o + " should be a Position");
        }
    }

    public String toString() {
        return "(" + x + "," + y + ")";
    }
}// Position
