package edu.plotter;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.*;
class RepositoryTest {
    @Test void singletonIsShared() { assertSame(Repository.getInstance(), Repository.getInstance()); }
    @Test void valuesAreBoundedAndSnapshotsImmutable() {
        Repository model = Repository.getInstance();
        for (int i = 0; i < 25; i++) model.addValue(i);
        assertEquals(20, model.getSize());
        assertEquals(24, model.getValue(19));
        assertThrows(UnsupportedOperationException.class, () -> model.getValues().add(1));
        assertThrows(IllegalArgumentException.class, () -> model.addValue(-1));
    }
    @Test void observersReceiveUpdates() {
        Repository model = Repository.getInstance();
        AtomicInteger count = new AtomicInteger();
        PropertyChangeListener listener = e -> count.incrementAndGet();
        model.addPropertyChangeListener(listener);
        try { model.addValue(42); assertEquals(1, count.get()); }
        finally { model.removePropertyChangeListener(listener); }
    }
}
