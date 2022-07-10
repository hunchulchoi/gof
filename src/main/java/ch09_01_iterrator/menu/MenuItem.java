package ch09_01_iterrator.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class MenuItem {

  private String name;
  private String description;
  private boolean vegetarian;
  private double price;

}
