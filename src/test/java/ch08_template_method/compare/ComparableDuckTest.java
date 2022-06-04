package ch08_template_method.compare;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class ComparableDuckTest {

  @Test
  void compareTo() {

    ComparableDuck daffy = new ComparableDuck("Daffy", 7);
    ComparableDuck dewey = new ComparableDuck("Dewey", 2);
    ComparableDuck howard = new ComparableDuck("Howard", 7);
    ComparableDuck louie = new ComparableDuck("Louie", 2);
    ComparableDuck donald = new ComparableDuck("Donald", 10);
    ComparableDuck huey = new ComparableDuck("Huey", 2);
    ComparableDuck[] ducks = {daffy, dewey, howard, louie, donald, huey,};

    System.out.println("정렬전");
    System.out.println(Arrays.stream(ducks).map(ComparableDuck::toString).collect(Collectors.joining(",")));

    Arrays.sort(ducks);

    System.out.println("정렬후");
    System.out.println(Arrays.stream(ducks).map(ComparableDuck::toString).collect(Collectors.joining(",")));

    assertArrayEquals(new ComparableDuck[]{dewey, huey, louie, daffy, howard, donald}, ducks);
  }
}