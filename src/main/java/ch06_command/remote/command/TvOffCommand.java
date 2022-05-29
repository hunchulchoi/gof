package ch06_command.remote.command;

import ch06_command.remote.invoker.Tv;

public class TvOffCommand implements Command{
  private Tv tv;

  public TvOffCommand(Tv tv) {
    this.tv = tv;
  }

  @Override
  public void execute() {
    if (tv.getStatus() == Tv.Status.OFF) System.out.println("already Off");
    else tv.toggle();
  }
}
