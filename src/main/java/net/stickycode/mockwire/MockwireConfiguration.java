/**
 * Copyright (c) 2018 RedEngine Ltd, http://www.redengine.co.nz. All rights reserved.
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
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.stickycode.mockwire.feature.MockwireScan;

/**
 * Define configuration used for configuring wired components in the Mockwire context.
 *
 * <pre>
 *   package net.stickycode.example;
 *
 *    &#064;RunWith(MockwireRunner.class)
 *    &#064;MockwireConfigured("a.b=value")
 *    public class ContainedTest {
 *      public static Class A {
 *        &#064;Configured
 *        String b;
 *      }
 *
 *      &#064;UnderTest
 *      A a;
 *
 *      &#064;Test
 *      public void configuredValues() {
 *        assertThat(a.b).isEqualTo("value");
 *      }
 *      
 *      &#064;Test
 *      &#064;MockwireConfiguration("a.b=local")
 *      public void localValueOverrides() {
 *        assertThat(a.b).isEqualTo("local");
 *      }
 *      
 *      &#064;Test
 *      &#064;MockwireConfiguration
 *      public void defaultToFileOfMethodName() {
 *        assertThat(a.b).isEqualTo("properties");
 *      }
 *
 *   }
 *   
 * check.properties |
 *   a.b=properties
 * </pre>
 *
 * 
 * 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MockwireConfiguration {

  /**
   * @return The values used for configuring wired components
   *
   */
  String[] value() default {};

  /**
   * @return The files used to load properties, if neither value nor files is set then a properties file will be looked for named
   *         based on the test method name
   */
  String[] files() default {};

}
