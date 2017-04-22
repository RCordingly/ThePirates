package gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Robert on 4/12/17.
 */
public class GButton implements GUIComponent, MouseListener {

    private int height;

    private int x;

    private int y;

    private int width;

    private Color color;

    private Color hover;

    private boolean pressed = false;

    private Font font;

    private String text;

    public GButton(final int height, final Color main, final Color hover, final String text) {
        this.color = main;
        this.hover = hover;
        this.height = height;
        this.font = new Font("Helvetica", Font.PLAIN, height - 6);
        this.text = text;
    }

    public GButton(final int height, final Color main, final Color hover, final String text , final Font font) {
        this.color = main;
        this.hover = hover;
        this.height = height;
        this.font = font;
        this.text = text;
    }

    @Override
    public int draw(Graphics g, int x, int y, int width) {
        if (pressed) {
            g.setColor(hover);
        } else {
            g.setColor(color);
        }
        g.fillRect(x, y, width, height);
        this.x = x;
        this.y = y;
        this.width = width;
        g.setColor(Color.white);
        g.setFont(font);


        int textWidth = g.getFontMetrics().stringWidth(text);

        g.drawString(text, x + width / 2 - textWidth / 2, y + font.getSize());
        return height;
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height) {
            pressed = true;
            GUI.window.redraw();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getX() > x && e.getX() < x + width && e.getY() > y && e.getY() < y + height && pressed) {
            clickAction();
        }
        pressed = false;
        GUI.window.redraw();
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    /**
     * When you create a button override this method to add
     * custom functionality to certain buttons.
     */
    public void clickAction() {}
}