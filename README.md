##JoisePlugin-TMLConverter
Convert Joise module chains to and from TML.
##Dependencies
This code assumes you have the following libs on your classpath:
* [Joise](https://github.com/codetaylor/Joise)
* [Juple](https://github.com/codetaylor/Juple)

##Example
###Convert To TML
```java
// create a Joise module chain
ModuleBasisFunction basis = new ModuleBasisFunction();
basis.setType(BasisType.GRADIENT);
basis.setSeed(648);

ModuleAutoCorrect auto = new ModuleAutoCorrect();
auto.setSource(basis);
auto.calculate();

// create a converter instance and convert to TML
JoiseTMLConverter converter = new JoiseTMLConverter();
String tml = converter.toTML(auto.getModuleMap());
```

```
[
    [func_1 | 
        [module | ModuleBasisFunction]
        [basis | gradient]
        [interpolation | quintic]
        [seed | 648]
    ]
    [func_2 | 
        [module | ModuleAutoCorrect]
        [low | 0.0]
        [high | 1.0]
        [samples | 100]
        [sampleScale | 1.0]
        [locked | false]
        [source | func_1]
    ]
]
```
###Convert From TML
```
// convert from TML to a Joise instance
Joise j = new Joise(converter.fromTML(tml));
```
##License

Copyright (C) 2013 Jason Taylor. Released as open-source under [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).
