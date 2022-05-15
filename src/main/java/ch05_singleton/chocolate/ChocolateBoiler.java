package ch05_singleton.chocolate;

import lombok.Getter;

public class ChocolateBoiler {

  @Getter
  private boolean empty;
  @Getter
  private boolean boiled;

  private volatile static ChocolateBoiler chocolateBoiler;

  private ChocolateBoiler() {
    empty = true;
    boiled = false;
  }

  public static ChocolateBoiler getInstance(){
    if(chocolateBoiler==null){
      chocolateBoiler = new ChocolateBoiler();
      System.out.println(chocolateBoiler.hashCode());
    }
    return chocolateBoiler;
  }

  public void fill(){
    if(isEmpty()){
      empty = false;
      boiled = false;
    }
  }
  public void drain(){
    if(!isEmpty() && isBoiled()){
      empty = true;
    }
  }
  public void boil(){
    if(!isEmpty() && !isBoiled()){
      boiled = true;
    }
  }

  @Override
  public String toString() {
    return "ChocolateBoiler{" +
        "empty=" + empty +
        ", boiled=" + boiled +
        '}';
  }
}
