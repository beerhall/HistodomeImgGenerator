/**
 * 
 */
package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
   * 文本列表
   */
  private ArrayList<TextLine> texts = new ArrayList<TextLine>();
  /**
   * 对齐类型
   */
  private Alignment alignment = Alignment.LEFT;

  /**
   * 
   */
  public TextLayer() {
    // TODO Auto-generated constructor stub
  }

  /**
   * 添加文本
   * 
   * @param textline 文本
   * @return true
   */
  public boolean addText(TextLine textline) {
    return getTexts().add(textline);
  }

  /* (non-Javadoc)
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
    this.alignment = alignment;
  }

}
