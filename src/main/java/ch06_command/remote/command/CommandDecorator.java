package ch06_command.remote.command;

public class CommandDecorator implements Command{

  private Command command;

  public CommandDecorator(Command command) {
    this.command = command;
  }

  @Override
  public void execute() {
    System.out.println("command:" + command.getClass().getSimpleName());
    command.execute();
  }
}
