package com.lin.springboot.test;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.lin.springboot.domain.PdfPrint;
import com.lin.springboot.domain.PensionOrgSum;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//打印表格公共类
public class PrintPdfAndWordUtil {


    /**
     * 创建文档对象，添加到输出流
     */
    public static void getPdfs(PdfPrint pdfPrint) throws IOException, DocumentException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String url = "C:\\Users\\LINx_x\\Desktop\\Test01.pdf";

        File file = new File(url);
        if (file.exists()) {
            file.delete();
        }


        // 创建Document对象
        Document doc = new Document(PageSize.A4.rotate(),40,40,80,40);
        // 获取pdfWriter实例，将文档放到输出流流
        PdfWriter pdfWriter = PdfWriter.getInstance(doc, new FileOutputStream(file));

        // 字体设置
        // 创建baseFont对象，指明字体，编码方式，是否嵌入
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);


//        //pdf标题
//        Font fontChineseTitle = new Font(bfChinese, 24, Font.NORMAL);
//        Paragraph title = new Paragraph(pdfPrint.getTitle(), fontChineseTitle);
//        title.setAlignment(1);
//        title.setAlignment(Element.ALIGN_CENTER);


//        //空行
//        Font fontChineseBlank = new Font(bfChinese, 6, Font.NORMAL);
//        Phrase blank = new Phrase("\n", fontChineseBlank);


        //创建表格，设置当前表格与上面元素的间距

        int colNumber = pdfPrint.getTitleChinese().size();
        PdfPTable datatable = new PdfPTable(colNumber + 1);
        //固定表头
        datatable.setHeaderRows(1);


        // 定义表格的宽度
        //构建单元格宽度数组
        //int[] cellsWidth = new int[colNumber + 1];
        //Arrays.fill(cellsWidth, 2);

        int[] cellsWidth = new int[pdfPrint.getCellsWidthSetting().length+1];
        System.arraycopy(new int[]{1},0,cellsWidth,0,1);
        System.arraycopy(pdfPrint.getCellsWidthSetting(),0,cellsWidth,1,pdfPrint.getCellsWidthSetting().length);


        datatable.setWidths(cellsWidth);// 单元格宽度
        datatable.setWidthPercentage(100);// 表格的宽度百分比


        datatable.getDefaultCell().setPadding(2);// 单元格的间隔
        datatable.getDefaultCell().setBorderWidth(1);// 边框宽度




        // 设置表格的底色
        datatable.getDefaultCell().setBackgroundColor(BaseColor.WHITE);

        //水平居中
        datatable.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);


        //垂直居中
        datatable.getDefaultCell().setUseAscender(true);
        datatable.getDefaultCell().setVerticalAlignment(PdfPCell.ALIGN_MIDDLE);

        //单元格列高
        datatable.getDefaultCell().setMinimumHeight(20);


        // 添加表头元素
        //添加序号表头
        datatable.addCell(new Paragraph("序号", fontChinese));
        for (int i = 0; i < colNumber; i++) {
            datatable.addCell(new Paragraph((String) pdfPrint.getTitleChinese().get(i), fontChinese));
        }

        List<PensionOrgSum> contents = pdfPrint.getContent();
        String titleEnglish;
        Class<?> c = Class.forName("com.lin.springboot.domain.PensionOrgSum");
        for (int k = 0; k < contents.size(); k++) {
            //添加序号数据
            datatable.addCell(new Paragraph(String.valueOf(k + 1), fontChinese));
            for (int j = 0; j < colNumber; j++) {




                titleEnglish = pdfPrint.getTitleEnglish().get(j);

                //自定义
                if(titleEnglish.equals("isPublic")){
                    Method method = c.getMethod(getMethodName(titleEnglish));
                    Object invoke = method.invoke(contents.get(k));
                    if (invoke != null) {

                        if(invoke.toString().equals("0")){
                            datatable.addCell(new Paragraph("盈利", fontChinese));
                        }else if(invoke.toString().equals("1")){
                            datatable.addCell(new Paragraph("非盈利", fontChinese));
                        }else {
                            datatable.addCell(new Paragraph("  ", fontChinese));
                        }


                    }else {
                        datatable.addCell(new Paragraph("  ", fontChinese));
                    }
                    continue;
                } else if(titleEnglish.equals("countyRatio")||titleEnglish.equals("cityRatio")){
                    Method method = c.getMethod(getMethodName(titleEnglish));
                    Object invoke = method.invoke(contents.get(k));
                    if (invoke != null) {
                        datatable.addCell(new Paragraph(invoke.toString()+"%", fontChinese));
                    }else {
                        datatable.addCell(new Paragraph("  ", fontChinese));
                    }
                    continue;
                }

                Method method = c.getMethod(getMethodName(titleEnglish));
                Object invoke = method.invoke(contents.get(k));

                if (invoke != null) {

                    //日期格式化
                    if (invoke instanceof Date) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");

                        datatable.addCell(new Paragraph(dateFormatter.format(invoke), fontChinese));
                    }else {
                        datatable.addCell(new Paragraph(invoke.toString(), fontChinese));
                    }



                }else {
                    datatable.addCell(new Paragraph("  ", fontChinese));
                }

            }
        }


        datatable.setSpacingAfter(10f);


        //设置页码
        setFooter(pdfWriter, bfChinese,pdfPrint.getTitle());


        doc.open();
        doc.add(datatable);// 把表格加入文档
        doc.close();


    }


    /**
     * 创建文档对象，添加到输出流
     */
    public static void getsPdfs(PdfPrint pdfPrint) throws IOException, DocumentException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 创建Document对象
        Document doc = new Document(PageSize.A4.rotate());

        String url = "C:\\Users\\LINx_x\\Desktop\\Test01.pdf";
        // 获取pdfWriter实例，将文档放到输出流流
        File file = new File(url);
        if (file.exists()) {
            file.delete();
        }


        PdfWriter.getInstance(doc, new FileOutputStream(file));
        // 字体设置
        // 创建baseFont对象，指明字体，编码方式，是否嵌入
        BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bfChinese, 12, Font.NORMAL);// 中文、12、正常


        //pdf标题
        Font fontChineseTitle = new Font(bfChinese, 24, Font.NORMAL);
        Paragraph title = new Paragraph(pdfPrint.getTitle(), fontChineseTitle);
        title.setAlignment(1);
        title.setAlignment(Element.ALIGN_CENTER);


        //空行
        Font fontChineseBlank = new Font(bfChinese, 6, Font.NORMAL);
        Phrase blank = new Phrase("\n", fontChineseBlank);


        //创建表格，设置当前表格与上面元素的间距

        int colNumber = pdfPrint.getTitleChinese().size();
        PdfPTable datatable = new PdfPTable(colNumber + 1);

        datatable.setHeaderRows(1);//固定表头
        // 定义表格的宽度
        List<Integer> cellsWidth = new ArrayList<Integer>(colNumber + 1);
        for (int i = 0; i < colNumber + 1; i++) {
            cellsWidth.add(1);
        }
        int[] cellsWidth2 = cellsWidth.stream().mapToInt(Integer::intValue).toArray();
        datatable.setWidths(cellsWidth2);// 单元格宽度
        // datatable.setTotalWidth(300f);//表格的总宽度
        datatable.setWidthPercentage(100);// 表格的宽度百分比

        datatable.getDefaultCell().setPadding(2);// 单元格的间隔
        datatable.getDefaultCell().setBorderWidth(1);// 边框宽度
        // 设置表格的底色
        datatable.getDefaultCell().setBackgroundColor(BaseColor.WHITE);
        datatable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);

        // 添加表头元素
        datatable.addCell(new Paragraph("序号", fontChinese));
        for (int i = 0; i < colNumber; i++) {
            datatable.addCell(new Paragraph((String) pdfPrint.getTitleChinese().get(i), fontChinese));
        }


        List<PensionOrgSum> contents = pdfPrint.getContent();
        String titleEnglish;

        Class<?> c = Class.forName("com.lin.springboot.domain.PensionOrgSum");

        int count = 0;
        for (int k = 0; k < contents.size(); k++) {
            datatable.addCell(new Paragraph(String.valueOf(++count), fontChinese));
            for (int j = 0; j < colNumber; j++) {

                titleEnglish = pdfPrint.getTitleEnglish().get(j);

                Method method = c.getMethod(getMethodName(titleEnglish));
                Object invoke = method.invoke(contents.get(k));

                datatable.addCell(new Paragraph(invoke.toString(), fontChinese));
            }
        }


        datatable.setSpacingAfter(10f);
        doc.open();
        doc.add(title);
        doc.add(blank);
        doc.add(datatable);// 把表格加入文档
        doc.addCreationDate();
        doc.close();


    }


    private static String getMethodName(String str) {

        return "get" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }


    //设置页码
    private static void setFooter(PdfWriter writer, BaseFont bf,String title) throws DocumentException, IOException {
        PdfPageMyHelper headerFooter = new PdfPageMyHelper(bf, 13, PageSize.A0,title);
        writer.setPageEvent(headerFooter);
    }


}
