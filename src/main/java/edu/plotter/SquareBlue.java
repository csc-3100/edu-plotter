package edu.plotter;
import java.awt.*;
/** Draws blue point markers over the wrapped plot. */
public final class SquareBlue extends Decorator {
    public SquareBlue(Component component) { super(component); }
    @Override public void draw(Graphics graphics) {
        Rectangle bounds = graphics.getClipBounds();
        int width = bounds == null ? 501 : bounds.width;
        int height = bounds == null ? 190 : bounds.height;
        graphics.setColor(Color.BLUE);
        Repository model = Repository.getInstance();
        for (int i = 0; i < model.getSize(); i++)
            graphics.fillRect(Plot.xFor(i, width) - 5, Plot.yFor(model.getValue(i), height) - 5, 10, 10);
        super.draw(graphics);
    }
}
