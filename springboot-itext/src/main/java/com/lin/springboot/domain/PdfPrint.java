package com.lin.springboot.domain;

import lombok.Data;

import java.util.List;
@Data
public class PdfPrint {

     // pdf标题
     private String title;

     // 表格中文标题
     private List<String> titleChinese;
     // 表格中文标题列的行距
     private int[] cellsWidthSetting;

     // 表格英文标题
     private List<String> titleEnglish;
     // 表格内容
     private  List<PensionOrgSum> content;
     // 作者
     private  String author;
     // 备注
     private  String remark;

}
