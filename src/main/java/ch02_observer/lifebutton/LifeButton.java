package ch02_observer.lifebutton;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LifeButton extends JFrame {

  public LifeButton() throws HeadlessException {
    JTextPane panel = new JTextPane();
    panel.setBounds(10, 10, 280, 200);
    JButton button = new JButton("할까 말까");
    button.setBounds(10, 220, 280, 30);

    Random random = new Random();

    button.addActionListener(e->panel.setBackground(random.nextBoolean()?Color.CYAN:Color.RED));

    add(panel);
    add(button);
    setSize(300, 300);
    setLayout(null);
    setVisible(true);
  }

  public static void main(String[] args) {
    new LifeButton();//
  }
}
