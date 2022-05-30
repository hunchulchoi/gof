package ch07_02_pacade.hometheater;

public class MachineFactory {

  Machine getMachine(String name){
    return new AVMachine(name);
  }
}
