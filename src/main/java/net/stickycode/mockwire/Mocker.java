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
public interface Mocker {

  static Mocker bridge() {
    ServiceLoader<Mocker> loader = ServiceLoader.load(Mocker.class);
    Iterator<Mocker> bootstraps = loader.iterator();
    if (!bootstraps.hasNext())
      throw new RuntimeException(Mocker.class + " implementation not found");

    Mocker bridge = bootstraps.next();
    if (bootstraps.hasNext())
      throw new RuntimeException("Too many " + Mocker.class + " implementations found");

    return bridge;
  }

  void initialise(StickyBootstrap bootstrap, Class<?> metadata);

  /**
   * @return object that appears to be of the type of the controlled field but can be fully controlled to isolate and test real code.
   * @param test The instance of the test class that is being exercised
   * @param <T> The type of the generated mock
   */
  Object mock(Object test, Field controlledField);



}
