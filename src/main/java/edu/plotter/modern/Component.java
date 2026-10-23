package edu.plotter.modern;

import java.awt.*;
import java.util.LinkedList;
/**
 * Defines the drawing operation shared by plots and decorators.
 *
 * <p>Concrete components and decorators implement this interface.</p>
 */
public interface Component {
    /** Draws onto the provided graphics context.
     * @param g drawing context
     */
    public void draw(Graphics g);
}
