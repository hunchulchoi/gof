package ch07_02_pacade.hometheater;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
public class Amplifer extends AVMachine {

  enum SOUND_MODE{
    SURROUND_MODE, STEREO_MODE
  }

  @Setter
  @Getter
  private Tuner tuner;

  @Getter
  private Player player;

  public void setPlayer(Player player) {
    this.player = player;
    //player.setAmplifer(this);
  }

  private SOUND_MODE soundMode;

  @Setter
  private short volume;

  public Amplifer() {

    super("앰프");
  }

  public Amplifer(String name) {
    super(name);
  }

  void setSurroundSound(){
    checkOn();
    this.soundMode = SOUND_MODE.SURROUND_MODE;
    System.out.println("setSurroundSound:" + this.soundMode);
  }

  void setStereoSound(){
    checkOn();
    this.soundMode = SOUND_MODE.STEREO_MODE;
    System.out.println("setStereoSound:" + this.soundMode);
  }

}
