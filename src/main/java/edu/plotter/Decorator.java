package edu.plotter;

import java.awt.*;

/**
 * Base class for plot decorations that delegate drawing to another Component.
 *
 * <p>The add method sets the wrapped component; subclasses add drawing behavior and then call super.draw.</p>
 */
public abstract class Decorator implements Component {

    protected Component component;

    /** Sets the component wrapped by this decorator. */
    public void add(Component d) {
        component = d;
    }

    @Override
    public void draw(Graphics g) {
        component.draw(g);
    }

}
