# Architecture

## Class relationships

```mermaid
classDiagram
    class Component {
      <<interface>>
      +draw(Graphics)
    }
    class Decorator {
      <<abstract>>
      #component: Component
      +Decorator(Component)
      +draw(Graphics)
    }
    class Plot
    class SquareBlue
    class BarGray
    class PlotPanel {
      -component: Component
      +propertyChange(PropertyChangeEvent)
    }
    class Repository {
      -instance: Repository
      -values: ArrayList~Integer~
      +getInstance() Repository
      +create()
      +getValue(int) int
    }
    Component <|.. Plot
    Component <|.. Decorator
    Decorator <|-- SquareBlue
    Decorator <|-- BarGray
    Decorator o--> Component
    PlotPanel --> Component
    PlotPanel ..> Repository : observes
    Plot ..> Repository : reads
```

## When the user clicks Run

```mermaid
sequenceDiagram
    actor User
    participant Main
    participant Repository
    participant PlotPanel
    participant Component
    User->>Main: click Run
    Main->>Repository: create()
    Repository-->>PlotPanel: propertyChange(event)
    PlotPanel->>PlotPanel: repaint()
    PlotPanel->>Component: draw(Graphics)
    Component->>Repository: getValues()
```

The three panels register independently with the same repository. Decorators receive their wrapped component through constructors. The drawing chains differ: `BarGray → SquareBlue → Plot`, `SquareBlue → Plot`, and `Plot`.
