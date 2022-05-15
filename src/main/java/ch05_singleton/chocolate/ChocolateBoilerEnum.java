package ch05_singleton.chocolate;

import lombok.Getter;

public enum ChocolateBoilerEnum {

  UniqueInstance;

  @Getter
  private boolean empty = false;
  @Getter
  private boolean boiled = false;

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
}
