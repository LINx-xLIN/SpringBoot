package com.lin.springboot.test;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.lin.springboot.domain.OperatingSubsidyServe;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class PdfTemplateToPdf {
    // 利用模板生成pdf
    public static void fillTemplate() {
        // 模板路径
        String templatePath = "C:\\Users\\LINx_x\\Desktop\\测试01.pdf";
        // 生成的新文件路径
        String newPDFPath = "C:\\Users\\LINx_x\\Desktop\\ceshi01.pdf";
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            String[] str = {"1", "你好养老机构"};
            int i = 0;
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next().toString();

                if (name.equals("buildMethod")) {
                    form.setField(name, str[i++], true);
                } else {
                    form.setField(name, str[i++]);
                }
                System.out.println(name);

            }
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();
        } catch (IOException e) {
            System.out.println(1);
        } catch (DocumentException e) {
            System.out.println(2);
        }
    }


    // 利用模板生成pdf
    public static void fillConstructionSubsidyTemplateByData(String classStr, Object object, String templatePath, String newPDFPath) {
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;
        try {
            Class<?> c = Class.forName(classStr);
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            int i = 0;
            java.util.Iterator<String> it = form.getFields().keySet().iterator();
            while (it.hasNext()) {
                String name = it.next().toString();

                //用于自定义
                if(name.equals("rentalBeginDateYear")){
                    Method method = c.getMethod(getMethodName("rentalBeginDate"));
                    Object invoke = method.invoke(object);
                    if (invoke != null) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy");
                        form.setField(name,dateFormatter.format(invoke));
                    }else{
                        form.setField(name, "  ");

                    }
                    continue;
                } else if(name.equals("rentalBeginDateMonth")){
                    Method method = c.getMethod(getMethodName("rentalBeginDate"));
                    Object invoke = method.invoke(object);
                    if (invoke != null) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM");
                        form.setField(name,dateFormatter.format(invoke));
                    }else{
                        form.setField(name, "  ");

                    }
                    continue;
                }else if(name.equals("rentalEndDateYear")){
                    Method method = c.getMethod(getMethodName("rentalEndDate"));
                    Object invoke = method.invoke(object);
                    if (invoke != null) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy");
                        form.setField(name,dateFormatter.format(invoke));
                    }else{
                        form.setField(name, "  ");

                    }
                    continue;
                }else if(name.equals("rentalEndDateMonth")){
                    Method method = c.getMethod(getMethodName("rentalEndDate"));
                    Object invoke = method.invoke(object);
                    if (invoke != null) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM");
                        form.setField(name,dateFormatter.format(invoke));
                    }else{
                        form.setField(name, "  ");

                    }
                    continue;
                }else if(name.equals("updateDateYear")){
                    Method method = c.getMethod(getMethodName("updateDate"));
                    Object invoke = method.invoke(object);
                    if (invoke != null) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy");
                        form.setField(name,dateFormatter.format(invoke));
                    }else{
                        form.setField(name, "  ");

                    }
                    continue;
                }

                //一般输入框

                Method method = c.getMethod(getMethodName(name));

                Object invoke = method.invoke(object);

                String value;
                if (invoke != null) {
                    //日期格式化
                    if (invoke instanceof Date) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                        value = dateFormatter.format(invoke);
                    }else {
                        value = invoke.toString();
                    }



                    //判断复选框属性
                    if (name.equals("buildMethod")||name.equals("houseWeight")) {
                        form.setField(name, value, true);
                    } else {
                        form.setField(name, value);
                    }


                } else {
                    form.setField(name, "  ");
                }

            }
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    } // 利用模板生成pdf
    public static void fillOperatingSubsidyTemplateByData(String classStr, Object object, String templatePath, String newPDFPath) {
        PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;


        try {
            Class<?> c = Class.forName(classStr);
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            int i = 0;
            java.util.Iterator<String> it = form.getFields().keySet().iterator();

            while (it.hasNext()) {
                String name = it.next().toString();

                //用于自定义
                if(name.equals("updateDateYear")){
                    Method method = c.getMethod(getMethodName("updateDate"));
                    Object invoke = method.invoke(object);
                    if (invoke != null) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy");
                        form.setField(name,dateFormatter.format(invoke));
                    }else{
                        form.setField(name, "  ");

                    }
                    continue;
                }else if(name.startsWith("operatingSubsidyServe")){
                    //处理List<operatingSubsidyServe>
                     // "operatingSubsidyServe-a-monNum"

                    String[] split = name.split("-");
                    Method method = c.getMethod(getMethodName("operatingSubsidyServe"));
                    Object invoke = method.invoke(object);
                    if (invoke != null) {
                        List<OperatingSubsidyServe> operatingSubsidyServes = (List<OperatingSubsidyServe>) invoke;
                        Boolean flag=false;


                        for (OperatingSubsidyServe operatingSubsidyServe : operatingSubsidyServes) {

                            if (operatingSubsidyServe.getServeType().equals(split[1])) {

                                Class<?> cc = Class.forName("com.lin.springboot.domain.OperatingSubsidyServe");
                                Method method2 = cc.getMethod(getMethodName(split[2]));
                                Object invoke2 = method2.invoke(operatingSubsidyServe);

                                if (invoke2 != null) {
                                    form.setField(name, invoke2.toString());
                                    flag=true;

                                }

                                break;

                            }
                        }


                        if (!flag) {
                            form.setField(name, "  ");
                        }

                    }else{
                        form.setField(name, "  ");

                    }
                    continue;
                }

                //一般输入框

                Method method = c.getMethod(getMethodName(name));

                Object invoke = method.invoke(object);

                String value;
                if (invoke != null) {
                    //日期格式化
                    if (invoke instanceof Date) {
                        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
                        value = dateFormatter.format(invoke);
                    }else {
                        value = invoke.toString();
                    }



                    //判断复选框属性
                    if (name.equals("isPublic")) {
                        form.setField(name, value, true);
                    } else {
                        form.setField(name, value);
                    }


                } else {
                    form.setField(name, "  ");
                }

            }
            stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
            stamper.close();
            Document doc = new Document();
            PdfCopy copy = new PdfCopy(doc, out);
            doc.open();
            PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
            copy.addPage(importPage);
            doc.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }



    private static String getMethodName(String str) {

        return "get" + str.substring(0, 1).toUpperCase() + str.substring(1);
    }

}

