package com.liaocheng.archives.Controller;

import com.liaocheng.archives.Po.StudentInfo;
import com.liaocheng.archives.Service.StudentInfoService;
import com.liaocheng.archives.util.JsonObject;
import com.liaocheng.archives.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class StudentInfoController {
    //查询
    @Autowired
    private StudentInfoService studentInfoService;

    @RequestMapping("student/studentInfo")
    @ResponseBody
    public JsonObject queryStudentAll(HttpServletRequest request,int page,int limit){
        String age=request.getParameter("age");
        String sex=request.getParameter("sex");
        JsonObject object=new JsonObject();
        object.setCode(0);
        object.setMsg("ok");
        object.setCount((long)studentInfoService.selectCount());
        if((age==""&&sex=="")||(age==null&&sex==null)){
            List<StudentInfo> list=studentInfoService.selectUserBySql(page,limit);
            object.setData(list);
            return object;
        }
        else if(age!=""&&sex==""){
            List<StudentInfo> list=studentInfoService.queryStudentAllByAge(Integer.parseInt(age),page,limit);
            object.setData(list);
            return object;
        }else if(age==""&&sex!=""){
            List<StudentInfo> list=studentInfoService.queryStudentAllBySex(sex,page,limit);
            object.setData(list);
            return object;
        }else {
            List<StudentInfo> list=studentInfoService.queryStudentAllByAgeAndSex(Integer.parseInt(age),sex,page,limit);
            object.setData(list);
            return object;
        }
    }
    //新增
    @RequestMapping("student/addStudent")
    @ResponseBody
    public R addStudent(StudentInfo studentInfo){
        studentInfo.setSTime(new Date());
        studentInfoService.addStudent(studentInfo);
        return R.ok();
    }


    @RequestMapping("/student")
    public String studentIndex(){
        return "teacher/student";
    }

    @RequestMapping("/addStudent")
    public String addStudent(){
        return "teacher/addStudent";
    }


    //修改
    @RequestMapping("/updateStudent")
    public String updateStudent(@RequestParam("id") Integer id,@RequestParam("name") String name, @RequestParam("age") String age,
                                @RequestParam("sex") String sex, Model model){
        model.addAttribute("id",id);
        model.addAttribute("sname",name);
        model.addAttribute("sage",age);
        model.addAttribute("ssex",sex);
        return "teacher/updateStudent";
    }

    @RequestMapping("student/updateStudent")
    @ResponseBody
    public R updateStudentInfo(StudentInfo studentInfo){
        studentInfo.setSTime(new Date());
        System.out.println(studentInfo);
        studentInfoService.updateStudentInfo(studentInfo);
        return R.ok();
    }

    //删除
    @RequestMapping("student/deleteStudent")
    @ResponseBody
    public R deleteStudent(int sid){
        studentInfoService.deleteStudentByID(sid);
        return R.ok();
    }


}
