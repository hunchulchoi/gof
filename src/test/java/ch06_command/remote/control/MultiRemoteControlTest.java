package ch06_command.remote.control;

import ch06_command.remote.command.*;
import ch06_command.remote.invoker.*;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class MultiRemoteControlTest {

  @Test
  void 리모콘테스트(){

    MultiRemoteControl remoteControl = new MultiRemoteControlDecorator(4);

    Light light = new Light();

    Command lightOnCommand = new CommandDecorator(new LightOnCommand(light));
    Command lightOffCommand = new CommandDecorator(new LightOffCommand(light));

    remoteControl.setSlot(0, lightOnCommand, lightOffCommand);

    GarageDoor garageDoor = new GarageDoor();
    remoteControl.setSlot(1, new GarageDoorOpenCommand(garageDoor), new GardenDoorCloseCommand(garageDoor));

    Tv tv = new Tv();
    remoteControl.setSlot(2, new TvOnCommand(tv), new TvOffCommand(tv));

    Stereo stereo = new Stereo();
    remoteControl.setSlot(3, new CommandDecorator(new StereoOnCommandWithCD(stereo)), new CommandDecorator(new StereoOffCommand(stereo)));

    remoteControl.onButtonWasPressed(0);
    assertEquals(Light.Status.ON, light.getStatus());

    remoteControl.offButtonWasPressed(0);
    assertEquals(Light.Status.OFF, light.getStatus());
    remoteControl.offButtonWasPressed(0);
    assertEquals(Light.Status.OFF, light.getStatus());

    remoteControl.onButtonWasPressed(1);
    assertEquals(GarageDoor.Status.OPEN, garageDoor.getStatus());
    remoteControl.onButtonWasPressed(1);
    assertEquals(GarageDoor.Status.OPEN, garageDoor.getStatus());

    remoteControl.offButtonWasPressed(1);
    assertEquals(GarageDoor.Status.CLOSED, garageDoor.getStatus());

    remoteControl.onButtonWasPressed(2);
    assertEquals(Tv.Status.ON, tv.getStatus());

    remoteControl.onButtonWasPressed(2);
    assertEquals(Tv.Status.ON, tv.getStatus());

    remoteControl.offButtonWasPressed(2);
    assertEquals(Tv.Status.OFF, tv.getStatus());

    remoteControl.onButtonWasPressed(3);
    assertEquals(Stereo.Power.ON, stereo.getPower());
    assertEquals(Stereo.Sets.CD, stereo.getSets());
    assertEquals(11, stereo.getVolume());

    System.out.println(stereo);

    remoteControl.offButtonWasPressed(3);
    assertEquals(Stereo.Power.OFF, stereo.getPower());

    System.out.println(stereo);
  }

  @Test
  void exceptTest(){

    MultiRemoteControl multiRemoteControl = new MultiRemoteControl(1);
    assertThrows(UnsupportedOperationException.class, ()->multiRemoteControl.setSlot(2, new NoCommand(), new NoCommand()));
  }

  @Test
  void noCommandTest(){
    MultiRemoteControl multiRemoteControl = new MultiRemoteControl(2);
    IntStream.range(0, 2).forEach(i->{
      multiRemoteControl.onButtonWasPressed(i);
      multiRemoteControl.offButtonWasPressed(i);
    });
  }

  @Test
  void 리모콘테스트_람다(){

    MultiRemoteControl remoteControl = new MultiRemoteControlDecorator(4);

    Light light = new Light();


    remoteControl.setSlot(0, light::on, light::off);

    GarageDoor garageDoor = new GarageDoor();
    remoteControl.setSlot(1, garageDoor::open, garageDoor::close);

    Tv tv = new Tv();
    remoteControl.setSlot(2, new TvOnCommand(tv), new TvOffCommand(tv));

    Stereo stereo = new Stereo();
    remoteControl.setSlot(3, new CommandDecorator(new StereoOnCommandWithCD(stereo)), new CommandDecorator(new StereoOffCommand(stereo)));

    remoteControl.onButtonWasPressed(0);
    assertEquals(Light.Status.ON, light.getStatus());

    remoteControl.offButtonWasPressed(0);
    assertEquals(Light.Status.OFF, light.getStatus());
    remoteControl.offButtonWasPressed(0);
    assertEquals(Light.Status.OFF, light.getStatus());

    remoteControl.onButtonWasPressed(1);
    assertEquals(GarageDoor.Status.OPEN, garageDoor.getStatus());
    remoteControl.onButtonWasPressed(1);
    assertEquals(GarageDoor.Status.OPEN, garageDoor.getStatus());

    remoteControl.offButtonWasPressed(1);
    assertEquals(GarageDoor.Status.CLOSED, garageDoor.getStatus());

    remoteControl.onButtonWasPressed(2);
    assertEquals(Tv.Status.ON, tv.getStatus());

    remoteControl.onButtonWasPressed(2);
    assertEquals(Tv.Status.ON, tv.getStatus());

    remoteControl.offButtonWasPressed(2);
    assertEquals(Tv.Status.OFF, tv.getStatus());

    remoteControl.onButtonWasPressed(3);
    assertEquals(Stereo.Power.ON, stereo.getPower());
    assertEquals(Stereo.Sets.CD, stereo.getSets());
    assertEquals(11, stereo.getVolume());

    System.out.println(stereo);

    remoteControl.offButtonWasPressed(3);
    assertEquals(Stereo.Power.OFF, stereo.getPower());

    System.out.println(stereo);
  }


  @Test
  void 리모콘_Undo테스트(){

    // given
    MultiRemoteControlWithUndo remoteControl = new MultiRemoteControlWithUndo(4);

    Light light = new Light();

    remoteControl.setSlot(0, light::on, light::off);

    GarageDoor garageDoor = new GarageDoor();
    remoteControl.setSlot(1, garageDoor::open, garageDoor::close);

    Tv tv = new Tv();
    remoteControl.setSlot(2, new TvOnCommand(tv), new TvOffCommand(tv));

    Stereo stereo = new Stereo();
    remoteControl.setSlot(3, new CommandDecorator(new StereoOnCommandWithCD(stereo)), new CommandDecorator(new StereoOffCommand(stereo)));

    // when
    remoteControl.onButtonWasPressed(0);
    assertEquals(Light.Status.ON, light.getStatus());

    remoteControl.undoButtonWasPressed();
    assertEquals(Light.Status.OFF, light.getStatus());

    remoteControl.offButtonWasPressed(0);
    assertEquals(Light.Status.OFF, light.getStatus());
    remoteControl.offButtonWasPressed(0);
    assertEquals(Light.Status.OFF, light.getStatus());

    remoteControl.undoButtonWasPressed();
    assertEquals(Light.Status.ON, light.getStatus());

    remoteControl.onButtonWasPressed(1);
    assertEquals(GarageDoor.Status.OPEN, garageDoor.getStatus());
    remoteControl.onButtonWasPressed(1);
    assertEquals(GarageDoor.Status.OPEN, garageDoor.getStatus());

    remoteControl.offButtonWasPressed(1);
    assertEquals(GarageDoor.Status.CLOSED, garageDoor.getStatus());

    remoteControl.onButtonWasPressed(2);
    assertEquals(Tv.Status.ON, tv.getStatus());

    remoteControl.onButtonWasPressed(2);
    assertEquals(Tv.Status.ON, tv.getStatus());

    remoteControl.undoButtonWasPressed();
    assertEquals(Tv.Status.OFF, tv.getStatus());

    remoteControl.offButtonWasPressed(2);
    assertEquals(Tv.Status.OFF, tv.getStatus());

    remoteControl.undoButtonWasPressed();
    assertEquals(Tv.Status.ON, tv.getStatus());

    remoteControl.onButtonWasPressed(3);
    assertEquals(Stereo.Power.ON, stereo.getPower());
    assertEquals(Stereo.Sets.CD, stereo.getSets());
    assertEquals(11, stereo.getVolume());

    System.out.println(stereo);

    remoteControl.offButtonWasPressed(3);
    assertEquals(Stereo.Power.OFF, stereo.getPower());

    System.out.println(stereo);
  }

  @Test
  void 선풍기_리모콘_테스트(){

    CeilingFan ceilingFan = new CeilingFan("안방 ");

    MultiRemoteControlWithUndo remoteControlWithUndo = new MultiRemoteControlWithUndo(3){
      @Override
      public void undoButtonWasPressed() {
        System.out.println("undoButtonWasPressed");
        switch (ceilingFan.getPrevSpeed()){
          case LOW -> ceilingFan.low();
          case MEDIUM ->  ceilingFan.medium();
          case HIGH -> ceilingFan.high();
          default -> ceilingFan.off();
        }
      }
    };

    remoteControlWithUndo.setSlot(0, ceilingFan::high, ceilingFan::off);
    remoteControlWithUndo.setSlot(1, ceilingFan::medium, ceilingFan::off);
    remoteControlWithUndo.setSlot(2, ceilingFan::low, ceilingFan::off);

    remoteControlWithUndo.onButtonWasPressed(0);
    assertEquals(CeilingFan.Speed.HIGH, ceilingFan.getSpeed());

    remoteControlWithUndo.onButtonWasPressed(1);
    assertEquals(CeilingFan.Speed.MEDIUM, ceilingFan.getSpeed());

    remoteControlWithUndo.undoButtonWasPressed();
    assertEquals(CeilingFan.Speed.HIGH, ceilingFan.getSpeed());

    remoteControlWithUndo.offButtonWasPressed(1);
    assertEquals(CeilingFan.Speed.OFF, ceilingFan.getSpeed());

    remoteControlWithUndo.onButtonWasPressed(2);
    assertEquals(CeilingFan.Speed.LOW, ceilingFan.getSpeed());

    remoteControlWithUndo.onButtonWasPressed(1);
    assertEquals(CeilingFan.Speed.MEDIUM, ceilingFan.getSpeed());

    remoteControlWithUndo.undoButtonWasPressed();
    assertEquals(CeilingFan.Speed.LOW, ceilingFan.getSpeed());

    remoteControlWithUndo.offButtonWasPressed(2);
    assertEquals(CeilingFan.Speed.OFF, ceilingFan.getSpeed());

  }

  @Test
  void 매크로_커맨드_테스트(){
    MultiRemoteControlWithUndo multiRemoteControl = new MultiRemoteControlWithUndo(1);

    Light light = new Light();
    GarageDoor garageDoor = new GarageDoor();
    CeilingFan ceilingFan = new CeilingFan("마루");

    Command[] commands = new Command[]{light::on, garageDoor::open, ceilingFan::medium};
    Command[] offCommands = new Command[]{light::off, garageDoor::close, ceilingFan::off};

    multiRemoteControl.setSlot(0, new MacroCammand(commands), new MacroCammand(offCommands));

    multiRemoteControl.onButtonWasPressed(0);

    assertEquals(Light.Status.ON ,light.getStatus());
    assertEquals(GarageDoor.Status.OPEN ,garageDoor.getStatus());
    assertEquals(CeilingFan.Speed.MEDIUM ,ceilingFan.getSpeed());

    multiRemoteControl.offButtonWasPressed(0);

    assertEquals(Light.Status.OFF ,light.getStatus());
    assertEquals(GarageDoor.Status.CLOSED ,garageDoor.getStatus());
    assertEquals(CeilingFan.Speed.OFF ,ceilingFan.getSpeed());

    multiRemoteControl.undoButtonWasPressed();

    assertEquals(Light.Status.ON ,light.getStatus());
    assertEquals(GarageDoor.Status.OPEN ,garageDoor.getStatus());
    assertEquals(CeilingFan.Speed.MEDIUM ,ceilingFan.getSpeed());

  }

}