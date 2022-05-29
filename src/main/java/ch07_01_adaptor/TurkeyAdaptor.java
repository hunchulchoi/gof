package ch07_01_adaptor;

import java.util.stream.IntStream;

public class TurkeyAdaptor implements Duck{

  private final Turkey turkey;

  public TurkeyAdaptor(Turkey turkey) {
    this.turkey = turkey;
  }

  @Override
  public void quack() {
    turkey.gobble();
  }

  @Override
  public void fly() {
    IntStream.range(0, 5).forEach(i->turkey.fly());
  }
}
