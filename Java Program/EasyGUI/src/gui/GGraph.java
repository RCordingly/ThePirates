package gui;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Robert on 4/30/17.
 *
 * This class draws a simple graph of a supplied data array.
 */
public class GGraph implements GUIComponent, GAnimation {

    /** All of the data that this graph will draw. */
    private static ArrayList<double[]> times;

    /** The largest value in the data. */
    private double largestValue = 0;

    /** The color of the various lines. */
    private Color[] lines = Style.graphBarColors;

    /** Used for the intro animation. */
    private double[] animation;

    /**
     * Creates a graph with the supplied data points.
     *
     * @param dataPoints The lines of the graph. Each element of the outer ArrayList is
     *                   a x point of the graph while each element of the double array is the y
     *                   value of a line on the graph.
     * @author Robert
     */
    public GGraph(final ArrayList<double[]> dataPoints) {
        times = dataPoints;
        for (double[] e : times) {
            for (double anE : e) {
                if (largestValue < anE) {
                    largestValue = anE;
                }
            }
        }
        animation = new double[times.size()];
    }


    @Override
    public int draw(Graphics g, int x, int y, int width) {

        int height = (int) ((width * 0.35));
        int paneX = (int) (width / 1.1);
        int paneY = (int) (height / 1.1);
        int offsetX = x + (int) (width * 0.05);
        int offsetY = y + (int) (height * 0.05) / 2;

        g.setColor(Color.black);
        g.drawLine(offsetX, offsetY, offsetX, offsetY + paneY);
        g.drawLine(offsetX, offsetY + paneY, offsetX + paneX, offsetY + paneY);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(2));

        int ticks = height / 30;
        if (ticks < 2) ticks = 2;

        g.setFont(Style.graphTicks);
        for (int i = 0; i < ticks; i++) {
            g.drawString(Integer.toString((int)(Math.round(largestValue / (ticks - 1) * i))), x, offsetY + paneY - paneY / (ticks - 1) * i);
        }

        for (int i = 0; i < times.size(); i++) {
            g.drawString(Integer.toString(i), offsetX + paneX / (times.size() - 1) * i, offsetY + paneY + 20);
        }
        int lastX = 0;
        int lastY = 0;
        double[] e = times.get(0);
        for (int j = 0; j < e.length; j++) {
            for (int i = 0; i < times.size(); i++) {
                e = times.get(i);

                g.setColor(lines[j]);
                int xPos = offsetX + paneX / (times.size() - 1) * i;

                double value = e[j];
                if (value < 0) value = 0;

                int yPos = offsetY + (int)((int) (paneY - value / largestValue * paneY) * animation[i]);
                if (animation[i] > 0) {
                    g.fillOval(xPos - 2, yPos - 2, 4, 4);
                    if (i != 0) {
                        g2d.drawLine(lastX, lastY, xPos, yPos);
                    }
                }
                lastX = xPos;
                lastY = yPos;
            }
        }

        return height;
    }

    @Override
    public void updateAnimations() {
        for (int i = 0; i < times.size(); i++) {
            if (i == 0) {
                animation[i] += (1 - animation[i]) / Style.graphMoveSpeed;
            } else {
                if (animation[i - 1] > Style.graphSpawnThreshold) {
                    animation[i] += (1 - animation[i]) / Style.graphMoveSpeed;
                }
            }
        }
    }
}
