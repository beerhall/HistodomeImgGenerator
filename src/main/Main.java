/**
 * 
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
   * @throws Exception 
   */
  public static void main(String[] args) {
    Logger log = LogManager.getLogger(Main.class.getName());
    try {
      TextLine tl = new TextLine(new Font("微软雅黑",Font.PLAIN,100), 7000, "三1四t五2六3u七八九4v一N三1四6二十7三十四8十五9十六一二三1四五2六3七八九4十十5一十6二十7三十四8十五9十六一二三1四五2六3七八九4十十5一十6二十7三十四8十五9十六一二三1四五2六3七八九4十十5一十6二十7三十四8十五9十六一二三1四五2六3七八九4十十5一十6二十7三十四8十五9十六一二三1四五2六3七八九4十十5一十6二十7三十四8十五9十六一二三1四五2六3七八九4十十5一十6二十7三十四8十五9十六", Alignment.CENTER, Color.BLACK);
      tl.getImg();
      log.info("获取图像");
      ImageIO.write(tl.getImg(), "png", new File("output\\test.png"));
      log.info("输出：test.png");
    } catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      PrintWriter  printWriter  = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      log.error(stringWriter.toString());
      printWriter.close();
    }
  }
}
