package ch02_observer.wheatherorama;

public interface Subject {
  boolean registerObserver(Observer observer);
  boolean removeObserver(Observer observer);
  void notigfyAll();
}
