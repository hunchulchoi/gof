package ch09_01_iterrator.menu;

import org.junit.jupiter.api.Test;

class ServingWorkerTest {

  @Test
  void printMenu() {
    ServingWorker servingWorker = new ServingWorker(new PancakeHouseMenu().arrayList(), new LunchMenu().arrayList(), new CafeMenu().arrayList());
    servingWorker.printMenu();
    servingWorker.printVegetarianMenu();
  }
}