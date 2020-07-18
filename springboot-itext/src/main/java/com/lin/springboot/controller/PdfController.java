package com.lin.springboot.controller;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;
import com.lin.springboot.domain.ConstructionSubsidy;
import com.lin.springboot.domain.OperatingSubsidy;
import com.lin.springboot.test.PdfTemplateToPdf;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
public class PdfController {
    @PostMapping("/generatePDF")
    public String generatePDF(@RequestBody OperatingSubsidy operatingSubsidy) {

        try {
           /* // 模板路径
            String templatePath = "C:\\Users\\LINx_x\\Desktop\\民办养老服务机构建设资助申请表.pdf";
            // 生成的新文件路径
            String newPDFPath = "C:\\Users\\LINx_x\\Desktop\\生成建设补贴表01.pdf";



            PdfTemplateToPdf.fillConstructionSubsidyTemplateByData("com.lin.springboot.domain.ConstructionSubsidy",constructionSubsidy,templatePath,newPDFPath);
            */


            /*// 模板路径
            String templatePath = "static/itext测试/民办养老服务机构运营资助申请表.pdf";
            // 生成的新文件路径
            String newPDFPath = "C:\\Users\\LINx_x\\Desktop\\生成建设补贴表03.pdf";


            PdfTemplateToPdf.fillOperatingSubsidyTemplateByData("com.lin.springboot.domain.OperatingSubsidy", operatingSubsidy, templatePath, newPDFPath); */

            // 模板路径
            String templatePath = "static/itext测试/民办养老服务机构运营资助申请表.pdf";
            // 生成的新文件路径
            String newPDFPath = "C:\\Users\\LINx_x\\Desktop\\生成建设补贴表03.pdf";


            PdfTemplateToPdf.fillOperatingSubsidyTemplateByData("com.lin.springboot.domain.OperatingSubsidy", operatingSubsidy, templatePath, newPDFPath);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

        return "success";



        /*PdfReader reader;
        FileOutputStream out;
        ByteArrayOutputStream bos;
        PdfStamper stamper;

        try {
            out = new FileOutputStream(newPDFPath);// 输出流
            reader = new PdfReader(templatePath);// 读取pdf模板
            bos = new ByteArrayOutputStream();
            stamper = new PdfStamper(reader, bos);
            AcroFields form = stamper.getAcroFields();
            //String[] str = {"1","你好养老机构"};
            int i = 0;
            java.util.Iterator<String> it = form.getFields().keySet().iterator();

            //反射
            Class<?> c = Class.forName("com.lin.springboot.domain.ConstructionSubsidy");


            while (it.hasNext()) {
                String name = it.next().toString();

                Method method = c.getMethod(getMethodName(name));

                Object invoke = method.invoke(constructionSubsidy);
                if (invoke != null) {
                    form.setField(name, invoke.toString());
                } else {
                    form.setField(name, " ");
                }

                stamper.setFormFlattening(true);// 如果为false那么生成的PDF文件还能编辑，一定要设为true
                stamper.close();
                Document doc = new Document();
                PdfCopy copy = new PdfCopy(doc, out);
                doc.open();
                PdfImportedPage importPage = copy.getImportedPage(new PdfReader(bos.toByteArray()), 1);
                copy.addPage(importPage);
                doc.close();


            }
        } catch (IOException | DocumentException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
*/

    }


}
