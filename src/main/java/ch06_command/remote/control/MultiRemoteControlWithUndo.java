package ch06_command.remote.control;

import ch06_command.remote.command.Command;
import ch06_command.remote.command.NoCommand;

public class MultiRemoteControlWithUndo extends MultiRemoteControl{

  private Command undoCommand;

  public MultiRemoteControlWithUndo(int slotCount) {
    super(slotCount);
  }

  public void onButtonWasPressed(int slot){
    checkSlot(slot);
    if(slots[slot]!=null){
      slots[slot].onCommand().execute();
      this.undoCommand = slots[slot].offCommand();
    } else{
      Command noCommand = new NoCommand();
      noCommand.execute();
    }
  }

  public void offButtonWasPressed(int slot){
    checkSlot(slot);
    if(slots[slot]!=null){
      slots[slot].offCommand().execute();
      this.undoCommand = slots[slot].onCommand();
    }
    else new NoCommand().execute();
  }

  public void undoButtonWasPressed(){
    System.out.println("undoButtonWasPressed:" + undoCommand.getClass().getSimpleName() );
    if(this.undoCommand==null){
      new NoCommand().execute();
    }else this.undoCommand.execute();
  }
  record Commands(Command onCommand, Command offCommand){
  };
}
