package ch06_command.remote.command;

import ch06_command.remote.invoker.Stereo;

public class StereoOffCommand implements Command{

  private Stereo stereo;

  public StereoOffCommand(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    if (stereo.getPower() == Stereo.Power.OFF) System.out.println("Already Off");
    else stereo.powerToggle();
  }
}
