package com.liaocheng.archives.Dao;

import com.liaocheng.archives.Po.TeacherInfo;
import org.springframework.stereotype.Component;

@Component("teacherInfoDao")
public interface TeacherInfoDao {
    TeacherInfo queryTeacherByID(Integer tID);
}
