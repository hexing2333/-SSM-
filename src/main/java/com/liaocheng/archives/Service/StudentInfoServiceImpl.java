package com.liaocheng.archives.Service;

import com.liaocheng.archives.Dao.StudentInfoDao;
import com.liaocheng.archives.Po.StudentInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService{
    @Autowired
    private StudentInfoDao studentInfoDao;

    @Override
    public List<StudentInfo> queryStudentAll() {
        return studentInfoDao.queryStudentAll();
    }

    @Override
    public void addStudent(StudentInfo studentInfo){
        studentInfoDao.addStudent(studentInfo);
    }

    @Override
    public StudentInfo queryStudentByID(Integer sID) {
        return studentInfoDao.queryStudentByID(sID);
    }

    @Override
    public void updateStudentInfo(StudentInfo studentInfo) {
        studentInfo.setSTime(new Date());
        studentInfoDao.updateStudentInfo(studentInfo);
    }

    @Override
    public void deleteStudentByID(Integer sID) {
        studentInfoDao.deleteStudentByID(sID);
    }

}
