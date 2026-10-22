package edu.plotter;
import java.awt.*;
/** Draws gray bars behind the wrapped plot. */
public final class BarGray extends Decorator {
    public BarGray(Component component) { super(component); }
    @Override public void draw(Graphics graphics) {
        Rectangle bounds = graphics.getClipBounds();
        int width = bounds == null ? 501 : bounds.width;
        int height = bounds == null ? 190 : bounds.height;
        graphics.setColor(Color.GRAY);
        Repository model = Repository.getInstance();
        for (int i = 0; i < model.getSize(); i++) {
            int x = Plot.xFor(i, width), y = Plot.yFor(model.getValue(i), height);
            graphics.fillRect(x - 5, y, 10, Math.max(0, height - y));
        }
        super.draw(graphics);
    }
}
