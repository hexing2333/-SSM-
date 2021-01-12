package com.liaocheng.archives.Po;

import lombok.Data;

import java.io.Serializable;
@Data
//课程信息类 包含课程ID和课程名称
public class course implements Serializable {
    private Integer cID;
    private String cName;
}
