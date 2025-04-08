package com.bridgelabz.advancedproblems;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
interface Greeting {
    void sayHello(String name);
}
// Implement the interface
class GreetingImpl implements Greeting {
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}
// dynamic proxy handler
class LoggingInvocationHandler implements InvocationHandler {
    private final Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }
    // Intercept method calls here
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("LOG Method called: " + method.getName());
        return method.invoke(target, args);
    }
}
public class LoggingProxy {
    public static void main(String[] args) {
        Greeting greeting = new GreetingImpl();
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );
        proxyInstance.sayHello("Prakul");
    }
}

