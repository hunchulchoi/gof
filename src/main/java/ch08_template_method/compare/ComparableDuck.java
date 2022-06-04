package ch08_template_method.compare;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ComparableDuck implements Comparable<ComparableDuck>{

  private String name;
  private int weight;

  @Override
  public int compareTo(ComparableDuck o) {
    if(this.weight==o.weight){
      return this.name.compareTo(o.name);
    }

    return this.weight - o.weight;
  }

  @Override
  public String toString() {
    return String.format("%s(%d)", name, weight);
  }
}
