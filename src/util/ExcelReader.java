/**
 * 
 */
package util;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Excel读取器
 * 
 * @author BeerHall
 *
 */
public class ExcelReader {
  /**
   * 读取Excel
   * 
   * @param file 文件
   * @return 第一列为键，每行剩下内容组成的ArrayList
   */
  static public HashMap<String, ArrayList<String>> readExcel(File file) {
    Logger log = LogManager.getLogger(ExcelReader.class.getName());
    log.debug("读取Excel文件：" + file.getName());
    HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
    return null;
  }

}
