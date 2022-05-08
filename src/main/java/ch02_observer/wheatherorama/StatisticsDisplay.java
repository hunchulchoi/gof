package ch02_observer.wheatherorama;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay implements Observer, DisplayElement{

  private final WeatherData weatherData;

  private final List<Double> templatures = new ArrayList<>();

  public StatisticsDisplay(WeatherData weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void display() {
    System.out.printf("기온: 최고: %f, 최저: %f, 평균: %f%n"
        , templatures.stream().mapToDouble(Double::doubleValue).max().orElse(0)
        , templatures.stream().mapToDouble(Double::doubleValue).min().orElse(0)
        , templatures.stream().mapToDouble(Double::doubleValue).average().orElse(0));
  }

  @Override
  public boolean update() {
    boolean r = templatures.add(weatherData.getData().getTemperature());
    display();
    return r;
  }
}
