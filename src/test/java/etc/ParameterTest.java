package etc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParameterTest {

  @Test
  void cbv(){
    String s = "a1";

    String s2 = addString(s);

    assertEquals("a1", s);
    assertEquals("a1a2", s2);

  }

  String addString(String s){

    s += "a2";

    return s;
  }

  @Test
  void cbr(){

    List<String> list = new ArrayList<>(Arrays.asList("a1", "a2"));

    System.out.println(list.stream().collect(Collectors.joining(",")));
    add(list);

    System.out.println(list.stream().collect(Collectors.joining(",")));

    assertEquals(3, list.size());
    assertEquals("a1", list.get(0));
    assertEquals("a2", list.get(1));
    assertEquals("b2", list.get(2));

  }

  void add(List<String> list){
    list.add("b2");
  }

  @Test
  void cbvW(){
    Long l = 1_000L;

    Long l2 = add(l);

    assertEquals(1_000L, l);
    assertEquals(1_010L, l2);

  }

  Long add(Long l){
    l = Long.sum(l, 10);

    System.out.println(l);

    return l;
  }
}
