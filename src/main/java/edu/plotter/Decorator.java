package edu.plotter;
import java.awt.Graphics;
import java.util.Objects;
/** Base drawing decorator, wrapping a required component. */
public abstract class Decorator implements Component {
    protected final Component component;
    protected Decorator(Component component) { this.component = Objects.requireNonNull(component); }
    @Override public void draw(Graphics graphics) { component.draw(graphics); }
}
