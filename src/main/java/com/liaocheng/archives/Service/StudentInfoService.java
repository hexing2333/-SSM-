package com.liaocheng.archives.Service;

import com.liaocheng.archives.Po.StudentInfo;

import java.util.List;

public interface StudentInfoService {
//    查询学生信息
    List<StudentInfo> queryStudentAll();

    void addStudent(StudentInfo studentInfo);

    //根据ID查询学生信息
    StudentInfo queryStudentByID(Integer sID);

    //修改
    void updateStudentInfo(StudentInfo studentInfo);

    //根据ID删除
    void deleteStudentByID(Integer sID);
}
