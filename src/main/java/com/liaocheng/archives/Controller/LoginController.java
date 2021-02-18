package com.liaocheng.archives.Controller;

import com.liaocheng.archives.Po.StudentInfo;
import com.liaocheng.archives.Po.TeacherInfo;
import com.liaocheng.archives.Service.StudentInfoService;
import com.liaocheng.archives.Service.TeacherInfoService;
import com.liaocheng.archives.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
    @Autowired
    private TeacherInfoService teacherInfoService;
    @Autowired
    private StudentInfoService studentInfoService;

    @GetMapping("/")
    public String Login(){
        return "login";
    }
    @PostMapping("/jslogin")
    @ResponseBody
    public R postjsLogin(HttpServletRequest request,
                         @RequestParam("sID") Integer tID,
                         @RequestParam("password") String password){
        TeacherInfo teacher = teacherInfoService.queryTeacherByID(tID);
        if(teacher==null){
            return R.fail("用户名不存在");
        }else {
            if (teacher.getTPassword().equals(password)){
                System.out.println("success");
                request.getSession().setAttribute("isLogin","1");
                request.getSession().setAttribute("username",teacher.getTName());
                return R.ok();
            }else {
                return R.fail("密码错误或用户名不存在");
            }
        }
    }
    @PostMapping("/xslogin")
    @ResponseBody
    public R postxsLogin(HttpServletRequest request,
                         @RequestParam("sID") Integer sID,
                         @RequestParam("password") String password){
        StudentInfo student = studentInfoService.queryStudentByID(sID);
        if(student==null){
            return R.fail("用户名不存在");
        }else {
            if (student.getSPassword().equals(password)){
                System.out.println("success");
                request.getSession().setAttribute("isLogin","1");
                request.getSession().setAttribute("sName",student.getSName());
                request.getSession().setAttribute("sID",sID);
                return R.ok();
            }else {
                return R.fail("密码错误或用户名不存在");
            }
        }

    }

}
