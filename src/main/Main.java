/**
 * 
 */
package main;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ExcelReader;

/**
 * 主类
 * 
 * @author BeerHall
 *
 */
public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {
    Logger log = LogManager.getLogger(Main.class.getName());
    try {
      HashMap<String, ArrayList<String>> data =
          ExcelReader.readExcel(new File("input\\test\\timeline.xlsx"));
      for (String key : data.keySet()) {
        System.out.print(key + "\t");
        for (String value : data.get(key)) {
          System.out.print(value + "\t");
        }
        System.out.println();
      }
    } catch (IOException e) {
      log.error(e);
      e.printStackTrace();
    } catch (Exception e) {
      StringWriter stringWriter = new StringWriter();
      PrintWriter  printWriter  = new PrintWriter(stringWriter);
      e.printStackTrace(printWriter);
      log.error(stringWriter.toString());
      printWriter.close();
      throw e;
    }
  }
}
