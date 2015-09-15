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

/**
 * Contract for things that can generate mock implementations of other contracts such that their behaviour can be controlled
 *
 */
public interface Mocker {

  /**
   * @return object that appears to be of <b>type</b> but can be fully controlled to isolate and test real code.
   * @param mockName The name for the mock to be generated
   * @param type The type to generate a mock for
   * @param <T> The type of the generated mock
   */
  <T> T mock(String mockName, Class<T> type);

  /**
   * @return an object that appears to be of <b>type</b> but can be fully controlled to isolate and test real code.
   * @param type The type to generate a mock for
   * @param <T> The type of the generated mock
   */
  <T> T mock(Class<T> type);


}
