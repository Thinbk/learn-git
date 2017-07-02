
package btap;

/**
 *
 * @author win7
 */

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;

public class NewClass1 {
  public static void main(String[] args) throws IOException {
    JFrame frame = new JFrame();
    frame.addWindowListener(new WindowListener() {
      @Override
      public void windowOpened(WindowEvent e) {
        System.out.println("JFrame has  been  made visible first  time");
      }

      @Override
      public void windowClosing(WindowEvent e) {
        System.out.println("JFrame is closing.");
      }

      @Override
      public void windowClosed(WindowEvent e) {
        System.out.println("JFrame is closed.");
      }

      @Override
      public void windowIconified(WindowEvent e) {
        System.out.println("JFrame is  minimized.");
      }

      @Override
      public void windowDeiconified(WindowEvent e) {
        System.out.println("JFrame is restored.");
      }

      @Override
      public void windowActivated(WindowEvent e) {
        System.out.println("JFrame is activated.");
      }

      @Override
      public void windowDeactivated(WindowEvent e) {
        System.out.println("JFrame is deactivated.");
      }
    });

    // Use the WindowAdapter class to intercept only the window closing event
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.out.println("JFrame is closing.");
      }
    });

  }
}
    