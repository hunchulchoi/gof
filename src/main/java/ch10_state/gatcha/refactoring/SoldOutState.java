package ch10_state.gatcha.refactoring;

public class SoldOutState extends State{

  @Override
  public void 동전투입() {
    throw new IllegalStateException("매진 입니다.");
  }

  @Override
  public void 동전반환() {
    throw new IllegalStateException("매진 입니다.");
  }

  @Override
  public void 손잡이돌림() {
    throw new IllegalStateException("매진 입니다.");
  }

  @Override
  public void 리필() {
    System.out.println("리필했습니다.");
  }
}
