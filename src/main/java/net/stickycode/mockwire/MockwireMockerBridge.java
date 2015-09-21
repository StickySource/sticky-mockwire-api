/**
 * Copyright (c) 2010 RedEngine Ltd, http://www.redengine.co.nz. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package net.stickycode.mockwire;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.ServiceLoader;

import net.stickycode.bootstrap.StickyBootstrap;

/**
 * Contract for things that can generate mock implementations of other contracts such that their behaviour can be controlled
 *
 */
public interface MockwireMockerBridge {

  static MockwireMockerBridge bridge() {
    ServiceLoader<MockwireMockerBridge> loader = ServiceLoader.load(MockwireMockerBridge.class);
    Iterator<MockwireMockerBridge> bootstraps = loader.iterator();
    if (!bootstraps.hasNext())
      throw new RuntimeException(MockwireMockerBridge.class + " implementation not found");

    MockwireMockerBridge bridge = bootstraps.next();
    if (bootstraps.hasNext())
      throw new RuntimeException("Too many " + MockwireMockerBridge.class + " implementations found");

    return bridge;
  }

  void initialise(StickyBootstrap bootstrap, Class<?> metadata);

  /**
   * @param name The name of the mock in the container
   * @return object that appears to be of the type of the controlled field but can be fully controlled to isolate and test real code.
   * @param test The instance of the test class that is being exercised
   * @param type The type of the generated mock
   */
  void process(String name, Object target, Field field, Class<?> type);




}
