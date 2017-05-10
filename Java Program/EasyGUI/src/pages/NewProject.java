package pages;

import gui.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by robertcordingly on 5/10/17.
 */
public class NewProject extends GUIPage {

    /**
     * Create a page and sets it's name.
     */
    public NewProject() {
        super("New");
    }

    @Override
    public void build() {
        GUI.window.add(new GSpacer(80));
        GDivider div = new GDivider(240, 3);
        GDivider cell1 = new GDivider(240);
        BufferedImage image;
        try {
            image = ImageIO.read(new File("img/insulation.png"));
        } catch (Exception ex) {
            image = null;
        }
        cell1.add(new GButton(277, mainColor, secondaryColor, "Insulation", new Font("Helvetica", Font.PLAIN, 20),32, image));
        cell1.add(new GSpacer(32));
        GDivider cell2 = new GDivider(240);
        try {
            image = ImageIO.read(new File("img/lightbulb.png"));
        } catch (Exception ex) {
            image = null;
        }
        cell2.add(new GButton(277, mainColor, secondaryColor, "Lights", new Font("Helvetica", Font.PLAIN, 20),32, image));
        cell2.add(new GSpacer(32));
        GDivider cell3 = new GDivider(240);
        try {
            image = ImageIO.read(new File("img/fridge.png"));
        } catch (Exception ex) {
            image = null;
        }
        cell3.add(new GButton(277, mainColor, secondaryColor, "Refrigerator", new Font("Helvetica", Font.PLAIN, 20),32, image));
        cell3.add(new GSpacer(32));
        GDivider cell4 = new GDivider(240);
        try {
            image = ImageIO.read(new File("img/washingMachine.gif"));
        } catch (Exception ex) {
            image = null;
        }
        cell4.add(new GButton(277, mainColor, secondaryColor, "Washing Machine", new Font("Helvetica", Font.PLAIN, 20),32, image));
        cell4.add(new GSpacer(32));
        GDivider cell5 = new GDivider(240);
        try {
            image = ImageIO.read(new File("img/dryer.gif"));
        } catch (Exception ex) {
            image = null;
        }
        cell5.add(new GButton(277, mainColor, secondaryColor, "Dryer", new Font("Helvetica", Font.PLAIN, 20),32, image));
        cell5.add(new GSpacer(32));
        div.add(cell1);
        div.add(cell2);
        div.add(cell3);
        div.add(cell4);
        div.add(cell5);
        GUI.window.add(div);
        GUI.window.add(menu);
    }
}
