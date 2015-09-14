package net.stickycode.mockwire;

import java.lang.reflect.Method;

public interface MockwireContainer {

  MockwireContainer startTest(Object test);

  void endTest(Object test);

  Object[] deriveParameters(Method method);

  void shutdown();

  void startup();

}
