package edu.plotter.modern;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

/**
 * Stores the shared data series and notifies observing plot panels.
 *
 * <p>Demonstrates a simple Singleton and JavaBeans property-change notifications. The mutable collection and lazy singleton are intentionally kept as teaching discussion points.</p>
 */
public class Repository extends PropertyChangeSupport {

    private static Repository instance = null;
    private ArrayList<Integer> values = new ArrayList<Integer>();

    private Repository(){
      super(new Object());
    }

    /** Returns the shared Repository instance. */
    public static Repository getInstance(){
        if (instance == null){
            instance = new Repository();
        }
        return instance;
    }
    /** Appends a random value and fires a property-change event. */
    public void create(){
        int value = 5 + (int) Math.ceil(Math.random() * 150);
        values.add(value);
        int MAX_NUMBER_OF_VALUES = 20;
        if (values.size() > MAX_NUMBER_OF_VALUES){
            values.remove(0);
        }
        firePropertyChange("value", null, value);
    }
    public int getValue(int position){
        return values.get(position);
    }

    public int getSize() {
        return values.size();
    }

    /** Returns the underlying mutable list (kept for classroom discussion). */
    public ArrayList<Integer> getValues() {
        return values;
    }
}
