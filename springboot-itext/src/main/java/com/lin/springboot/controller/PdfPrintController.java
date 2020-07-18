package com.lin.springboot.controller;

import com.itextpdf.text.DocumentException;
import com.lin.springboot.domain.PdfPrint;
import com.lin.springboot.test.PrintPdfAndWordUtil;
import lombok.var;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
public class PdfPrintController {
    @PostMapping("/pdfPrint")
    public String pdfGeneratePrint(@RequestBody PdfPrint pdf)  {


        try {
            PrintPdfAndWordUtil.getPdfs(pdf);
            return "success";
        } catch (IOException | DocumentException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            return "fail";

        }


    }
}
