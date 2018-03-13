/**
 * 
 */
package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.Alignment;
import main.Imageable;

/**
 * 文本行
 * 
 * @author BeerHall
 *
 */
public class TextLine implements Imageable {
  /**
   * 日志工具
   */
  private Logger log = LogManager.getLogger(TextLine.class.getName());
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
   * 对齐方式
   */
  private Alignment alignment;
  /**
   * 颜色
   */
  private Color color;

  /**
   * 构造函数
   * 
   * @param _font 字体
   * @param _limit 长度限制
   * @param _text 文本
   * @param _alignment 对齐类型
   * @param _color 颜色
   */
  public TextLine(Font _font, int _limit, String _text, Alignment _alignment, Color _color) {
    log.debug("构造TextLine：" + this.hashCode() + "，字体：" + _font.getName() + "，大小：" + _font.getSize()
        + "，样式：" + _font.getStyle() + "，长度限制：" + _limit + "，文本内容：" + _text + "，对齐方式："
        + _alignment.toString() + "，颜色：" + _color.toString());
    setFont(_font);
    setLimit(_limit);
    setText(_text);
    setAlignment(_alignment);
    setColor(_color);
  }

  /*
   * (non-Javadoc)
   * 
   * @see main.Imageable#getImg()
   */
  @Override
  public BufferedImage getImg() {
    Color transparent = new Color(0, 0, 0, 0);
    BufferedImage img;
    Graphics g = (new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)).getGraphics();;
    if (getLimit() == 0) {
      img = new BufferedImage((int) (getRealLength(getText())),
          (int) g.getFontMetrics(getFont()).getHeight(), BufferedImage.TYPE_INT_ARGB);
      g = img.getGraphics();
      g.setColor(transparent);
      g.fillRect(0, 0, img.getWidth(), img.getHeight());
      g.setColor(getColor());
      g.setFont(getFont());
      g.drawString(getText(), 0, (int) (g.getFontMetrics().getAscent()));
      g.dispose();
    } else {
      ArrayList<String> strs = splitStr(getText());
      int width = limit;
      if (strs.size() == 1) {
        width = (int) (getRealLength(getText()));
      }
      img = new BufferedImage(width, strs.size() * g.getFontMetrics(getFont()).getHeight(),
          BufferedImage.TYPE_INT_ARGB);
      g = img.getGraphics();
      g.setColor(transparent);
      g.fillRect(0, 0, img.getWidth(), img.getHeight());
      g.setColor(getColor());
      g.setFont(getFont());
      float y = g.getFontMetrics(getFont()).getAscent();
      for (String str : strs) {
        if (getAlignment() == Alignment.LEFT) {
          g.drawString(str, 0, (int) y);
        } else if (getAlignment() == Alignment.RIGHT) {
          g.drawString(str, (int) (width - getRealLength(str)), (int) y);
        } else if (getAlignment() == Alignment.CENTER) {
          g.drawString(str, (int) ((width - getRealLength(str)) / 2), (int) y);
        } else {
          log.error("对齐方式错误");
        }
        y += g.getFontMetrics().getHeight();
      }
      g.dispose();
    }
    return img;
  }

  /**
   * 获取真实长度
   * 
   * @param str 字符串
   * @return 字符串的真实长度
   */
  private float getRealLength(String str) {
    Graphics g = (new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB)).getGraphics();
    float length = 0;
    for (int i = 0; i < str.length(); i++) {
      length += g.getFontMetrics(getFont()).charWidth(str.charAt(i));
    }
    return length;
  }

  /**
   * 分离字符串
   * 
   * @param str 字符串
   * @return 分离的字符串
   */
  private ArrayList<String> splitStr(String str) {
    ArrayList<String> lines = new ArrayList<String>();
    if (getRealLength(str) > getLimit()) {
      String str_clone = str;
      while (getRealLength(str_clone) > getLimit()) {
        int start = 0;
        int end = str_clone.length();
        while (getRealLength(str_clone.substring(start, end)) > getLimit()) {
          end--;
        }
        lines.add(str_clone.substring(start, end));
        str_clone = str_clone.substring(end);
      }
      lines.add(str_clone);
    } else {
      lines.add(str);
    }
    return lines;
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

  /**
   * @return the color
   */
  public Color getColor() {
    return color;
  }

  /**
   * @param color the color to set
   */
  public void setColor(Color color) {
    this.color = color;
  }

}
