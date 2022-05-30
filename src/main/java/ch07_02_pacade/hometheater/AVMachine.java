package ch07_02_pacade.hometheater;

import lombok.Getter;

public class AVMachine implements Machine {

  @Getter
  protected final String name;

  public AVMachine(String name) {
    this.name = name;
  }

  @Getter
  protected boolean on;

  @Override
  public void on(){
    this.on =true;
    System.out.println(this.getName() + " Turn On");
  }
  @Override
  public void off(){
    this.on = false;
    System.out.println(this.getName() + " Turn off");
  }

  @Override
  public void checkOn(){
    if(!this.on) throw new IllegalStateException(this.name + "이 꺼져 있습니다.");
  }
}
