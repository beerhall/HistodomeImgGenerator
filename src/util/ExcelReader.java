/**
 * 
 */
package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
   * @throws IOException
   */
  static public HashMap<String, ArrayList<String>> readExcel(File file) throws IOException {
    Logger log = LogManager.getLogger(ExcelReader.class.getName());
    log.debug("读取Excel文件：" + file.getName());
    HashMap<String, ArrayList<String>> data = new HashMap<String, ArrayList<String>>();
    try {
      FileInputStream fis = new FileInputStream(file);
      Workbook wb = new XSSFWorkbook(fis);
      Sheet sheet = wb.getSheetAt(0);
      for (Iterator<Row> i_row = sheet.rowIterator(); i_row.hasNext();) {
        Row row = i_row.next();
        String key = null;
        ArrayList<String> rowData = new ArrayList<String>();
        for (Iterator<Cell> i_cell = row.cellIterator(); i_cell.hasNext();) {
          Cell cell = i_cell.next();
          cell.setCellType(CellType.STRING);
          String value = cell.getStringCellValue();
          if (key == null) {
            key = value;
          } else {
            rowData.add(value);
          }
        }
        data.put(key, rowData);
      }
      wb.close();
    } catch (FileNotFoundException e) {
      log.error("FileNotFoundException - 未找到Excel文件：" + file.getName());
      log.error(e.getLocalizedMessage());
      e.printStackTrace();
      throw e;
    } catch (IOException e) {
      log.error("IOException - 输入/输出错误");
      log.error(e.getLocalizedMessage());
      e.printStackTrace();
      throw e;
    }
    return data;
  }

}
