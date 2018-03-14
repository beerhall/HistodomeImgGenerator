/**
 * 
 */
package model;

import java.awt.Graphics;
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
   * 构造函数
   * 
   * @param _baseImg 底图
   */
  public ImgHandler(BufferedImage _baseImg) {
    log.debug("构造ImgHandeler：" + this.hashCode() + "，底图：" + _baseImg.toString());
    setBaseImg(_baseImg);
  }

  /*
   * (non-Javadoc)
   * 
   * @see main.Imageable#getImg()
   */
  @Override
  public BufferedImage getImg() {
    log.debug("获取ImgHandler：" + this.hashCode() + "的图像");
    BufferedImage img = getBaseImg();
    Graphics g = img.getGraphics();

    for (TextLayer layer : textLayers) {
      BufferedImage bi = layer.getImg();
      if (layer.getPos() != null) {
        calcPos(layer, bi.getWidth(), bi.getHeight());
      }
      log.debug("在ImgHandler：" + this.hashCode() + "画图层：" + layer.hashCode());
      g.drawImage(bi, layer.getX(), layer.getY(), null);
    }

    g.dispose();
    return img;
  }

  /**
   * 增加文本图层
   * 
   * @param layer 文本图层
   * @param pos 相对位置
   */
  public void addLayer(TextLayer layer, RelativePosition pos) {
    log.debug("在ImgHanlder：" + this.hashCode() + "中添加TextLayer：" + layer.hashCode() + "，相对位置："
        + pos.toString());
    layer.setPos(pos);
    textLayers.add(layer);
  }

  /**
   * 增加文本图层
   * 
   * @param layer 文本图层
   * @param X 绝对横坐标
   * @param Y 绝对纵坐标
   */
  public void addLayer(TextLayer layer, int X, int Y) {
    log.debug("在ImgHanlder中：" + this.hashCode() + "添加TextLayer：" + layer.hashCode() + "，绝对坐标X：" + X
        + "，Y：" + Y);
    layer.setX(X);
    layer.setY(Y);
    textLayers.add(layer);
  }

  /**
   * 计算绝对位置
   * 
   * @param layer 图层
   * @param layerWidth 图层宽
   * @param layerHeight 图层高
   */
  public void calcPos(TextLayer layer, int layerWidth, int layerHeight) {
    log.debug("在ImgHanlder：" + this.hashCode() + "中计算图层：" + layer.hashCode() + "的绝对位置");
    switch (layer.getPos()) {
      case LEFT_BOTTOM: {
        layer.setX(0);
        layer.setY(getBaseImg().getHeight() - layerHeight);
      }
        break;
      case LEFT_TOP: {
        layer.setX(0);
        layer.setY(0);
      }
        break;
      case RIGHT_BOTTOM: {
        layer.setX(getBaseImg().getWidth() - layerWidth);
        layer.setY(getBaseImg().getHeight() - layerHeight);
      }
        break;
      case RIGHT_TOP: {
        layer.setX(getBaseImg().getWidth() - layerWidth);
        layer.setY(0);
      }
        break;
      default:
        break;
    }
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

}
