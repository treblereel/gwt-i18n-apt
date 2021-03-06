/*
 * Copyright © 2018 The GWT Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gwtproject.i18n.apt;

/** @author Dmitrii Tikhomirov Created by treblereel 12/7/20 */
public class LocaleInfoFactoryGenerator {

  private static final String newLine = System.lineSeparator();

  static String get(String[] locales) {
    StringBuffer factory = new StringBuffer();
    factory
        .append("goog.module('org.gwtproject.i18n.shared.cldr.impl.LocaleInfoFactoryImpl');")
        .append(newLine);
    factory.append(newLine);

    factory
        .append(
            "let LocaleInfoImpl = goog.forwardDeclare('org.gwtproject.i18n.shared.cldr.LocaleInfoImpl$impl');")
        .append(newLine);

    for (String locale : locales) {
      factory.append("let LocaleInfoImpl__");
      factory.append(locale);
      factory.append(
          " = goog.forwardDeclare('org.gwtproject.i18n.shared.cldr.impl.LocaleInfoImpl_");
      factory.append(locale);
      factory.append("$impl');");
      factory.append(newLine);
    }

    factory.append(newLine);
    factory
        .append(
            "let LocaleInfoImpl__default = goog.forwardDeclare('org.gwtproject.i18n.shared.cldr.impl.LocaleInfoImpl$impl');")
        .append(newLine);

    factory.append("class Locale {").append(newLine);
    factory.append(" /** @return {LocaleInfoImpl} */").append(newLine);
    factory.append(" static get(locale) {").append(newLine);
    factory.append("    switch(locale) {").append(newLine);

    for (String locale : locales) {
      factory.append("      case '");
      factory.append(locale);
      factory.append("':").append(newLine);

      factory.append("        return LocaleInfoImpl__");
      factory.append(locale);
      factory.append(".$create__();").append(newLine);
    }

    factory.append("      default:").append(newLine);
    factory.append("        return LocaleInfoImpl__default.$create__();").append(newLine);
    factory.append("    }").append(newLine);

    factory.append(" }").append(newLine);
    factory.append("}").append(newLine);

    factory.append(newLine);
    factory.append("exports = Locale;").append(newLine);
    return factory.toString();
  }
}
