package com.liaocheng.archives.Service;

import com.liaocheng.archives.Po.StudentInfo;
import com.liaocheng.archives.util.JsonObject;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

public interface StudentInfoService {
//    查询学生信息
    List<StudentInfo> queryStudentAll();
    List<StudentInfo> queryStudentAllByAge(Integer sAge, int currentPage, int pageSize);
    List<StudentInfo> queryStudentAllBySex(String sSex,int currentPage,int pageSize);
    List<StudentInfo> queryStudentAllByAgeAndSex(Integer sAge,String sSex,int currentPage,int pageSize);
    void addStudent(StudentInfo studentInfo);

    //根据ID查询学生信息
    StudentInfo queryStudentByID(Integer sID);

    //修改
    void updateStudentInfo(StudentInfo studentInfo);

    //根据ID删除
    void deleteStudentByID(Integer sID);

    //JsonObject select(int page, int limit);
    int selectCount();
    List<StudentInfo> selectUserBySql(int currentPage,int pageSize);
}
