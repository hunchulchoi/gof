package ch06_command.order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

  @Test
  void order(){
    Customer customer = new Customer();
    customer.order(Food.Bugger);
    customer.order(Food.김치찌개);
  }

}