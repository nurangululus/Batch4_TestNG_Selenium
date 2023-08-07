package com.kraftechnologie.tests.day20_ddf;

import com.kraftechnologie.utilities.ExcelUtil;
import org.testng.annotations.Test;

public class ExcelUtilDemo {

    @Test
    public void readExcelFile(){
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/Book1.xlsx","Sheet1");

        //how many rows in the sheet
        System.out.println("excelUtil.rowCount() = " + excelUtil.rowCount());

        //get first map from the list

    }
}
