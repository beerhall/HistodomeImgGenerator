/**
 * 
 */
package main;

import java.awt.image.BufferedImage;

/**
 * 可生成图像
 * 
 * @author BeerHall
 *
 */
public interface Imageable {
  /**
   * 生成图像
   * 
   * @return 生成的图像
   */
  public BufferedImage getImg();
}
