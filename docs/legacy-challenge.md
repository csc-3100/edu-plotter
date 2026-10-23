# Legacy Grade Plotter: UML and Refactoring Challenge

The 19-class original CSC308 `gradePlotterApp` is preserved under `edu.plotter.legacy`. The code intentionally retains its design flaws for teaching.

## Student exercise

1. Reverse-engineer a UML class diagram with inheritance, interfaces, associations, and dependencies.
2. Identify code smells and explain their consequences with references to specific classes.
3. Propose improvements using design principles and appropriate patterns.
4. Refactor incrementally while maintaining intended behavior; add tests where practical.

Start at `edu.plotter.legacy.Main`. Examine `Repository`, the decorators, `ObserverTable`, `ObserverPlotter`, `MainUI`, and `MainController`. The deprecated Java Observer API is intentionally retained. Input CSV data may be needed for some operations.

See [original exercise](legacy-original-readme.md).
