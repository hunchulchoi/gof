package ch10_state.gatcha.refactoring;

public class HasQuarterState extends State{

  @Override
  public void 동전투입() {
    throw new IllegalStateException("돈은 한번만 넣어주세요");
  }

  @Override
  public void 동전반환() {
    System.out.println("돈이 반환 됩니다.");
  }

  @Override
  public void 손잡이돌림() {
    System.out.println("상품이 나옵니다.");
  }

}
