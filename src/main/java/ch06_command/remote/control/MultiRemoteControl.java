package ch06_command.remote.control;

import ch06_command.remote.command.Command;
import ch06_command.remote.command.MacroCammand;
import ch06_command.remote.command.NoCommand;

public class MultiRemoteControl {

  protected final Commands[] slots;

  public MultiRemoteControl(int slotCount) {
    slots = new Commands[slotCount];
  }

  public void setSlot(int slot, Command onCommand, Command offCommand){
    checkSlot(slot);
    slots[slot] = new Commands(onCommand, offCommand);
  }

  protected void checkSlot(int slot) {
    if(slot > slots.length-1) throw new UnsupportedOperationException("slot 최대 수는 " + slots.length);
  }

  public void onButtonWasPressed(int slot){
    checkSlot(slot);
    if(slots[slot]!=null) slots[slot].onCommand().execute();
    else new NoCommand().execute();
  }

  public void offButtonWasPressed(int slot){
    checkSlot(slot);
    if(slots[slot]!=null) slots[slot].offCommand().execute();
    else new NoCommand().execute();
  }

  public record Commands(Command onCommand, Command offCommand){
  };
}
