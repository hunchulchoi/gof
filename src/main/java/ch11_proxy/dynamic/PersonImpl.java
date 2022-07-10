package ch11_proxy.dynamic;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PersonImpl implements Person{
  String name;
  String gender;
  String interests;
  int rating;
  int ratingCount = 0;

  public PersonImpl(String name, String gender, String interests) {
    this.name = name;
    this.gender = gender;
    this.interests = interests;
  }

  @Override
  public int getGeekRating() {
    return ratingCount==0?0:rating/ratingCount;
  }

  @Override
  public void setGeekRating(int rating) {
    this.rating += rating;
    ratingCount++;
  }
}
