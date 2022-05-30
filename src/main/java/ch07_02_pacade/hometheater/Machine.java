package ch07_02_pacade.hometheater;

public interface Machine {
  void on();

  void off();

  void checkOn();

  String getName();

  boolean isOn();
}
