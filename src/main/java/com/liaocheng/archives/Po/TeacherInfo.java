package com.liaocheng.archives.Po;

import lombok.Data;

import java.io.Serializable;
@Data
public class TeacherInfo implements Serializable {
    private int tID;
    private String tName;
    private String tPassword;
}
