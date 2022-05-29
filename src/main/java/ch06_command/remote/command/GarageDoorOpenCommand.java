package ch06_command.remote.command;

import ch06_command.remote.command.Command;
import ch06_command.remote.invoker.GarageDoor;

public class GarageDoorOpenCommand implements Command {

  public GarageDoorOpenCommand(GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  private GarageDoor garageDoor;
  @Override
  public void execute() {
    garageDoor.open();
  }
}
