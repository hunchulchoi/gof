package ch06_command.remote.control;

import ch06_command.remote.command.Command;

public class MultiRemoteControlDecorator extends MultiRemoteControl{

  public MultiRemoteControlDecorator(int slotCount) {
    super(slotCount);
  }

  @Override
  public void setSlot(int slot, Command onCommand, Command offCommand) {
    System.out.println("setSlot>" + slot);
    super.setSlot(slot, onCommand, offCommand);
  }

  @Override
  public void onButtonWasPressed(int slot) {
    System.out.println("onButtonWasPressed>" + slot);
    super.onButtonWasPressed(slot);
  }

  @Override
  public void offButtonWasPressed(int slot) {
    System.out.println("offButtonWasPressed>" + slot);
    super.offButtonWasPressed(slot);
  }
}
