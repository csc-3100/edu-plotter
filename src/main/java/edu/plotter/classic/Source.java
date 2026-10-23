package edu.plotter.classic;

import java.util.Observable;
/**
 * Produces values and notifies observers using the legacy Java Observable API.
 * <p>Original CSC308 implementation, preserved for comparison.</p>
 */
public class Source extends Observable{
    private int value;
    private static final int MAX_VALUE = 175;
    public void create(){
        value = 5 + (int) Math.ceil(Math.random() * MAX_VALUE);
        setChanged();
        notifyObservers();
    }
    public int getValue(){
        return value;
    }
}
