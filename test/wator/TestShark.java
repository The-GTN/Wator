package wator;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import wator.fish.*;
import wator.environment.*;


public class TestShark extends TestTuna{

  public Fish createFish() {
    return new Shark();
  }

  @Test
  public void testHaveToDie() {
    Shark shark = (Shark) this.fish;
    assertFalse(shark.haveToDie());
    int energy = shark.getEnergy();
    for(int i=0;i!=energy;i++){
      shark.timePass();
    }
    assertTrue(shark.haveToDie());
  }

  @Test
  public void testEat() {
    Shark shark = (Shark) this.fish;
    assertEquals(2,shark.getEnergy());
    shark.timePass();
    assertEquals(1,shark.getEnergy());
    Cell cell = new Cell();
    cell.setFish(new Tuna());
    assertTrue(shark.canMove(cell));
    assertEquals(2,shark.getEnergy());
  }

  // ---Pour permettre l'execution des tests ----------------------
    public static junit.framework.Test suite() {
	return new junit.framework.JUnit4TestAdapter(wator.TestShark.class);
  }
}
