package ch06_command.remote.command;

import ch06_command.remote.invoker.Light;

public class LightOffCommand implements Command{
  private Light light;

  public LightOffCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    this.light.off();
  }
}
