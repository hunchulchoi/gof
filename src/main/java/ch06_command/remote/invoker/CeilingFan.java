package ch06_command.remote.invoker;

import lombok.Getter;
import lombok.ToString;

public class CeilingFan {

  public enum Speed{
    HIGH(3),MEDIUM(2),LOW(1),OFF(0);

    @Getter
    private final int speed;

    Speed(int speed){
      this.speed = speed;
    }
  }

  @Getter
  private Speed speed;
  private final String location;

  @Getter
  private Speed prevSpeed;

  public CeilingFan(String location) {
    this.location = location;
  }

  public void low(){
    this.prevSpeed = this.speed;
    this.speed = Speed.LOW;
    System.out.println(this);
  }

  public void medium(){
    this.prevSpeed = this.speed;
    this.speed = Speed.MEDIUM;
    System.out.println(this);
  }

  public void high(){
    this.prevSpeed = this.speed;
    this.speed = Speed.HIGH;
    System.out.println(this);
  }
  public void off(){
    this.prevSpeed = this.speed;
    this.speed = Speed.OFF;
    System.out.println(location + " 선풍기 off");
    System.out.println(this);
  }

  @Override
  public String toString() {
    return "CeilingFan{" +
        "prevSpeed=" + prevSpeed +
        "->" + speed +
        ", location='" + location + '\'' +
        '}';
  }
}
