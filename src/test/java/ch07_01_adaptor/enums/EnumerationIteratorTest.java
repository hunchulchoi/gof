package ch07_01_adaptor.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class EnumerationIteratorTest {

  private EnumerationIterator enumerationIterator;

  @BeforeEach
  void setUp() {

    Enumeration<Integer> enumeration =
        new Enumeration<Integer>() {

          private Integer[] integers = new Integer[] {1};

          private int current = -1;

          @Override
          public boolean hasMoreElements() {
            System.out.println(current + ":" + integers.length + "=" + (current+1 <= integers.length - 1));
            return current+1 <= integers.length - 1;
          }

          @Override
          public Integer nextElement() {

            if (!hasMoreElements()) throw new IndexOutOfBoundsException("no more elements");
            current += 1;
            return integers[current];
          }
        };

    enumerationIterator = new EnumerationIterator(enumeration);
  }

  @Test
  void hasNext() {
    assertTrue(enumerationIterator.hasNext());
    System.out.println(enumerationIterator.next());
    //assertTrue(enumerationIterator.hasNext());
    //assertTrue(enumerationIterator.hasNext());
    assertFalse(enumerationIterator.hasNext());
    assertFalse(enumerationIterator.hasNext());
  }

  @Test
  void next() {
    assertEquals(1, enumerationIterator.next());
    //assertEquals(2, enumerationIterator.next());
    //assertEquals(4, enumerationIterator.next());
    assertThrows(IndexOutOfBoundsException.class, ()-> enumerationIterator.next());
  }

  @Test
  void remove() {
    assertThrows(UnsupportedOperationException.class, ()-> enumerationIterator.remove());
  }

  @Test
  void test(){

  }
}