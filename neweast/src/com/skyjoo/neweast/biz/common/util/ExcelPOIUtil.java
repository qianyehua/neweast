package com.skyjoo.neweast.biz.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

/**
/**
 * Excel数据读取工具 支持Excell2003,Excell2007
 * @author lxh
 * @version 2013-9-22 下午02:06:23
 */
public class ExcelPOIUtil {

    protected final Logger log      = Logger.getLogger(this.getClass());

    /** 最大行数 */
    private int            maxRows  = 0;

    /** 最大列数 */
    private int            maxCells = 0;

    /** 构造方法 */
    public ExcelPOIUtil() {
    }

    /**
     * 根据文件名读取excel文件
     */
    public List<ArrayList<String>> read(String fileName) {

        /** 检查文件是否存在 */
        File file = new File(fileName);
        if (file == null || !file.exists()) {
            return null;
        }

        return read(file);
    }

    /**
     * 根据文件读取excel文件
     */
    public List<ArrayList<String>> read(File file) {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

        /** 检查文件名是否为空或者是否是Excel格式的文件 */
        if (!file.getName().endsWith(".xls") && !file.getName().endsWith(".xlsx")) {
            return null;
        }

        boolean isExcel2003 = true;
        /** 对文件的合法性进行验证 */
        if (file.getName().endsWith(".xlsx")) {
            isExcel2003 = false;
        }

        try {
            /** 调用本类提供的根据流读取的方法 */
            dataLst = read(new FileInputStream(file), isExcel2003);
        } catch (Exception ex) {
            log.error("read Exception", ex);
        }

        /** 返回最后读取的结果 */
        return dataLst;
    }

    public List<ArrayList<String>> read(MultipartFile file) {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

        /** 检查文件名是否为空或者是否是Excel格式的文件 */
        if (!file.getOriginalFilename().endsWith(".xls") && !file.getOriginalFilename().endsWith(".xlsx")) {
            return null;
        }

        boolean isExcel2003 = true;
        /** 对文件的合法性进行验证 */
        if (file.getOriginalFilename().endsWith(".xlsx")) {
            isExcel2003 = false;
        }

        try {
            /** 调用本类提供的根据流读取的方法 */
            dataLst = read(file.getInputStream(), isExcel2003);
        } catch (Exception ex) {
            log.error("read Exception", ex);
        }

        /** 返回最后读取的结果 */
        return dataLst;
    }
    
    /**
     * 根据流读取Excel文件
     * @param inputStream
     * @param isExcel2003
     * @return
     */
    public List<ArrayList<String>> read(InputStream inputStream, boolean isExcel2003) {
        List<ArrayList<String>> dataLst = null;
        try {
            /** 根据版本选择创建Workbook的方式 */
            Workbook wb = isExcel2003 ? new HSSFWorkbook(inputStream) : new XSSFWorkbook(
                inputStream);
            dataLst = read(wb);
        } catch (IOException e) {
            log.error("read IOException", e);
        }
        return dataLst;
    }

    /**
     * 读取数据
     */
    private List<ArrayList<String>> read(Workbook wb) {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

        /** 得到第一个shell */
        Sheet sheet = wb.getSheetAt(0);
        this.maxRows = sheet.getLastRowNum();
        /** 循环Excel的行 */
        for (int r = 0; r <= this.maxRows; r++) {
            Row row = sheet.getRow(r);
            if (row == null) {
                continue;
            }
            int cellnum = row.getLastCellNum();
            if (cellnum < 0)
                continue;
            if (cellnum > this.maxCells) {
                this.maxCells = cellnum;
            }
            ArrayList<String> rowLst = new ArrayList<String>(cellnum);
            /** 循环Excel的列 */
            for (int c = 0; c < cellnum; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (cell == null) {
                    rowLst.add(cellValue);
                    continue;
                }

                /** 处理数字型的,自动去零 */
                if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                    /** 在excel里,日期也是数字,在此要进行判断 */
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        cellValue = getDateStr(cell.getDateCellValue());
                    } else {
                        cellValue = getRightStr(cell.getNumericCellValue() + "");
                    }
                }
                /** 处理字符串型 */
                else if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                    cellValue = cell.getStringCellValue();
                }
                /** 处理布尔型 */
                else if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
                    cellValue = cell.getBooleanCellValue() + "";
                }
                /** 其它的,非以上几种数据类型 */
                else {
                    cellValue = cell.toString() + "";
                }

                rowLst.add(cellValue);
            }
            dataLst.add(rowLst);
        }
        return dataLst;
    }

    /**
     * 正确地处理整数后自动加零的情况
     * @return
     */
    private String getRightStr(String sNum) {
        DecimalFormat decimalFormat = new DecimalFormat("#.000000");
        String resultStr = decimalFormat.format(new Double(sNum));
        if (resultStr.matches("^[-+]?\\d+\\.[0]+$")) {
            resultStr = resultStr.substring(0, resultStr.indexOf("."));
        }
        return resultStr;
    }

    private String   pattern = "yyyyMMdd HH:mm:ss";
    SimpleDateFormat sf      = new SimpleDateFormat(pattern);

    /**
     * 格式化日期
     * @param date
     * @return
     */
    private String getDateStr(Date date) {
        return sf.format(date);
    }

    /**
     * 获取日期格式
     * @return
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * 设置日期格式
     * @param pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * 最大行数
     * @return
     */
    public int getMaxRows() {
        return maxRows;
    }

    /**
     * 最大列数
     * @return
     */
    public int getMaxCells() {
        return maxCells;
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        List<ArrayList<String>> dataLst = new ExcelPOIUtil()
            .read("C:/Users/Administrator/Desktop/11.xlsx");
        if (dataLst != null) {
            for (ArrayList<String> innerLst : dataLst) {
                StringBuffer rowData = new StringBuffer();
                for (String dataStr : innerLst) {
                    rowData.append("[").append(dataStr).append("]");
                }
                if (rowData.length() > 0) {
                    System.out.println(rowData.toString());
                }
            }
        }
    }
}
