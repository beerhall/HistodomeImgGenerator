/**
 * 
 */
package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.Alignment;
import main.Imageable;

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
   * 对齐类型
   */
  private Alignment alignment;

  /**
   * 
   */
  public TextLayer() {
    log.debug("构造TextLayer："+this.hashCode());
    setAlignment(Alignment.LEFT);
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
    // TODO Auto-generated method stub
    return null;
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

}
