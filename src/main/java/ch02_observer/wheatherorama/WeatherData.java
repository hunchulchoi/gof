package ch02_observer.wheatherorama;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{

  private final List<Observer> observers = new ArrayList<>();

  @Getter
  private Datas data;

  @Override
  public boolean registerObserver(Observer observer) {
    return observers.add(observer);
  }

  @Override
  public boolean removeObserver(Observer observer) {
    return observers.remove(observer);
  }

  @Override
  public void notigfyAll() {
    observers.forEach(o->o.update());
  }

  public void measurementsChanged(){
    notigfyAll();
  }

  public void setData(Datas data){
    this.data = data;
    measurementsChanged();
  }

  @Getter
  @AllArgsConstructor
  @ToString
  public static class Datas{
    private double temperature;
    private double humidity;
    private double pressure;
  }

}
