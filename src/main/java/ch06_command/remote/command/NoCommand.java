package ch06_command.remote.command;

public class NoCommand implements Command{

  @Override
  public void execute() {
    System.out.println("No Command Here");
  }
}
