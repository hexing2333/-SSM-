package com.liaocheng.archives.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liaocheng.archives.Dao.StudentInfoDao;
import com.liaocheng.archives.Po.StudentInfo;
import com.liaocheng.archives.util.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentInfoService")
public class StudentInfoServiceImpl implements StudentInfoService{
    @Autowired
    private StudentInfoDao studentInfoDao;

    @Override
    public List<StudentInfo> queryStudentAll() {
        return studentInfoDao.queryStudentAll();
    }

    @Override
    public List<StudentInfo> queryStudentAllByAge(Integer sAge,int currentPage,int pageSize) {
        Map<String,Object> map=new HashMap<>();
        int startCurrentPage=(currentPage-1)*pageSize;        //从第几个数据开始
        int count=selectCount();
        int totalPage=count/pageSize+1;                   //总页数
        if (currentPage>totalPage || currentPage<=0){
            return null;
        }else{
            map.put("currentPage",startCurrentPage);
            map.put("pageSize",pageSize);
            System.out.println(startCurrentPage);
            List<StudentInfo> list = studentInfoDao.queryStudentAllByAge(sAge,currentPage,pageSize);
            return list;
        }
    }

    @Override
    public List<StudentInfo> queryStudentAllBySex(String sSex,int currentPage,int pageSize) {
        int startCurrentPage=(currentPage-1)*pageSize;        //从第几个数据开始
        int count=selectCount();
        int totalPage=count/pageSize+1;                   //总页数
        if (currentPage>totalPage || currentPage<=0){
            return null;
        }else{

            List<StudentInfo> list = studentInfoDao.queryStudentAllBySex(sSex,startCurrentPage,pageSize);
            return list;
        }
    }

    @Override
    public List<StudentInfo> queryStudentAllByAgeAndSex(Integer sAge, String sSex,int currentPage,int pageSize) {
        int startCurrentPage=(currentPage-1)*pageSize;        //从第几个数据开始
        int count=selectCount();
        int totalPage=count/pageSize+1;                   //总页数
        if (currentPage>totalPage || currentPage<=0){
            return null;
        }else{
            List<StudentInfo> list = studentInfoDao.queryStudentAllByAgeAndSex(sAge,sSex,currentPage,pageSize);
            return list;
        }
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

    @Override
    public int selectCount() {
        int count = studentInfoDao.selectCount();
        return count;
    }
    @Override
    public List<StudentInfo> selectUserBySql(int currentPage, int pageSize) {
        int startCurrentPage=(currentPage-1)*pageSize;        //从第几个数据开始
        int count=selectCount();
        int totalPage=count/pageSize+1;                   //总页数
        if (currentPage>totalPage || currentPage<=0){
            return null;
        }else{
            List<StudentInfo> list = studentInfoDao.selectBySql(startCurrentPage,pageSize);
            return list;
        }
    }

}
