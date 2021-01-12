package com.liaocheng.archives.Po;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
//学生信息类 包含学生ID 学生姓名 学生性别 学生出生日期 信息录入日期
public class StudentInfo implements Serializable {
    private Integer sID;
    private String sName;
    private String sPassword;
    private String sSex;
    private Integer sAge;
    private Date sTime;
}
