package ch05_singleton.legacy;

/**
 * 싱글톤 테스트
 */
public class MyObject {

  private static MyObject object;

  private MyObject() {
    System.out.println(this.hashCode());
  }

  public static MyObject getInstance(){
    System.out.println(object);
    if(object==null) object = new MyObject();

    return object;
  }
}
