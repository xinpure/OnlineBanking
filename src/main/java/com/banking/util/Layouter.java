package com.banking.util;

import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;


public class Layouter {

  private static Logger logger = Logger.getLogger("service");

  /**
   * Builds the report layout. 
   * <p>
   * This doesn't have any data yet. This is your template.
   */
  public static void buildReport(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
    // Set column widths
    worksheet.setColumnWidth(0, 5000);
    worksheet.setColumnWidth(1, 5000);
    worksheet.setColumnWidth(2, 5000);
    worksheet.setColumnWidth(3, 5000);
    worksheet.setColumnWidth(4, 5000);
    worksheet.setColumnWidth(5, 5000);
    worksheet.setColumnWidth(6, 5000);
    worksheet.setColumnWidth(7, 5000);
    worksheet.setColumnWidth(8, 5000);

    // Build the title and date headers
    buildTitle(worksheet, startRowIndex, startColIndex);
    // Build the column headers
    buildHeaders(worksheet, startRowIndex, startColIndex);
  }

  /**
   * Builds the report title and the date header
   * 
   * @param worksheet
   * @param startRowIndex starting row offset
   * @param startColIndex starting column offset
   */
  public static void buildTitle(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
    // Create font style for the report title
    Font fontTitle = worksheet.getWorkbook().createFont();
    fontTitle.setBoldweight(Font.BOLDWEIGHT_BOLD);
    fontTitle.setFontHeight((short) 500);

    // Create cell style for the report title
    HSSFCellStyle cellStyleTitle = worksheet.getWorkbook().createCellStyle();
    cellStyleTitle.setAlignment(CellStyle.ALIGN_CENTER);
    cellStyleTitle.setWrapText(true);
    cellStyleTitle.setFont(fontTitle);

    // Create report title
    HSSFRow rowTitle = worksheet.createRow((short) startRowIndex);
    rowTitle.setHeight((short) 800);
    HSSFCell cellTitle = rowTitle.createCell(startColIndex);
    cellTitle.setCellValue("User Report");
    cellTitle.setCellStyle(cellStyleTitle);

    // Create merged region for the report title
    worksheet.addMergedRegion(new CellRangeAddress(0,0,0,5));

    // Create date header
    HSSFRow dateTitle = worksheet.createRow((short) startRowIndex +1);
    HSSFCell cellDate = dateTitle.createCell(startColIndex);
    cellDate.setCellValue("This report was generated at " + new Date());
  }

  /**
   * Builds the column headers
   * 
   * @param worksheet
   * @param startRowIndex starting row offset
   * @param startColIndex starting column offset
   */
  public static void buildHeaders(HSSFSheet worksheet, int startRowIndex, int startColIndex) {
    // Create font style for the headers
    Font font = worksheet.getWorkbook().createFont();
    font.setBoldweight(Font.BOLDWEIGHT_BOLD);

    // Create cell style for the headers
    HSSFCellStyle headerCellStyle = worksheet.getWorkbook().createCellStyle();
    headerCellStyle.setFillBackgroundColor(HSSFColor.GREY_25_PERCENT.index);
    headerCellStyle.setFillPattern(CellStyle.FINE_DOTS);
    headerCellStyle.setAlignment(CellStyle.ALIGN_CENTER);
    headerCellStyle.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
    headerCellStyle.setWrapText(true);
    headerCellStyle.setFont(font);
    headerCellStyle.setBorderBottom(CellStyle.BORDER_THIN);

    // Create the column headers
    HSSFRow rowHeader = worksheet.createRow((short) startRowIndex +2);
    rowHeader.setHeight((short) 500);

    HSSFCell cell1 = rowHeader.createCell(startColIndex+0);
    cell1.setCellValue("userID");
    cell1.setCellStyle(headerCellStyle);

    HSSFCell cell2 = rowHeader.createCell(startColIndex+1);
    cell2.setCellValue("username");
    cell2.setCellStyle(headerCellStyle);

    HSSFCell cell3 = rowHeader.createCell(startColIndex+2);
    cell3.setCellValue("password");
    cell3.setCellStyle(headerCellStyle);

    HSSFCell cell4 = rowHeader.createCell(startColIndex+3);
    cell4.setCellValue("phoneNum");
    cell4.setCellStyle(headerCellStyle);

    HSSFCell cell5 = rowHeader.createCell(startColIndex+4);
    cell5.setCellValue("address");
    cell5.setCellStyle(headerCellStyle);

    HSSFCell cell6 = rowHeader.createCell(startColIndex+5);
    cell6.setCellValue("email");
    cell6.setCellStyle(headerCellStyle);
    
    HSSFCell cell7 = rowHeader.createCell(startColIndex+6);
    cell7.setCellValue("birth");
    cell7.setCellStyle(headerCellStyle);

    HSSFCell cell8 = rowHeader.createCell(startColIndex+7);
    cell8.setCellValue("ssn");
    cell8.setCellStyle(headerCellStyle);

    HSSFCell cell9 = rowHeader.createCell(startColIndex+8);
    cell9.setCellValue("available");
    cell9.setCellStyle(headerCellStyle);
  }
}
