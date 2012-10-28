import javax.swing.*;

class Main {
  public static void main(String args[]) {

    /*try {
            // Set cross-platform Java L&F (also called "Metal")
UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");

    }
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }*/
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        new Music();
	}
     });
  }
}
