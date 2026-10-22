package edu.plotter.classic;

import java.awt.*;
import java.util.LinkedList;
/**
 * Defines the classic chart drawing operation.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public interface Worker {
    public void draw(Graphics g, LinkedList values);
}
