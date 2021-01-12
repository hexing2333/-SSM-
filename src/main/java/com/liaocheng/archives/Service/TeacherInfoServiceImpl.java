package com.liaocheng.archives.Service;

import com.liaocheng.archives.Dao.StudentInfoDao;
import com.liaocheng.archives.Dao.TeacherInfoDao;
import com.liaocheng.archives.Po.TeacherInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teacherInfoService")
public class TeacherInfoServiceImpl implements TeacherInfoService{
    @Autowired
    private TeacherInfoDao teacherInfoDao;

    @Override
    public TeacherInfo queryTeacherByID(Integer tID) {
        return teacherInfoDao.queryTeacherByID(tID);
    }
}
