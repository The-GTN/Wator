
/**
 * TextGridDisplayer.java
 *
 */
package grid;


/** display a grid in  text format on standard ouput
 */
public class TextGridDisplayer implements GridDisplayer{    
    
    /** displays the grid
     * @param grid the grid to be displaid
     * @param msg a msg : displaid before the text grid
     */
    public void display(Grid grid, String msg) {
	System.out.println("******** "+msg);	
	for (int i=0; i<grid.getWidth(); i++) {
	    for (int j=0; j< grid.getHeight();j++) {
		System.out.print(grid.getCharAtPosition(new Position(i,j)));
	    }
	    System.out.println();	    
	}

//  	System.out.println("press ENTER to continue");
//  	try {
//  	    System.in.read(new byte[2]);
//  	}
//  	catch(java.io.IOException e) {
//  	    e.printStackTrace();
//  	}
    }
}// TextGridDisplayer
