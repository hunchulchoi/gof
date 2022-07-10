package ch10_state.gatcha.refactoring;

import lombok.RequiredArgsConstructor;

public abstract class State {

  public enum STATE{
    동전있음, 동전없음, 알맹이판매, 알맹이매진, 보너스
  }

  public abstract void 동전투입();
  public abstract void 동전반환();
  public abstract void 손잡이돌림();
  public void 리필(){
    throw new IllegalStateException("지금은 리필 할 수 없습니다." + this);
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName();
  }
}
