package edu.plotter;
import java.beans.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
/** Shared observable in-memory data series. */
public final class Repository {
    public static final int MAX_VALUES = 20;
    public static final int MAX_VALUE = 155;
    private final PropertyChangeSupport changes = new PropertyChangeSupport(this);
    private final List<Integer> values = new ArrayList<>();
    private Repository() {}
    private static final class Holder { private static final Repository INSTANCE = new Repository(); }
    /** Returns the single shared model. */
    public static Repository getInstance() { return Holder.INSTANCE; }
    /** Generates a new value. Call from the Swing event thread. */
    public void create() { addValue(ThreadLocalRandom.current().nextInt(6, MAX_VALUE + 1)); }
    /** Adds a value and notifies observers. */
    public void addValue(int value) {
        if (value < 0 || value > MAX_VALUE) throw new IllegalArgumentException("Value out of range");
        if (values.size() == MAX_VALUES) values.remove(0);
        values.add(value);
        changes.firePropertyChange("value", null, value);
    }
    public void addPropertyChangeListener(PropertyChangeListener listener) { changes.addPropertyChangeListener(listener); }
    public void removePropertyChangeListener(PropertyChangeListener listener) { changes.removePropertyChangeListener(listener); }
    public int getValue(int index) { return values.get(index); }
    public int getSize() { return values.size(); }
    /** Returns an immutable snapshot. */
    public List<Integer> getValues() { return List.copyOf(values); }
}
