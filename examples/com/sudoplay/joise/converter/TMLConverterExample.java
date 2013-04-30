package com.sudoplay.joise.converter;

import com.sudoplay.joise.Joise;
import com.sudoplay.joise.module.ModuleAutoCorrect;
import com.sudoplay.joise.module.ModuleBasisFunction;
import com.sudoplay.joise.module.ModuleBasisFunction.BasisType;
import com.sudoplay.joise.module.ModuleFractal;
import com.sudoplay.joise.module.ModuleFractal.FractalType;

public class TMLConverterExample {

  public static void main(String[] args) {
    TMLConverterExample app = new TMLConverterExample();
    app.run();
  }

  void run() {

    JoiseTMLConverter converter = new JoiseTMLConverter();

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

    double d = auto.get(0.26598, 0.986532);

    String tml = converter.toTML(auto.getModuleMap());

    System.out.println(tml);

    Joise j = new Joise(converter.fromTML(tml));

    System.out.println(d + " == " + j.get(0.26598, 0.986532));

  }

}
