package ch07_02_pacade.hometheater;

import lombok.Data;
import lombok.Setter;

@Data
public class StreamingPlayer extends AVMachine implements Player {

  public StreamingPlayer() {
    super("스트리밍 플레이어");
  }

  public StreamingPlayer(String name) {
    super(name);
  }

  private PLAY play;

  @Setter
  private Amplifer amplifer;

  @Override
  public void pause(){
    checkOn();
    this.play = PLAY.PAUSE;
    System.out.println(this.getName() + ": " + this.play);
  }

  @Override
  public void play(){
    checkOn();
    this.play = PLAY.PLAY;
    System.out.println(this.getName() + ": " + this.play);
  }

  void setSurroundAudio(){
    checkOn();
    this.amplifer.setSurroundSound();
  }

  public void setTowChannelAudio(){
    checkOn();
    this.amplifer.setStereoSound();
  }

  @Override
  public void stop(){
    checkOn();
    this.play = PLAY.STOP;
    System.out.println(this.getName() + ": " + this.play);
  }
}
