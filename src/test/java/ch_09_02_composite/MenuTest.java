package ch_09_02_composite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MenuTest {


  private MenuComponent menu;
  private MenuComponent menuChild1;
  private MenuComponent menuChild2;
  private MenuComponent menuChild3;

  private MenuComponent menuItem1;
  private MenuComponent menuItem2;
  private MenuComponent menuItem3;
  private MenuComponent menuItem4;

  @BeforeEach
  void setUp() {
    menu = new Menu("메뉴", "메뉴입니다.");
    menuChild1 = new Menu("자식 메뉴", "자식메뉴1 입니다.");
    menuChild2 = new Menu("자식 메뉴2", "자식메뉴2 입니다.");
    menuChild3 = new Menu("자식 메뉴3", "자식메뉴3 입니다.");


    menuItem1 = new MenuItem("Leaf1", "나는 자식이 없어요", 3.39, true);
    menuItem2 = new MenuItem("Leaf2", "나는 자식이 없어요", 4.39, false);
    menuItem3 = new MenuItem("Leaf3", "나는 자식이 없어요", 5.39, false);
    menuItem4 = new MenuItem("Leaf4", "나는 자식이 없어요", 2.39, true);
  }

  @Test
  void 중복등록_테스트(){
    menu.add(menuChild1);
    assertThrows(IllegalArgumentException.class, ()->menu.add(menuChild1));
  }

  @Test
  void print(){
    menu.add(menuChild1);
    menuChild1.add(menuItem1);

    menu.add(menuChild2);
    menuChild2.add(menuChild3);
    menuChild2.add(menuItem3);
    menuChild3.add(menuItem2);
    menuChild3.add(menuItem4);

    menu.add(menuItem4);

    menu.print();
  }

  @Test
  void add() {
    menu.add(menuChild1);
    menu.add(menuItem1);

    menu.print();

    assertSame(menuChild1, menu.getChild(0).get());
    assertSame(menuItem1, menu.getChild(1).get());
  }

  @Test
  void remove() {
    assertThrows(IllegalArgumentException.class, ()->menu.remove(menuItem1));

    menu.add(menuChild1);
    menu.add(menuChild2);

    assertSame(menuChild1, menu.getChild(0).get());

    menu.remove(menuChild1);
    assertSame(menuChild2, menu.getChild(0).get());

    assertThrows(IndexOutOfBoundsException.class, ()->menu.getChild(1));

  }

  @Test
  void getChild() {
    menu.add(menuChild1);
    menu.add(menuChild2);
    assertSame(menuChild1, menu.getChild(0).get());
    assertSame(menuChild2, menu.getChild(1).get());

    assertThrows(IndexOutOfBoundsException.class, ()->menu.getChild(2));
    assertThrows(IndexOutOfBoundsException.class, ()->menuChild2.getChild(0));
  }
}