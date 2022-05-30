package ch07_02_pacade.hometheater;

public interface Player {

  void on();
  void off();

  boolean isOn();

  void pause();

  void play();

  void stop();

  void setAmplifer(Amplifer amplifer);

  PLAY getPlay();

  public enum PLAY {
    PLAY, PAUSE, STOP
  }
}
