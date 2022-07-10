package ch11_proxy.gumbal_monitoring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GumballMonitorTest {

  @Test
  void print() {

    GumballMonitor gumballMonitor = new GumballMonitor(new GumballMachine("곽지", 50));

    gumballMonitor.print();


  }
}