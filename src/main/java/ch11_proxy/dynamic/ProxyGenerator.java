package ch11_proxy.dynamic;

import java.lang.reflect.Proxy;
import java.util.Objects;

public class ProxyGenerator {

  static Person getProxy(Person person, String name){
    Objects.requireNonNull(person, "person must be not null");
    Objects.requireNonNull(name);

    Class<? extends Person> personClass = person.getClass();

    if(name.equals(person.getName())){
      return (Person) Proxy.newProxyInstance(personClass.getClassLoader(), personClass.getInterfaces(), new OwnerInvocationHandler(person));
    }

    return (Person) Proxy.newProxyInstance(personClass.getClassLoader(), personClass.getInterfaces(), new NonOwnerInvocationHandler(person));
  }
}
