package com.liaocheng.archives.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {
    @RequestMapping("/indexJS")
    public String IndexJS(Model model, HttpServletRequest request, HttpServletResponse resp){
        HttpSession session=request.getSession();
        String isLogin=(String)session.getAttribute("isLogin");
        String username=(String)session.getAttribute("username");
        model.addAttribute("isLogin",isLogin);
        model.addAttribute("username",username);
        return "teacher/indexJS";
    }

    @RequestMapping("/indexXS")
    public String IndexXS(Model model, HttpServletRequest request, HttpServletResponse resp){
        HttpSession session=request.getSession();
        String isLogin=(String)session.getAttribute("isLogin");
        String username=(String)session.getAttribute("username");
        model.addAttribute("isLogin",isLogin);
        model.addAttribute("username",username);
        return "student/indexXS";
    }

}
