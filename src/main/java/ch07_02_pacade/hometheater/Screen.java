package ch07_02_pacade.hometheater;

import lombok.Getter;

public class Screen {

  enum SCREEN_STATUS{
    UP,DOWN
  }

  @Getter
  private SCREEN_STATUS screenStatus;

  void up(){
    this.screenStatus = SCREEN_STATUS.UP;
  }

  void down(){
    this.screenStatus = SCREEN_STATUS.DOWN;
  }

}
