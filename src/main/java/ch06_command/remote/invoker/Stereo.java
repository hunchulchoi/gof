package ch06_command.remote.invoker;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Data
public class Stereo {

  public enum Power {ON, OFF};
  public enum Sets {Radio, CD};

  private Power power;
  private Sets sets;
  private int volume;

  public void powerToggle(){
    if(power == Power.ON) power = Power.OFF;
    else power = Power.ON;
  }
}
