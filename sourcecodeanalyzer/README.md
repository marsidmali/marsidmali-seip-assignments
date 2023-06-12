# Refactored Code Analyzer

This project is a refactored version of a code analyzer system that calculates various metrics such as lines of code (LOC), number of methods (NOM), and number of classes (NOC) for a given source code file. The refactored project uses four design patterns: ***Strategy, Factory, Bridge*** and ***Façade***, which help to improve the system's maintainability, flexibility, and readability.
<br></br>
<br></br>

![class_diagram](https://github.com/marsidmali/mmm/assets/93339789/309152ea-e081-405c-8704-68f7a7634fb0)




<br></br>

## Design Patterns

#### Strategy

The Strategy pattern was chosen to enable different implementations for reading source code files (Local, Web), calculating metrics (LOC, NOM, NOC) and exporting metrics (csv, json). This pattern allows the system to be easily extended with new calculation techniques or file reader types without modifying existing code.

**Impact on the system**

The benefits of using the Strategy pattern include:

- Easier addition of new algorithms or data source types without changing existing code, enhancing extensibility.
- Improved readability as the code is more organized and modular.

The trade-offs include:

- Increased number of classes, which can make the system more complex.
- Potential overhead due to the use of interfaces and indirection.

**Classes participating in the pattern and their roles**

- `MetricsExporter(interface)`, `SourceFileReader(interface)`, and `SourceCodeAnalyzer(abstract class)` serve as the strategy base, defining the contract for concrete implementations.
- `CSVExporter` and  `JSONExporter` are concrete strategies for exporting metrics.
- `LocalFileReader` and `WebFileReader` are concrete strategies for reading source code files.
- `RegexAnalyzer` and `StringComparisonAnalyzer` are concrete strategies for calculating metrics.

#### Factory

The Factory pattern was chosen to create instances of concrete strategy classes without exposing the instantiation logic to the client. This pattern allows for easier management of object creation and promotes loose coupling between the client and the concrete classes.

**Impact on the system**

The benefits of using the Factory pattern include:

- Encapsulation of object creation logic, increasing maintainability.
- Loose coupling between client and concrete classes, improving flexibility.
- Easier addition or modification of concrete classes without affecting the client code.

The trade-offs include:

- Increased number of classes, which can make the system more complex.
- Potential overhead due to the use of factory classes.

**Classes participating in the pattern and their roles**

- `MetricsExporterFactory`, `SourceFileReaderFactory`, and `SourceCodeAnalyzerFactory` are factory classes responsible for creating instances of concrete strategy classes.

#### Bridge


The Bridge pattern was chosen to decouple the abstraction (`SourceCodeAnalyzer`) from its implementation (`SourceFileReader`). This pattern allows the two hierarchies to vary independently, improving the system's modularity and extensibility.

**Impact on the system**

The benefits of using the Bridge pattern include:

- Decoupling of abstraction and implementation, improving maintainability and flexibility.
- Independent variation of abstraction and implementation, enhancing extensibility.
- Improved code organization and readability.

The trade-offs include:

- Increased complexity due to the introduction of additional classes and interfaces.

**Classes participating in the pattern and their roles**

- `SourceCodeAnalyzer` serves as the abstraction, which is decoupled from its implementation.
- `SourceFileReader` serves as the implementation, providing different ways to read source code files.

#### Façade

The Facade pattern was chosen to provide a simplified interface to the code analyzer system, hiding the complexity of the underlying classes and making it easier for the client to use the system.

**Impact on the system**

The benefits of using the Facade pattern include:

- Simplified interface for the client, improving usability.
- Encapsulation of the complex system, enhancing maintainability.
- Improved readability as the client code is cleaner and more straightforward.

The trade-offs include:

- An additional layer of indirection, which can introduce some overhead.

**Classes participating in the pattern and their roles**

- `CodeAnalyzerFacade` serves as the facade, providing a simplified interface for client to interact with the code analyzer system.

## 1. Build the executable Java application with: 
	mvn package jacoco:report

## 2. Run the executable by executing
	java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
were args translate to: 	

    arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
    arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
    arg2 = “SourceCodeLocationType” [local|web]
    arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
    arg4 = “OutputFileType” [csv|json]

example:
      
    java -jar ./sourcecodeanalyzer/target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar sourcecodeanalyzer/src/test/resources/TestClass.java regex local metrics_results csv

