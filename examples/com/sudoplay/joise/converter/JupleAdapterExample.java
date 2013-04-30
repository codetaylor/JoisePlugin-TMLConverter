package com.sudoplay.joise.converter;

import com.sudoplay.joise.module.ModuleAutoCorrect;
import com.sudoplay.joise.module.ModuleBasisFunction;
import com.sudoplay.joise.module.ModuleBasisFunction.BasisType;
import com.sudoplay.joise.module.ModuleFractal;
import com.sudoplay.joise.module.ModuleFractal.FractalType;
import com.sudoplay.juple.Juple;
import com.sudoplay.juple.JupleBuilder;

public class JupleAdapterExample {

  public static void main(String[] args) {
    JupleAdapterExample app = new JupleAdapterExample();
    app.run();
  }

  void run() {

    Juple juple = new JupleBuilder()
        .registerTypeAdapterFactory(JoiseJupleAdapters.MODULE_MAP_FACTORY)
        .setPrettyPrinting().create();

    ModuleBasisFunction basis = new ModuleBasisFunction();
    basis.setType(BasisType.GRADIENT);
    basis.setSeed(648);

    ModuleFractal frac = new ModuleFractal();
    frac.setType(FractalType.RIDGEMULTI);
    frac.setAllSourceBasisTypes(BasisType.SIMPLEX);
    frac.setNumOctaves(5);
    frac.setSeed(42);

    frac.overrideSource(0, basis);

    ModuleAutoCorrect auto = new ModuleAutoCorrect();
    auto.setSource(frac);
    auto.calculate();
    auto.setLocked(true);

    String tml = juple.toTML(frac.getModuleMap());

    System.out.println(tml);

  }

}
