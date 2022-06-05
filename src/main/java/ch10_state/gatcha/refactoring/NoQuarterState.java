package ch10_state.gatcha.refactoring;

public class NoQuarterState extends State{

  @Override
  public void 동전투입() {
    System.out.println("동전투입");
  }

  @Override
  public void 동전반환() {
    throw new IllegalStateException("돈을 넣어 주세요");
  }

  @Override
  public void 손잡이돌림() {
    throw new IllegalStateException("돈을 넣어 주세요");
  }

}
