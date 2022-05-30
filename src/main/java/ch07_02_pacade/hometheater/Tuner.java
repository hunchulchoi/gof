package ch07_02_pacade.hometheater;

import lombok.Getter;
import lombok.Setter;

public class Tuner extends AVMachine {

  public Tuner() {
    super("튜너");
  }

  public Tuner(String name) {
    super(name);
  }

  enum AMFM{
    AM,FM;
  }

  @Getter
  private AMFM amfm;
  @Setter
  @Getter
  private double frequency;

  void setAM(){
    checkOn();
    this.amfm = AMFM.AM;
  }
  void setFM(){
    checkOn();
    this.amfm = AMFM.FM;
  }

}
