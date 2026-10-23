package edu.plotter.classic;

import java.awt.*;
import java.util.LinkedList;
/**
 * Draws the base line chart.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public class WorkerStandard implements Worker{
    public final int MAX_NUMBER_OF_VALUES = 20;
    @Override
    public void draw(Graphics g, LinkedList values) {
        Graphics2D graphics2D = (Graphics2D)g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(Color.BLUE);
        for(int index = 0; index < values.size(); index++){
            if(index == 0){
                g.fillRect(501/MAX_NUMBER_OF_VALUES*index+6, (int)values.get(index), 1, 1);
            }else{
                g.drawLine(501/MAX_NUMBER_OF_VALUES*(index-1)+6, (int)values.get(index-1),
                        501/MAX_NUMBER_OF_VALUES*index+6, (int)values.get(index));
            }
        }
    }
}
