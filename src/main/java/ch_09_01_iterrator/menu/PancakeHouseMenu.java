package ch_09_01_iterrator.menu;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PancakeHouseMenu implements Menu {

  private final List<MenuItem> menuItems;

  public PancakeHouseMenu() {
    menuItems = new ArrayList<>();

    addItem("K&B 팬케이크 세트", "스크램블 에그와 토스트가 어우러진 팬케이크", true, 2.99);
    addItem("레귤러 팬케이크 세트", "달걀 프라이와 소시지가 곁들여진 팬케이크", false, 2.99);
    addItem("블루베리 팬케이크 세트", "신선한 블루베리와 블루베리 시럽으로 만든 팬케이크", true, 3.49);
    addItem("와플", "취향에 따라 블루베리나 딸리를 얹을수 있는 와플", true, 3.59);
  }

  public void addItem(String name, String description, boolean vegetarian, double price){
    menuItems.add(new MenuItem(name, description, vegetarian, price));
  }


  @Override
  public List<MenuItem> arrayList() {
    return menuItems;
  }
}
