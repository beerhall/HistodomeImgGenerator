/**
 * 
 */
package model;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import main.Imageable;
import main.RelativePosition;

/**
 * 图片处理器
 * 
 * @author BeerHall
 *
 */
public class ImgHandler implements Imageable {
  /**
   * 日志工具
   */
  private Logger log = LogManager.getLogger(ImgHandler.class.getName());
  /**
   * 底图
   */
  private BufferedImage baseImg;
  /**
   * 文本图层
   */
  private ArrayList<TextLayer> textLayers = new ArrayList<TextLayer>();
  /**
   * 相对位置
   */
  private RelativePosition pos = RelativePosition.LEFT_BOTTOM;
  /**
   * 绝对位置横坐标
   */
  private int x;
  /**
   * 绝对位置纵坐标
   */
  private int y;

  /**
   * 构造函数
   * 
   * @param _baseImg 底图
   * @param _pos 相对位置
   */
  public ImgHandler(BufferedImage _baseImg, RelativePosition _pos) {
    log.debug("构造ImgHandeler："+this.hashCode()+"，底图：" + _baseImg.toString() + "，相对位置：" + _pos.toString());
    setBaseImg(_baseImg);
    setPos(pos);
    calcPos();
  }

  /**
   * 构造函数
   * 
   * @param _baseImg 底图
   * @param _x 绝对横坐标
   * @param _y 绝对纵坐标
   */
  public ImgHandler(BufferedImage _baseImg, int _x, int _y) {
    log.debug("构造ImgHandeler，底图：" + _baseImg.toString() + "，绝对位置X：" + _x + "，Y：" + _y);
    setBaseImg(_baseImg);
    setX(_x);
    setY(_y);
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
   * 根据相对位置计算绝对位置
   */
  private void calcPos() {
    // TODO
  }

  /**
   * @return the baseImg
   */
  public BufferedImage getBaseImg() {
    return baseImg;
  }

  /**
   * @param baseImg the baseImg to set
   */
  public void setBaseImg(BufferedImage baseImg) {
    this.baseImg = baseImg;
  }

  /**
   * @return the textLayers
   */
  public ArrayList<TextLayer> getTextLayers() {
    return textLayers;
  }

  /**
   * @param textLayers the textLayers to set
   */
  public void setTextLayers(ArrayList<TextLayer> textLayers) {
    this.textLayers = textLayers;
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
    this.pos = pos;
  }

  /**
   * @return the x
   */
  public int getX() {
    return x;
  }

  /**
   * @param x the x to set
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * @return the y
   */
  public int getY() {
    return y;
  }

  /**
   * @param y the y to set
   */
  public void setY(int y) {
    this.y = y;
  }

}
