package ch11_proxy.gumbal_monitoring;

public class GumballMonitor {

  private final GumballMachine gumballMachine;

  public GumballMonitor(GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  public void print(){
    System.out.println(gumballMachine);
  }


}
