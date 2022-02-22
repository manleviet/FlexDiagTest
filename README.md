# FlexDiagTest

## How to get the CA-CDR package

This project uses a GitHub Maven package so-called [CA-CDR](https://github.com/manleviet/CA-CDR), a library of Consistency-based Algorithms for Conflict Detection and Resolution.

To help your project can get the CA-CDR package from the GitHub Maven Repository, please add the below script in the settings.xml file of your project:

```
<?xml version="1.0" encoding="UTF-8"?>
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 http://maven.apache.org/xsd/settings-1.0.0.xsd">
    <activeProfiles>
        <activeProfile>github</activeProfile>
    </activeProfiles>

    <profiles>
        <profile>
            <id>github</id>
            <repositories>
                <repository>
                    <id>central</id>
                    <url>https://repo1.maven.org/maven2</url>
                </repository>
                <repository>
                    <id>github</id>
                    <url>https://maven.pkg.github.com/manleviet/*</url>
                </repository>
            </repositories>
        </profile>
    </profiles>
</settings>
```

## KB classes

There are five KB classes which correspond to five models, including _model_1_nok_1_, _model_1_nok_2_, _model_1_nok_3_, _model_2_nok_, and _model_3_nok_.

Each KB class contains three essential functions that define domains, variables, and constraints. For further details on Domain, Variable, and Constraint classes, I refer to the [ChocoKB package](https://github.com/manleviet/ChocoKB).

## CDRModel class

The NOKModel class extending the CDRModel class is responsible for getting the KB's constraints and setting them to two sets, i.e., the possibly faulty constraints C, and the background knowledge B, which will be used as the input of consistency-based algorithms.

The NOKModel class asks for a KB object when initializing.

## Main class

With the Main class, you can do the following:

1. Select a KB out of five KBs
2. Print out all KB's constraints
3. Identify conflicts using [QuickXPlain](https://github.com/manleviet/CA-CDR/blob/main/src/main/java/at/tugraz/ist/ase/cacdr/algorithms/QuickXPlain.java)
4. Identify diagnoses using [FlexDiag](https://github.com/manleviet/CA-CDR/blob/second_version/src/main/java/at/tugraz/ist/ase/cacdr/algorithms/FlexDiag.java)
5. Identify diagnoses using [FastDiag](https://github.com/manleviet/CA-CDR/blob/main/src/main/java/at/tugraz/ist/ase/cacdr/algorithms/FastDiagV2.java)
6. Uncomment _printPerformance_ to see more evaluation

For further details on HSDAG, I refer to [here](https://github.com/manleviet/CA-CDR/blob/second_version/src/main/java/at/tugraz/ist/ase/cacdr/algorithms/hsdag/HSDAG.java).
