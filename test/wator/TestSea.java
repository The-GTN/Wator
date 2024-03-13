package wator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import wator.environment.*;
import grid.*;
import java.awt.Color;

public class TestSea {

  private Sea sea;

  @Before
  public void init() {
    this.sea = new Sea(5,4);
  }

  @Test
	public void takeGoodWidth() {
		assertEquals(5,sea.getWidth());
	}

  @Test
	public void takeGoodHeight() {
		assertEquals(4,sea.getHeight());
	}

  @Test
  public void testFullSea() {
    sea.addTunasAndSharks(20,0);
    assertTrue(sea.fullSea());
  }

  @Test
  public void getCorrectColor() {
    Position test = new Position(0,0);
    assertEquals(Color.blue,sea.getColorAtPosition(test));
    sea.addTunasAndSharks(20,0);
    assertEquals(Color.white,sea.getColorAtPosition(test));
    sea.cleanSea();
    assertEquals(Color.blue,sea.getColorAtPosition(test));
    sea.addTunasAndSharks(0,20);
    assertEquals(Color.red,sea.getColorAtPosition(test));
  }

  @Test
  public void getCorrectCharac() {
    Position test = new Position(0,0);
    assertEquals('-',sea.getCharAtPosition(test));
    sea.addTunasAndSharks(20,0);
    assertEquals('T',sea.getCharAtPosition(test));
    sea.cleanSea();
    assertEquals('-',sea.getCharAtPosition(test));
    sea.addTunasAndSharks(0,20);
    assertEquals('S',sea.getCharAtPosition(test));
  }

  @Test
  public void testValidPosition() {
    assertTrue(sea.validPosition(new Position(0,0)));
    assertFalse(sea.validPosition(new Position(5,5)));
  }

  @Test(expected=ArrayIndexOutOfBoundsException.class)
  public void getWrongCell() {
    sea.getCell(new Position(6,6));
  }





  // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(wator.TestSea.class);
  }
}
