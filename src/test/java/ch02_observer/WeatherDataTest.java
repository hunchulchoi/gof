package ch02_observer;

import ch02_observer.wheatherorama.CurrentConditionDisplay;
import ch02_observer.wheatherorama.StatisticsDisplay;
import ch02_observer.wheatherorama.WeatherData;
import org.junit.jupiter.api.Test;

import java.util.Random;

class WeatherDataTest {

  @Test
  void observerTest() throws InterruptedException {

    WeatherData weatherData = new WeatherData();

    CurrentConditionDisplay display1 = new CurrentConditionDisplay("current1", weatherData);
    CurrentConditionDisplay display2 = new CurrentConditionDisplay("current2", weatherData);
    StatisticsDisplay display3 = new StatisticsDisplay(weatherData);

    for(int i=0; i<10; i++){
      Thread.sleep(500);

      Random random = new Random();

      WeatherData.Datas data = new WeatherData.Datas(random.nextDouble() * 10d, random.nextDouble() * 80d, random.nextDouble() * 99d);

      weatherData.setData(data);
    }


  }

}