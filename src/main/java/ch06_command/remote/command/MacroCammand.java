package ch06_command.remote.command;

import ch06_command.remote.control.MultiRemoteControl;

import java.util.Arrays;

public class MacroCammand implements Command{

  private final Command[] commands;

  public MacroCammand(Command[] commands) {
    this.commands = commands;
  }

  @Override
  public void execute() {
    Arrays.stream(commands).forEach(Command::execute);
  }
}
