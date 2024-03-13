/**
 * GraphicalGridDisplayer.java
 *
 */
package grid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * display a grid in a JFrame
 */
public class GraphicalGridDisplayer extends JFrame implements GridDisplayer {

    public static int SQUARE_SIZE = 10;
    public static int SQUARE_SIZE_INT = SQUARE_SIZE - 2;

    private java.awt.Color[][] oldGrid;
    private Insets insets;

    public GraphicalGridDisplayer(int width, int height, String icon) {

        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.getImage(icon);
        setIconImage(img);

        addWindowListener(new MyWindowAdapter());
        oldGrid = new java.awt.Color[width][height];
        for (int i = 0; i < oldGrid.length; i++) {
            for (int j = 0; j < oldGrid[0].length; j++) {
                this.oldGrid[i][j] = Color.WHITE;
            }
        }
        this.setVisible(true);
        this.insets = this.getInsets();
        this.setSize(width * SQUARE_SIZE + (this.insets.left + this.insets.right)+10, height * SQUARE_SIZE + (this.insets.top + this.insets.bottom)+15);

    }

    public void paint(Graphics g) {
        Graphics2D myGraphics = (Graphics2D) g;

        for (int i = 0; i < oldGrid.length; i++) {
            for (int j = 0; j < oldGrid[0].length; j++) {
                myGraphics.setColor(oldGrid[i][j]);
                myGraphics.fillRect(i * SQUARE_SIZE + this.insets.left + 1 +5, j * SQUARE_SIZE + this.insets.top+1 +10, SQUARE_SIZE_INT, SQUARE_SIZE_INT);
            }
        }

        try {
            synchronized (this) {
                Thread.sleep(50);
                this.notifyAll();
            }
        } catch (Exception e) {
        }
    }

    /**
     * displays the grid, msg is
     *
     * @param grid
     *            the grid to be displaid
     * @param msg
     *            a msg : displaid in the title bar of the frame
     */
    public void display(Grid toBeRepaint, String msg) {
        setTitle(msg);

        int w = toBeRepaint.getWidth();
        int h = toBeRepaint.getHeight();

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                java.awt.Color newColor = toBeRepaint.getColorAtPosition(new Position(i, j));

                if (!newColor.equals(oldGrid[i][j])) {
                    oldGrid[i][j] = newColor;
                }
            }
        }

        try {
            synchronized (this) {
                this.repaint();
                this.wait();
            }
        } catch (Exception e) {
        }
    }

    class MyWindowAdapter extends java.awt.event.WindowAdapter {
        public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
        }
    }

}// GraphicalGridDisplayer
