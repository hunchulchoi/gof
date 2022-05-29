package ch06_command.remote.invoker;

import ch06_command.order.Server;
import lombok.Getter;

public class GarageDoor {

  public enum Status {
    OPEN, CLOSED
  }

  @Getter
  private Status status;

  public void open(){
    this.status = Status.OPEN;
    System.out.println(this.status);
  }

  public void close(){
    this.status = Status.CLOSED;
    System.out.println(this.status);
  }

}
