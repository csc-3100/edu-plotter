package edu.plotter.classic;

import java.awt.*;
import java.util.LinkedList;

/**
 * Base decorator forwarding drawing to a wrapped Worker.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public abstract class WorkerTool implements Worker{
    protected Worker worker;
    public void add(Worker d){
        worker = d;
    }
    @Override
    public void draw(Graphics g, LinkedList values) {
        worker.draw(g, values);
    }
}
