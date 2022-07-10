package ch10_state.gatcha.refactoring;

public class WinningState extends State{
  @Override
  public void 동전투입() {
    throw new IllegalStateException("지금은 동전 투입이 힘듭니다.");
  }

  @Override
  public void 동전반환() {
    throw new IllegalStateException("지금은 동전 반환이 안됩니다");
  }

  @Override
  public void 손잡이돌림() {
    System.out.println("당첨되었습니다. 상품이 하나더 나옵니다.");
  }
}
