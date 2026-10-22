package edu.plotter.classic;

import java.awt.*;
import java.util.LinkedList;
/**
 * Adds square markers.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public class WorkerToolSquare extends WorkerTool{
    private static final int POINT_HEIGHT = 10;
    private static final int POINT_WIDTH = 10;
    public final int MAX_NUMBER_OF_VALUES = 20;
    public void draw(Graphics g, LinkedList values){
        g.setColor(Color.BLUE);
        for(int index = 0; index < values.size(); index++){
            g.fillRect((501/MAX_NUMBER_OF_VALUES * index) - (POINT_WIDTH/2)+6,
                    (int)values.get(index) - (POINT_HEIGHT/2), POINT_WIDTH, POINT_HEIGHT);
        }
        super.draw(g, values);
    }
}
