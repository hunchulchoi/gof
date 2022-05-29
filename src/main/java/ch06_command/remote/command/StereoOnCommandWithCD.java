package ch06_command.remote.command;

import ch06_command.remote.invoker.Stereo;

public class StereoOnCommandWithCD implements Command{

  private final Stereo stereo;

  public StereoOnCommandWithCD(Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    if (stereo.getPower() == Stereo.Power.ON) System.out.println("already ON");
    else stereo.powerToggle();
    stereo.setSets(Stereo.Sets.CD);
    stereo.setVolume(11);
  }
}
