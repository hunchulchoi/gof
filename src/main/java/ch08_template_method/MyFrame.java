package ch08_template_method;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

  public MyFrame(String title) throws HeadlessException {
    super(title);

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400, 400);
    this.setVisible(true);
  }

  /**
   * hook method
   * @param g
   */
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    String msg = "내가 제일 잘나가";
    g.drawString(msg, 150, 150);
  }

  public static void main(String[] args) {
    MyFrame myFrame = new MyFrame("Head First Design Pattern");
  }
}
