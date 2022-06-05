package ch_09_02_composite;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class MenuItem extends MenuComponent {

  private final String name;
  private final String description;
  private final double price;
  private final boolean vegetarian;

  @Override
  String name() {
    return this.name;
  }

  @Override
  String description() {
    return this.description;
  }

  @Override
  Optional<Double> price() {
    return Optional.of(this.price);
  }

  @Override
  boolean vegetarian() {
    return this.vegetarian;
  }
}
