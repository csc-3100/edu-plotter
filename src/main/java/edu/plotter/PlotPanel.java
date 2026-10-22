package edu.plotter;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Displays a drawable Component inside a Swing panel.
 *
 * <p>Implements PropertyChangeListener so updates from Repository trigger a repaint.</p>
 */
public class PlotPanel extends JPanel implements PropertyChangeListener {

    private Component component;

    /** Creates a panel to display the given component. */
    public PlotPanel(Component component){
        this.component = component;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (component != null)
            component.draw(g);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}