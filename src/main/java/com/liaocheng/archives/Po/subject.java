package com.liaocheng.archives.Po;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

@Data
//学习成绩类 包含成绩ID 课程ID和名称 学生ID和名称 成绩
public class subject implements Serializable {
    private Integer eID;
    private Integer cID;
    private String cName;
    private Integer sID;
    private String sName;
    private Integer score;
    private Date eTime;
    private java.util.Date createTime;
}
