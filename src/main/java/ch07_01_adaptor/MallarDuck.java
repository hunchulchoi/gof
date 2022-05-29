package ch07_01_adaptor;

public class MallarDuck implements Duck{
  @Override
  public void quack() {
    System.out.println("꽥꽥");
  }

  @Override
  public void fly() {
    System.out.println("멀리 납니다.");
  }
}
