/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import model.ImgHandler;
import model.TextLayer;
import model.TextLine;
import util.ExcelReader;

/**
 * 主类
 * 
 * @author BeerHall
 *
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Logger log = LogManager.getLogger(Main.class.getName());
    try {
      BufferedImage bi = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_ARGB);
      Graphics g = bi.getGraphics();
      g.setColor(Color.BLUE);
      g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
      g.dispose();

      TextLine tl1 = new TextLine(new Font("微软雅黑", Font.BOLD, 150), 7000, "第9位", Alignment.CENTER,
          Color.BLACK);
      TextLine tl2 = new TextLine(new Font("微软雅黑", Font.PLAIN, 100), 7000, "1997年2月18日",
          Alignment.LEFT, Color.BLACK);

      TextLayer layer = new TextLayer();
      layer.addText(tl1);
      layer.addText(tl2);
      layer.setAlignment(Alignment.CENTER);

      ImgHandler ih = new ImgHandler(bi);
      ih.addLayer(layer);


      ImageIO.write(ih.getImg(), "png", new File("output\\test.png"));
      log.info("输出：test.png");
    } catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      log.error(stringWriter.toString());
      printWriter.close();
    }
  }
}
