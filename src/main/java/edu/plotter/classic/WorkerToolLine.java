package edu.plotter.classic;

import java.awt.*;
import java.util.LinkedList;
/**
 * Adds vertical bars.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public class WorkerToolLine extends WorkerTool{
    private static final int BAR_WIDTH = 10;
    public final int MAX_NUMBER_OF_VALUES = 20;
    public void draw(Graphics g, LinkedList values){
        g.setColor(Color.GRAY);
        for(int index = 0; index < values.size(); index++){
            g.fillRect((501/MAX_NUMBER_OF_VALUES*index) - (BAR_WIDTH/2)+6, (int)values.get(index),
                    BAR_WIDTH, 190-(int)values.get(index));
        }
        super.draw(g, values);
    }
}
