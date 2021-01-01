//package com.JavaG.controller;
//
//
//import org.springframework.web.bind.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//
//@RestController
//@RequestMapping("/api/login2")
//public class LoginController {
//    @CrossOrigin
//    @RequestMapping()
//    @ResponseBody
//    public void cookie(HttpServletRequest request, HttpSession session) {
//
//
//
//
//
//        //获取用户提交的参数
//        String sid = request.getParameter("sid");
//        //向session域中写入数据
//        session.setAttribute("sid",sid);
//        System.out.println("获取session对象" + session.toString());
//        System.out.println("session中的值为：" + session.getAttribute("sid"));
//    }
//}
