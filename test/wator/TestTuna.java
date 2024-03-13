package wator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import wator.fish.*;
import java.lang.reflect.Field;
import wator.environment.*;

public class TestTuna {

  protected Fish fish;

  public Fish createFish() {
    return new Tuna();
  }

  @Before
  public void init() {
    this.fish = this.createFish();
  }

  @Test
  public void goodGestation() {
    assertEquals(2,this.fish.getGestation());
    this.fish.timePass();
    assertEquals(1,this.fish.getGestation());
  }

  @Test
  public void giveBorn() {
    Fish littleFish = this.fish.giveBorn();
    assertTrue(littleFish.equals(this.createFish()));
  }

  @Test
  public void testCanMove() {
    Cell cell = new Cell();
    assertTrue(this.fish.canMove(cell));
    cell.setFish(this.createFish());
    assertFalse(this.fish.canMove(cell));
  }

  @Test
  public void testHaveToDie() {
    assertFalse(this.fish.haveToDie());
  }

  @Test
  public void testTime() {
    assertEquals(2,this.fish.getGestation());
    this.fish.timePass();
    assertEquals(1,this.fish.getGestation());
  }

  // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(wator.TestTuna.class);
  }
}
