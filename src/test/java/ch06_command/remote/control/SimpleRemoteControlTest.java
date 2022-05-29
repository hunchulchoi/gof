package ch06_command.remote.control;

import ch06_command.remote.command.GarageDoorOpenCommand;
import ch06_command.remote.command.LightOnCommand;
import ch06_command.remote.invoker.GarageDoor;
import ch06_command.remote.invoker.Light;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleRemoteControlTest {

  @Test
  void buttonWasPressed() {

    SimpleRemoteControl remoteControl = new SimpleRemoteControl();
    Light light = new Light();
    remoteControl.setCommand(new LightOnCommand(light));
    remoteControl.buttonWasPressed();

    GarageDoor garageDoor = new GarageDoor();
    remoteControl.setCommand(new GarageDoorOpenCommand(garageDoor));
    remoteControl.buttonWasPressed();
  }
}