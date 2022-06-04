package ch08_template_method;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStringListTest {

  @Test
  void set() {

    MyStringList strings = new MyStringList(new String[]{"최훈철", "문", "최강욱"});

    System.out.println(strings);

    strings.set(2, "문문문문");

    assertEquals("문문문문", strings.get(2));
  }
}