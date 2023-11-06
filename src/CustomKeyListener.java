import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CustomKeyListener implements KeyListener {

    public void keyPressed(KeyEvent e) {
        System.out.println("Key pressed: " + e.getKeyChar());
    }

    public void keyTyped(KeyEvent e) {
        // Not used in this example
    }

    public void keyReleased(KeyEvent e) {
        // Not used in this example
    }
}
