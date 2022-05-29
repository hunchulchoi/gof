package ch06_command.remote.invoker;

import lombok.Getter;

public class Tv {

  public enum Status{
    ON, OFF
  }
  @Getter
  private Status status;

  public void toggle(){
    if(this.status == Status.ON) this.status = Status.OFF;
    else this.status = Status.ON;

    System.out.println(this.status);
  }

}
