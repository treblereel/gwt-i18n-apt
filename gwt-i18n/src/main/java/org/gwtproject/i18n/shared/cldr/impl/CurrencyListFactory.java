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

package org.gwtproject.i18n.shared.cldr.impl;

import javax.annotation.Generated;
import jsinterop.annotations.JsMethod;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

@Generated(
    "gwt-cldr-importer : org.gwtproject.tools.cldr.CurrencyListProcessor, CLDR version : release-34")
public class CurrencyListFactory {

  public static String locale = System.getProperty("locale");
  private static JsPropertyMap cache = JsPropertyMap.of();

  public static org.gwtproject.i18n.shared.cldr.CurrencyList create() {
    if (cache.has(locale)) {
      return Js.uncheckedCast(cache.get(locale));
    }
    CurrencyList_ list = get(locale);
    list.loadCurrencyMap();
    cache.set(locale, list);
    return list;
  }

  @JsMethod
  @SuppressWarnings("unusable-by-js")
  public static native org.gwtproject.i18n.shared.cldr.impl.CurrencyList_ get(String locale);
}
