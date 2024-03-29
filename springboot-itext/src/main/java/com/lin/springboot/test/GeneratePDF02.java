package com.lin.springboot.test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPRow;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

public class GeneratePDF02 {

    public static void main(String[] args) {
        try {
            OutputStream file = new FileOutputStream(new File("D:\\Test02.pdf"));

            //创建文件
            Document document = new Document();
            //建立一个书写器
            PdfWriter writer = PdfWriter.getInstance(document, file);
            //打开文件
            document.open();
            //添加内容
            document.add(new Paragraph("HD content here"));

            // 3列的表.
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100); // 宽度100%填充
            table.setSpacingBefore(10f); // 前间距
            table.setSpacingAfter(10f); // 后间距

            List<PdfPRow> listRow = table.getRows();
            //设置列宽
            float[] columnWidths = { 1f, 2f, 3f };
            table.setWidths(columnWidths);

            //行1
            PdfPCell[] cells1= new PdfPCell[3];
            PdfPRow row1 = new PdfPRow(cells1);

            //单元格
            cells1[0] = new PdfPCell(new Paragraph("111"));//单元格内容
            cells1[0].setBorderColor(BaseColor.BLUE);//边框验证
            //cells1[0].setPaddingLeft(20);//左填充20
            cells1[0].setHorizontalAlignment(Element.ALIGN_CENTER);//水平居中
            cells1[0].setVerticalAlignment(Element.ALIGN_MIDDLE);//垂直居中

            cells1[1] = new PdfPCell(new Paragraph("222"));
            cells1[2] = new PdfPCell(new Paragraph("333"));

            //行2
            PdfPCell cells2[]= new PdfPCell[3];
            PdfPRow row2 = new PdfPRow(cells2);
            cells2[0] = new PdfPCell(new Paragraph("444"));

            //把第一行添加到集合
            listRow.add(row1);
            listRow.add(row2);
            //把表格添加到文件中
            document.add(table);

            //关闭文档
            document.close();
            //关闭书写器
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
