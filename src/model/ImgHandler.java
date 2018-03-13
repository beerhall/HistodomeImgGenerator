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
    log.debug("构造ImgHandeler，底图：" + _baseImg.toString());
    setBaseImg(_baseImg);
  }

  /*
   * (non-Javadoc)
   * 
   * @see main.Imageable#getImg()
   */
  @Override
  public BufferedImage getImg() {
    BufferedImage img = getBaseImg();
    Graphics g = img.getGraphics();
    g.drawImage(img, 0, 0, null);

    for (TextLayer layer : textLayers) {
      BufferedImage bi = layer.getImg();
      switch (layer.getPos()) {
        case LEFT_BOTTOM: {
          int x = 0;
          int y = img.getHeight() - bi.getHeight();
          g.drawImage(bi, x, y, null);
        }
          break;
        case LEFT_TOP: {
          int x = 0;
          int y = 0;
          g.drawImage(bi, x, y, null);
        }
          break;
        case RIGHT_BOTTOM: {
          int x = img.getWidth() - bi.getWidth();
          int y = img.getHeight() - bi.getHeight();
          g.drawImage(bi, x, y, null);
        }
          break;
        case RIGHT_TOP: {
          int x = img.getWidth() - bi.getWidth();
          int y = 0;
          g.drawImage(bi, x, y, null);
        }
          break;
        default:
          break;
      }
    }

    g.dispose();
    return img;
  }

  /**
   * 增加文本图层
   * 
   * @param layer 文本图层
   */
  public void addLayer(TextLayer layer) {
    textLayers.add(layer);
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
