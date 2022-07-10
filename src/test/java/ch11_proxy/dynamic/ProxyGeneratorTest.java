package ch11_proxy.dynamic;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ProxyGeneratorTest {

  Person kim = new PersonImpl("munmun", "woman", "cook, draw picture, take a photo");
  Person choi = new PersonImpl("choi", "man", "develope, guitar");


  @Test
  void notNullTest(){
    assertThrows(NullPointerException.class, ()->ProxyGenerator.getProxy(kim, null));
    assertThrows(NullPointerException.class, ()->ProxyGenerator.getProxy(null, kim.getName()));
  }

  @Test
  void 본인_프록시_테스트(){
    Person kimOp = ProxyGenerator.getProxy(kim, kim.getName());

    assertNotNull(kimOp);
    assertEquals("munmun", kimOp.getName());

    kimOp.setInterests("사진찍기");

    assertThrows(Exception.class, ()->kimOp.setGeekRating(10));
  }

  @Test
  void 다른사람_프록시_테스트(){
    Person choiNoP = ProxyGenerator.getProxy(choi, kim.getName());

    assertNotNull(choiNoP);
    assertEquals("choi", choiNoP.getName());

    choiNoP.setGeekRating(10);
    choiNoP.setGeekRating(5);
    choiNoP.setGeekRating(3);

    System.out.println(choiNoP.getGeekRating());
    System.out.println(choi);

    assertThrows(Exception.class, ()->choiNoP.setInterests("사진찍기"));
  }

}