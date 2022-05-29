package ch06_command.remote.control;

import ch06_command.remote.command.Command;

public class SimpleRemoteControl {
  private Command slot;

  public void setCommand(Command command){
    this.slot = command;
  }
  public void buttonWasPressed(){
    slot.execute();
  }
}
