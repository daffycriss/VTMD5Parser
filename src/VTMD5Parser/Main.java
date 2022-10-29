/*
 * @author Ντάφος Χρήστος
 */

// Main Class Starts App

package VTMD5Parser;

import GuiDesign.Panel;
import org.jfree.ui.RefineryUtilities;

public class Main {

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Call of GUI App Basic Form
                // GUI Run
                Panel panel = new Panel();
                RefineryUtilities.centerFrameOnScreen(panel);
                panel.setVisible(true);
            }
        });
    }
}
