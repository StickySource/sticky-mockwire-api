package net.stickycode.mockwire;

import java.util.Iterator;
import java.util.ServiceLoader;

import net.stickycode.bootstrap.StickyBootstrap;

public interface MockwireFrameworkBridge {

  static MockwireFrameworkBridge bridge() {
    ServiceLoader<MockwireFrameworkBridge> loader = ServiceLoader.load(MockwireFrameworkBridge.class);
    Iterator<MockwireFrameworkBridge> bootstraps = loader.iterator();
    if (!bootstraps.hasNext())
      throw new RuntimeException(MockwireFrameworkBridge.class + " implementation not found");

    MockwireFrameworkBridge bridge = bootstraps.next();
    if (bootstraps.hasNext())
      throw new RuntimeException("Too many " + MockwireFrameworkBridge.class + " implementations found");

    return bridge;
  }

  void initialise(StickyBootstrap bootstrap, Class<?> metadata);
}
