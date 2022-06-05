package ch_09_01_iterrator.menu;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class LunchMenu implements Menu{

  public final int MAX_ITEMS = 6;
  private int numberOfItems = 0;

  private final MenuItem[] menuItems;

  public LunchMenu() {
    this.menuItems = new MenuItem[MAX_ITEMS];

    addItem("채식주의자용BLT", "통밀 위에 콩고기 베이컨, 상추, 토마토를 얹은 메뉴", true, 2.99);
    addItem("BLT", "통밀 위에 베이컨, 상추, 토마토를 얹은 메뉴", false, 2.99);
    addItem("오늘의 스프y", "감자 샐러드를 곁들인 오늘의 스프", false, 3.29);
    addItem("핫도그", "사워크라우트, 갖은 양념, 양파, 치즈가 곁들여진 핫도그", false, 3.05);
  }

  public void addItem(String name, String description, boolean vegetarian, double price){
    if(this.numberOfItems >= MAX_ITEMS){
      System.out.println("죄송합니다. 메뉴가 꽉 찼습니다. 더 이상 추가할 수 없습니다.");
    }else{
      menuItems[numberOfItems] = new MenuItem(name, description, vegetarian, price);
      numberOfItems+=1;
    }
  }

  @Override
  public List<MenuItem> arrayList() {
    return Arrays.asList(menuItems);
  }
}
