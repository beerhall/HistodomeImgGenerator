/**
 * 
 */
package model;

import java.awt.Font;
import java.awt.image.BufferedImage;
import main.Imageable;

/**
 * 文本行
 * 
 * @author BeerHall
 *
 */
public class TextLine implements Imageable {
  /**
   * 字体
   */
  private Font font;
  /**
   * 长度限制
   */
  private int limit = 0;
  /**
   * 文本
   */
  private String text;

  /**
   * 构造函数
   * 
   * @param _font 字体
   * @param _limit 长度限制
   * @param _text 文本
   */
  public TextLine(Font _font, int _limit, String _text) {
    setFont(_font);
    setLimit(_limit);
    setText(_text);
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
   * @return the font
   */
  public Font getFont() {
    return font;
  }

  /**
   * @param font the font to set
   */
  public void setFont(Font font) {
    this.font = font;
  }

  /**
   * @return the limit
   */
  public int getLimit() {
    return limit;
  }

  /**
   * @param limit the limit to set
   */
  public void setLimit(int limit) {
    this.limit = limit;
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

}
