import javax.swing.*;
import javax.swing.UIManager.*;

class Main {
  public static void main(String args[]) {
try {
    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
            UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
} catch (Exception e) {
    // If Nimbus is not available, you can set the GUI to another look and feel.
}
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Music();
	}
     });
  }
}
