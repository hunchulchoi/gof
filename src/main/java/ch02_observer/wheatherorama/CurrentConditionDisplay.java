package ch02_observer.wheatherorama;

public class CurrentConditionDisplay implements Observer, DisplayElement{

  private final WeatherData weatherData;
  private WeatherData.Datas data;
  private final String name;

  public CurrentConditionDisplay(String name,WeatherData weatherData) {
    this.name = name;
    this.weatherData = weatherData;
    this.weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.println("Am " + name + " currents:" + this.data);
  }

  @Override
  public boolean update() {
    this.data = weatherData.getData();
    this.display();
    return true;
  }
}
