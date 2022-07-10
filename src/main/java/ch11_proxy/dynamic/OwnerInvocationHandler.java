package ch11_proxy.dynamic;

import lombok.Setter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class OwnerInvocationHandler implements InvocationHandler {

  private Person person;

  public OwnerInvocationHandler(Person person) {
    this.person = person;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

    String methodName = method.getName();

    if(methodName.equals("setGeekRating")){
      throw new IllegalAccessException("본인 괴짜 지수는 변경할 수 없습니다.");
    }
    if(methodName.startsWith("get") || methodName.startsWith("set")){
      return method.invoke(person, args);
    }

    return null;
  }
}
