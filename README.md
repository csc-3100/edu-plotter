# Plotter — Design Patterns in Java

A small Java Swing application that demonstrates how **Decorator**, **Observer**, and **Singleton** can collaborate to visualize a changing collection of values.

## Run

Requires **JDK 17+** and **Maven 3.9+**.

```bash
mvn clean package
mvn exec:java
```

A window opens with three plots. Click **Run** to generate a new value. All three panels update together and display the same data with different decorations.

## Design patterns

- **Decorator:** `Component` defines drawing; `Plot` draws the line, while `SquareBlue` and `BarGray` add visual layers without changing `Plot`.
- **Observer:** `Repository` emits property-change events when data changes. Each `PlotPanel` listens and repaints.
- **Singleton:** `Repository.getInstance()` supplies one shared in-memory dataset for the three panels.

See [the architecture diagram](docs/architecture.md) for relationships and the update flow.

## Project layout

- `src/main/java/edu/plotter/` — the original plotting application, moved into a Java package.
- `docs/architecture.md` — Mermaid class and interaction diagrams.
- `pom.xml` — Maven build and run configuration.

## Teaching notes and limitations

This is a **teaching example**, not a production-ready charting library. The code intentionally preserves the original behavior and pattern implementation for discussion. Possible refactorings include using panel dimensions instead of hard-coded coordinates, preventing external mutation of stored values, using constructor injection for decorators, and improving singleton thread safety.

The earlier unrelated `OLD/` examples are removed from the current branch but remain accessible in Git history.

## License

No license has been specified. Do not assume the source is licensed for reuse outside this repository.
