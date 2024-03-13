package forest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;

public class TestCell {

  protected Cell cell;

  @Before
  public void init() {
    this.cell = this.createCell();
  }

  protected Cell createCell() {
    return new Cell();
  }

  @Test
  public void TestGetChar() {
    assertEquals(' ',this.cell.getChar());
    this.cell.putTree();
    assertEquals('T',this.cell.getChar());
    this.cell.setFire();
    assertEquals('&',this.cell.getChar());
    this.cell.setAsh();
    assertEquals('_',this.cell.getChar());
  }

  @Test
  public void TestGetColor() {
    assertEquals(Color.white,this.cell.getColor());
    this.cell.putTree();
    assertEquals(Color.green,this.cell.getColor());
    this.cell.setFire();
    assertEquals(Color.red,this.cell.getColor());
    this.cell.setAsh();
    assertEquals(Color.gray,this.cell.getColor());
  }

  @Test
  public void testStates() {
    assertTrue(this.cell.isEmpty());
    assertFalse(this.cell.isTree());
    assertFalse(this.cell.isOnFire());
    assertFalse(this.cell.isAsh());
    this.cell.putTree();
    assertFalse(this.cell.isEmpty());
    assertTrue(this.cell.isTree());
    assertFalse(this.cell.isOnFire());
    assertFalse(this.cell.isAsh());
    this.cell.setFire();
    assertFalse(this.cell.isEmpty());
    assertFalse(this.cell.isTree());
    assertTrue(this.cell.isOnFire());
    assertFalse(this.cell.isAsh());
    this.cell.setAsh();
    assertFalse(this.cell.isEmpty());
    assertFalse(this.cell.isTree());
    assertFalse(this.cell.isOnFire());
    assertTrue(this.cell.isAsh());
  }

  // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(forest.TestCell.class);
  }

}
