package ch05_singleton.legacy;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MyObjectTest {

  @Test
  void getInstance() {

    MyObject object = MyObject.getInstance();

    IntStream.range(1, 3).forEach(i -> assertSame(object, MyObject.getInstance()));
  }
}