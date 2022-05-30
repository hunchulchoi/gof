package ch07_02_pacade.hometheater;

public class TheaterLights extends AVMachine {

  public TheaterLights() {
    super("조명");
  }

  public TheaterLights(String name) {
    super(name);
  }

  private int dim;

  public void setDim(int dim) {
    checkOn();
    this.dim = dim;
    System.out.println(this.name + String.format(" 조명 밝기 %d%%", dim));
  }

  public int getDim() {
    checkOn();
    return dim;
  }
}
