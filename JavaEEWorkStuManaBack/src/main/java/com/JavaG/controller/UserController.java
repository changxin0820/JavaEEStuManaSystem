package com.JavaG.controller;


import com.JavaG.dao.UserDao;
import com.JavaG.domain.Student;
import com.JavaG.domain.User;
import com.JavaG.service.UserService;


import com.JavaG.tool.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Map;


@RestController
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserDao userDao;
    //登录
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/api/login")
    public User login(HttpServletRequest request){
        //获取用户的帐号，新建一个User对象，以这个对象查询数据库中是否存在该用户
        String id = request.getParameter("id");
        User user = new User();
        user.setId(Integer.parseInt(id));
        User result =userService.login(user);
        //登陆成功
        if(result!=null){

            System.out.println("查询用户成功");
            //获取用户提交的参数

            //获取Session对象
            HttpSession session = request.getSession();

            //向session域中写入数据
            session.setAttribute("sid",result);

            return result;
        }
        else System.out.println("用户不存在");

        return null;
    }

    //修改密码
    @RequestMapping(value = "/api/updatePass",method = RequestMethod.POST)
    public Response updatePass(@RequestBody Map<String, String> map, HttpSession session){

        //登陆成功
        User user=(User)session.getAttribute("sid");
        if(!userService.checkUserIsExist(user.getId())){
            return new Response().failure("该用户不存在！");
        } else if (!user.getPassword().equals(map.get("oldPass"))){
            return new Response().failure("请输入正确的原密码");
        }else{
            userService.updatePass(user.getId(),map.get("newPass"));
            return new Response().success();
        }
    }


    //退出登录
    @RequestMapping(value = "/api/logout",method = RequestMethod.GET)
    public Response logout(HttpSession session){

        session.removeAttribute("sid");
        System.out.println("退出系统");


        return new Response().success();
    }

    //获得所有Users
    @RequestMapping("/api/getAllUsers")
    public Response getAllUsers (HttpServletRequest request, HttpSession session){

        ArrayList<Student> users=userService.getAllUsers();
        return new Response().success(users);
    }

    //禁用Users，改变状态status
    @RequestMapping("/api/enableUser")
    public Response enableUser(HttpServletRequest request, HttpSession session){
        //启用用户
        User user =(User) session.getAttribute("USER_SESSION");
        String id=request.getParameter("id");
        userService.enableUser(Integer.parseInt(id));
        return new Response().success();

    }

    //启用Users
    @RequestMapping("/api/disableUser")
    public Response disableUser(HttpServletRequest request, HttpSession session){
        //禁用用户
        User user =(User) session.getAttribute("USER_SESSION");
        String id=request.getParameter("id");

        userService.disableUser(Integer.parseInt(id));
        return new Response().success();
    }


}
