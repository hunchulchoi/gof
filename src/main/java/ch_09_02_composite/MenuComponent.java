package ch_09_02_composite;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

public abstract class MenuComponent {

  String name(){
    throw new UnsupportedOperationException();
  }
  String description(){
    throw new UnsupportedOperationException();
  }
  Optional<Double> price(){
    return Optional.empty();
  }
  boolean vegetarian(){
    return false;
  }

  void print() {
    print("");
  }

  void print(String prefix) {
    System.out.printf("%s%s%s %s -- %s%n", prefix, name(), vegetarian()?"(v)":"", price().map(String::valueOf).orElseGet(()->""), description());
  }

  void add(MenuComponent menuComponent){
    throw new UnsupportedOperationException("서브 메뉴가 없는 메뉴입니다.");
  }
  void remove(MenuComponent menuComponent){
    throw new UnsupportedOperationException("삭제 할 수 없습니다.");
  }
  Optional<MenuComponent> getChild(int index){
    throw new UnsupportedOperationException("서브 메뉴가 없는 메뉴입니다.");
  }

}
