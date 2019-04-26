package com.iss.util;

import com.iss.po.Books;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

public class ExcelUtil {

    public static void writeExcelFile(List<Books> list, String filename) {
        try {
            //定义一个excel的文件
            Workbook wb = null;

            //判断一下文件是否是xlsx结尾的，不是使用else部分的代码
            if (filename.endsWith("xlsx")) {
                wb = new XSSFWorkbook();//文件扩展名是xlsx
            } else {
                wb = new HSSFWorkbook();//文件扩展名xls
            }

            //定义表头
            String titleRow[] = {"编号", "书名", "作者", "单价"};

            //定义一个sheet页
            Sheet sheet = wb.createSheet("图书信息表");

            //将list添加到表格中
            //1.添加表头
            Row row = sheet.createRow(0);
            //创建单元格
            Cell cell = row.createCell(0);
            row.setHeight((short) 540);
            cell.setCellValue("BookShop图书表信息");

            //给单元格设置字体和样式
            CellStyle style = wb.createCellStyle();
            style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直对齐
            style.setAlignment(CellStyle.ALIGN_CENTER);//水平对齐
            style.setWrapText(true);//当指定单元格内容显示不下时，自动换行

            cell.setCellStyle(style);

            Font font = wb.createFont();
            font.setFontName("微软雅黑");
            font.setFontHeight((short) 280);
            style.setFont(font);

            //合并单元格
            sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));


            //第二行表头
            row = sheet.createRow(1);
            for (int i = 0; i < titleRow.length; i++) {
                cell = row.createCell(i);
                cell.setCellValue(titleRow[i]);
                cell.setCellStyle(style);
                sheet.setColumnWidth(i, 20 * 256);
            }
            row.setHeight((short) 540);


            //将list写入表格
            for (int i = 0; i < list.size(); i++) {
                row = sheet.createRow(i + 2);
                row.setHeight((short) 500);

                row.createCell(0).setCellValue(list.get(i).getBid());
                row.createCell(1).setCellValue(list.get(i).getBname());
                row.createCell(2).setCellValue(list.get(i).getAuthor());
                row.createCell(3).setCellValue(list.get(i).getPress());

            }


            //保存excel文件
            OutputStream outputStream = new FileOutputStream(filename);
            wb.write(outputStream);
            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readExcelFile(String filename) {
        try {
            FileInputStream inputStream = new FileInputStream(filename);

            Workbook wb = null;
            if (filename.endsWith("xlsx")) {
                wb = new XSSFWorkbook(inputStream);
            } else {
                wb = new HSSFWorkbook(inputStream);
            }

            //从excel文件中获取第一个sheet页
            Sheet sheet = wb.getSheetAt(0);


            //获取excel中的所有行
            Iterator<Row> rows = sheet.rowIterator();

            //跳过前两行
            rows.next();
            rows.next();


            while (rows.hasNext()) {
                Row row = rows.next();

                System.out.println(row.getCell(0).getStringCellValue() + "\t" + row.getCell(1).getStringCellValue()
                        + "\t" + row.getCell(2).getStringCellValue() + "\t" +
                        String.valueOf(row.getCell(3).getStringCellValue()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
