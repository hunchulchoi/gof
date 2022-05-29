package ch07_01_adaptor.enums;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IteratorEnumerationTest {

  private IteratorEnumeration iteratorEnumeration;

  @BeforeEach
  void setUp() {
    iteratorEnumeration = new IteratorEnumeration(List.of(1, 2, 4).iterator());
  }

  @Test
  void hasMoreElements() {

    assertTrue(iteratorEnumeration.hasMoreElements());
    iteratorEnumeration.nextElement();
    assertTrue(iteratorEnumeration.hasMoreElements());
    iteratorEnumeration.nextElement();
    assertTrue(iteratorEnumeration.hasMoreElements());
    assertTrue(iteratorEnumeration.hasMoreElements());
    iteratorEnumeration.nextElement();
    assertFalse(iteratorEnumeration.hasMoreElements());

  }

  @Test
  void nextElement() {
    assertEquals(1, iteratorEnumeration.nextElement());
    assertEquals(2, iteratorEnumeration.nextElement());
    assertEquals(4, iteratorEnumeration.nextElement());
    assertThrows(NoSuchElementException.class, ()->iteratorEnumeration.nextElement());
  }
}