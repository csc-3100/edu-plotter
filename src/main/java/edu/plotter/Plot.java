package edu.plotter;
import java.awt.*;
import java.util.List;
/** Draws a line plot and the average value. */
public final class Plot implements Component {
    static int xFor(int index, int width) { return 6 + index * Math.max(1, width - 12) / Repository.MAX_VALUES; }
    static int yFor(int value, int height) {
        return Math.max(0, height - 1 - value * Math.max(1, height - 12) / Repository.MAX_VALUE);
    }
    @Override public void draw(Graphics graphics) {
        Rectangle bounds = graphics.getClipBounds();
        int width = bounds == null ? 501 : Math.max(1, bounds.width);
        int height = bounds == null ? 190 : Math.max(1, bounds.height);
        if (graphics instanceof Graphics2D g2)
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        List<Integer> values = Repository.getInstance().getValues();
        graphics.setColor(Color.BLUE);
        for (int i = 0; i < values.size(); i++) {
            int x = xFor(i, width), y = yFor(values.get(i), height);
            if (i == 0) graphics.fillRect(x, y, 1, 1);
            else graphics.drawLine(xFor(i - 1, width), yFor(values.get(i - 1), height), x, y);
        }
        if (!values.isEmpty()) {
            int mean = (int) Math.round(values.stream().mapToInt(Integer::intValue).average().orElse(0));
            graphics.setColor(Color.RED);
            graphics.drawLine(0, yFor(mean, height), width, yFor(mean, height));
        }
    }
}
