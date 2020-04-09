package com.lin.springboot.controller;

import com.lin.springboot.mapper.CityMapper;
import com.lin.springboot.pojo.City;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@Controller
public class ExcelController {

    @Autowired
    private CityMapper cityMapper;

    @RequestMapping("/export/excel01")
    @ResponseBody
    public Object ExportCityExcel01(HttpServletResponse response) {

        try {
            //1.创建一个excel文件簿（创建对象）
            Workbook wb = new HSSFWorkbook();


            //2.创建一个表格sheet
            Sheet sheet = wb.createSheet("city");

            //3.创建一个行row,首行
            Row sheetRow = sheet.createRow(0);

            //4.创建一个cell，首行单元格
            Cell headCell = null;
            Class<?> c = Class.forName("com.lin.springboot.pojo.City");
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i <fields.length; i++) {
                headCell = sheetRow.createCell(i);
                headCell.setCellValue(fields[i].getName());
            }

            //5.循环List,将信息写入表格

            List<City> cities = cityMapper.selectAll();
            City city = null;
            Row rowData = null;
            Cell cellData = null;
            String name = null;
            String nameFirsttoUpperCase = null;
            Method method = null;
            for (int j = 0; j < cities.size(); j++) {

                city = cities.get(j);

                rowData = sheet.createRow(j+1);

                for (int k = 0; k <fields.length; k++) {
                    cellData = rowData.createCell(k);
                    name = fields[k].getName();
                    nameFirsttoUpperCase = name.substring(0, 1).toUpperCase() + name.substring(1);
                    method = c.getMethod("get"+nameFirsttoUpperCase);

                    String strData = method.invoke(city).toString();

                    cellData.setCellValue(strData);
                }




            }





            //6.文件名
            String fileName = "city.xls";

            //7.导出文件
            response.setHeader("Content-Disposition","attachment;filename="+fileName);


            wb.write(response.getOutputStream());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //return只能返回null
        return null;
    }

    @RequestMapping("/export/excel02")
    @ResponseBody
    public Object ExportCityExcel02(HttpServletResponse response) {

        try {
            //1.创建一个excel文件簿（创建对象）
            Workbook wb = new XSSFWorkbook();


            //2.创建一个表格sheet
            Sheet sheet = wb.createSheet("city");

            //3.创建一个行row,首行
            Row sheetRow = sheet.createRow(0);

            //4.创建一个cell，首行单元格
            Cell headCell = null;
            Class<?> c = Class.forName("com.lin.springboot.pojo.City");
            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i <fields.length; i++) {
                headCell = sheetRow.createCell(i);
                headCell.setCellValue(fields[i].getName());
            }

            //5.循环List,将信息写入表格

            List<City> cities = cityMapper.selectAll();
            City city = null;
            Row rowData = null;
            Cell cellData = null;
            String name = null;
            String nameFirsttoUpperCase = null;
            Method method = null;
            for (int j = 0; j < cities.size(); j++) {

                city = cities.get(j);

                rowData = sheet.createRow(j+1);

                for (int k = 0; k <fields.length; k++) {
                    cellData = rowData.createCell(k);
                    name = fields[k].getName();
                    nameFirsttoUpperCase = name.substring(0, 1).toUpperCase() + name.substring(1);
                    method = c.getMethod("get"+nameFirsttoUpperCase);

                    String strData = method.invoke(city).toString();

                    cellData.setCellValue(strData);
                }




            }





            //6.文件名
            String fileName = "city.xlsx";

            //7.导出文件
            response.setHeader("Content-Disposition","attachment;filename="+fileName);


            wb.write(response.getOutputStream());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //return只能返回null
        return null;
    }

}
