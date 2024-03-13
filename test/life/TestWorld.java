package life;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;
import grid.*;

public class TestWorld {

  protected World world;

  @Before
  public void init() {
    this.world = this.createWorld();
  }

  protected World createWorld() {
    return new World(5,4,0);
  }

  @Test
  public void testGetWidth() {
    assertEquals(5,this.world.getWidth());
  }

  @Test
  public void testGetHeight() {
    assertEquals(4,this.world.getHeight());
  }

  @Test
  public void testGetCell() {
    Cell cell = this.world.getCellAtPosition(new Position(2,2));
    assertTrue(cell.isAlive());
  }

  @Test
  public void testGetColorAtPosition() {
    assertEquals(Color.white,this.world.getColorAtPosition(new Position(2,2)));
  }

  @Test
  public void testGetCharAtPosition() {
    assertEquals('O',this.world.getCharAtPosition(new Position(2,2)));
  }

  @Test
  public void testValidPosition() {
    assertTrue(this.world.validPosition(new Position(2,2)));
    assertFalse(this.world.validPosition(new Position(99,99)));
  }

  @Test
  public void testOneStep() {
    Position p = new Position(2,2);
    assertTrue(this.world.getCellAtPosition(p).isAlive());
    this.world.oneStep();
    assertFalse(this.world.getCellAtPosition(p).isAlive());
  }

  // ---Pour permettre l'execution des tests ----------------------
  public static junit.framework.Test suite() {
    return new junit.framework.JUnit4TestAdapter(life.TestWorld.class);
  }

}
