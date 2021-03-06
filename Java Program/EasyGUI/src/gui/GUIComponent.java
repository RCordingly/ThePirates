package gui;

import java.awt.*;

/**
 * Created by Robert on 4/11/17.
 *
 * The basis of the entire component based GUI system.
 */
public interface GUIComponent {

    /**
     * Draw the elements for this object every frame.
     *
     * @param g The graphics object to draw to.
     * @param x The x origin of this object.
     * @param y The y origin of this object.
     * @param width The width of this object.
     * @return The height of this object.
     * @author Robert
     */
    int draw(Graphics g, final int x, final int y, final int width);
}
