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

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Reuse the container for all test methods on a test class, by default each test method will have its own container lifecycle.
 *
 * <pre>
 *  &#064;MockwireSingleLifecycle
 *  public class MockwireTest {
 *
 *  &#064;Controlled
 *  AnInterface field;
 *
 *  &#064;Inject
 *  IsolateTestContext context;
 *
 *  &#064;Test
 *  public void testOne() {
 *    assertThat(context.getBeanNamesForType(AnInterface)).hasSize(1);
 *  }
 *
 *  &#064;Test
 *  public void testTwo() {
 *    assertThat(context.getBeanNamesForType(AnInterface)).hasSize(1);
 *  }
 *
 * </pre>
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface MockwireSingleLifecycle {

}
