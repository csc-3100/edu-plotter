package edu.plotter;
import org.junit.jupiter.api.Test;
import java.awt.image.BufferedImage;
import static org.junit.jupiter.api.Assertions.*;
class PlotTest {
    @Test void decoratedPlotDrawsAtDifferentSizes() {
        Repository.getInstance().addValue(42);
        Component plot = new BarGray(new SquareBlue(new Plot()));
        for (int size : new int[]{120, 400}) {
            var graphics = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB).createGraphics();
            try {
                graphics.setClip(0, 0, size, size);
                assertDoesNotThrow(() -> plot.draw(graphics));
            } finally { graphics.dispose(); }
        }
    }
}
