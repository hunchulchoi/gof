package ch06_command.remote.invoker;

import lombok.Getter;

public class Light {

  public enum Status{ON,OFF};

  @Getter
  private Status status;

  public void on(){
    this.status = Status.ON;
    System.out.println(this.status);
  }

  public void off(){
    this.status = Status.OFF;
    System.out.println(this.status);
  }

}
