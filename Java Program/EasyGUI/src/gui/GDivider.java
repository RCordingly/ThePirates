package gui;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 4/23/17.
 */
public class GDivider implements GUIComponent {

    private int cellWidth;

    private int cellHeight;

    ArrayList<GUIComponent> components = new ArrayList<>();

    public GDivider(final int cellWidth) {
        this.cellWidth = cellWidth;
    }

    public void add(GUIComponent c) {
        components.add(c);
    }

    @Override
    public int draw(Graphics g, int x, int y, int width) {
        int cellsPerRow = (int) (Math.floor(width / cellWidth));
        //int cellWidth = width / cellsPerRow;

        int rowHeight = 0;
        int maxHeight = 0;
        for (int i = 0; i < components.size(); i++) {
            GUIComponent part = components.get(i);
            int lastHeight = part.draw(g, x + (cellWidth * (i % cellsPerRow)), y + rowHeight, cellWidth);
            if (lastHeight > maxHeight) {
                maxHeight = lastHeight;
            }
            if ((i + 1) % cellsPerRow == 0) {
                rowHeight += maxHeight;
                maxHeight = 0;
            }
        }
            rowHeight += maxHeight;

        return rowHeight;
    }
}