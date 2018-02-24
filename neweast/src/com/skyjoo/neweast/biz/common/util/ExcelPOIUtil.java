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
 * Excel���ݶ�ȡ���� ֧��Excell2003,Excell2007
 * @author lxh
 * @version 2013-9-22 ����02:06:23
 */
public class ExcelPOIUtil {

    protected final Logger log      = Logger.getLogger(this.getClass());

    /** ������� */
    private int            maxRows  = 0;

    /** ������� */
    private int            maxCells = 0;

    /** ���췽�� */
    public ExcelPOIUtil() {
    }

    /**
     * �����ļ�����ȡexcel�ļ�
     */
    public List<ArrayList<String>> read(String fileName) {

        /** ����ļ��Ƿ���� */
        File file = new File(fileName);
        if (file == null || !file.exists()) {
            return null;
        }

        return read(file);
    }

    /**
     * �����ļ���ȡexcel�ļ�
     */
    public List<ArrayList<String>> read(File file) {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

        /** ����ļ����Ƿ�Ϊ�ջ����Ƿ���Excel��ʽ���ļ� */
        if (!file.getName().endsWith(".xls") && !file.getName().endsWith(".xlsx")) {
            return null;
        }

        boolean isExcel2003 = true;
        /** ���ļ��ĺϷ��Խ�����֤ */
        if (file.getName().endsWith(".xlsx")) {
            isExcel2003 = false;
        }

        try {
            /** ���ñ����ṩ�ĸ�������ȡ�ķ��� */
            dataLst = read(new FileInputStream(file), isExcel2003);
        } catch (Exception ex) {
            log.error("read Exception", ex);
        }

        /** ��������ȡ�Ľ�� */
        return dataLst;
    }

    public List<ArrayList<String>> read(MultipartFile file) {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

        /** ����ļ����Ƿ�Ϊ�ջ����Ƿ���Excel��ʽ���ļ� */
        if (!file.getOriginalFilename().endsWith(".xls") && !file.getOriginalFilename().endsWith(".xlsx")) {
            return null;
        }

        boolean isExcel2003 = true;
        /** ���ļ��ĺϷ��Խ�����֤ */
        if (file.getOriginalFilename().endsWith(".xlsx")) {
            isExcel2003 = false;
        }

        try {
            /** ���ñ����ṩ�ĸ�������ȡ�ķ��� */
            dataLst = read(file.getInputStream(), isExcel2003);
        } catch (Exception ex) {
            log.error("read Exception", ex);
        }

        /** ��������ȡ�Ľ�� */
        return dataLst;
    }
    
    /**
     * ��������ȡExcel�ļ�
     * @param inputStream
     * @param isExcel2003
     * @return
     */
    public List<ArrayList<String>> read(InputStream inputStream, boolean isExcel2003) {
        List<ArrayList<String>> dataLst = null;
        try {
            /** ���ݰ汾ѡ�񴴽�Workbook�ķ�ʽ */
            Workbook wb = isExcel2003 ? new HSSFWorkbook(inputStream) : new XSSFWorkbook(
                inputStream);
            dataLst = read(wb);
        } catch (IOException e) {
            log.error("read IOException", e);
        }
        return dataLst;
    }

    /**
     * ��ȡ����
     */
    private List<ArrayList<String>> read(Workbook wb) {
        List<ArrayList<String>> dataLst = new ArrayList<ArrayList<String>>();

        /** �õ���һ��shell */
        Sheet sheet = wb.getSheetAt(0);
        this.maxRows = sheet.getLastRowNum();
        /** ѭ��Excel���� */
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
            /** ѭ��Excel���� */
            for (int c = 0; c < cellnum; c++) {
                Cell cell = row.getCell(c);
                String cellValue = "";
                if (cell == null) {
                    rowLst.add(cellValue);
                    continue;
                }

                /** ���������͵�,�Զ�ȥ�� */
                if (Cell.CELL_TYPE_NUMERIC == cell.getCellType()) {
                    /** ��excel��,����Ҳ������,�ڴ�Ҫ�����ж� */
                    if (HSSFDateUtil.isCellDateFormatted(cell)) {
                        cellValue = getDateStr(cell.getDateCellValue());
                    } else {
                        cellValue = getRightStr(cell.getNumericCellValue() + "");
                    }
                }
                /** �����ַ����� */
                else if (Cell.CELL_TYPE_STRING == cell.getCellType()) {
                    cellValue = cell.getStringCellValue();
                }
                /** �������� */
                else if (Cell.CELL_TYPE_BOOLEAN == cell.getCellType()) {
                    cellValue = cell.getBooleanCellValue() + "";
                }
                /** ������,�����ϼ����������� */
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
     * ��ȷ�ش����������Զ���������
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
     * ��ʽ������
     * @param date
     * @return
     */
    private String getDateStr(Date date) {
        return sf.format(date);
    }

    /**
     * ��ȡ���ڸ�ʽ
     * @return
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * �������ڸ�ʽ
     * @param pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * �������
     * @return
     */
    public int getMaxRows() {
        return maxRows;
    }

    /**
     * �������
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
