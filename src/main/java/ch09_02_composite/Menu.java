package ch09_02_composite;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Menu extends MenuComponent {

  private final String name;
  private final String description;
  private final List<MenuComponent> menuComponents;

  public Menu(String name, String description) {
    this.name = name;
    this.description = description;
    this.menuComponents = new ArrayList<>();
  }

  @Override
  String name() {
    return this.name;
  }

  @Override
  String description() {
    return this.description;
  }

  @Override
  void print(String prefix) {
    super.print(prefix);
    menuComponents.forEach(
        m -> {
          m.print(prefix.isBlank()?"|-- ":"   "+ prefix);
        });
  }

  @Override
  void add(MenuComponent menuComponent) {
    if (menuComponents.contains(menuComponent)){
      throw new IllegalArgumentException("이미 등록 되어 있는 메뉴입니다.");
    }
    menuComponents.add(menuComponent);
  }

  @Override
  void remove(MenuComponent menuComponent) {
    if(!menuComponents.contains(menuComponent)){
      throw new IllegalArgumentException(String.format("%s는 %s의 서브 메뉴가 아닙니다.",menuComponent.name(), this.name));
    }
    menuComponents.remove(menuComponent);
  }

  @Override
  Optional<MenuComponent> getChild(int index) {
    return Optional.ofNullable(menuComponents.get(index));
  }
}
