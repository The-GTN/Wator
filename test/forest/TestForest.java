package forest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;
import grid.*;

public class TestForest {

  protected Forest forest;

  @Before
  public void init() {
    this.forest = this.createForest();
  }

  protected Forest createForest() {
    return new Forest(5,4,0);
  }

  @Test
  public void testGetWidth() {
    assertEquals(5,this.forest.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertEquals(4,this.forest.getHeight());
  }

  @Test
  public void testGetCell() {
    Cell cell = this.forest.getCellAtPosition(new Position(2,2));
    assertTrue(cell.isEmpty());
  }

  @Test
  public void testGetColorAtPosition() {
    assertEquals(Color.white,this.forest.getColorAtPosition(new Position(2,2)));
  }

  @Test
  public void testGetCharAtPosition() {
    assertEquals(' ',this.forest.getCharAtPosition(new Position(2,2)));
  }

  @Test
  public void testOneStep() {
    Forest newTest = new Forest(3,3,100);
    Position p = new Position(2,2);
    for(int i=0;i!=4;i++) newTest.oneStep();
    assertTrue(newTest.getCellAtPosition(p).isAsh());
  }

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(forest.TestForest.class);
  }

}
