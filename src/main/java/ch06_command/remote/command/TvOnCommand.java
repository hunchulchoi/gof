package ch06_command.remote.command;

import ch06_command.remote.invoker.Tv;

public class TvOnCommand implements Command{
  private Tv tv;

  public TvOnCommand(Tv tv) {
    this.tv = tv;
  }

  @Override
  public void execute() {
    if (tv.getStatus() == Tv.Status.ON) System.out.println("already On");
    else tv.toggle();
  }
}
