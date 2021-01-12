package com.liaocheng.archives.Dao;

import com.liaocheng.archives.Po.StudentInfo;
import org.springframework.stereotype.Component;

import java.util.List;
@Component("studentInfoDao")
public interface StudentInfoDao {
    //查询所有的学生列表
    List<StudentInfo> queryStudentAll();

    //添加学生信息
    void addStudent(StudentInfo studentInfo);

    //根据ID查询学生信息
    StudentInfo queryStudentByID(Integer sID);

    //修改
    void updateStudentInfo(StudentInfo studentInfo);

    //删除
    void deleteStudentByID(Integer sID);
}
