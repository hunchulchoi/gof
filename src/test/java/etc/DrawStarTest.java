package etc;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DrawStarTest {

  @Test
  void draw(){
    DrawStar drawStar = new DrawStar();
    String draw = drawStar.draw(7);
    System.out.println(draw);
  }

  @Test
  void print() {

    DrawStar drawStar = new DrawStar();

    //IntStream.range(0, 13).forEach(i->assertTrue(drawStar.print(5, 2, i)));

    System.out.println("row====0");
    assertFalse(drawStar.print(5, 0, 0));
    assertFalse(drawStar.print(5, 0, 1));
    assertFalse(drawStar.print(5, 0, 2));
    assertFalse(drawStar.print(5, 0, 3));
    assertFalse(drawStar.print(5, 0, 4));
    assertTrue(drawStar.print(5, 0, 5));
    assertTrue(drawStar.print(5, 0, 6));
    assertFalse(drawStar.print(5, 0, 7));
    assertFalse(drawStar.print(5, 0, 8));
    assertFalse(drawStar.print(5, 0, 9));
    assertFalse(drawStar.print(5, 0, 10));
    assertFalse(drawStar.print(5, 0, 11));
    assertFalse(drawStar.print(5, 0, 12));

    System.out.println("row====4");
    assertFalse(drawStar.print(5, 4, 0));
    assertFalse(drawStar.print(5, 4, 1));
    assertTrue( drawStar.print(5, 4, 2));
    assertFalse(drawStar.print(5, 4, 3));
    assertFalse(drawStar.print(5, 4, 4));

    System.out.println("row====1");
    assertFalse(drawStar.print(5, 1, 0));
    assertTrue( drawStar.print(5, 1, 1));
    assertTrue( drawStar.print(5, 1, 2));
    assertTrue( drawStar.print(5, 1, 3));
    assertFalse(drawStar.print(5, 1, 4));

    System.out.println("row====3");
    assertFalse(drawStar.print(5, 3, 0));
    assertTrue( drawStar.print(5, 3, 1));
    assertTrue( drawStar.print(5, 3, 2));
    assertTrue( drawStar.print(5, 3, 3));
    assertFalse(drawStar.print(5, 3, 4));

    System.out.println("row====3");
    assertFalse(drawStar.print(5, 3, 0));
    assertTrue( drawStar.print(5, 3, 1));
    assertTrue( drawStar.print(5, 3, 2));
    assertTrue( drawStar.print(5, 3, 3));
    assertFalse(drawStar.print(5, 3, 4));

  }

  @Test
  void print9Test(){

    DrawStar drawStar = new DrawStar();

    IntStream.range(0, 9).forEach(i->assertTrue(drawStar.print(9, 4, i)));

    System.out.println("row====0");
    assertFalse(drawStar.print(9, 0, 0));
    assertFalse(drawStar.print(9, 0, 1));
    assertFalse(drawStar.print(9, 0, 2));
    assertFalse(drawStar.print(9, 0, 3));
    assertTrue( drawStar.print(9, 0, 4));
    assertFalse(drawStar.print(9, 0, 5));
    assertFalse(drawStar.print(9, 0, 6));
    assertFalse(drawStar.print(9, 0, 7));
    assertFalse(drawStar.print(9, 0, 8));

    System.out.println("row====1");
    assertFalse(drawStar.print(9, 1, 0));
    assertFalse(drawStar.print(9, 1, 1));
    assertFalse(drawStar.print(9, 1, 2));
    assertTrue(drawStar.print(9, 1, 3));
    assertTrue( drawStar.print(9, 1, 4));
    assertTrue(drawStar.print(9, 1, 5));
    assertFalse(drawStar.print(9, 1, 6));
    assertFalse(drawStar.print(9, 1, 7));
    assertFalse(drawStar.print(9, 1, 8));

    System.out.println("row====2");
    assertFalse(drawStar.print(9, 2, 0));
    assertFalse(drawStar.print(9, 2, 1));
    assertTrue( drawStar.print(9, 2, 2));
    assertTrue( drawStar.print(9, 2, 3));
    assertTrue( drawStar.print(9, 2, 4));
    assertTrue( drawStar.print(9, 2, 5));
    assertTrue( drawStar.print(9, 2, 6));
    assertFalse(drawStar.print(9, 2, 7));
    assertFalse(drawStar.print(9, 2, 8));

    System.out.println("row====3");
    assertFalse(drawStar.print(9, 3, 0));
    assertTrue( drawStar.print(9, 3, 1));
    assertTrue( drawStar.print(9, 3, 2));
    assertTrue( drawStar.print(9, 3, 3));
    assertTrue( drawStar.print(9, 3, 4));
    assertTrue( drawStar.print(9, 3, 5));
    assertTrue( drawStar.print(9, 3, 6));
    assertTrue( drawStar.print(9, 3, 7));
    assertFalse(drawStar.print(9, 3, 8));

  }
}