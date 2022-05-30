package ch07_02_pacade.hometheater;

import lombok.Getter;
import lombok.Setter;

public class Projector extends AVMachine {
  @Getter
  @Setter
  private Player player;

  enum MODE{
    TV_MODE,WIDE_SCREEN_MODE
  }

  public Projector() {
    super("프로젝터");
  }

  public Projector(String name) {
    super(name);
  }

  @Getter
  private MODE mode;

  void tvMode(){
    checkOn();
    this.mode = MODE.TV_MODE;
    System.out.println(this.getName() + " " + this.mode);
  }

  void wideScreenMode(){
    checkOn();
    this.mode = MODE.WIDE_SCREEN_MODE;
    System.out.println(this.getName() + " " + this.mode);
  }
}
