package ch_09_01_iterrator.menu;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ServingWorker {
  private final List<MenuItem> pancakeHouseMenu;
  private final List<MenuItem> lunchMenu;
  private final List<MenuItem> dinnerMenu;

  public void printMenu(){

    System.out.println();
    System.out.println("--------------    아침 메뉴    --------------");
    print(pancakeHouseMenu);

    System.out.println();
    System.out.println("--------------    점심 메뉴    --------------");
    print(lunchMenu);

    System.out.println();
    System.out.println("--------------    저녁 메뉴    --------------");
    print(dinnerMenu);

  }

  public void printBreakfastMenu(){

  }

  public void printLunchMenu(){

  }

  public void printVegetarianMenu(){
    System.out.println();
    System.out.println("--------------    아침 채식 메뉴    --------------");
    print(pancakeHouseMenu.stream().filter(MenuItem::isVegetarian).collect(Collectors.toList()));
    System.out.println();
    System.out.println("--------------    점심 채식 메뉴    --------------");
    print(lunchMenu.stream().filter(Objects::nonNull).filter(MenuItem::isVegetarian).collect(Collectors.toList()));

    System.out.println();
    System.out.println("--------------    저녁 채식 메뉴    --------------");
    print(dinnerMenu.stream().filter(Objects::nonNull).filter(MenuItem::isVegetarian).collect(Collectors.toList()));
  }

  public void isItemVegetarianMenu(MenuItem menuItem){
    if(menuItem.isVegetarian()){
      System.out.println("채식 매뉴입니다.");
    }

    System.out.println("채식 메뉴가 아닙니다.");
  }

  public void print(List<MenuItem> menuItems){

    for (MenuItem menuItem : menuItems) {
      if(menuItem==null) continue;
      System.out.printf("%s %.2f -- %s%n", menuItem.getName(), menuItem.getPrice(), menuItem.getDescription());
    }
  }
}
