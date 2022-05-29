package ch06_command.remote.command;

import ch06_command.remote.invoker.GarageDoor;

public class GardenDoorCloseCommand implements Command {

  private GarageDoor garageDoor;

  public GardenDoorCloseCommand(GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    this.garageDoor.close();
  }
}
