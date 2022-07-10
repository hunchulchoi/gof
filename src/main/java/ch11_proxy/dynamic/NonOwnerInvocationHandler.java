package ch11_proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class NonOwnerInvocationHandler implements InvocationHandler {

  private Person person;

  public NonOwnerInvocationHandler(Person person) {
    this.person = person;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    String methodName = method.getName();

    if(methodName.equals("setGeekRating") || methodName.startsWith("get")){
      return method.invoke(person, args);
    }else if(methodName.startsWith("set")){
      throw new IllegalAccessException();
    }
    return null;
  }
}
