package ch10_state.gatcha.refactoring;

public class SoldState extends State{

  @Override
  public void 동전투입() {
    throw new IllegalStateException("상품이 나오는 중입니다. 잠시후에");
  }

  @Override
  public void 동전반환() {
    throw new IllegalStateException("상품이 나오는 중입니다. 잠시후에");
  }

  @Override
  public void 손잡이돌림() {
    throw new IllegalStateException("상품이 나오는 중입니다. 잠시후에");
  }

}
