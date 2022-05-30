package ch07_02_pacade.hometheater;

import lombok.Getter;

public class PopcornPoper extends AVMachine {

  public PopcornPoper() {
    super("팝콘 기계");
  }

  public PopcornPoper(String name) {
    super(name);
  }

  @Getter
  private boolean pop;

  void pop(){
    checkOn();
    this.pop = true;
    System.out.println(this.getName() + " 팝팝팝");
  }
}
