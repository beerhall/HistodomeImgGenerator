/**
 * 
 */
package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.Alignment;
import main.Imageable;
import main.RelativePosition;

/**
 * 文本图层
 * 
 * @author BeerHall
 *
 */
public class TextLayer implements Imageable {
  /**
   * 日志
   */
  private Logger log = LogManager.getLogger(TextLayer.class.getName());
  /**
   * 文本列表
   */
  private ArrayList<TextLine> texts = new ArrayList<TextLine>();
  /**
   * 文本图像列表
   */
  private ArrayList<BufferedImage> imgs = new ArrayList<BufferedImage>();
  /**
   * 对齐方式
   */
  private Alignment alignment;
  /**
   * 相对位置
   */
  private RelativePosition pos = RelativePosition.LEFT_BOTTOM;

  /**
   * 
   */
  public TextLayer() {
    log.debug("构造TextLayer：" + this.hashCode());
    setAlignment(Alignment.LEFT);
    setPos(RelativePosition.LEFT_BOTTOM);
  }

  /**
   * 添加文本
   * 
   * @param textline 文本
   * @return true
   */
  public boolean addText(TextLine textline) {
    log.debug("添加文本：" + textline.getText());
    return getTexts().add(textline);
  }

  /*
   * (non-Javadoc)
   * 
   * @see main.Imageable#getImg()
   */
  @Override
  public BufferedImage getImg() {
    int width = 0;
    int height = 0;
    for (TextLine tl : texts) {
      log.debug(tl.getImg().getWidth()); // test
      imgs.add(tl.getImg());
    }
    for (BufferedImage bi : imgs) {
      if (width < bi.getWidth()) {
        width = bi.getWidth();
      }
      height += bi.getHeight();
    }
    log.debug("宽：" + width + "，高：" + height);
    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics g = img.getGraphics();
    g.setColor(new Color(0, 0, 0, 0));
    g.fillRect(0, 0, width, height);

    switch (getAlignment()) {
      case LEFT: {
        int y = 0;
        for (BufferedImage bi : imgs) {
          g.drawImage(bi, 0, y, null);
          y += bi.getHeight();
        }
      }
        break;
      case RIGHT: {
        int y = 0;
        for (BufferedImage bi : imgs) {
          log.debug(width + "\t" + bi.getWidth()); // test
          g.drawImage(bi, width - bi.getWidth(), y, null);
          y += bi.getHeight();
        }
      }
        break;
      case CENTER: {
        int y = 0;
        for (BufferedImage bi : imgs) {
          g.drawImage(bi, (width - bi.getWidth()) / 2, y, null);
          y += bi.getHeight();
        }
      }
        break;
      default:
        break;
    }
    g.dispose();

    return img;
  }

  /**
   * @return the texts
   */
  public ArrayList<TextLine> getTexts() {
    return texts;
  }

  /**
   * @param texts the texts to set
   */
  public void setTexts(ArrayList<TextLine> texts) {
    this.texts = texts;
  }

  /**
   * @return the alignment
   */
  public Alignment getAlignment() {
    return alignment;
  }

  /**
   * @param alignment the alignment to set
   */
  public void setAlignment(Alignment alignment) {
    log.debug("设置对齐方式：" + alignment.toString());
    this.alignment = alignment;
  }

  /**
   * @return the pos
   */
  public RelativePosition getPos() {
    return pos;
  }

  /**
   * @param pos the pos to set
   */
  public void setPos(RelativePosition pos) {
    log.debug("设置相对位置：" + pos.toString());
    this.pos = pos;
  }
}
