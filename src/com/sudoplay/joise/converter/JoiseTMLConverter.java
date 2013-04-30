/*
 * Copyright (C) 2013 Jason Taylor
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sudoplay.joise.converter;

import java.io.Reader;
import java.io.Writer;

import com.sudoplay.joise.ModuleMap;
import com.sudoplay.juple.Juple;
import com.sudoplay.juple.JupleBuilder;

public class JoiseTMLConverter {

  private Juple juple;

  public JoiseTMLConverter() {
    this(true);
  }

  public JoiseTMLConverter(boolean prettyPrint) {
    JupleBuilder builder = new JupleBuilder();
    builder.registerTypeAdapterFactory(JoiseJupleAdapters.MODULE_MAP_FACTORY);
    if (prettyPrint) {
      builder.setPrettyPrinting();
    }
    juple = builder.create();
  }

  public String toTML(ModuleMap moduleMap) {
    return juple.toTML(moduleMap);
  }

  public void toTML(ModuleMap moduleMap, Writer writer) {
    juple.toTML(moduleMap, writer);
  }

  public ModuleMap fromTML(String tml) {
    return juple.fromTML(tml, ModuleMap.class);
  }

  public ModuleMap fromTML(Reader reader) {
    return juple.fromTML(reader, ModuleMap.class);
  }

}
