package edu.plotter.classic;

import java.awt.*;
import java.util.LinkedList;
/**
 * Adds a horizontal average line.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public class WorkerToolAvg extends WorkerTool{
    public void draw(Graphics g, LinkedList values){
        g.setColor(Color.RED);
        int sum = 0;
        if(!values.isEmpty()) {
            for (int index = 0; index < values.size(); index++) {
                sum += (int) values.get(index);
            }
            g.drawLine(0, (sum / values.size()), 501, (sum / values.size()));
        }
        super.draw(g, values);
    }
}
