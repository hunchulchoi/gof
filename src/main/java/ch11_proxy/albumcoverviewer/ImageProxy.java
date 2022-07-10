package ch11_proxy.albumcoverviewer;

import lombok.Synchronized;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Optional;

public class ImageProxy implements Icon {

  volatile ImageIcon imageIcon;
  final URL imageURL;
  Thread retrievalThead;
  boolean retrieving = false;

  public ImageProxy(URL imageURL) {
    this.imageURL = imageURL;
  }

  @Synchronized
  void setImageIcon(ImageIcon imageIcon){
    this.imageIcon = imageIcon;
  }

  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    Optional.ofNullable(imageIcon).ifPresentOrElse(ic->ic.paintIcon(c,g,x,y), ()->{
      g.drawString("앨범 커버를 불러오는 중입니다. 잠시만 기다려 주세요", x+300, y+190);
      if(!retrieving){
        retrieving = true;

        retrievalThead = new Thread(new Runnable() {
          @Override
          public void run() {
            try{
              setImageIcon(new ImageIcon(imageURL, "Album Cover"));
              c.repaint();
            }catch (Exception e){
              e.printStackTrace();
            }
          }
        });
        retrievalThead.start();
      }
    });
  }

  @Override
  public int getIconWidth() {
    return Optional.ofNullable(imageIcon).map(ImageIcon::getIconWidth).orElse(800);
  }

  @Override
  public int getIconHeight() {
    return Optional.ofNullable(imageIcon).map(ImageIcon::getIconHeight).orElse(600);
  }
}
