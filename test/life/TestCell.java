package life;

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
    return new Cell(true);
  }

  @Test
  public void testLiveandDeath() {
    this.cell.giveLife();
    assertTrue(this.cell.isAlive());
    this.cell.giveDeath();
    assertFalse(this.cell.isAlive());
    this.cell.giveLife();
    assertTrue(this.cell.isAlive());
  }

  @Test
  public void testGetColor() {
    this.cell.giveLife();
    assertEquals(Color.white,this.cell.getColor());
    this.cell.giveDeath();
    assertEquals(Color.darkGray,this.cell.getColor());
    this.cell.giveLife();
    assertEquals(Color.white,this.cell.getColor());
  }

  @Test
  public void testGetChar() {
    this.cell.giveLife();
    assertEquals('O',this.cell.getChar());
    this.cell.giveDeath();
    assertEquals('-',this.cell.getChar());
    this.cell.giveLife();
    assertEquals('O',this.cell.getChar());
  }

  // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(life.TestCell.class);
  }

}
