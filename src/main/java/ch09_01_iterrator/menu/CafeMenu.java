package ch09_01_iterrator.menu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CafeMenu implements Menu{

  private final Map<String, MenuItem> menuItems = new HashMap<>();

  public CafeMenu() {
    addItems("베지 버거와 에어 프라이", "통밀빵, 상추, 토마토, 감자 튀김이 첨가된 베지 버거", true, 3.99);
    addItems("오늘의 스프", "샐러드가 곁들여진 오늘의 스프", false, 3.69);
    addItems("부리토", "통 판코통과 살사, 구아카몰이 곁들여진 푸짐한 부리토", true, 4.29);
  }

  public void addItems(String name, String description, boolean vegetarians, double price){
    menuItems.put(name, new MenuItem(name, description, vegetarians, price));
  }

  @Override
  public List<MenuItem> arrayList() {
    return menuItems.values().stream().toList();
  }
}
