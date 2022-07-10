package ch09_02_composite;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuItemTest {

  MenuItem menuItem = new MenuItem("제품명", "제품설명",  2.89, true);
  MenuItem menuItemChild = new MenuItem("제품명1", "제품설명1",  2.88, false);

  @Test
  void add() {
    assertThrows(UnsupportedOperationException.class, ()->menuItem.add(menuItemChild));
  }

  @Test
  void remove() {
    assertThrows(UnsupportedOperationException.class, ()->menuItem.remove(menuItemChild));
  }

  @Test
  void getChild() {
    assertThrows(UnsupportedOperationException.class, ()->menuItem.getChild(0));
  }
}