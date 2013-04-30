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
